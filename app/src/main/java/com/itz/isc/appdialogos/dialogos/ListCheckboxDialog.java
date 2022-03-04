package com.itz.isc.appdialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

/**
 * Diálogo con checkboxes
 */
public class ListCheckboxDialog extends DialogFragment {

    public ListCheckboxDialog() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return createMultipleListDialog();
    }

    /**
     * Crea un diálogo con una lista de checkboxes
     * de selección multiple
     *
     * @return Diálogo
     */
    public AlertDialog createMultipleListDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final ArrayList itemsSeleccionados = new ArrayList();

        CharSequence[] items = new CharSequence[3];

        items[0] = "Desarrollo Android";
        items[1] = "Diseño De Bases De Datos";
        items[2] = "Pruebas Unitarias";

        builder.setTitle("Intereses")
                .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            // Guardar indice seleccionado
                            itemsSeleccionados.add(which);
                            Toast.makeText(
                                    getActivity(),
                                    "Checks seleccionados:(" + itemsSeleccionados.size() + ")",
                                    Toast.LENGTH_SHORT)
                                    .show();
                        } else if (itemsSeleccionados.contains(which)) {
                            // Remover indice sin selección
                            itemsSeleccionados.remove(Integer.valueOf(which));
                        }
                    }
                });

        return builder.create();
    }

}

