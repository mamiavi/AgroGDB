package com.example.app_tfg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class FichaPozo extends Activity {
    EditText nombre, year, concesion, profundidad, diametro, nivel, tarifa, potencia, bomba, caudal, altura;
    CheckBox variador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pozo);
        nombre=findViewById(R.id.etiqueta_pozo_nombre);
        year=findViewById(R.id.etiqueta_pozo_year);
        concesion=findViewById(R.id.etiqueta_pozo_concesion);
        profundidad=findViewById(R.id.etiqueta_pozo_profundidad);
        diametro=findViewById(R.id.etiqueta_pozo_diametro);
        nivel=findViewById(R.id.etiqueta_pozo_nivel);
        tarifa=findViewById(R.id.etiqueta_pozo_tarifa);
        potencia=findViewById(R.id.etiqueta_pozo_potencia);
        bomba=findViewById(R.id.etiqueta_pozo_bomba);
        caudal=findViewById(R.id.etiqueta_pozo_caudal);
        altura=findViewById(R.id.etiqueta_pozo_altura);
        variador=findViewById(R.id.checkBox_pozo_variador);
    }

    public void Georreferenciar(View vita){
        Intent i = new Intent(this,Georreferenciar.class);
        i.putExtra("Feature", "Point");
        i.putExtra("tabla","pozo");
        i.putExtra("pozo_nombre",nombre.getText());
        i.putExtra("pozo_year",year.getText());
        i.putExtra("pozo_concesion", concesion.getText());
        i.putExtra("pozo_profundidad", profundidad.getText());
        i.putExtra("pozo_diametro",diametro.getText());
        i.putExtra("pozo_nivel",nivel.getText());
        i.putExtra("pozo_tarifa",tarifa.getText());
        i.putExtra("pozo_potencia",potencia.getText());
        i.putExtra("pozo_bomba",bomba.getText());
        i.putExtra("pozo_caudal",caudal.getText());
        i.putExtra("pozo_altura", altura.getText());
        i.putExtra("pozo_variador",variador.isChecked());

        startActivity(i);
    }
}
