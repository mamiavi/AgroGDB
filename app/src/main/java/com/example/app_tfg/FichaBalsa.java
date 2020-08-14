package com.example.app_tfg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class FichaBalsa extends Activity {

    EditText nombre, year, capacidad, estado, materiales, problemas,funcion;
    CheckBox filtraciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_balsa);
        nombre=findViewById(R.id.etiqueta_balsa_nombre);
        year=findViewById(R.id.etiqueta_balsa_ano);
        capacidad=findViewById(R.id.etiqueta_balsa_capacidad);
        estado=findViewById(R.id.etiqueta_balsa_estado);
        materiales=findViewById(R.id.etiqueta_balsa_materiales);
        problemas=findViewById(R.id.etiqueta_balsa_problemas);
        filtraciones=findViewById(R.id.checkBox_balsa_filtraciones);
        funcion=findViewById(R.id.etiqueta_balsa_funcion);
    }

    public void Georreferenciar(View vita){
        Intent i = new Intent(this,Georreferenciar.class);
        i.putExtra("Feature","Polygon");
        i.putExtra("tabla","balsa");
        i.putExtra("balsa_nombre",nombre.getText().toString());
        i.putExtra("balsa_ano",year.getText());
        i.putExtra("balsa_capacidad",capacidad.getText());
        i.putExtra("balsa_estado",estado.getText().toString());
        i.putExtra("balsa_materiales",materiales.getText().toString());
        i.putExtra("balsa_problemas",problemas.getText().toString());
        i.putExtra("balsa_filtraciones",filtraciones.isChecked());
        i.putExtra("balsa_funcion",funcion.getText().toString());
        startActivity(i);
    }


}
