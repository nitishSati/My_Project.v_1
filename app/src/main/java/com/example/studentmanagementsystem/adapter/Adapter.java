package com.example.studentmanagementsystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.studentmanagementsystem.R;
import com.example.studentmanagementsystem.model.Student;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder > {

    private List<Student> studentList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name,ids;

        public MyViewHolder(View v){
            super(v);
            name= v.findViewById(R.id.name);
            ids= v.findViewById(R.id.ids);
        }
    }


    public Adapter(List<Student> studentList){
        this.studentList=studentList;
    }
    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.student_list,parent,false);
        return new MyViewHolder(item);
}

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    Student student=studentList.get(position);
    holder.name.setText(student.getName());
    holder.ids.setText(student.getId());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }



}
