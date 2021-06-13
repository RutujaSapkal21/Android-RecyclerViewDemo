package com.example.dynamiclistviewusingrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edtname,edtemail,edtmobile;
    Button addbtn;

    RecyclerView recyclerView;
    List<Name> nameList;
    nameadaptor nmeadaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtname=findViewById(R.id.getname);
        edtemail=findViewById(R.id.getemail);
        edtmobile=findViewById(R.id.getmobile);

        addbtn=findViewById(R.id.add);
        recyclerView=findViewById(R.id.recyclerview);

        nameList=new ArrayList<>();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        nmeadaptor= new nameadaptor(this,nameList);
        recyclerView.setAdapter(nmeadaptor);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name nm=new Name();
                String myname=edtname.getText().toString();
                String myemail=edtemail.getText().toString();
                String mymobile=edtmobile.getText().toString();
                nm.setName(myname);
                nm.setEmail(myemail);
                nm.setMobile(mymobile);
                nameList.add(nm);


            }
        });

    }
}