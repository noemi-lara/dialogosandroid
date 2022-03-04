package com.itz.isc.appdialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import com.itz.isc.appdialogos.R;


/**
 * Fragmento con un diálogo personalizado
 */
public class LoginDialog extends DialogFragment {
    private static final String TAG = LoginDialog.class.getSimpleName();

    public LoginDialog() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return createLoginDialogo();
    }

    /**
     * Crea un diálogo con personalizado para comportarse
     * como formulario de login
     *
     * @return Diálogo
     */
    public AlertDialog createLoginDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.dialog_signin, null);

        builder.setView(v);

        Button signup = (Button) v.findViewById(R.id.crear_boton);
        Button signin = (Button) v.findViewById(R.id.entrar_boton);

        signup.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Crear Cuenta...
                        dismiss();
                    }
                }
        );

        signin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Loguear...
                        dismiss();
                    }
                }

        );

        return builder.create();
    }

}

