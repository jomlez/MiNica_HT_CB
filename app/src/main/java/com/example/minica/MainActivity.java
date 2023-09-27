package com.example.minica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etc, etp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etc = (EditText) findViewById(R.id.txt_ingresCorreo);
        etp = (EditText) findViewById(R.id.txt_ingresPass);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        etc.setText(preferences.getString("correo", ""));
    }

    //Metodo para guel boton de guardar
    /*public void Guardar(View view) {
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = preferencias.edit();
        Obj_editor.putString("correo", etc.getText().toString());
        Obj_editor.commit();
    }*/

    //Moverse a ventana de registros
    public void registrarse(View view) {
        Intent registro = new Intent(this, Registro_usuario.class);
        startActivity(registro);
    }

    //Verificacion de inicio de sesion
    public void inicio_sesion(View view) {
        String correo = etc.getText().toString();
        String pass = etp.getText().toString();

        if(correo.length() == 0){
            Toast.makeText(this, "Ingrese un correo", Toast.LENGTH_SHORT).show();
        }
        if(pass.length() == 0){
            Toast.makeText(this, "Ingrese una contraseña", Toast.LENGTH_SHORT).show();
        } else if(pass.length() <= 8){
            Toast.makeText(this,"La contraseña debe ser mayor a 8", Toast.LENGTH_LONG).show();
        }
        if((correo.length() != 0) && (pass.length() >= 8)){
            Toast.makeText(this,"Verificando", Toast.LENGTH_LONG).show();
            SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
            SharedPreferences.Editor Obj_editor = preferencias.edit();
            Obj_editor.putString("correo", etc.getText().toString());
            Obj_editor.commit();
        }
    }
}