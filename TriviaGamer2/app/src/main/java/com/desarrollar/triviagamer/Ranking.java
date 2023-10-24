package com.desarrollar.triviagamer;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Ranking extends AppCompatActivity {

    private Sqlite_DB_handler sqlite_db_handler;
    SharedPreferences sharedPreferences;

    TextView lista;

    public static final String signinCredentials = "login_credentials";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);


        sqlite_db_handler = new Sqlite_DB_handler(Ranking.this);
        sharedPreferences = getSharedPreferences(signinCredentials, Context.MODE_PRIVATE);

        ArrayList<RankingUser> rankingList = sqlite_db_handler.getRankingList();
        lista = findViewById(R.id.rankingList);
        ArrayList<String> rankingListString = new ArrayList<>();
        for (RankingUser user: rankingList) {
            String s = "";
            s = s + user.getName() + ", " + user.getScore();
            rankingListString.add(s);
        }
        lista.setText(String.join("\n, ", rankingListString));

    }
}