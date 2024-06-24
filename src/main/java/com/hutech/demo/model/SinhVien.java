/*
package com.hutech.demo.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class SinhVien {
    @NotBlank(message = "Tên là bắt buộc")
    private String ten;

    @Min(value = 18, message = "Tuổi phải lớn hơn hoặc bằng 18")
    @Max(value = 100, message = "Tuổi phải nhỏ hơn hoặc bằng 100")
    private int tuoi;

    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Khoa phải là chữ")
    private String khoa;

    // Getters and Setters
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }
}
*/

package com.hutech.demo.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;

public class SinhVien {
    @NotBlank(message = "Tên là bắt buộc")
    private String ten;

    @Min(value = 18, message = "Tuổi phải lớn hơn hoặc bằng 18")
    @Max(value = 100, message = "Tuổi phải nhỏ hơn hoặc bằng 100")
    private int tuoi;

    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Khoa phải là chữ")
    private String khoa;

    @Email(message = "Email phải là một địa chỉ email hợp lệ")
    private String email;

    @Past(message = "Ngày sinh phải là ngày trong quá khứ")
    private LocalDate ngaySinh;

    @Pattern(regexp = "^\\+?\\d{10,15}$", message = "Số điện thoại phải là 10-15 chữ số và có thể bắt đầu bằng +")
    private String soDienThoai;

    private String imagePath;  // Store the image path

    // Getters and Setters
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
}

