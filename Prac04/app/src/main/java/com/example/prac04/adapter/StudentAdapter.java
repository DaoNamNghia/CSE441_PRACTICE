package com.example.prac04.adapter;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.prac04.R;
import com.example.prac04.model.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private List<Student> studentList;
    private Context context;

    public StudentAdapter(List<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.textName.setText(student.getName());
        holder.textMSSV.setText(student.getMssv());
        holder.textClass.setText(student.getClassName());
        holder.textScore.setText(String.valueOf(student.getGpa()));

        holder.buttonEdit.setOnClickListener(v -> {
            // Chuyển đến màn hình sửa sinh viên
        });

        holder.buttonDelete.setOnClickListener(v -> {
            // Xóa sinh viên
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textMSSV, textClass, textScore;
        Button buttonEdit, buttonDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.text_name);
            textMSSV = itemView.findViewById(R.id.text_mssv);
            textClass = itemView.findViewById(R.id.text_class);
            textScore = itemView.findViewById(R.id.text_score);
            buttonEdit = itemView.findViewById(R.id.button_edit);
            buttonDelete = itemView.findViewById(R.id.button_delete);
        }
    }
}