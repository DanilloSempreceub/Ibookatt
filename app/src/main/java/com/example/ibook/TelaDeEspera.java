package com.example.ibook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class TelaDeEspera extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 5000; // 2 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_de_espera);

        getSupportActionBar().hide();

        // Esconde a barra de navegação e barra de status
       //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        //getSupportActionBar().hide();
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Aguarda alguns segundos antes de iniciar a próxima activity

        new Handler().postDelayed(() -> {
            Intent i = new Intent(TelaDeEspera.this, MainActivity.class);
            startActivity(i);
            finish();
        }, SPLASH_TIME_OUT);
    }
}