package com.example.situacaoaluno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ResultActivity extends AppCompatActivity {

    private String name;
    private double grade1;
    private double grade2;
    private int frequency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent it = getIntent();
        if (it == null) return;

        Bundle params = it.getExtras();
        if (params == null) return;

        this.name = params.getString("name", "");
        this.grade1 = params.getDouble("grade1", -1);
        this.grade2 = params.getDouble("grade2", -1);
        this.frequency = params.getInt("frequency", -1);
    }
}