package com.example.app_tfg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FichaImpulsiones extends Activity {
    EditText nombre, year, tarifa, potencia, tipo, caudal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_impulsiones);
        nombre=findViewById(R.id.etiqueta_impulsiones_nombre);
        year=findViewById(R.id.etiqueta_impulsiones_year);
        tarifa=findViewById(R.id.etiqueta_impulsiones_tarifa);
        potencia=findViewById(R.id.etiqueta_impulsiones_potencia);
        tipo=findViewById(R.id.etiqueta_impulsiones_tipo);
        caudal=findViewById(R.id.etiqueta_impulsiones_caudal);

    }

    public void Georreferenciar(View vita){
        Intent i = new Intent(this,Georreferenciar.class);
        i.putExtra("Feature", "Point");
        i.putExtra("tabla","impulsiones");
        i.putExtra("impulsiones_nombre",nombre.getText().toString());
        i.putExtra("impulsiones_year",year.getText().toString());
        i.putExtra("impulsiones_tarifa",tarifa.getText().toString());
        i.putExtra("impulsiones_potencia",potencia.getText().toString());
        i.putExtra("impulsiones_tipo",tipo.getText().toString());
        i.putExtra("impulsiones_caudal",caudal.getText().toString());
        startActivity(i);
    }
}
