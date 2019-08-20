//package com.example.test;
//
//import androidx.appcompat.app.AppCompatActivity;
//import android.widget.TextView;
//import android.os.Bundle;
//import android.content.Intent;
//import android.util.Log;
//import java.util.Random;
//public class SubActivity extends AppCompatActivity {
//    private  TextView tx1;
//    private  Random random;
//    private int count1;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sub2);
//        TextView tx1 = (TextView) findViewById(R.id.countText);
//        random = new Random();
//        Intent intent = getIntent();
//        count1 = intent.getIntExtra("count",0);
//        Log.v("Count1", "count1 :" + (random.nextInt(count1)+1));
//        tx1.setText("count값:"+(random.nextInt(count1)+1));
//    }
//
//}
