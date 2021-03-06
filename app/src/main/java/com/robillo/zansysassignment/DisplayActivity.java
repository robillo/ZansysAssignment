package com.robillo.zansysassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {

    ArrayList<String> mImageUrls;
    ArrayList<String> mCaptions;
    List<Data> list = new ArrayList<>();
    RVRecycler recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        mImageUrls = new ArrayList<>();
        mCaptions = new ArrayList<>();
        mImageUrls = getIntent().getStringArrayListExtra("array");
        mCaptions = getIntent().getStringArrayListExtra("captions");
        for(int i=0; i<mImageUrls.size(); i++){
            list.add(new Data(mImageUrls.get(i), mCaptions.get(i)));
        }
        for(int i=0; i<mCaptions.size(); i++){
            Log.e("array ", mCaptions.get(i));
        }
        recycler = new RVRecycler(list, this);
        ((RecyclerView) findViewById(R.id.recycler_view)).setLayoutManager(new LinearLayoutManager(this));
        ((RecyclerView) findViewById(R.id.recycler_view)).setAdapter(recycler);
    }
}
