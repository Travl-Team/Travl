package com.example.travl10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TravLFinal9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trav_lfinal9);

        Button button1 = (Button) findViewById(R.id.button10);
        Button button2 = (Button) findViewById(R.id.button11);
        Button button3 = (Button) findViewById(R.id.button12);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TravLFinal9.this, TravL3.class));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TravLFinal9.this, TravL3.class));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TravLFinal9.this, TravL3.class));
            }
        });


    }
}
