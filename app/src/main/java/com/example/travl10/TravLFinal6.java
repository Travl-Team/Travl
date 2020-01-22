package com.example.travl10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class TravLFinal6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trav_lfinal6);

        Button button6 = (Button) findViewById(R.id.button17);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TravLFinal6.this, MainActivity.class));


            }
        });

        new Thread(new Runnable() {
            public void run() {

                String email = "f@k.com";
                String password = "letmein";

                String fname = "lucas";
                String lname = "luke";
                String city = "edmonton";
                String province = "alberta";
                //name1=value1&name2=value2
                String myURL = "https://www.nicholasreis.com/tour/signup.php?email=" + email + "&password=" + password + "&fname=" + fname + "&lname=" + lname + "&city" + city + "&province" + province;
                StringBuilder sb = new StringBuilder();
                URLConnection urlConn = null;
                InputStreamReader in = null;
                try {
                    URL url = new URL(myURL);
                    urlConn = url.openConnection();
                    if (urlConn != null)
                        urlConn.setReadTimeout(60 * 1000);
                    if (urlConn != null && urlConn.getInputStream() != null) {
                        in = new InputStreamReader(urlConn.getInputStream(),
                                Charset.defaultCharset());
                        BufferedReader bufferedReader = new BufferedReader(in);
                        if (bufferedReader != null) {
                            int cp;
                            while ((cp = bufferedReader.read()) != -1) {
                                sb.append((char) cp);
                            }
                            bufferedReader.close();
                        }
                    }
                    in.close();
                } catch (Exception e) {
                    throw new RuntimeException("Exception while calling URL:" + myURL, e);
                }


            }
        }).start();




    }



}
