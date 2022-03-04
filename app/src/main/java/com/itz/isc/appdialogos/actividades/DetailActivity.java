package com.itz.isc.appdialogos.actividades;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.itz.isc.appdialogos.R;
import com.itz.isc.appdialogos.dialogos.FullScreenDialog;


public class DetailActivity extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_detail);
        if (savedInstanceState == null) {
            crearFullScreenDialog();
        }
    }

    private void crearFullScreenDialog() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FullScreenDialog newFragment = new FullScreenDialog();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.add(android.R.id.content, newFragment, "FullScreenFragment")
                .commit();
    }


    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        FullScreenDialog fragment = (FullScreenDialog) getSupportFragmentManager().findFragmentByTag("FullScreenFragment");
        if (fragment != null) {
            fragment.setDateView(year, monthOfYear, dayOfMonth);
        }
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        FullScreenDialog fragment = (FullScreenDialog) getSupportFragmentManager().findFragmentByTag("FullScreenFragment");
        if (fragment != null) {
            fragment.setTimeView(hourOfDay, minute);
        }
    }
}
