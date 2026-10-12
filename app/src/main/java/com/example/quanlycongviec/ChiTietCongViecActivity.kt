package com.example.quanlycongviec

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var tvChiTietTen: TextView
    private lateinit var tvChiTietMoTa: TextView
    private lateinit var btnChinhSua: Button
    private lateinit var btnQuayLai: Button

    private var congViec: CongViec? = null

    private val chinhSuaLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            @Suppress("DEPRECATION")
            val congViecCapNhat = data?.getSerializableExtra("RESULT_CONG_VIEC") as? CongViec
            if (congViecCapNhat != null) {
                congViec = congViecCapNhat
                hienThiThongTin()
                Toast.makeText(this, "Đã cập nhật công việc!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvChiTietTen = findViewById(R.id.tvChiTietTen)
        tvChiTietMoTa = findViewById(R.id.tvChiTietMoTa)
        btnChinhSua = findViewById(R.id.btnChinhSua)
        btnQuayLai = findViewById(R.id.btnQuayLai)

        // Nhận đối tượng CongViec từ MainActivity
        @Suppress("DEPRECATION")
        congViec = intent.getSerializableExtra("EXTRA_CONG_VIEC") as? CongViec

        hienThiThongTin()

        // Bấm Chỉnh sửa: Truyền đối tượng CongViec sang màn hình chỉnh sửa
        btnChinhSua.setOnClickListener {
            val intent = Intent(this, ChinhSuaCongViecActivity::class.java).apply {
                putExtra("EXTRA_CONG_VIEC", congViec)
            }
            chinhSuaLauncher.launch(intent)
        }

        btnQuayLai.setOnClickListener {
            finish()
        }
    }

    private fun hienThiThongTin() {
        congViec?.let {
            tvChiTietTen.text = it.tenCongViec
            tvChiTietMoTa.text = it.moTa
        }
    }
}