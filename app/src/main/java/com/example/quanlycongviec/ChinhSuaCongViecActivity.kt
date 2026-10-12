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
    private var congViecHienTai: CongViec? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_cong_viec)

        edtChinhSuaTen = findViewById(R.id.edtChinhSuaTen)
        edtChinhSuaMoTa = findViewById(R.id.edtMoTaCongViec ?: R.id.edtChinhSuaMoTa)
        btnLuuChinhSua = findViewById(R.id.btnLuuChinhSua)
        btnHuyChinhSua = findViewById(R.id.btnHuyChinhSua)

        // Nhận đối tượng CongViec từ Intent
        @Suppress("DEPRECATION")
        congViecHienTai = intent.getSerializableExtra("EXTRA_CONG_VIEC") as? CongViec

        congViecHienTai?.let {
            edtChinhSuaTen.setText(it.tenCongViec)
            edtChinhSuaMoTa.setText(it.moTa)
        }

        // Bấm Lưu: Cập nhật đối tượng và gửi trả về
        btnLuuChinhSua.setOnClickListener {
            val tenMoi = edtChinhSuaTen.text.toString().trim()
            val moTaMoi = edtChinhSuaMoTa.text.toString().trim()

            congViecHienTai?.apply {
                tenCongViec = tenMoi
                moTa = moTaMoi
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