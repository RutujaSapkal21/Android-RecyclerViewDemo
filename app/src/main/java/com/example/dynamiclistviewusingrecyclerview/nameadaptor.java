package com.example.dynamiclistviewusingrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
        holder.txt2.setText(nme.getEmail());
        holder.txt3.setText(nme.getMobile());

        holder.txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{nme.getEmail()});
                intent.setType("message/rfc822");
                mContext.startActivity(intent);
                Toast.makeText(mContext,"You Clicked on "+nme.getEmail(),Toast.LENGTH_LONG).show();
            }
        });
        holder.txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calling=new Intent(Intent.ACTION_CALL);
                calling.setData(Uri.parse("tel:"+nme.getMobile()));
                mContext.startActivity(calling);
                Toast.makeText(mContext,"You Clicked on "+nme.getMobile(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public class NameHolder extends RecyclerView.ViewHolder {
        TextView txt1,txt2,txt3;
        public NameHolder(@NonNull View itemView) {
            super(itemView);
            txt1=itemView.findViewById(R.id.namee);
            txt2=itemView.findViewById(R.id.email);
            txt3=itemView.findViewById(R.id.mobile);

        }
    }
}
