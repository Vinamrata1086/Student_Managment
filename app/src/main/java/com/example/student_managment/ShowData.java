package com.example.student_managment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ShowData extends AppCompatActivity {
    RecyclerView rev;
    DatabaseReference dbr;
    FirebaseDatabase fd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        rev=findViewById(R.id.rec);
        rev.setHasFixedSize(true);
        rev.setLayoutManager(new LinearLayoutManager(this));
        fd=FirebaseDatabase.getInstance();
        dbr=fd.getReference("Student");
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Student,DataHolder> fra=new FirebaseRecyclerAdapter<Student, DataHolder>(Student.class,
                R.layout.mycoustomlayout,DataHolder.class,dbr) {
            @Override
            protected void populateViewHolder(DataHolder dataHolder, Student student, int i) {
                dataHolder.setView(getApplicationContext(),student.getName(),student.getRoll_no(),student.getEmail(),student.getBranch(),student.getAdd());


            }
        };
        rev.setAdapter(fra);

    }
}
