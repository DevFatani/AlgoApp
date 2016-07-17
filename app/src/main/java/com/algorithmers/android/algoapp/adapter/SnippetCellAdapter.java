package com.algorithmers.android.algoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.algorithmers.android.algoapp.R;
import com.algorithmers.android.algoapp.model.Snippet;

import java.util.ArrayList;

/**
 * Created by DevFatani on 7/11/2016 AD.
 */
public class SnippetCellAdapter extends ArrayAdapter<Snippet> {


    ArrayList<Snippet> snippets = new ArrayList<>();

    public SnippetCellAdapter(Context context, ArrayList<Snippet> snippets) {
        super(context, 0, snippets);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


//        Snippet snippet = snippets.get(position);

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_snippet_cell, parent, false);


            ViewHolder viewHolder = new ViewHolder();

            viewHolder.mCellSnippetImg = (ImageView) convertView.findViewById(R.id.cellSnippetImg);
            viewHolder.mCellSnippetTxt = (TextView) convertView.findViewById(R.id.cellSnippetTxt);
            viewHolder.mCellSnippetType = (TextView) convertView.findViewById(R.id.cellSnippetType);


            convertView.setTag(viewHolder);

        }


        ViewHolder viewHolder = (ViewHolder) convertView.getTag();


//        viewHolder.mCellSnippetTxt.s.

        return convertView;
    }


    class ViewHolder {

        private TextView mCellSnippetTxt;
        private TextView mCellSnippetType;
        private ImageView mCellSnippetImg;


    }
}
