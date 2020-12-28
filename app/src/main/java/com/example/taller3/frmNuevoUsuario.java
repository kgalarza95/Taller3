package com.example.taller3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class frmNuevoUsuario extends AppCompatActivity {

    private String  miSpinnerLebel;
    private EditText txtNombre;
    private EditText txtEdad ;
    private EditText txtTelefono;
    private EditText txtCorreo;
    private EditText txtContrasenia;
    private TextView txtFecha;
    private RadioButton rbMasculino;
    private RadioButton rbFemenino ;
    private TextInputLayout impNombre;
    private TextInputLayout impEdad;
    private TextInputLayout impTelefono;
    private TextInputLayout impCorreo;
    private TextInputLayout impContrasenia;
    private TextInputLayout impFecha;

    //validaciones
    boolean isCorreo;

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
        impNombre = (TextInputLayout) findViewById(R.id.impNombre);
        impEdad = (TextInputLayout) findViewById(R.id.impEdad);
        impTelefono = (TextInputLayout) findViewById(R.id.impTelefono);
        impCorreo = (TextInputLayout) findViewById(R.id.impCorreo);
        impContrasenia = (TextInputLayout) findViewById(R.id.impContrasenia);
        impFecha = (TextInputLayout) findViewById(R.id.impFechaNacimiento);
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

                if (Patterns.EMAIL_ADDRESS.matcher(txtCorreo.getText().toString()).matches()){//validacion predefinida de correo
                    isCorreo = true;
                    impCorreo.setError(null);
                }
                else{
                    impCorreo.setError("Correo Invalido");
                    isCorreo = false;
                }

                Pattern patron = Pattern.compile("[0-9][0-9][0-9]");// ingresar 3 numeros del 0 al 9
                if(patron.matcher(txtContrasenia.getText().toString()).matches()){//validacion de 3 numeros
                    impContrasenia.setError("Digite 3 números");
                }else{
                    impContrasenia.setError(null);
                }


                if (isCorreo)  {
                    Toast.makeText(this, "Se registro correctamente", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnAtras:
                Toast.makeText(this, "Cancelado por el usuario", Toast.LENGTH_SHORT).show();
                break;
        }
        limpiarPantalla();
    }


    private void limpiarPantalla(){
        txtNombre.setText("");
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