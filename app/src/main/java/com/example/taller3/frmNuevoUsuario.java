package com.example.taller3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class frmNuevoUsuario extends AppCompatActivity {

    String miSpinnerLebel;
    private EditText txtNombre;
    private EditText txtEdad ;
    private EditText txtTelefono;
    private EditText txtCorreo;
    private EditText txtContrasenia;
    private TextView txtFecha;
    private RadioButton rbMasculino;
    private RadioButton rbFemenino ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_usuario);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtEdad =  findViewById(R.id.txtEdad);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtContrasenia = (EditText) findViewById(R.id.txtContrasenia);
        txtFecha = (TextView) findViewById(R.id.fecha_nacimiento);
        rbMasculino = (RadioButton)  findViewById(R.id.rBtnMasculino);
        rbFemenino = (RadioButton)  findViewById(R.id.rBtnFeminino);
        llenarSpinner();
    }

    private void llenarSpinner(){
        Spinner ciudades = (Spinner) findViewById(R.id.spinnerCiudades);

        //un adaptaodr de arreglos recibe la ubicacion del adaptador
        ArrayAdapter<CharSequence> arrAdaptador = ArrayAdapter.createFromResource(this,R.array.spiner_ciudad,
                android.R.layout.simple_spinner_item);

        //diseño que utilizara el spinnercuando aparezca la lista de opciones
        arrAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ciudades.setAdapter(arrAdaptador);///establecer el adaptador al spinner

        //evento interno
        ciudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                miSpinnerLebel = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void abrirDialogoFecha(View v){
        final TextView vFechaNac = (TextView) findViewById(R.id.fecha_nacimiento);

        DatePickerFragment nuevoFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int anio, int mes, int dia) {
                final String fechaSeleccionada  =   dia+"/"+(mes+1)+"/" +anio; //el mes comienza desde cero por eso se le suma 1
                vFechaNac.setText(fechaSeleccionada);
            }
        });

        nuevoFragment.show(getSupportFragmentManager(), "Calendario");
    }

    public void eventoRadiosButtons(View v){
        boolean  seleccionado = ((RadioButton) v).isChecked();
        switch (v.getId()){
            case R.id.rBtnMasculino:
                Toast.makeText(this, "Seleccionó Masculino", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rBtnFeminino:
                Toast.makeText(this, "Seleccionó Femenino", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void eventoBotones(View v){
        switch (v.getId()){
            case R.id.btnRegistrar:
                Toast.makeText(this, "Se registro correctamente", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAtras:
                Toast.makeText(this, "Cancelado por el usuario", Toast.LENGTH_SHORT).show();
                break;
        }
        limpiarPantalla();
    }


    private void limpiarPantalla(){
        //txtNombre.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtContrasenia.setText("");
        txtFecha.setText("");
        rbMasculino.setSelected(false);
        rbFemenino.setSelected(false);
        llenarSpinner();
    }



}