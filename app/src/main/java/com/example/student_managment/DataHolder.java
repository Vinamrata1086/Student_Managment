package com.example.student_managment;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataHolder extends RecyclerView.ViewHolder {
    View view;
    public DataHolder(@NonNull View itemView) {
        super(itemView);
        view=itemView;
    }
    public void setView(Context context,String name, int roll, String branch, String address, String email){
        TextView sname=view.findViewById(R.id.name);
        TextView sroll=view.findViewById(R.id.roll_no);
        TextView sadd=view.findViewById(R.id.add);
        TextView semail=view.findViewById(R.id.email);
        TextView sbranch=view.findViewById(R.id.branch);

        sname.setText(name);
        semail.setText(email);
        sbranch.setText(branch);
        sadd.setText(address);
        sroll.setText(String.valueOf(roll));
    }
}

