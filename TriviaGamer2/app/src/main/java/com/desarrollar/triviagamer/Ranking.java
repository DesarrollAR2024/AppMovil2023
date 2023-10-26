package com.desarrollar.triviagamer;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Ranking extends AppCompatActivity {

    TextView lista;

    private DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);


        DB = new DBHelper(this);

        ArrayList<RankingUser> rankingList = DB.getRankingList();
        lista = findViewById(R.id.rankingList);
        ArrayList<String> rankingListString = new ArrayList<>();
        for (RankingUser user: rankingList) {
            String s = "";
            s = s + user.getName() + "," + "Score:" + user.getScore();
            rankingListString.add(s);
        }
        lista.setText(String.join("\n, ", rankingListString));

    }
}