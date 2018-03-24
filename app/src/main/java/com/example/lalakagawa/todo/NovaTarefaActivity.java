package com.example.lalakagawa.todo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NovaTarefaActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtNovaTarefa;
    private Button btnIncluir;

    public static final String CHAVE_NOVA_TAREFA = "chave";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_tarefa);

        edtNovaTarefa = findViewById(R.id.edtNovaTarefa);
        btnIncluir = findViewById(R.id.btnIncluirNovaTarefa);

        btnIncluir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnIncluirNovaTarefa){
            TarefaModelo tarefaModelo = new TarefaModelo(edtNovaTarefa.getText().toString(), false);

            AppDatabase appDatabase = AppDatabase.appDatabaseInstance(this);
            TarefaDao dao = appDatabase.getTarefaDao();
            long id = dao.inserirTarefa(tarefaModelo);
            tarefaModelo.setId(id);

            Intent intent = new Intent();
            intent.putExtra(CHAVE_NOVA_TAREFA, tarefaModelo);

            setResult(Activity.RESULT_OK, intent);
            finish();
        }
    }
}
