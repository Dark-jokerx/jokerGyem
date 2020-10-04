package com.gym.jokergym;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.*;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import static com.gym.jokergym.R.layout.activity_costum;
import static com.gym.jokergym.R.layout.adil_dialog;

public class content_us extends AppCompatActivity {
    ImageButton mContentUs , mAbode ,mAdil;
    //dialog
    Button closeButton;
    Dialog dialog;
    ImageButton mfacebookButton , minstaButton , mfacebookAdilButton , minstaAdilButton;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_us);
        mContentUs = findViewById(R.id.content_us);
        mAbode = findViewById(R.id.abode_photo);
        mAdil = findViewById(R.id.adil_photo);

        //dialog buttons facebook
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
//
        //dialog buttons insta
//
//

        mAbode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                setmDialog(v);

            }
        });

        mAdil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                setmDialogAdil(v);
            }
        });

        mContentUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackBar = Snackbar.make(v,getString(R.string.massage_send),Snackbar.LENGTH_LONG);
                snackBar.setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE);
                snackBar.show();
                snackBar.setAction(getString(R.string.send), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sendEmail();
                    }
                });
            }
        });
    }
    private void sendEmail(){
        String emailIntent = getString(R.string.email);
        Intent sendEmial = new Intent(Intent.ACTION_SEND);
        sendEmial.setData(Uri.parse("this from dark joker"));
        sendEmial.setType("text/plain");
        sendEmial.putExtra(Intent.EXTRA_EMAIL,new String[] {emailIntent});
        try {
            startActivity(Intent.createChooser(sendEmial,"help"));
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Can Not Send an Email",Toast.LENGTH_SHORT).show();
        }
    }
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.1F);

    public void setActivityView(Class mweek) {
        Intent week1 = new Intent(this, mweek);
        startActivity(week1);
//        animTran();
    }

    private void setmDialog(View v){
        dialog = new Dialog(this);
        dialog. setContentView(activity_costum);
        closeButton = (Button) dialog.findViewById(R.id.close_button);

        //facebook
        mfacebookButton = (ImageButton) dialog.findViewById(R.id.facebook);
        mfacebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/abodex0x"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/abodex0x")));
                }}
        });

        //insta
        minstaButton = dialog.findViewById(R.id.insta);
        minstaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://instagram.com/_u/abdulkreim_davud/");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/abdulkreim_davud/")));
                }
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }



    private void setmDialogAdil(View v){
        dialog = new Dialog(this);
        dialog. setContentView(adil_dialog);
        closeButton = (Button) dialog.findViewById(R.id.close_button);

        //facebook
        mfacebookAdilButton = dialog.findViewById(R.id.facebook_adil);
        mfacebookAdilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/profile.php?id=100015270001164"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/profile.php?id=100015270001164")));
                }}
        });

        //insta
        minstaAdilButton = dialog.findViewById(R.id.insta_adil);
        minstaAdilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //h1
                Uri uri = Uri.parse("http://instagram.com/_u/adil_seyho");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/adil_seyho")));
                }
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }


}