package com.example.pparcialcm2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    EditText usuario, clave;
    TextView lblRegistrarse;
    Button btnregistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        usuario = (EditText) findViewById(R.id.txtUsuario);
        clave = (EditText) findViewById(R.id.txtClave);
        lblRegistrarse = (TextView) findViewById(R.id.lblRegistrarse);
        btnregistrar= (Button) findViewById(R.id.btnIngresar);

        String datoUsuario = getIntent().getStringExtra("usuarioReg");
        usuario.setText(datoUsuario);
        String datoClave = getIntent().getStringExtra("claveReg");
        clave.setText(datoClave);
    }

    //Metodo para el lblRegistrarse
    public void enviarRegistrarse(View view){
        Intent i = new Intent(this, Registrarse.class);
        startActivity(i);
    }

    public void ingresar(View view){
        String usu = usuario.getText().toString();
        String pass = clave.getText().toString();
        if(usu.length()==0){
            Toast.makeText(this,"Debes ingresar un usuario", Toast.LENGTH_LONG).show();
        }
        if(pass.length()==0){
            Toast.makeText(this,"Debes ingresar un password", Toast.LENGTH_SHORT).show();
        }
        if(usu.equals("abel") && pass.equals("1234")){
            Intent i = new Intent(this, JuegoMichi.class);
            startActivity(i);
            Toast.makeText(this,"Usuario y contraseña correctos", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();
        }
    }

}