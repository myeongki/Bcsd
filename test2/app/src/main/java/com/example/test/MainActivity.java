package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.util.Log;
public class MainActivity extends AppCompatActivity {
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnListener1 = (Button)findViewById(R.id.toastbutton);
        Button btnListener2 = (Button)findViewById(R.id.countbutton);
        Button btnListener3 = (Button)findViewById(R.id.randombutton);

        btnListener1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_LONG).show();
            }
        });

        btnListener2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                count+=1;
                Log.v("Main2Activity","count: " + count);
            }

        });

        btnListener3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this,SubActivity.class);
                Intent intent = new Intent(getApplicationContext(),SubActivity.class);

                intent.putExtra("count",count);
                startActivity(intent);
            }

        });
    }
}
