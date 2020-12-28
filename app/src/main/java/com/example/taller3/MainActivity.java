package com.example.taller3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private Button btnAceptar;
    private Button btnCancelar;
    private EditText txtUsuario;
    private EditText txtContrasenia;
    private TextInputLayout impUsuario;
    private TextInputLayout impContrasenia;
    private FloatingActionButton fabUsuario;
    private String usuario = "android";
    private String contrasenia = "android";


    //validaciones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnAceptar      = (Button) findViewById(R.id.btnIngresar);
        btnCancelar     = (Button) findViewById(R.id.btnCancelar);
        txtUsuario      = (EditText) findViewById(R.id.txtUsuario);
        txtContrasenia  = (EditText) findViewById(R.id.txtContrasenia);
        impUsuario      = (TextInputLayout) findViewById(R.id.impUsuario);
        impContrasenia  = (TextInputLayout) findViewById(R.id.impContrasenia);
        fabUsuario      = (FloatingActionButton) findViewById(R.id.btnFlotador);

        //1 forma de evento en boton
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtUsuario.getText().toString().equals(usuario)){
                    Toast.makeText(view.getContext(), "Validación correcta", Toast.LENGTH_SHORT);
                }
                else{
                    Toast.makeText(view.getContext(),"Los datos Ingresados no so correctos", Toast.LENGTH_SHORT);
                }
            }
        });
    }//onCreate


    public void abrirfrmNuevoUsuario(View v){
        Intent objInten = new Intent(v.getContext(), frmNuevoUsuario.class);
        startActivityForResult(objInten, 0);
    }


}