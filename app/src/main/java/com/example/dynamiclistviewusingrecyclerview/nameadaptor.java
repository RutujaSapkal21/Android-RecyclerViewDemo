package com.example.dynamiclistviewusingrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class nameadaptor extends RecyclerView.Adapter<nameadaptor.NameHolder>
{

    Context mContext;
    List<Name> nameList;
    public nameadaptor(Context mContext, List<Name> nameList) {
        this.mContext = mContext;
        this.nameList = nameList;
    }

    @NonNull
    @Override
    public nameadaptor.NameHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myview;
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        myview=layoutInflater.inflate(R.layout.customdesign,parent,false);

        return new NameHolder(myview);
    }

    @Override
    public void onBindViewHolder(@NonNull nameadaptor.NameHolder holder, int position) {
        Name nme=nameList.get(position);
        holder.txt1.setText(nme.getName());

    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public class NameHolder extends RecyclerView.ViewHolder {
        TextView txt1;
        public NameHolder(@NonNull View itemView) {
            super(itemView);
            txt1=itemView.findViewById(R.id.txt1);

        }
    }
}
