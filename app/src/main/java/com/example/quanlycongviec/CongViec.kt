package com.example.quanlycongviec

import java.io.Serializable

data class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: String = "Chưa hoàn thành",
    var soLanChinhSua: Int = 0
) : Serializable {

    fun layThongTinChiTiet(): String {
        return "Tên: $tenCongViec\nMô tả: $moTa\nTrạng thái: $trangThai\nSố lần sửa: $soLanChinhSua"
    }
}