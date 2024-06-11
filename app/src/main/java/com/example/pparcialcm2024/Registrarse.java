package com.example.pparcialcm2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registrarse extends AppCompatActivity {
    private EditText usuario, clave;

    public Registrarse() {
    }

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
        usuario = findViewById(R.id.txtUsuarioReg);
        clave = findViewById(R.id.txtClaveReg);
        Spinner sp1 = findViewById(R.id.spinner);

        String[] opciones = {"Juane", "Tacacho con Cecina"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item_abel, opciones);
        sp1.setAdapter(adapter);
    }

    //Metodo para el btnRegresar
    public void enviarLogin(View view) {
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);

    }

    public void Registrar(View view) {
        String usu = usuario.getText().toString();
        String pass = clave.getText().toString();

        if (usu.isEmpty()) {
            Toast.makeText(this, "Debes ingresar un usuario", Toast.LENGTH_LONG).show();
            return;
        }
        if (pass.isEmpty()) {
            Toast.makeText(this, "Debes ingresar un password", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent i = new Intent(this, LoginActivity.class);
        i.putExtra("usuarioReg", usuario.getText().toString());
        i.putExtra("claveReg", clave.getText().toString());
        startActivity(i);

    }



}