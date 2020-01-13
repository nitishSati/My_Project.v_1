package com.example.studentmanagementsystem.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.view.View.OnClickListener;

import com.example.studentmanagementsystem.R;

public class AddStudentActivity extends AppCompatActivity {

    EditText editText1,editText2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText1=findViewById((R.id.id_name));
        editText2=findViewById((R.id.id_id));
        button=findViewById(R.id.submit);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg1 = editText1.getText().toString();
                String msg2 = editText2.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("name", msg1);
                intent.putExtra("ids", msg2);
                setResult(1, intent);
                finish();
            }
        });
    }
}
