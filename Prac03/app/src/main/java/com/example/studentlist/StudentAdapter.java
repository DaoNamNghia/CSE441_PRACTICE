package com.example.studentlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.example.studentlist.model.Student;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private final List<Student> studentList; // Danh sách sinh viên
    private final OnItemClickListener listener; // Listener cho sự kiện click

    // Giao diện để xử lý sự kiện click
    public interface OnItemClickListener {
        void onItemClick(Student student);
    }

    // Constructor
    public StudentAdapter(List<Student> studentList, OnItemClickListener listener) {
        this.studentList = studentList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout cho item sinh viên
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        // Lấy đối tượng sinh viên tại vị trí hiện tại
        Student student = studentList.get(position);
        holder.bind(student, listener); // Gán dữ liệu và listener cho ViewHolder
    }

    @Override
    public int getItemCount() {
        return studentList.size(); // Trả về số lượng sinh viên
    }

    // ViewHolder để nắm giữ các view
    public static class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView tvId, tvName, tvGpa; // Các TextView để hiển thị ID, tên và điểm

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
            tvGpa = itemView.findViewById(R.id.tvGpa);
        }

        public void bind(final Student student, final OnItemClickListener listener) {
            // Thiết lập dữ liệu cho các view
            tvId.setText("ID: " + student.getId());
            tvName.setText(student.getFirstName() + " " + student.getMiddleName() + " " + student.getLastName());
            tvGpa.setText("GPA: " + student.getGpa());

            // Thiết lập sự kiện click cho từng item
            itemView.setOnClickListener(v -> listener.onItemClick(student));
        }
    }
}
