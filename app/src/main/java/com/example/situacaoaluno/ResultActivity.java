package com.example.situacaoaluno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

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


        TextView finalMsg = findViewById(R.id.finalMsg);
        String msg = "Houve um erro inesperado";

        double sum = (grade1 + grade2)/2;
        if (frequency < 75) {
            // Reprovado por frequência (não mostrar a nota)
            msg = "O(A) aluno(a) "+ this.name + " foi reprovado(a) por falta pois só compareceu a " +
                    this.frequency + "% das aulas sendo necessário 75% de participação";
        } else {
            if (sum < 4) {
                // reprovado por nota (não mostrar frequencia)
                msg = "O(A) aluno(a) "+ this.name + " foi reprovado(a) por nota pois ficou com uma média final " +
                        "de "+ String.format("%.1f", sum) +" , sendo necessário um mínimo de 4 pontos para ir para final";
            } else if (sum >= 7) {
                // aprovado
                msg = "O(A) aluno(a) "+ this.name + " foi aprovado com nota "+ String.format("%.1f", sum) +" e frequência de "+ this.frequency + "%";
            } else {
                // final
                msg = "O(A) aluno(a) "+ this.name + " foi para final com nota "+ String.format("%.1f", sum) +" e frequência de "+ this.frequency + "%";
            }
        }
        finalMsg.setText(msg);
    }
}