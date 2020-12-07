package com.example.movieapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel channel=new NotificationChannel("movie notify","Movie Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,"movie notify");
        builder.setContentTitle("Lots of Movies are waiting For you ");
        builder.setContentText("Book Your Ticket Now For Your Favourite Movie");
        builder.setSmallIcon(R.drawable.avatar);
        builder.setAutoCancel(true);

        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(MainActivity.this);
        managerCompat.notify(1,builder.build());


        MyMovieData[] myMovieData = new MyMovieData[]{
                new MyMovieData("Avengers","2019 film",R.drawable.avenger),
                new MyMovieData("Venom","2018 film",R.drawable.venom),
                new MyMovieData("Batman Begins","2005 film",R.drawable.batman),
                new MyMovieData("Jumanji","2019 film",R.drawable.jumanji),
                new MyMovieData("Good Deeds","2012 film",R.drawable.good_deeds),
                new MyMovieData("Hulk","2003 film",R.drawable.hulk),
                new MyMovieData("Avatar","2009 film",R.drawable.avatar),
        };

        MyMovieAdapter myMovieAdapter = new MyMovieAdapter(myMovieData,MainActivity.this);
        recyclerView.setAdapter(myMovieAdapter);

    }
}
