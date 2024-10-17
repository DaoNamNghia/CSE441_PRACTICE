package com.example.studentlist;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.example.studentlist.model.Student;

public class MainActivity extends AppCompatActivity implements StudentAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Đọc dữ liệu từ tệp JSON
        List<Student> studentList = loadStudentsFromAssets(); // Gọi phương thức đọc dữ liệu

        // Khởi tạo Adapter và thiết lập cho RecyclerView
        studentAdapter = new StudentAdapter(studentList, this);
        recyclerView.setAdapter(studentAdapter);
    }

    private List<Student> loadStudentsFromAssets() {
        List<Student> students = new ArrayList<>();
        try {
            InputStream is = getAssets().open("students.json"); // Mở tệp JSON từ assets
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            Gson gson = new Gson();
            Type studentListType = new TypeToken<List<Student>>(){}.getType(); // Định nghĩa kiểu cho Gson
            students = gson.fromJson(reader, studentListType); // Chuyển đổi JSON thành danh sách sinh viên
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void onItemClick(Student student) {
    }
}
