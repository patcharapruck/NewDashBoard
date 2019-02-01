package com.example.pchrp.newdashboard.activity;

import android.app.DatePickerDialog;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.pchrp.newdashboard.R;
import com.example.pchrp.newdashboard.fragment.FragmentBill;
import com.example.pchrp.newdashboard.manager.Contextor;
import com.example.pchrp.newdashboard.util.SharedPrefDateManager;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BillActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    Button btncalendarbill;
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
        btncalendarbill = (Button)findViewById(R.id.btncalendarbill);
        btncalendarbill.setOnClickListener(this);
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
        if(v == btncalendarbill){

            DatePickerDialog dialog = new DatePickerDialog(BillActivity.this,new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    month++;
                    String mm = ""+month;
                    String dd = ""+dayOfMonth;

                    if (month<10){
                        mm = "0"+month;
                    }
                    if (dayOfMonth < 10){
                        dd = "0"+dayOfMonth;
                    }
                    String datecalendat;
                    toolbar.setSubtitle(year+ "/" + mm + "/" +dd);
                    datecalendat = year+ "/" + mm + "/" +dd;

                    SharedPrefDateManager.getInstance(Contextor.getInstance().getContext())
                            .saveDatereq(datecalendat);

                    activity.reqAPI(SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate());

                    SharedPrefDateManager.getInstance(Contextor.getInstance().getContext())
                            .saveDateCalendar(dayOfMonth,month,year);

                }
            },SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getYear()
                    ,SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getMonth()
                    ,SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getDateofMonth());

            Calendar c = Calendar.getInstance(Locale.ENGLISH);
            c.add(Calendar.DATE,-1);
            Date date = c.getTime();
            dialog.getDatePicker().setMaxDate(date.getTime());
            dialog.show();

        }
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