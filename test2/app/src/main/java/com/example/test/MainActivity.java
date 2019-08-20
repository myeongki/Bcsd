package com.example.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.app.NotificationCompat;
import android.app.Notification;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.content.Intent;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    private int count = 0;
    private Button btnListener1, btnListener2, btnListener3;
    private AlertDialog.Builder buttonBuilder;
    private Intent intent;
    public static final String CHANNEL_ID = "NOTICE";
    public static final String NOTIFICATION_ID = "service notice";
    public static final int COUNT_FRAGMENT_ID = 0;
    public static final int RANDOM_FRAGMENT_ID = 1;


    // 잠깐 전화와서 전화받고올께요 넵
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(COUNT_FRAGMENT_ID);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setContentTitle("Picture Download")
                .setContentText("Download in progress")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setPriority(NotificationCompat.PRIORITY_LOW);

// Issue the initial notification with zero progress
        int PROGRESS_MAX = 100;
        int PROGRESS_CURRENT = 0;
        builder.setProgress(PROGRESS_MAX, PROGRESS_CURRENT, true);
        notificationManager.notify(1, builder.build());

// Do the job here that tracks the progress.
// Usually, this should be in a
// worker thread
// To show progress, update PROGRESS_CURRENT and update the notification with:
// builder.setProgress(PROGRESS_MAX, PROGRESS_CURRENT, false);
// notificationManager.notify(notificationId, builder.build());

// When done, update the notification one more time to remove the progress bar
        builder.setContentText("Download complete")
                .setProgress(0,0,false);
        notificationManager.notify(1, builder.build());

        buttonBuilder = new AlertDialog.Builder(this);

        btnListener1 = (Button) findViewById(R.id.toastbutton);
        btnListener2 = (Button) findViewById(R.id.countbutton);
        btnListener3 = (Button) findViewById(R.id.servicebutton);

        btnListener1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonBuilder.setPositiveButton("positive", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        count = 0;
                    }
                });

                buttonBuilder.setNegativeButton("negative", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_LONG).show();
                    }
                });

                buttonBuilder.setNeutralButton("Nettral", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AlertDialog alertDialog = buttonBuilder.create();
                alertDialog.show();
            }
        });

        btnListener2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count += 1;
                replaceFragment(COUNT_FRAGMENT_ID);
                Log.v("Main2Activity", "count: " + count);
            }
        });

        btnListener3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              intent = new Intent(MainActivity.this,MyService.class);
               startService(intent);

               //replaceFragment(RANDOM_FRAGMENT_ID);
            }

        });

    }

    public void replaceFragment(int id) {
        FragmentManager countFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = countFragmentManager.beginTransaction();
        Fragment fragment = null;
        switch (id) {
            case COUNT_FRAGMENT_ID:
                  fragment = new CountFragment();
                Bundle countBundle = new Bundle();
                countBundle.putInt("count", count);
                fragment.setArguments(countBundle);
                break;
            case RANDOM_FRAGMENT_ID:
                fragment = new RandomFragment();
                break;
            default:
                break;
        }
        fragmentTransaction.replace(R.id.count_fragment, fragment).commit();
    }
}
