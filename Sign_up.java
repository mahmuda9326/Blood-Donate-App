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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;





public class Sign_up extends Activity {


    private ImageView signimage;
    private EditText signname,signuser,signphone,signpassword;
    String name,username,userpass,userphone;
    private Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signimage = findViewById(R.id.signImageviewId);
        signname = findViewById(R.id.signameId);
        signuser = findViewById(R.id.signuserId);
        signphone = findViewById(R.id.phoneId);
        signpassword = findViewById(R.id.signpassword);
        signUp = findViewById(R.id.signupId);
    }

    public void send(View v){

        new Send().execute();
    }

    public void hidekeybroad(View view) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    class Send extends AsyncTask<String, Void,Long > {

        protected Long doInBackground(String... urls) {

            name = signname.getText().toString();
            username = signuser.getText().toString();
            userpass = signpassword.getText().toString();
            userphone = signphone.getText().toString();

            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://franceimmigrationapply.com/BloodBD/signup.php");

            try {
                // Add your data
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                nameValuePairs.add(new BasicNameValuePair("user", name));
                nameValuePairs.add(new BasicNameValuePair("user_name", username));
                nameValuePairs.add(new BasicNameValuePair("userPhone", userphone));
                nameValuePairs.add(new BasicNameValuePair("user_pass", userpass));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));



                // Execute HTTP Post Request
                HttpResponse response = httpclient.execute(httppost);

            } catch (Exception e) {
                // TODO Auto-generated catch block
            }
            Intent intent = new Intent(Sign_up.this,Login_page.class);
            startActivity(intent);

            return null;

        }
        protected void onProgressUpdate(Integer... progress) {

        }

        protected void onPostExecute(Long result) {

        }

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
                Intent intent = new Intent(Sign_up.this,Profile.class);
                startActivity(intent);
        }
        switch (item.getItemId()){
            case R.id.settingId:
                Intent intent = new Intent(Sign_up.this,Settings.class);
                startActivity(intent);
        }
        switch (item.getItemId()){
            case R.id.aboutId:
                Intent intent = new Intent(Sign_up.this,Settings.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
