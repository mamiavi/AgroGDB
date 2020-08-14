package com.example.app_tfg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FichaCabezal extends Activity {
    EditText nombre, tipo, dimensiones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cabezales);
        nombre=findViewById(R.id.etiqueta_cabezal_nombre);
        tipo=findViewById(R.id.etiqueta_cabezal_tipo);
        dimensiones=findViewById(R.id.etiqueta_cabezal_dimensiones);
    }

    public void Georreferenciar(View vita){
        Intent i = new Intent(this,Georreferenciar.class);
        i.putExtra("Feature", "Point");
        i.putExtra("tabla","cabezal");
        i.putExtra("cabezales_nombre",nombre.getText().toString());
        i.putExtra("cabezales_tipo",tipo.getText().toString());
        i.putExtra("cabezales_dimensiones",dimensiones.getText());
        startActivity(i);
    }
}
