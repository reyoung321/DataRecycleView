package com.kishor_bhattarai.datarecycleview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kishor_bhattarai.datarecycleview.R;
import com.kishor_bhattarai.datarecycleview.model.DataRecycle;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DatasAdapter extends RecyclerView.Adapter<DatasAdapter.DatasViewHolder>{
    Context mContext;
    List<DataRecycle> dataRecycleList;

    public DatasAdapter(Context mContext, List<DataRecycle> dataRecycleList) {
        this.mContext = mContext;
        this.dataRecycleList = dataRecycleList;
    }

    @NonNull
    @Override
    public DatasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_data,parent,false);
        return new DatasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DatasViewHolder holder, int position) {
        final DataRecycle dataRecycle = dataRecycleList.get(position);
        holder.circleimgdata.setImageResource(dataRecycle.getImageId());
        holder.txtName.setText(dataRecycle.getName());
        holder.txtAge.setText(dataRecycle.getAge());
        holder.txtGender.setText(dataRecycle.getGender());

    }

    @Override
    public int getItemCount() {
        return dataRecycleList.size();
    }


    public class DatasViewHolder extends RecyclerView.ViewHolder{
        CircleImageView circleimgdata;
        TextView txtName, txtAge, txtGender;
        ImageButton btnDelete;

        public DatasViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtAge = itemView.findViewById(R.id.txtAge);
            txtGender = itemView.findViewById(R.id.txtGender);
            circleimgdata = itemView.findViewById(R.id.circledataimg);
            btnDelete = itemView.findViewById(R.id.btndelete);
        }
    }
}
