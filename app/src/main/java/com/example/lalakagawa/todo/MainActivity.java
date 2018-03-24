package com.example.lalakagawa.todo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvListaTarefa;
    private FloatingActionButton fabNovaTarefa;
    private TarefaAdapter adapter;

    private static final int RC_NOVA_TAREFA = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvListaTarefa = findViewById(R.id.rvListaTarefa);
        fabNovaTarefa = findViewById(R.id.fabNovaTarefa);

        fabNovaTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NovaTarefaActivity.class);
                startActivityForResult(intent, RC_NOVA_TAREFA);
            }
        });

       inicializaLista();
    }

    private void inicializaLista(){
        List<TarefaModelo> lista = AppDatabase.appDatabaseInstance(this).getTarefaDao().getListaDeTarefas();
        adapter = new TarefaAdapter(lista);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvListaTarefa.setLayoutManager(llm);
        rvListaTarefa.setAdapter(adapter);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == RC_NOVA_TAREFA){
            if(data != null){
                TarefaModelo tarefaModelo = data.getParcelableExtra(NovaTarefaActivity.CHAVE_NOVA_TAREFA);

               adapter.AdicionaTarefaNaLista(tarefaModelo);

                //Toast.makeText(this, tarefaModelo.getDescricao(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
