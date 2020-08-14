package com.example.app_tfg;

public class Variables_Globales {
    private static Variables_Globales instance;
    private static int tlf_personal=0;
    private static String vadenominacion="";

    public int get_tlfpersonal(){
        return tlf_personal;
    }

    public void set_tlf_personal(Integer tlf){
        Variables_Globales.tlf_personal=tlf;
    }

    public String getDenominacion(){
        return vadenominacion;
    }

    public void setDenominacion(String denominacion){ Variables_Globales.vadenominacion=denominacion; }

    public static synchronized Variables_Globales getInstance(){
        if (instance == null){
            instance=new Variables_Globales();
        }
        return instance;
    }

}
