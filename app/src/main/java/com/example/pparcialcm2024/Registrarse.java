package com.example.pparcialcm2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registrarse extends AppCompatActivity {
    EditText usuario, clave;
    Button btnregresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrarse);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        usuario = (EditText) findViewById(R.id.txtUsuarioReg);
        clave = (EditText) findViewById(R.id.txtClaveReg);
        btnregresar= (Button) findViewById(R.id.btnRegresar);
    }

    //Metodo para el btnRegresar
    public void enviarLogin(View view){
        Intent i = new Intent(this, LoginActivity.class);
        i.putExtra("usuarioReg",usuario.getText().toString());
        i.putExtra("claveReg",clave.getText().toString());
        startActivity(i);
    }


}