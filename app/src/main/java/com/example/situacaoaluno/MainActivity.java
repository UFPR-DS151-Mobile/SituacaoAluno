package com.example.situacaoaluno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String name;
    private double grade1;
    private double grade2;
    private int frequency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getData(View view) {
        EditText inputName = findViewById(R.id.inputName);
        EditText inputGrade1 = findViewById(R.id.inputGrade1);
        EditText inputGrade2 = findViewById(R.id.inputGrade2);
        EditText inputFrequency = findViewById(R.id.inputFrequency);

        TextView errorName = findViewById(R.id.errorName);
        TextView errorGrade1 = findViewById(R.id.errorGrade1);
        TextView errorGrade2 = findViewById(R.id.errorGrade2);
        TextView errorFrequency = findViewById(R.id.errorFrequency);


        try {
            String name = inputName.getText().toString();
            if (name.length() == 0) {
                throw new RuntimeException("É obrigatório informar o nome do aluno");
            }
            this.name = name;
        } catch (RuntimeException e) {
            errorName.setText(e.getMessage());
        }

        try {
            String grade1 = inputGrade2.getText().toString();
            if (grade1.length() == 0) {
                throw new RuntimeException("É obrigatório informar a primeira nota");
            }
            this.grade1 = Double.parseDouble(grade1);
        } catch(NumberFormatException e) {
            errorGrade1.setText("A Nota 1 precisa ser um número");
        } catch (RuntimeException e) {
            errorGrade1.setText(e.getMessage());
        }

        try {
            String grade2 = inputGrade2.getText().toString();
            if (grade2.length() == 0) {
                throw new RuntimeException("É obrigatório informar a segunda nota");
            }
            this.grade2 = Double.parseDouble(grade2);
        } catch(NumberFormatException e) {
            errorGrade2.setText("A Nota 2 precisa ser um número");
        } catch (RuntimeException e) {
            errorGrade2.setText(e.getMessage());
        }

        try {
            String frequency = inputFrequency.getText().toString();
            if (frequency.length() == 0) {
                throw new RuntimeException("É obrigatório informar a frequencia");
            }
            this.frequency = Integer.parseInt(frequency);
        } catch(NumberFormatException e) {
            errorFrequency.setText("A frequencia precisa ser um número inteiro");
        } catch (RuntimeException e) {
            errorFrequency.setText(e.getMessage());
        }

//        callResultActivity();
    }

//    public void callResultActivity() {
//        Intent it = new Intent( this, ResultActivity.class);
//
//    }

}