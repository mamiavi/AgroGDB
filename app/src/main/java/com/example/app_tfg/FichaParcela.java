package com.example.app_tfg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class FichaParcela extends Activity {
    EditText etiqueta_sistema_riego,etiqueta_tipo_cultivo;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_parcela);
        extras=getIntent().getExtras();
        etiqueta_sistema_riego=findViewById(R.id.etiqueta_sistema_riego);
        etiqueta_tipo_cultivo=findViewById(R.id.etiqueta_tipo_cultivo);
    }

    public void Georreferenciar(View vita){
        Intent i = new Intent(this,Georreferenciar.class);
        i.putExtra("Feature","Polygon");
        i.putExtra("tabla","parcela");
        i.putExtra("sistema_riego",etiqueta_sistema_riego.getText());
        i.putExtra("tipo_cultivo",etiqueta_tipo_cultivo.getText());
        startActivity(i);

    }
}
