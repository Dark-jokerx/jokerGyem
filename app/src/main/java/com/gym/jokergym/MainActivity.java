package com.gym.jokergym;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.gym.jokergym.chat.ChatMainActivity;
import com.gym.jokergym.firstWeek.firstMonth;
import com.gym.jokergym.secondWeek.secondMonth;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;



import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    public static final int RC_SIGN_IN = 2;
    private Button mweek1, mWeek2;
    private ImageButton mImage, mImage2;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private InterstitialAd mInterstitialAd;


    private static final String TAG = "MainActivity";

    private AdView mAdView;

    public void setActivityView(Class mweek) {
        Intent week1 = new Intent(this, mweek);
        startActivity(week1);

//        animTran();
        // android_key  C:\Users\LENOVO\Desktop\android_key.jks

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mweek1 = findViewById(R.id.firstWeek);
        mWeek2 = findViewById(R.id.SecondWeek);
        mImage = findViewById(R.id.meImage);
        mImage2 = findViewById(R.id.meImage2);
        mFirebaseAuth = FirebaseAuth.getInstance();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7856542270150897/9836840928");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());



        // athunticion mothed
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // Toast.makeText(MainActivity.this,"Signed in",Toast.LENGTH_SHORT).show();
                } else {


                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setLogo(R.mipmap.ic_launcher1_foreground)// Set logo drawable
                                    .setTheme(R.style.AppTheme)
                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.EmailBuilder().build(),
                                            new AuthUI.IdpConfig.GoogleBuilder().build()))
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };

        mweek1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityView(firstMonth.class);

            }
        });

        mWeek2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityView(secondMonth.class);
                adLoded();
            }
        });
        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityView(content_us.class);
            }
        });
        mImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityView(ChatMainActivity.class);
                adLoded();
            }
        });

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                adLoded();
            }


            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
            }
        });

    }

    protected void onPause() {
        super.onPause();
        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
    }

    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(MainActivity.this, "Login Secssessful", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(MainActivity.this, "Login Canclled", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    private void animTran() {
        overridePendingTransition(R.anim.side_out_right, R.anim.side_out_right);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sign_out_menu:
                AuthUI.getInstance().signOut(this);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
    private void adLoded(){
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }


}