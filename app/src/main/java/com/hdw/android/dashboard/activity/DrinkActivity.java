package com.hdw.android.dashboard.activity;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.hdw.android.dashboard.R;
import com.hdw.android.dashboard.fragment.FragmentDrink;

public class DrinkActivity extends AppCompatActivity {

Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_drink, FragmentDrink.newInstance())
                    .commit();
        }
    }

}
