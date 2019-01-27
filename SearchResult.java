package com.example.mitu.bloodbd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;

public class SearchResult extends AppCompatActivity /*implements AdapterView.OnItemSelectedListener*/{
    private EditText displayCity,displayBloodType;
    private Spinner spinner1,spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        displayCity = (EditText) findViewById(R.id.citynameviewId);
        displayBloodType = (EditText) findViewById(R.id.bloodtypeviewId);

        Bundle b;
        b = getIntent().getExtras();
        //cityname = intent.getStringExtra("cityname");
        displayCity.setText(b.getString("cityname"));
        displayBloodType.setText(b.getString("bloodgroup"));
        //displayTable = String.valueOf(spinner1.getSelectedItem();

         /*bloodgroup = intent.getStringExtra("bloodtype");
        displayTable = (TextView) findViewById(R.id.resultviewId);
        displayTable.setText(bloodgroup);*/
    }
/*@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spinner1=(Spinner)parent;
        Spinner spinner2=(Spinner)parent;
        if (spinner1.getId()==R.id.cityId) {
            String item = parent.getItemAtPosition(position).toString();
            displayTable.setText(item);
        }
        if (spinner2.getId()==R.id.bloodGroupId) {
            String item = parent.getItemAtPosition(position).toString();
            displayTable.setText(item);
        }
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }*/

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
                Intent intent = new Intent(SearchResult.this,Profile.class);
                startActivity(intent);
        }
        switch (item.getItemId()){
            case R.id.settingId:
                Intent intent = new Intent(SearchResult.this,Settings.class);
                startActivity(intent);
        }
        switch (item.getItemId()){
            case R.id.aboutId:
                Intent intent = new Intent(SearchResult.this,Settings.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
