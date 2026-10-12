package com.example.quanlycongviec

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaCongViecActivity : AppCompatActivity() {

    private lateinit var edtChinhSuaTen: EditText
    private lateinit var edtChinhSuaMoTa: EditText
    private lateinit var cbChinhSuaHoanThanh: CheckBox
    private lateinit var btnLuuChinhSua: Button
    private lateinit var btnHuyChinhSua: Button
    private var congViecHienTai: CongViec? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_cong_viec)

        edtChinhSuaTen = findViewById(R.id.edtChinhSuaTen)
        edtChinhSuaMoTa = findViewById(R.id.edtChinhSuaMoTa)
        cbChinhSuaHoanThanh = findViewById(R.id.cbChinhSuaHoanThanh)
        btnLuuChinhSua = findViewById(R.id.btnLuuChinhSua)
        btnHuyChinhSua = findViewById(R.id.btnHuyChinhSua)

        @Suppress("DEPRECATION")
        congViecHienTai = intent.getSerializableExtra("EXTRA_CONG_VIEC") as? CongViec

        congViecHienTai?.let {
            edtChinhSuaTen.setText(it.tenCongViec)
            edtChinhSuaMoTa.setText(it.moTa)
            cbChinhSuaHoanThanh.isChecked = (it.trangThai == "Đã hoàn thành")
        }

        btnLuuChinhSua.setOnClickListener {
            val tenMoi = edtChinhSuaTen.text.toString().trim()
            val moTaMoi = edtChinhSuaMoTa.text.toString().trim()

            // Kiểm tra rỗng khi sửa
            if (tenMoi.isEmpty()) {
                edtChinhSuaTen.error = "Tên công việc không được để trống!"
                Toast.makeText(this, "Vui lòng nhập tên công việc!", Toast.LENGTH_SHORT).show()
                edtChinhSuaTen.requestFocus()
                return@setOnClickListener
            }

            congViecHienTai?.apply {
                tenCongViec = tenMoi
                moTa = moTaMoi
                trangThai = if (cbChinhSuaHoanThanh.isChecked) "Đã hoàn thành" else "Chưa hoàn thành"
            }

            val traVeIntent = Intent().apply {
                putExtra("RESULT_CONG_VIEC", congViecHienTai)
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