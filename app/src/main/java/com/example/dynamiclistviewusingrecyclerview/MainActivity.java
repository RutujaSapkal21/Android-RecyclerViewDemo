package com.example.dynamiclistviewusingrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edtname;
    Button addbtn;

    RecyclerView recyclerView;
    List<Name> nameList;
    nameadaptor nmeadaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtname=findViewById(R.id.getname);
        addbtn=findViewById(R.id.add);
        recyclerView=findViewById(R.id.recyclerview);

        nameList=new ArrayList<>();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        nmeadaptor= new nameadaptor(this,nameList);
        recyclerView.setAdapter(nmeadaptor);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name nm=new Name();
                String myname=edtname.getText().toString();
                nm.setName(myname);
                nameList.add(nm);
            }
        });
    }
}