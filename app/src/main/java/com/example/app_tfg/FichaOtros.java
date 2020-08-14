package com.example.app_tfg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FichaOtros extends Activity {


    EditText etiqueta_nombre, etiqueta_year, etiqueta_desc;
    String nombre,year,desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_otros);
        etiqueta_nombre=findViewById(R.id.otros_nombre);
        etiqueta_year=findViewById(R.id.otros_ano);
        etiqueta_desc=findViewById(R.id.otros_desc);
    }



    public void Georreferenciar(View vita){

        nombre=etiqueta_nombre.getText().toString();
        year=etiqueta_year.getText().toString();
        desc=etiqueta_desc.getText().toString();

        Intent i = new Intent(this, Georreferenciar.class);
        i.putExtra("Feature", "Point");
        i.putExtra("tabla","otros");
        i.putExtra("otros_nombre",nombre);
        i.putExtra("otros_year",year);
        i.putExtra("otros_desc",desc);

        startActivity(i);
    }
}
