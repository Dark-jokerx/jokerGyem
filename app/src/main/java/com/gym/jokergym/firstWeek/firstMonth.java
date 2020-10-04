package com.gym.jokergym.firstWeek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdRequest;


import com.gym.jokergym.R;

public class firstMonth extends AppCompatActivity {
    private Button mweek1,mWeek2,mWeek3,mWeek4,mWeek5,mWeek6,mWeek7;
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;


    public void setActivityView(Class mweek){
        Intent week1 = new Intent(this, mweek);
        startActivity(week1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_month);
        mweek1 = findViewById(R.id.week1_botton);
        mWeek2 = findViewById(R.id.week2_botton);
        mWeek3 = findViewById(R.id.week3_botton);
        mWeek4 = findViewById(R.id.week4_botton);
        mWeek5 = findViewById(R.id.week5_botton);
        mWeek6 = findViewById(R.id.week6_botton);
        mWeek7 = findViewById(R.id.week7_botton);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7856542270150897/9836840928");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());





        mweek1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityView(week1.class);
                adLoded();
            }
        });

        mWeek2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityView(week2_java.class);
                adLoded();
            }
        });


        mWeek3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityView(week3_java.class);
                adLoded();
            }
        });


        mWeek4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityView(week4_java.class);
                adLoded();
            }
        });


        mWeek5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityView(week5_java.class);
                adLoded();
            }
        });


        mWeek6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityView(week6_java.class);
                adLoded();
            }
        });


        mWeek7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityView(week7_java.class);
                adLoded();
            }
        });

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });


    }
    private void adLoded(){
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

}