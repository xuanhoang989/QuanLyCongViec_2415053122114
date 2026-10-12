package com.example.quanlycongviec

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaCongViecActivity : AppCompatActivity() {

    private lateinit var edtChinhSuaTen: EditText
    private lateinit var edtChinhSuaMoTa: EditText
    private lateinit var btnLuuChinhSua: Button
    private lateinit var btnHuyChinhSua: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_cong_viec)

        edtChinhSuaTen = findViewById(R.id.edtChinhSuaTen)
        edtChinhSuaMoTa = findViewById(R.id.edtChinhSuaMoTa)
        btnLuuChinhSua = findViewById(R.id.btnLuuChinhSua)
        btnHuyChinhSua = findViewById(R.id.btnHuyChinhSua)

        // Điền sẵn dữ liệu hiện tại để người dùng sửa
        val tenHienTai = intent.getStringExtra("EXTRA_TEN_CONG_VIEC") ?: ""
        val moTaHienTai = intent.getStringExtra("EXTRA_MO_TA_CONG_VIEC") ?: ""
        edtChinhSuaTen.setText(tenHienTai)
        edtChinhSuaMoTa.setText(moTaHienTai)

        // Khi bấm Lưu: Gửi dữ liệu mới về qua Intent setResult
        btnLuuChinhSua.setOnClickListener {
            val tenMoi = edtChinhSuaTen.text.toString().trim()
            val moTaMoi = edtChinhSuaMoTa.text.toString().trim()

            val traVeIntent = Intent().apply {
                putExtra("RESULT_TEN_CONG_VIEC", tenMoi)
                putExtra("RESULT_MO_TA_CONG_VIEC", moTaMoi)
            }
            setResult(Activity.RESULT_OK, traVeIntent)
            finish()
        }

        btnHuyChinhSua.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}