package com.itz.isc.appdialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

/**
 * Fragmento con un diálogo que muestra radio buttons
 */
public class ListRadioDialog extends DialogFragment {

    public ListRadioDialog() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return createRadioListDialog();
    }

    /**
     * Crea un diálogo con una lista de radios
     *
     * @return Diálogo
     */
    public AlertDialog createRadioListDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final CharSequence[] items = new CharSequence[3];

        items[0] = "Soltero/a";
        items[1] = "Casado/a";
        items[2] = "Divorciado/a";

        builder.setTitle("Estado Civil")
                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(
                                getActivity(),
                                "Seleccionaste: " + items[which],
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        return builder.create();
    }

}

