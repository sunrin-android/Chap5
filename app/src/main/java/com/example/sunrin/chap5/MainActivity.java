package com.example.sunrin.chap5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button button1;
    LinearLayout container;
    CheckBox check;
    Integer count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        container = findViewById(R.id.container);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count == 0) {
                    //sub.xml 인플레이션
                    LayoutInflater inflater = getLayoutInflater();
                    inflater.inflate(R.layout.sub, container);
                    CheckBox check = findViewById(R.id.check);
                }
                count++;
                check.setText(count.toString());
                check.setChecked(true);
            }
        });
    }
}
