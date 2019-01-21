package com.example.pchrp.newdashboard.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pchrp.newdashboard.R;
import com.example.pchrp.newdashboard.fragment.FragmentBill;

public class BillActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_bill, FragmentBill.newInstance())
                    .commit();
        }

    }
}