package com.gym.jokergym.secondWeek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gym.jokergym.R;

public class secondMonth extends AppCompatActivity {
    private Button mweek1,mWeek2,mWeek3,mWeek4,mWeek5,mWeek6,mWeek7;

    public void setActivityView(Class mweek){
        Intent week1 = new Intent(this, mweek);
        startActivity(week1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_month);
        mweek1 = findViewById(R.id.seWeek1_botton);
        mWeek2 = findViewById(R.id.seWeek2_botton);
        mWeek3 = findViewById(R.id.seWeek3_botton);
        mWeek4 = findViewById(R.id.seWeek4_botton);
        mWeek5 = findViewById(R.id.seWeek5_botton);
        mWeek6 = findViewById(R.id.seWeek6_botton);
        mWeek7 = findViewById(R.id.seWeek7_botton);

        mweek1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityView(seWeek1_java.class);
            }
        });

        mWeek2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityView(seWeek2_java.class);
            }
        });


        mWeek3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityView(seWeek3_java.class);
            }
        });


        mWeek4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityView(seWeek4_java.class);
            }
        });


        mWeek5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityView(seWeek5_java.class);
            }
        });


        mWeek6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityView(seWeek6_java.class);
            }
        });


        mWeek7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityView(seWeek7_java.class);
            }
        });


    }

}