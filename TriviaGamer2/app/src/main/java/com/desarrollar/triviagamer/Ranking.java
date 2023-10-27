package com.desarrollar.triviagamer;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Ranking extends AppCompatActivity {
    RecyclerView rankingLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        DBHelper DB = new DBHelper(this);
        rankingLista = findViewById(R.id.rankingList);
        rankingLista.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<RankingUser> rankingList = DB.getRankingList();

        RankingListAdapter adapter = new RankingListAdapter(rankingList);

        rankingLista.setAdapter(adapter);

    }
}