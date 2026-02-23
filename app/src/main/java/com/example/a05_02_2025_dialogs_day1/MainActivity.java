package com.example.a05_02_2025_dialogs_day1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnAlertDialog,btnDatePickerDialog,btnTimePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnAlertDialog = findViewById(R.id.btnAlertDialog);
        btnDatePickerDialog = findViewById(R.id.btnDatePickerDialog);
        btnTimePickerDialog = findViewById(R.id.btnTimePickerDialog);

        btnAlertDialog.setOnClickListener(new BtnAlertDialogClickListener());
        btnDatePickerDialog.setOnClickListener(new BtnDatePickerClickDialogListener());
        btnTimePickerDialog.setOnClickListener(new BtnTimePickerDialogClickListener());
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

        }
    }

    public class BtnTimePickerDialogClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {

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
}