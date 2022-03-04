package com.itz.isc.appdialogos.dialogos;


import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;

import android.text.format.DateFormat;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

/**
 * Fragmento con un diálogo de elección de tiempos
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class TimeDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Iniciar con el tiempo actual
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Retornar en nueva instancia del dialogo selector de tiempo
        return new TimePickerDialog(
                getActivity(),
                (TimePickerDialog.OnTimeSetListener) getActivity(),
                hour,
                minute,
                DateFormat.is24HourFormat(getActivity()));
    }

}