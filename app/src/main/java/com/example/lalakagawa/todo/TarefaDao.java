package com.example.lalakagawa.todo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface TarefaDao {
    @Query("select * from tarefa")
    List<TarefaModelo> getListaDeTarefas();

    @Insert
    long inserirTarefa(TarefaModelo tarefa);

    @Delete
    int excluirTarefa(TarefaModelo tarefa);

}
