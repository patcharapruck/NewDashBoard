package com.example.pchrp.newdashboard.activity;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pchrp.newdashboard.R;

public class LogInActivity extends AppCompatActivity {
    EditText username,password;
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        username = (EditText)findViewById(R.id.userId);
        password = (EditText)findViewById(R.id.passId);
        btnlogin = (Button)findViewById(R.id.btnLogin);
        InitInstances();


    }

    private void InitInstances(){

        username.getText().toString();
        password.getText().toString();


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
