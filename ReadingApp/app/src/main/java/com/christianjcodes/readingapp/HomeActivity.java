package com.christianjcodes.readingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    CardView dashboard;
    CardView currentReads;
    CardView completedReads;
    CardView readingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dashboard = (CardView) findViewById(R.id.my_dashboard);
        currentReads = (CardView) findViewById(R.id.current_reads);
        completedReads = (CardView) findViewById(R.id.completed_reads);
        readingList = (CardView) findViewById(R.id.reading_list);

        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DashActivity.class);
                startActivity(intent);
            }
        });

        currentReads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CurrentReadsActivity.class);
                startActivity(intent);
            }
        });

    }
}