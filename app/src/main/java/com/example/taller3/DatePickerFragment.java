package com.example.taller3;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private DatePickerDialog.OnDateSetListener escuchador;


    //************************************
    //* 1)                               *
    //* ELIMINAR CONSTRUCTOR POR DEFECTO *
    //************************************

    public static DatePickerFragment newInstance(DatePickerDialog.OnDateSetListener listener) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setEscuchador(listener); // se mantenga escuchando el evneto
        return fragment; // retornar el fragment
    }

    //**********************************************************************************************\\
    //** GETTERS Y SETTERS **\\
    public void setEscuchador(DatePickerDialog.OnDateSetListener listener){
        this.escuchador = listener; // actaliza lo escuchado
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar fecha = Calendar.getInstance(); //Api Calendar

        int year = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), escuchador, year, mes, dia); // retorna nueva instancia
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day){

    }

}