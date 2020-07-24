package com.example.student_managment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText name, email, branch, add, roll_no;
    Button reg, show;
    FirebaseDatabase fd;
    DatabaseReference dbr;
    int maxid = 0;
    Student s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        branch = findViewById(R.id.branch);
        add = findViewById(R.id.add);
        roll_no = findViewById(R.id.roll_no);
        reg = findViewById(R.id.register);
        show = findViewById(R.id.show_data);
        s = new Student();
        dbr = FirebaseDatabase.getInstance().getReference().child("Student");
        dbr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    maxid = (int) snapshot.getChildrenCount();
                } else {

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s.setRoll_no(Integer.parseInt(roll_no.getText().toString()));
                s.setEmail(email.getText().toString());
                s.setAdd(add.getText().toString());
                s.setName(name.getText().toString());
                s.setBranch(branch.getText().toString());
                dbr.child(String.valueOf(maxid + 1)).setValue(s);
                //dbr.setValue(s);
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowData.class);
                startActivity(intent);
            }
        });



    }
}