package com.example.quanlycongviec

import android.content.Intent
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

        tvThongTinSinhVien = findViewById(R.id.tvThongTinSinhVien)
        edtTenCongViec = findViewById(R.id.edtTenCongViec)
        edtMoTaCongViec = findViewById(R.id.edtMoTaCongViec)
        btnTaoCongViec = findViewById(R.id.btnTaoCongViec)
        btnXemDanhSach = findViewById(R.id.btnXemDanhSach)

        btnTaoCongViec.setOnClickListener {
            val ten = edtTenCongViec.text.toString().trim()
            val moTa = edtMoTaCongViec.text.toString().trim()

            // Kiểm tra không cho phép để trống tên công việc
            if (ten.isEmpty()) {
                edtTenCongViec.error = "Tên công việc không được để trống!"
                Toast.makeText(this, "Vui lòng nhập tên công việc!", Toast.LENGTH_SHORT).show()
                edtTenCongViec.requestFocus()
                return@setOnClickListener
            }

            val congViecMoi = CongViec(tenCongViec = ten, moTa = moTa)

            val intent = Intent(this, ChiTietCongViecActivity::class.java).apply {
                putExtra("EXTRA_CONG_VIEC", congViecMoi)
            }
            startActivity(intent)
        }

        btnXemDanhSach.setOnClickListener {
            Toast.makeText(this, "Chức năng xem danh sách đang hoàn thiện", Toast.LENGTH_SHORT).show()
        }
    }
}