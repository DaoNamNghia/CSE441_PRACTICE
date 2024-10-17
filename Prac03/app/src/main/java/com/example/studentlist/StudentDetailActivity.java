package com.example.studentlist;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        // Lấy dữ liệu từ Intent
        String id = getIntent().getStringExtra("id");
        String fullName = getIntent().getStringExtra("fullName");
        String email = getIntent().getStringExtra("email");
        String address = getIntent().getStringExtra("address");
        String major = getIntent().getStringExtra("major");
        double gpa = getIntent().getDoubleExtra("gpa", 0.0);
        int year = getIntent().getIntExtra("year", 1);

        // Ánh xạ các TextView
        TextView tvFullName = findViewById(R.id.tvFullName);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvAddress = findViewById(R.id.tvAddress);
        TextView tvMajor = findViewById(R.id.tvMajor);
        TextView tvGpa = findViewById(R.id.tvGpa);
        TextView tvYear = findViewById(R.id.tvYear);

        // Thiết lập giá trị cho các TextView
        tvFullName.setText(fullName);
        tvEmail.setText("Email: " + email);
        tvAddress.setText("Address: " + address);
        tvMajor.setText("Major: " + major);
        tvGpa.setText("GPA: " + gpa);
        tvYear.setText("Year: " + year);
    }
}
