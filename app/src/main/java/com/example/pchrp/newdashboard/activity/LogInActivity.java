package com.example.pchrp.newdashboard.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pchrp.newdashboard.Dao.DashBoardDao;
import com.example.pchrp.newdashboard.Dao.LoginItemDao;
import com.example.pchrp.newdashboard.R;
import com.example.pchrp.newdashboard.manager.Contextor;
import com.example.pchrp.newdashboard.manager.DashBoradManager;
import com.example.pchrp.newdashboard.manager.http.HttpLoginManager;
import com.example.pchrp.newdashboard.manager.http.HttpManager;
import com.example.pchrp.newdashboard.util.SharedPrefManager;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {
    EditText username,password;
    Button btnlogin;

    String user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

//        if(SharedPrefManager.getInstance(Contextor.getInstance().getContext()).getToken().length()>0){
//            Intent intent = new Intent(LogInActivity.this,MainActivity.class);
//            finish();
//            this.startActivity(intent);
//        }

        InitInstances();


    }

    private void InitInstances(){

        username = (EditText)findViewById(R.id.userId);
        password = (EditText)findViewById(R.id.passId);
        btnlogin = (Button)findViewById(R.id.btnLogin);

        btnlogin.setOnClickListener(this);

    }

    public void reqLogin(final String user, final String pass) {

        final Context mcontext = Contextor.getInstance().getContext();
        String nn = "{\"authentication\":{\"username\":\""+user+"\",\"password\":\""+pass+"\"}}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),nn);
        Call<LoginItemDao> call = HttpLoginManager.getInstance().getService().loadAPIToken(requestBody);
        call.enqueue(new Callback<LoginItemDao>() {

            @Override
            public void onResponse(Call<LoginItemDao> call, Response<LoginItemDao> response) {
                if(response.isSuccessful()){
                    LoginItemDao dao = response.body();
                    SharedPrefManager.getInstance(Contextor.getInstance().getContext())
                            .saveLogin(user,pass,dao.getObject().getAuthentication().getAccessToken());

                }else {
                    Toast.makeText(mcontext,"เกิดข้อผิดพลาด",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<LoginItemDao> call, Throwable t) {
                Toast.makeText(mcontext,"ไม่สามารถเชื่อมต่อกับข้อมูลได้",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
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

    @Override
    public void onClick(View v) {
        if(v == btnlogin){

         user =  username.getText().toString();
         pass =  password.getText().toString();
         reqLogin(user,pass);

         if(SharedPrefManager.getInstance(Contextor.getInstance().getContext()).getToken().length()>0){
             Intent intent = new Intent(LogInActivity.this,MainActivity.class);
             finish();
             this.startActivity(intent);
         }
        }
    }
}
