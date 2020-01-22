package com.example.travl10;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.net.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import android.os.Bundle;
import android.content.Intent;

import android.os.StrictMode;
import android.view.View;
//import android.net.Uri;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

  //  public void main(String[] args) {

  //  }
//System.out.println(output);


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // new RetrieveFeedTask().execute(urlToRssFeed);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        Button button1 = (Button) findViewById(R.id.button3);
        Button button2 = (Button) findViewById(R.id.button4);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TravLFinal6.class));
            }
        });


        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String output="";
                new Thread(new Runnable(){
                    public void run() {
                        EditText txt=findViewById(R.id.editText3);
                        String email = txt.getText().toString();
                        String password = "letmein"; //name1=value1&name2=value2
                        String myURL ="https://www.nicholasreis.com/tour/loginHook.php?email="+email+"&password="+password;
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
                            throw new RuntimeException("Exception while calling URL:"+ myURL, e);
                        }
                        String output = sb.toString();
                        if(output.charAt(0) == 'f'){
                            System.out.println("Fail!");
                        }
                        System.out.println(output);
                        if (output.charAt(0)=='u') {
                            System.out.println("asdasd");
                            startActivity(new Intent(MainActivity.this, TravL3.class));
                        }
                        if (output.charAt(0)=='g'){
                            startActivity(new Intent(MainActivity.this,TravLFinal11.class));
                        }



                    }

                }).start();
            }
        });
    }
}