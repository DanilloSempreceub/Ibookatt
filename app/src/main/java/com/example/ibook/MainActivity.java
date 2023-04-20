package com.example.ibook;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        EditText txtSenha, txtEmail;
        Button btnEntrar;
        Button btnNaoTemCadastro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtEmail = findViewById(R.id.txtEmail);
        txtSenha = findViewById(R.id.txtSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnNaoTemCadastro = findViewById(R.id.btnNaoTemCadastro);


        btnNaoTemCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent naoTemCadastro = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(naoTemCadastro);
            }
        });


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent entrar = new Intent(getApplicationContext(), LivrosActivity.class);
                startActivity(entrar);

                        String email = txtEmail.getText().toString().trim();
                String senha = txtSenha.getText().toString().trim();
                if (email.equals("") || senha.equals("") ){
                    Toast.makeText(MainActivity.this, "Todos os campos devem estar preenchidos", Toast.LENGTH_SHORT).show();
                }else {
                    return ;
                }
            }
        });

    }
}