package com.example.myalert;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2, button3, button4, button5, button6;
    AlertDialog alertDialog;
    String[] item;
    String msg;
    Integer index;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == button1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setTitle("알림");
            builder.setMessage("정말 종료하시겠습니까?");
            builder.setPositiveButton("OK", null);
            builder.setNegativeButton("CANCEL", null);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        } else if (v == button2) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("입장권 판매");
            item = new String[]{"어른", "청소년", "어린이", "유아"};
            builder.setItems(item, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    showToast(item[which] + "이(가) 선택되었습니다.");
                }
            });
            builder.setNegativeButton("취소", null);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        } else if (v == button3) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("알람 벨소리");
            builder.setSingleChoiceItems(R.array.dialog_array, index, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    index = which;

                }
            });
            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String[] datas = getResources().getStringArray(R.array.dialog_array);
                    String s = datas[index];
                    showToast(s + "이(가) 선택되었습니다.");
                }
            });
            builder.setNegativeButton("취소", null);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        } else if (v == button4){
            // custom dialog 인플레이션
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(R.layout.custom_dialog);
            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if(checkBox.isChecked())
                        showToast("dialog checkbox is checked");
                    else
                        showToast("dialog checkbox is unchecked");
                }
            });
            builder.setNegativeButton("취소", null);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            checkBox = alertDialog.findViewById(R.id.check);
        }
        else if(v == button5){
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dateDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    showToast(year + "/" + (month + 1) + "/" + dayOfMonth);
                }
            }, year, month, day);
            dateDialog.show();
        }
        else if(v == button6){
            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            TimePickerDialog timeDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    showToast(hourOfDay + ":" + minute);
                }
            }, hour, minute, true);
            timeDialog.show();
        }
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT);
    }
}
