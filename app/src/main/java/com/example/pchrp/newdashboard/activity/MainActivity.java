package com.example.pchrp.newdashboard.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pchrp.newdashboard.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


        CardView cv_bill,Cv_pay,Cv_drink;

        CardView cv_in_bill,cv_in_pay,cv_in_drink;

        TextView menutextbill,menupay,menudrink;

        ImageView imgbill,imgpay,imgdrink;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            initInstances();

        }

        private void initInstances() {
            cv_bill = (CardView)findViewById(R.id.Cv_bill);
            Cv_pay = (CardView)findViewById(R.id.Cv_pay);
            Cv_drink = (CardView)findViewById(R.id.Cv_drink);

            cv_in_bill = (CardView)findViewById(R.id.cv_in_bill);
            cv_in_pay = (CardView)findViewById(R.id.cv_in_pay);
            cv_in_drink = (CardView)findViewById(R.id.cv_in_drink);

            menutextbill = (TextView)findViewById(R.id.menutextbill);
            menupay = (TextView)findViewById(R.id.menupay);
            menudrink = (TextView)findViewById(R.id.menudrink);

            imgbill = (ImageView)findViewById(R.id.imgbill);
            imgpay = (ImageView)findViewById(R.id.imgpay);
            imgdrink = (ImageView)findViewById(R.id.imgdrink);



            cv_bill.setOnClickListener(this);
            Cv_pay.setOnClickListener(this);
            Cv_drink.setOnClickListener(this);

            cv_in_bill.setOnClickListener(this);
            cv_in_pay.setOnClickListener(this);
            cv_in_drink.setOnClickListener(this);

            menutextbill.setOnClickListener(this);
            menupay.setOnClickListener(this);
            menudrink.setOnClickListener(this);

            imgbill.setOnClickListener(this);
            imgpay.setOnClickListener(this);
            imgdrink.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if (v==cv_bill||v==cv_in_bill||v==menutextbill||v==imgbill){
                Intent intent = new Intent(MainActivity.this,BillActivity.class);
                this.startActivity(intent);
                //this.finish();
            }
            if (v==Cv_pay||v==cv_in_pay||v==menupay||v==imgpay){
                Intent intent = new Intent(MainActivity.this,PaymentActivity.class);
                this.startActivity(intent);
                //this.finish();
            }
            if (v==Cv_drink||v==cv_in_drink||v==menudrink||v==imgdrink){
                Intent intent = new Intent(MainActivity.this,DrinkActivity.class);
                this.startActivity(intent);
                //this.finish();
            }
        }
    }