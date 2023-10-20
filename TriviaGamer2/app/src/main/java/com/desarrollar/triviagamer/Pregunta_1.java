package com.desarrollar.triviagamer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pregunta_1 extends AppCompatActivity {

    Button btnpuntaje;

    TextView quiztext, aans, bans, cans, dans;

    List<QuestionsItems> questionsitems;
    int currentQuestions = 0;
    int correct = 0, wrong = 0;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta1);

/*        btnpuntaje = findViewById(R.id.buttnsigp1);

        btnpuntaje.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pregunta_1.this, Resultado_correcto.class);
                startActivity(intent);
            }
        });*/

        quiztext = findViewById(R.id.pregunta);
        aans = findViewById(R.id.respuesta1);
        bans = findViewById(R.id.respuesta2);
        cans = findViewById(R.id.respuesta3);
        dans = findViewById(R.id.respuesta4);


        loadAllQuestion();
        Collections.shuffle(questionsitems);
        setQuestionScreen(currentQuestions);

        aans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsitems.get(currentQuestions).getAlternativa1().equals(questionsitems.get(currentQuestions).getRespuestacorrecta())) {
                    correct++;
                    aans.setBackgroundResource(R.color.verde);
                    aans.setTextColor(getApplicationContext().getColor(R.color.rosa));
                } else {
                    wrong++;
                    aans.setBackgroundResource(R.color.verde);
                    aans.setTextColor(getApplicationContext().getColor(R.color.rosa));
                }
                if (currentQuestions < questionsitems.size() - 1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            aans.setBackgroundResource(R.color.verde);
                            aans.setTextColor(getApplicationContext().getColor(R.color.lavender));
                        }
                    }, 500);

                } else {
                    Intent intent = new Intent(Pregunta_1.this, puntaje.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void setQuestionScreen(int currentQuestions) {
        quiztext.setText(questionsitems.get(currentQuestions).getQuestions());
        aans.setText(questionsitems.get(currentQuestions).getAlternativa1());
        bans.setText(questionsitems.get(currentQuestions).getAlternativa2());
        cans.setText(questionsitems.get(currentQuestions).getAlternativa3());
        dans.setText(questionsitems.get(currentQuestions).getRespuestacorrecta());

    }

    private void loadAllQuestion() {
        questionsitems = new ArrayList<>();
        String jsonquiz = loadJsonFromAsset("preguntasfaciles.json");
        try {
            JSONObject jsonObject = new JSONObject(jsonquiz);
            JSONArray questions = jsonObject.getJSONArray("preguntafaciles");
            for (int i = 0; i < questions.length(); i++) {

                JSONObject question = questions.getJSONObject(i);

                String questionsString = question.getString("question");
                String respuestacorrectaString = question.getString("respuestacorrecta");
                String alternativa1String = question.getString("alternativa1");
                String alternativa2String = question.getString("alternativa2");
                String alternativa3String = question.getString("alternativa3");

                questionsitems.add(new QuestionsItems(questionsString, alternativa1String, alternativa2String, alternativa3String, respuestacorrectaString));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String loadJsonFromAsset(String s) {
        String json = "";
        try {
            InputStream inputStream = getAssets().open(s);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

}

