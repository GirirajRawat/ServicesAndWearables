package com.y.servicesandwearables;

import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import createchannel.CreateChannel;

public class MainActivity extends AppCompatActivity {
    private Button btnDisplayNotification1,btnDisplayNotification2;

    private  NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnDisplayNotification1 = findViewById(R.id.btnDisplayNotification1);
        btnDisplayNotification2 = findViewById(R.id.btnDisplayNotification2);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();


        btnDisplayNotification1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification1();
            }
        });
        btnDisplayNotification2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification2();
            }
        });
    }

        private void DisplayNotification1() {
            Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_1)
                    .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                    .setContentTitle("First Message")
                    .setContentText("This is First Message")
                    .setCategory(NotificationCompat.CATEGORY_SYSTEM)
                    .build();

            notificationManagerCompat.notify(1, notification);
        }
        private void DisplayNotification2() {
            Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_2)
                    .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                    .setContentTitle("Second Message")
                    .setContentText("This is Second Message")
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .build();

            notificationManagerCompat.notify(1, notification);
        }
}
