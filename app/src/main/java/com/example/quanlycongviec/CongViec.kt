package com.example.quanlycongviec

import java.io.Serializable

data class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: String = "Chưa hoàn thành"
) : Serializable {

    // Hàm trả về chuỗi thông tin công việc theo yêu cầu đề bài
    fun layThongTinChiTiet(): String {
        return "Tên: $tenCongViec\nMô tả: $moTa\nTrạng thái: $trangThai"
    }
}