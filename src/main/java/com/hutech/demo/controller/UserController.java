package com.hutech.demo.controller;

import com.hutech.demo.model.User;
import com.hutech.demo.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller // Đánh dấu lớp này là một Controller trong Spring MVC.
@RequestMapping("/") // Đường dẫn gốc mà controller này sẽ xử lý.
@RequiredArgsConstructor // Lombok tự động tạo constructor có tham số cho các trường final.
public class UserController {
    private final UserService userService; // Dịch vụ quản lý người dùng

    @GetMapping("/login") // Xử lý GET request cho "/login"
    public String login() {
        return "users/login"; // Trả về view "login" cho người dùng
    }

    @GetMapping("/register") // Xử lý GET request cho "/register"
    public String register(@NotNull Model model) {
        model.addAttribute("user", new User()); // Thêm một đối tượng User mới vào model
        return "users/register"; // Trả về view "register"
    }

    @PostMapping("/register") // Xử lý POST request cho "/register"
    public String register(@Valid @ModelAttribute("user") User user, // Validate đối tượng User
                           @NotNull BindingResult bindingResult, // Kết quả của quá trình validate
                           Model model) {
        if (bindingResult.hasErrors()) { // Kiểm tra nếu có lỗi validate
            var errors = bindingResult.getAllErrors() // Lấy tất cả lỗi
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toArray(String[]::new); // Chuyển các lỗi thành mảng String
            model.addAttribute("errors", errors); // Thêm lỗi vào model
            return "users/register"; // Trả về lại view "register" nếu có lỗi
        }
        userService.save(user); // Lưu người dùng vào cơ sở dữ liệu
        userService.setDefaultRole(user.getUsername()); // Gán vai trò mặc định cho người dùng
        return "redirect:/login"; // Chuyển hướng người dùng tới trang "login"
    }
}
