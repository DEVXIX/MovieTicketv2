package com.example.movieapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {
    TextView textTitle,balance;
    Integer bal;
   Button book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        book=findViewById(R.id.button);
        balance=findViewById(R.id.textView7);
        bal=Integer.parseInt(balance.getText().toString());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i = getIntent();
         final String title = i.getStringExtra("title");
        textTitle = findViewById(R.id.detailTitle);
        textTitle.setText(title);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  if(bal>100)
                  {
                      final AlertDialog dialog=new AlertDialog.Builder(Details.this)
                              .setTitle("Booking Confirmation")
                              .setMessage("Are you sure to book Ticket for movie  "+title)
                              .setPositiveButton("OK",null)
                              .setNegativeButton("Cancel",null)
                              .show();
                      Button positive=dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                      Button negative=dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                      negative.setOnClickListener(new View.OnClickListener() {
                          @Override
                          public void onClick(View v) {
                              dialog.cancel();
                          }
                      });
                      positive.setOnClickListener(new View.OnClickListener() {
                          @Override
                          public void onClick(View v) {
                              bal=bal-100;
                              String bal1=Integer.toString(bal);
                              balance.setText(bal1);
                              dialog.cancel();
                              book.setText("Your ticket is booked ");
                              book.setBackgroundColor(Color.GREEN);
                              book.setEnabled(false);
                          }
                      });
                  }
            }
        });
    }

}
