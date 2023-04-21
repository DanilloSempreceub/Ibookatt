package com.example.ibook;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class LivrosActivity extends MainActivity {
     TextView txtView;
     Button btndeBuscar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livros_activity);
        btndeBuscar = (Button) findViewById(R.id.btndeBuscar);
        txtView = (TextView) findViewById(R.id.textView);
        btndeBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tarefa tarefa= new Tarefa();
                tarefa.execute("https://www.googleapis.com/books/v1/mylibrary/bookshelves");
            }
        });

    }

    private class Tarefa extends AsyncTask<String, String, String>{


        @Override
        protected String doInBackground(String... strings) {
            String retorno = null;
            try {
                retorno = Conexao.getDados(strings[0]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return retorno;
        }
        @Override
        protected void onPostExecute(String s){
            txtView.setText(s);
        }
    }

}

