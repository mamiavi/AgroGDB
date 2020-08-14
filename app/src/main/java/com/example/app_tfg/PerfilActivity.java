package com.example.app_tfg;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.preference.PreferenceManager;

import java.sql.Connection;
import java.sql.SQLException;


public class PerfilActivity extends Activity {

    EditText denominacion,direccion,telefonoER,nombre,cargo,telf_persona;
    conexionPSQL con = new conexionPSQL();
    public Variables_Globales va = Variables_Globales.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_perfil);

        denominacion=findViewById(R.id.text_denominacion);
        direccion=findViewById(R.id.text_direccion);
        telefonoER=findViewById(R.id.text_telfrc);
        nombre=findViewById(R.id.text_nombre);
        cargo=findViewById(R.id.text_posicionrc);
        telf_persona=findViewById(R.id.text_telfpersonal);

        Button btnGuardar = findViewById(R.id.btnGuadarDatos);

         btnGuardar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Connection conexion= con.conexionBD();


                 try {
                     //DATOS PERSONALES
                     conexion.prepareStatement("insert into public.\"FICHA_PERSONAL\"(\"NOMBRE\",\"POSICION\",\"TELEFONO\") VALUES (\'"+nombre.getText().toString()+"\',\'"+cargo.getText().toString()+"\',"+Integer.parseInt(telf_persona.getText().toString())+")").executeUpdate();

                     //DATOS COMUNIDAD
                     conexion.prepareStatement("insert into public.\"EERR\"(\"DENOMINACION\",\"DIRECCION\",\"TELEFONO\") VALUES (\'"+denominacion.getText().toString()+"\',\'"+direccion.getText().toString()+"\',"+Integer.parseInt(telefonoER.getText().toString())+")").executeUpdate();

                 } catch (SQLException e) {
                     e.printStackTrace();
                 }

                 va.setDenominacion(denominacion.getText().toString());
                 va.set_tlf_personal(Integer.parseInt(telf_persona.getText().toString()));
                 finish();

             }
         });
    }


    public void onPause(){
        super.onPause();

        SharedPreferences datos= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor miEditor=datos.edit();
        miEditor.putString("denominacion",""+(denominacion.getText()));
        miEditor.putString("direccion",""+(direccion.getText()));
        miEditor.putString("telefonoER",""+(telefonoER.getText()));
        miEditor.putString("nombre",""+(nombre.getText()));
        miEditor.putString("cargo",""+(cargo.getText()));
        miEditor.putString("telf_personal",""+(telf_persona.getText()));
        miEditor.apply();

    }

    public void onResume(){
        super.onResume();

        SharedPreferences datos= PreferenceManager.getDefaultSharedPreferences(this);
        denominacion.setText(datos.getString("denominacion",""));
        direccion.setText(datos.getString("direccion",""));
        telefonoER.setText(datos.getString("telefonoER",""));
        nombre.setText(datos.getString("nombre",""));
        cargo.setText(datos.getString("cargo",""));
        telf_persona.setText(datos.getString("telf_personal",""));
    }






}
