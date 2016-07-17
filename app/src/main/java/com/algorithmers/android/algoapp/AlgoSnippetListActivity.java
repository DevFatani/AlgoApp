package com.algorithmers.android.algoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.algorithmers.android.algoapp.adapter.SnippetCellAdapter;
import com.algorithmers.android.algoapp.model.Snippet;

import java.util.ArrayList;

public class AlgoSnippetListActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algo_snippet_list);


        ArrayList<Snippet>  snippets = new ArrayList<>();

        for(int i = 0; i < 10; i++){

            snippets.add(new Snippet());

        }

        ListView listView = (ListView) this.findViewById(R.id.lvActSnippetList);


        listView.setAdapter(new SnippetCellAdapter(this, snippets));



    }
}
