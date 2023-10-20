package com.desarrollar.triviagamer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class preguntasintermedias extends AppCompatActivity {


    TextView quiztext;
     AppCompatButton aans, bans, cans, dans;

    List<QuestionsItems> questionsitems;
    int currentQuestions = 0;
    int correct = 0, wrong = 0;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta1);


        quiztext = findViewById(R.id.textpreguntaview);
        aans = findViewById(R.id.btn_resp2);
        bans = findViewById(R.id.btn_resp3);
        cans = findViewById(R.id.btn_resp);
        dans = findViewById(R.id.btn_resp4);


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
                    aans.setBackgroundResource(R.color.lila);
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
                    Intent intent = new Intent(preguntasintermedias.this, Resultadofinal.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });
        dans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsitems.get(currentQuestions).getAlternativa2().equals(questionsitems.get(currentQuestions).getRespuestacorrecta())) {
                    correct++;
                    dans.setBackgroundResource(R.color.verde);
                    dans.setTextColor(getApplicationContext().getColor(R.color.rosa));
                } else {
                    wrong++;
                    dans.setBackgroundResource(R.color.lila);
                    dans.setTextColor(getApplicationContext().getColor(R.color.rosa));
                }
                if (currentQuestions < questionsitems.size() - 1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            dans.setBackgroundResource(R.color.verde);
                            dans.setTextColor(getApplicationContext().getColor(R.color.lavender));
                        }
                    }, 500);

                } else {
                    Intent intent = new Intent(preguntasintermedias.this, Resultadofinal.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });

        cans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsitems.get(currentQuestions).getAlternativa3().equals(questionsitems.get(currentQuestions).getRespuestacorrecta())) {
                    correct++;
                    cans.setBackgroundResource(R.color.verde);
                    cans.setTextColor(getApplicationContext().getColor(R.color.rosa));
                } else {
                    wrong++;
                    cans.setBackgroundResource(R.color.lila);
                    cans.setTextColor(getApplicationContext().getColor(R.color.rosa));
                }
                if (currentQuestions < questionsitems.size() - 1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            cans.setBackgroundResource(R.color.verde);
                            cans.setTextColor(getApplicationContext().getColor(R.color.lavender));
                        }
                    }, 500);

                } else {
                    Intent intent = new Intent(preguntasintermedias.this, Resultadofinal.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });

        bans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsitems.get(currentQuestions).getRespuestacorrecta().equals(questionsitems.get(currentQuestions).getRespuestacorrecta())) {
                    correct++;
                    bans.setBackgroundResource(R.color.verde);
                    bans.setTextColor(getApplicationContext().getColor(R.color.rosa));
                } else {
                    wrong++;
                    bans.setBackgroundResource(R.color.lila);
                    bans.setTextColor(getApplicationContext().getColor(R.color.rosa));
                }
                if (currentQuestions < questionsitems.size() - 1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            bans.setBackgroundResource(R.color.verde);
                            bans.setTextColor(getApplicationContext().getColor(R.color.lavender));
                        }
                    }, 500);

                } else {
                    Intent intent = new Intent(preguntasintermedias.this, Resultadofinal.class);
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
        String jsonquiz = loadJsonFromAsset("preguntasintermedias.json");
        try {
            JSONObject jsonObject = new JSONObject(jsonquiz);
            JSONArray questions = jsonObject.getJSONArray("preguntasintermedias");
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

