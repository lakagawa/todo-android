package com.example.lalakagawa.todo;

import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class NovaTarefaActivityTest {
    @Rule
    public IntentsTestRule<NovaTarefaActivity> rule = new IntentsTestRule<NovaTarefaActivity>(NovaTarefaActivity.class, true, false);

    @Test
    public void aoCLicarIncluir_DeveFinalizarActivity() throws Exception{
        rule.launchActivity(new Intent());

        Espresso.onView(ViewMatchers.withId(R.id.edtNovaTarefa)).perform(ViewActions.typeText("Estudar espresso"));
        Espresso.onView(ViewMatchers.withId(R.id.btnIncluirNovaTarefa)).perform(ViewActions.click());

        Assert.assertTrue(rule.getActivity().isFinishing());
    }
}