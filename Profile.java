package com.example.mitu.bloodbd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class Profile extends AppCompatActivity {
    private EditText name,bloodtype,age,weight,phone,email,address,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = (EditText) findViewById(R.id.pptextId);
        bloodtype = (EditText) findViewById(R.id.bloodviewId);
        age = (EditText) findViewById(R.id.ageviewId);
        weight = (EditText) findViewById(R.id.weightviewId);
        phone = (EditText) findViewById(R.id.phonenumberviewId);
        email = (EditText) findViewById(R.id.emailviewId);
        address = (EditText) findViewById(R.id.addressviewId);
        date = (EditText) findViewById(R.id.lastdonateviewId);
//        Bundle bu;
//        bu = getIntent().getExtras();
//        //String str = intent.getStringExtra("name");
//        name.setText(bu.getString("name"));
//        bloodtype.setText(bu.getString("bloodgroup"));
//        age.setText(bu.getString("age"));
//        weight.setText(bu.getString("weight"));
//        phone.setText(bu.getString("phonenumber"));
//        email.setText(bu.getString("email"));
//        address.setText(bu.getString("address"));
//        date.setText(bu.getString("date"));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.profile,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.mainId:
                Intent intent = new Intent(Profile.this,Content_main.class);
                startActivity(intent);
        }
        switch (item.getItemId()){
            case R.id.settingId:
                Intent intent = new Intent(Profile.this,Settings.class);
                startActivity(intent);
        }
        switch (item.getItemId()){
            case R.id.aboutId:
                Intent intent = new Intent(Profile.this,About.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }
}
