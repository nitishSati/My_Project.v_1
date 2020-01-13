package com.example.studentmanagementsystem.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.studentmanagementsystem.R;
import com.example.studentmanagementsystem.model.Student;
import com.example.studentmanagementsystem.adapter.Adapter;

import java.util.ArrayList;
import java.util.List;

public class DisplayStudentActivity extends AppCompatActivity {

    private Button button;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter rAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Student> sList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler);
        rAdapter = new Adapter(sList);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(rAdapter);
        button = findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener(){

                public void onClick(View v){
                Intent intent=new Intent(DisplayStudentActivity.this, AddStudentActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(data!= null) {
                String s_name = data.getStringExtra("name");
                String s_ids = data.getStringExtra("ids");
                Student newStudent = new Student(s_name, s_ids);
                sList.add(newStudent);
                rAdapter.notifyDataSetChanged();
            }
        }
    }
}
