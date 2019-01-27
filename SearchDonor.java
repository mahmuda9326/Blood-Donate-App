package com.example.mitu.bloodbd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;


public class SearchDonor extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    /*private ListView listView;
    private SearchView searchView;*/
    private Spinner spinner1,spinner2;
    private Button search;
    private TextView textView;
    private ImageView imageView;
    String[] cityname,bloodgroup;
    ArrayAdapter<String> cityadapter,bloodgroupadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_donor);

        imageView = (ImageView) findViewById(R.id.searchimageviewId);
        textView = (TextView) findViewById(R.id.choosecityId);
        textView = (TextView) findViewById(R.id.chooseBloodId);

        addListenerOnButton();

       /* listView = (ListView) findViewById(R.id.listviewId);
        searchView = (SearchView) findViewById(R.id.searviewId);
        adapter = new ArrayAdapter<String>(SearchDonor.this,R.layout.activity_search_result,R.id.resultviewId,cityname);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;
            }
        });*/
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
                Intent intent = new Intent(SearchDonor.this,Profile.class);
                startActivity(intent);
        }
        switch (item.getItemId()){
            case R.id.settingId:
                Intent intent = new Intent(SearchDonor.this,Settings.class);
                startActivity(intent);
        }
        switch (item.getItemId()){
            case R.id.aboutId:
                Intent intent = new Intent(SearchDonor.this,Settings.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
  @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

         spinner1=(Spinner)parent;
         spinner2=(Spinner)parent;
        if (spinner1.getId()==R.id.cityId) {
            spinner1.getSelectedItem().toString();
        }
        if (spinner2.getId()==R.id.bloodGroupId) {
            spinner2.getSelectedItem().toString();
        }
    }
  public void onNothingSelected(AdapterView<?> arg0) {
      // TODO Auto-generated method stub

  }

    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.cityId);
        spinner2 = (Spinner) findViewById(R.id.bloodGroupId);
        search = (Button) findViewById(R.id.searchId);

        search.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

//                spinner1 = (Spinner) findViewById(R.id.cityId);
//                spinner2 = (Spinner) findViewById(R.id.bloodGroupId);

//                cityname = getResources().getStringArray(R.array.City_Name);
//                bloodgroup = getResources().getStringArray(R.array.Blood_type);
//                cityadapter = new ArrayAdapter<String>(SearchDonor.this,R.layout.activity_search_result,R.id.citynameviewId,cityname);
//                cityadapter.setDropDownViewResource(R.layout.activity_search_result);
//                spinner1.setAdapter(cityadapter);

//                bloodgroupadapter = new ArrayAdapter<String>(SearchDonor.this,R.layout.activity_search_result,R.id.bloodtypeviewId,bloodgroup);
//                bloodgroupadapter.setDropDownViewResource(R.layout.activity_search_result);
//                spinner2.setAdapter(bloodgroupadapter);

//                Intent intent = new Intent(SearchDonor.this, SearchResult.class);
//                intent.putExtra("message", message);
//                startActivity(intent);

                Intent intent = new Intent(SearchDonor.this,SearchResult.class);
                intent.putExtra("cityname",spinner1.getSelectedItem().toString());
                intent.putExtra("bloodgroup",spinner2.getSelectedItem().toString());
                startActivity(intent);

                /*Toast.makeText(SearchDonor.this,
                        "OnClickListener : " +
                                "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) +
                                "\nSpinner 2 : "+ String.valueOf(spinner2.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();*/
            }
        });
    }

}
