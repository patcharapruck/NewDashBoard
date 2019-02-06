package com.hdw.android.dashboard.activity;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.hdw.android.dashboard.R;
import com.hdw.android.dashboard.fragment.FragmentBill;
import com.hdw.android.dashboard.manager.Contextor;
import com.hdw.android.dashboard.util.SharedPrefDateManager;

public class BillActivity extends AppCompatActivity implements View.OnClickListener {

    public Toolbar toolbar;
    MainActivity activity = new MainActivity();
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_bill, FragmentBill.newInstance())
                    .commit();
        }

        initInstances();

    }

    private void initInstances() {
        toolbar = findViewById(R.id.tbBill);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onStart() {
        super.onStart();

        date = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate();
        toolbar.setTitle("รายรับตามบิล");

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        toolbar.setSubtitle(date);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}