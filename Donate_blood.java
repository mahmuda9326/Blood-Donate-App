package com.example.mitu.bloodbd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Donate_blood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_blood);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_options,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.profileId:
                Intent intent = new Intent(Donate_blood.this,Profile.class);
                startActivity(intent);
        }
        switch (item.getItemId()){
            case R.id.settingId:
                Intent intent = new Intent(Donate_blood.this,Settings.class);
                startActivity(intent);
        }
        switch (item.getItemId()){
            case R.id.aboutId:
                Intent intent = new Intent(Donate_blood.this,Settings.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
