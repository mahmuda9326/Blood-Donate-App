package com.example.mitu.bloodbd;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class Doner_registration extends Activity {

    private ImageView regImageview;
    private EditText regname,regAge,regWeight,regPhoneNumber,regEmail,regaddress,reglasrdonateDate;
    private Button regButton;
    private Spinner regBloodGroup,regGender;
    String result,name,bloodGroup,gender,age,weight,phone,email,address,donateDate;
    ArrayAdapter genderadapter,bloodgroupadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doner_registration);

        regImageview = (ImageView) findViewById(R.id.regImageId);
        regname = (EditText) findViewById(R.id.regnameId);
        regBloodGroup = (Spinner) findViewById(R.id.regBloodgroupId);
        regGender = (Spinner) findViewById(R.id.regGenderId);
        regAge = (EditText) findViewById(R.id.regAgeId);
        regWeight = (EditText) findViewById(R.id.regWeightId);
        regPhoneNumber = (EditText) findViewById(R.id.regPhonenumberId);
        regEmail = (EditText) findViewById(R.id.regEmailId);
        regaddress = (EditText) findViewById(R.id.regAddressId);
        reglasrdonateDate = (EditText) findViewById(R.id.regLastdonateId);

        bloodgroupadapter = ArrayAdapter.createFromResource(this, R.array.Blood_type, R.layout.spinner);
        bloodgroupadapter.setDropDownViewResource(R.layout.spinner);
        regBloodGroup.setAdapter(bloodgroupadapter);

        genderadapter = ArrayAdapter.createFromResource(this, R.array.Gender, R.layout.spinner);
        genderadapter.setDropDownViewResource(R.layout.spinner);
        regGender.setAdapter(genderadapter);

/*        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(Doner_registration.this,R.layout.spinner,R.array.Blood_type);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner);
        regBloodGroup.setAdapter(spinnerArrayAdapter);*/
    }

    public void register(View v){

       new Register().execute();
    }

    class Register extends AsyncTask<String, Void,Long > {

        protected Long doInBackground(String... urls) {

            name = regname.getText().toString();
            bloodGroup = regBloodGroup.getSelectedItem().toString();
            gender = regGender.getSelectedItem().toString();
            age = regAge.getText().toString();
            weight = regWeight.getText().toString();
            phone = regPhoneNumber.getText().toString();
            email = regEmail.getText().toString();
            address = regaddress.getText().toString();
            donateDate = reglasrdonateDate.getText().toString();

            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://franceimmigrationapply.com/BloodBD/register.php");

            try {
                // Add your data
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(9);
                nameValuePairs.add(new BasicNameValuePair("Name", name));
                nameValuePairs.add(new BasicNameValuePair("BloodGroup", bloodGroup));
                nameValuePairs.add(new BasicNameValuePair("Gender", gender));
                nameValuePairs.add(new BasicNameValuePair("Age", age));
                nameValuePairs.add(new BasicNameValuePair("Weight", weight));
                nameValuePairs.add(new BasicNameValuePair("Phone", phone));
                nameValuePairs.add(new BasicNameValuePair("Email", email));
                nameValuePairs.add(new BasicNameValuePair("Address", address));
                nameValuePairs.add(new BasicNameValuePair("DonateDate", donateDate));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                // Execute HTTP Post Request
                HttpResponse response = httpclient.execute(httppost);

            } catch (Exception e) {
                // TODO Auto-generated catch block
            }
            Intent intent = new Intent(Doner_registration.this,Content_main.class);
            startActivity(intent);

            return null;

        }
        protected void onProgressUpdate(Integer... progress) {

        }

        protected void onPostExecute(Long result) {

        }
    }

    public void hidekeybroad(View view) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
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
                Intent intent = new Intent(Doner_registration.this,Profile.class);
                startActivity(intent);
        }
        switch (item.getItemId()){
            case R.id.settingId:
                Intent intent = new Intent(Doner_registration.this,Settings.class);
                startActivity(intent);
        }
        switch (item.getItemId()){
            case R.id.aboutId:
                Intent intent = new Intent(Doner_registration.this,Settings.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
