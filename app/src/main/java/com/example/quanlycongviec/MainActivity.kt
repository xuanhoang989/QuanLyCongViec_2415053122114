package com.example.quanlycongviec

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvThongTinSinhVien: TextView
    private lateinit var edtTenCongViec: EditText
    private lateinit var edtMoTaCongViec: EditText
    private lateinit var btnTaoCongViec: Button
    private lateinit var btnXemDanhSach: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ thành phần giao diện
        tvThongTinSinhVien = findViewById(R.id.tvThongTinSinhVien)
        edtTenCongViec = findViewById(R.id.edtTenCongViec)
        edtMoTaCongViec = findViewById(R.id.edtMoTaCongViec)
        btnTaoCongViec = findViewById(R.id.btnTaoCongViec)
        btnXemDanhSach = findViewById(R.id.btnXemDanhSach)

        // Xử lý sự kiện cho nút Xem danh sách
        btnXemDanhSach.setOnClickListener {
            Toast.makeText(this, "Chức năng xem danh sách đang hoàn thiện", Toast.LENGTH_SHORT).show()
        }
    }
}