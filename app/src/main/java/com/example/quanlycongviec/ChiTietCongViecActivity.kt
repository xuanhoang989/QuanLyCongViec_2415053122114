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

    // Đăng ký Activity Result API để nhận kết quả chỉnh sửa trả về
    private val chinhSuaLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val tenMoi = data?.getStringExtra("RESULT_TEN_CONG_VIEC") ?: ""
            val moTaMoi = data?.getStringExtra("RESULT_MO_TA_CONG_VIEC") ?: ""

            // Cập nhật lại TextView hiển thị
            tvChiTietTen.text = tenMoi
            tvChiTietMoTa.text = moTaMoi
            Toast.makeText(this, "Đã cập nhật công việc!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvChiTietTen = findViewById(R.id.tvChiTietTen)
        tvChiTietMoTa = findViewById(R.id.tvChiTietMoTa)
        btnChinhSua = findViewById(R.id.btnChinhSua)
        btnQuayLai = findViewById(R.id.btnQuayLai)

        // Nhận dữ liệu truyền từ MainActivity
        val tenCongViec = intent.getStringExtra("EXTRA_TEN_CONG_VIEC") ?: ""
        val moTaCongViec = intent.getStringExtra("EXTRA_MO_TA_CONG_VIEC") ?: ""

        tvChiTietTen.text = tenCongViec
        tvChiTietMoTa.text = moTaCongViec

        // Bấm Chỉnh sửa: Gọi launcher mở màn hình ChinhSuaCongViecActivity
        btnChinhSua.setOnClickListener {
            val intent = Intent(this, ChinhSuaCongViecActivity::class.java).apply {
                putExtra("EXTRA_TEN_CONG_VIEC", tvChiTietTen.text.toString())
                putExtra("EXTRA_MO_TA_CONG_VIEC", tvChiTietMoTa.text.toString())
            }
            chinhSuaLauncher.launch(intent)
        }

        btnQuayLai.setOnClickListener {
            finish()
        }
    }
}