package com.example.quanlycongviec

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var tvChiTietTen: TextView
    private lateinit var tvChiTietMoTa: TextView
    private lateinit var btnQuayLai: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvChiTietTen = findViewById(R.id.tvChiTietTen)
        tvChiTietMoTa = findViewById(R.id.tvChiTietMoTa)
        btnQuayLai = findViewById(R.id.btnQuayLai)

        // Nhận dữ liệu truyền từ MainActivity
        val tenCongViec = intent.getStringExtra("EXTRA_TEN_CONG_VIEC") ?: ""
        val moTaCongViec = intent.getStringExtra("EXTRA_MO_TA_CONG_VIEC") ?: ""

        // Hiển thị dữ liệu lên giao diện
        tvChiTietTen.text = tenCongViec
        tvChiTietMoTa.text = moTaCongViec

        btnQuayLai.setOnClickListener {
            finish()
        }
    }
}