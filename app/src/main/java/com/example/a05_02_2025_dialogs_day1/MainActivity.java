package com.example.a05_02_2025_dialogs_day1;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnAlertDialog,btnDatePickerDialog,btnTimePickerDialog, btnProgressDialog;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnAlertDialog = findViewById(R.id.btnAlertDialog);
        btnDatePickerDialog = findViewById(R.id.btnDatePickerDialog);
        btnTimePickerDialog = findViewById(R.id.btnTimePickerDialog);
        btnProgressDialog = findViewById(R.id.btnProgressDialog);

        btnAlertDialog.setOnClickListener(new BtnAlertDialogClickListener());
        btnDatePickerDialog.setOnClickListener(new BtnDatePickerClickDialogListener());
        btnTimePickerDialog.setOnClickListener(new BtnTimePickerDialogClickListener());
        btnProgressDialog.setOnClickListener(new MyProgressDialogClickListener());
    }

    public class MyProgressDialogClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Downloading");
            progressDialog.setMessage("Please wait...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setMax(100);
            progressDialog.setCancelable(false);
            progressDialog.show();

            //way 1- Thread class
            Thread thread = new Thread(new MyProgressBarClickListener(), "thread_1");
            thread.start();

            //way 2
            // Updating progress on a background thread to avoid blocking the UI
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        for (int i = 0; i <= 100; i++) {
//                            Thread.sleep(50); // Simulate work delay
//                            progressDialog.setProgress(i);
//                        }
//                        progressDialog.dismiss();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
        }
    }

    class MyProgressBarClickListener implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(50); // Simulate work delay
                    progressDialog.setProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public class BtnAlertDialogClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

            alertDialogBuilder.setTitle("Submit Exam");
            alertDialogBuilder.setMessage("Do you want to submit the exam?");
            alertDialogBuilder.setIcon(R.drawable.ic_launcher_background);

            //way 1
//            alertDialogBuilder.setPositiveButton("Yes",new AlertDialogPositiveBtnClickListener());
//            alertDialogBuilder.setNegativeButton("No",new AlertDialogNegativeBtnClickListener());
//            alertDialogBuilder.setNeutralButton("Ok",new AlertDialogNeutralBtnClickListener());

            //way 2
            alertDialogBuilder.setPositiveButton("Yes",new AlertDialogBtnClickListener());
            alertDialogBuilder.setNegativeButton("No",new AlertDialogBtnClickListener());
            alertDialogBuilder.setNeutralButton("Ok",new AlertDialogBtnClickListener());

            alertDialogBuilder.create();
            alertDialogBuilder.show();
        }
    }

    public class BtnDatePickerClickDialogListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    MainActivity.this,
                    new MyDatePickerClickListener(),
                    1980,
                    2,          //month starts with index 0
                    12);
            datePickerDialog.create();
            datePickerDialog.show();
        }
    }

    public class BtnTimePickerDialogClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            TimePickerDialog timePickerDialog= new TimePickerDialog(
                    MainActivity.this,
                    new MyTimePickerClickListener(),
                    4,
                    34,
                    true);
            timePickerDialog.create();
            timePickerDialog.show();
        }
    }

    public class AlertDialogBtnClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            switch (which){
                case -1:
                    Toast.makeText(MainActivity.this,"Yes Clicked  " + which,Toast.LENGTH_LONG).show();
                    break;
                case -2:
                    Toast.makeText(MainActivity.this,"No Clicked  " + which,Toast.LENGTH_LONG).show();
                    break;
                case -3:
                    Toast.makeText(MainActivity.this,"Neutral Clicked  " + which,Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

    public class AlertDialogPositiveBtnClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this,"Yes Clicked  " + i,Toast.LENGTH_LONG).show();
        }
    }

    public class AlertDialogNegativeBtnClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this,"No Clicked  " + i,Toast.LENGTH_LONG).show();
        }
    }

    public class AlertDialogNeutralBtnClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this,"Neutral Clicked  " + i,Toast.LENGTH_LONG).show();
        }
    }


    public class MyDatePickerClickListener implements DatePickerDialog.OnDateSetListener{
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            Toast.makeText(MainActivity.this,
                    "i : " + year + " i1 : " + month + "  i2 :" + day,
                    Toast.LENGTH_LONG).
                    show();
        }
    }

    public class MyTimePickerClickListener implements TimePickerDialog.OnTimeSetListener{
        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int minutes) {
            Toast.makeText(MainActivity.this,
                    "time is : " + hour +":" + minutes,
                    Toast.LENGTH_LONG)
                    .show();
        }
    }
}
