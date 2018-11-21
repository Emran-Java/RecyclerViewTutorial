package com.emran.recyclerviewtutorial;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<DemoData> myDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialViews();
        viewClickListener();
        loadData();
    }


    private void initialViews() {
        setContentView(R.layout.activity_main);

        mContext = this;
        mRecyclerView = findViewById(R.id.my_recycler_view);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        myDataset = new ArrayList<>();
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void viewClickListener() {

        ((MyAdapter)mAdapter).setOnItemClickListener(new MyAdapter.ListItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                //TODO,
                Toast.makeText(mContext, "position: "+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadData() {
        //bring data fron app string xml
        String[] titles = mContext.getResources().getStringArray(R.array.demoDataList);
        String[] subTitles = mContext.getResources().getStringArray(R.array.demoSubDataList);

        for(int i = 0; i<titles.length && i<subTitles.length; i++){
            //collect model object for data source
            DemoData demoData = new DemoData(titles[i],subTitles[i]);
            myDataset.add(demoData);
        }
        //refresh the adapter
        mAdapter.notifyDataSetChanged();

    }

}
