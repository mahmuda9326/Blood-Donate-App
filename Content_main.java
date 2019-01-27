package com.example.mitu.bloodbd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Content_main extends AppCompatActivity implements View.OnClickListener{
    private CardView logincardview,becomeDonarcardview,searchDonarcardview,donateBloodcardview,mapcardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_main);

        logincardview = (CardView) findViewById(R.id.logincardviewId);
        becomeDonarcardview = (CardView) findViewById(R.id.becomeadonarcardviewId);
        searchDonarcardview = (CardView) findViewById(R.id.searchdonarcardviewId);
        donateBloodcardview = (CardView) findViewById(R.id.donateBloodcardviewId);
        mapcardview = (CardView) findViewById(R.id.mapcardviewId);

        logincardview.setOnClickListener(this);
        becomeDonarcardview.setOnClickListener(this);
        searchDonarcardview.setOnClickListener(this);
        donateBloodcardview.setOnClickListener(this);
        mapcardview.setOnClickListener(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_options,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.logincardviewId) {
            Intent intent =new Intent(Content_main.this,Login_page.class);
            startActivity(intent);

        } else if (v.getId() == R.id.becomeadonarcardviewId) {
            Intent intent =new Intent(Content_main.this,Doner_registration.class);
            startActivity(intent);

        } else if (v.getId() == R.id.searchdonarcardviewId) {
            Intent intent =new Intent(Content_main.this,SearchDonor.class);
            startActivity(intent);

        }else if (v.getId() == R.id.donateBloodcardviewId) {
            Intent intent =new Intent(Content_main.this,Donate_blood.class);
            startActivity(intent);

        }else if (v.getId() == R.id.mapcardviewId) {
            Intent intent =new Intent(Content_main.this,MapsActivity.class);
            startActivity(intent);

        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.profileId:
                Intent intent = new Intent(Content_main.this,Profile.class);
                startActivity(intent);
        }
        switch (item.getItemId()){
            case R.id.settingId:
                Intent intent = new Intent(Content_main.this,Settings.class);
                startActivity(intent);
        }
        switch (item.getItemId()){
            case R.id.aboutId:
                Intent intent = new Intent(Content_main.this,About.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
