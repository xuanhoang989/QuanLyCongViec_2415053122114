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

        // 1. Chức năng Hủy: Quay về màn hình chi tiết mà không cập nhật thông tin và không tăng số lần sửa
        btnHuyChinhSua.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        // 2. Chức năng Lưu: Kiểm tra hợp lệ -> Chỉ tăng soLanChinhSua khi lưu thành công
        btnLuuChinhSua.setOnClickListener {
            val tenMoi = edtChinhSuaTen.text.toString().trim()
            val moTaMoi = edtChinhSuaMoTa.text.toString().trim()

            // Dữ liệu không hợp lệ: Không tăng số lần sửa và không lưu
            if (tenMoi.isEmpty()) {
                edtTenCongViecError()
                return@setOnClickListener
            }

            // Lưu thành công: Tăng số lần chỉnh sửa lên 1
            congViecHienTai?.apply {
                tenCongViec = tenMoi
                moTa = moTaMoi
                trangThai = if (cbChinhSuaHoanThanh.isChecked) "Đã hoàn thành" else "Chưa hoàn thành"
                soLanChinhSua += 1
            }

            val traVeIntent = Intent().apply {
                putExtra("RESULT_CONG_VIEC", congViecHienTai)
            }
            setResult(Activity.RESULT_OK, traVeIntent)
            finish()
        }
    }

    private fun edtTenCongViecError() {
        edtChinhSuaTen.error = "Tên công việc không được để trống!"
        Toast.makeText(this, "Vui lòng nhập tên công việc!", Toast.LENGTH_SHORT).show()
        edtChinhSuaTen.requestFocus()
    }
}