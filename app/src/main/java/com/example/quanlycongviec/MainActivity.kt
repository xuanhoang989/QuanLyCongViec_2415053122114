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

            val intent = Intent(this, ChiTietCongViecActivity::class.java).apply {
                putExtra("EXTRA_TEN_CONG_VIEC", ten)
                putExtra("EXTRA_MO_TA_CONG_VIEC", moTa)
            }
            startActivity(intent)
        }

        btnXemDanhSach.setOnClickListener {
            Toast.makeText(this, "Chức năng xem danh sách đang hoàn thiện", Toast.LENGTH_SHORT).show()
        }
    }
}