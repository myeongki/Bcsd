package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import java.util.Random;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Button;

public class CountFragment extends Fragment {
    private TextView countText;
    private Random random;
    private int count1;
    private Bundle countBundle;
    private Button endButtonListener;
    private  Intent intent;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View countView = inflater.inflate(R.layout.fragment_count, container, false);
        countBundle = getArguments();
        if (countBundle != null)
            count1 = countBundle.getInt("count", 0);
        else
            count1 = 0;
        countText = countView.findViewById(R.id.countText);
        random = new Random();
        countText.setText(Integer.toString(count1));

        endButtonListener = (Button) countView.findViewById(R.id.endButton);
        endButtonListener.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                getActivity().finish();
            }
        });
        return countView;
    }


}
