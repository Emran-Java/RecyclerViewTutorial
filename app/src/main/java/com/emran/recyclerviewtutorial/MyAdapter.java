package com.emran.recyclerviewtutorial;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by emran on 11/21/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private ArrayList<DemoData> mDataList;
    private ListItemClickListener listItemClickListener;

    public MyAdapter(ArrayList<DemoData> dataArrayList){
        mDataList = dataArrayList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view, listItemClickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtVwTitle.setText(mDataList.get(position).getTitle());
        holder.txtVwSubTitle.setText(mDataList.get(position).getSubTitle());
    }

   @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void setOnItemClickListener(ListItemClickListener onItemClickListener) {
        this.listItemClickListener = onItemClickListener;
    }



    //Create a view holder inner class
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ListItemClickListener listItemClickListener;
        private TextView txtVwTitle, txtVwSubTitle;

        public ViewHolder(View itemView, ListItemClickListener listItemClickListener) {
            super(itemView);
            this.listItemClickListener = listItemClickListener;
            txtVwTitle = itemView.findViewById(R.id.txtVwTitle);
            txtVwSubTitle = itemView.findViewById(R.id.txtVwSubTitle);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(listItemClickListener!=null){
                listItemClickListener.onItemClick(getLayoutPosition(), v);
            }
        }
    }
    //-------- end inner class ---------

    // create click listener interface
    public interface ListItemClickListener {
        void onItemClick(int position, View v);
    }
}
