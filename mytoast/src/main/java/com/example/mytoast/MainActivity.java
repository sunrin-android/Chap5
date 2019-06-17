package com.example.mytoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
    }

    public void onButtonClicked(View v) {
        Toast toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);

        int xOffset = Integer.valueOf(edit1.getText().toString());
        int yOffset = Integer.valueOf(edit2.getText().toString());

        toast.setGravity(Gravity.CENTER, xOffset, yOffset);
        toast.setText("텍스트 위치 바꿔 보여주기");
        toast.show();
    }

    public void onButton2Clicked(View v) {
        LayoutInflater inflater = getLayoutInflater();
        View toastview = inflater.inflate(R.layout.toastview, null);
        TextView text = toastview.findViewById(R.id.text1);
        text.setText("모양 바꾼 토스트");

        Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER, 0, -200);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(toastview);
        toast.show();
    }
}
