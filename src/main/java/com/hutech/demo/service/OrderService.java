package com.hutech.demo.service;

import com.hutech.demo.model.CartItem;
import com.hutech.demo.model.Order;
import com.hutech.demo.model.OrderDetail;
import com.hutech.demo.repository.OrderDetailRepository;
import com.hutech.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private CartService cartService;

    @Transactional
    public Order createOrder(String customerName, List<CartItem> cartItems) {
        Order order = new Order();
        order.setCustomerName(customerName);
        order = orderRepository.save(order); // Lưu thông tin đơn hàng vào cơ sở dữ liệu.

        for (CartItem item : cartItems) {
            OrderDetail detail = new OrderDetail();
            detail.setOrder(order); // Thiết lập đơn hàng cho chi tiết đơn hàng.
            detail.setProduct(item.getProduct()); // Thiết lập sản phẩm cho chi tiết đơn hàng.
            detail.setQuantity(item.getQuantity()); // Thiết lập số lượng cho chi tiết đơn hàng.
            orderDetailRepository.save(detail); // Lưu chi tiết đơn hàng vào cơ sở dữ liệu.
        }

        // Tùy chọn xóa giỏ hàng sau khi đặt hàng
        cartService.clearCart();

        return order; // Trả về đơn hàng đã được tạo.
    }
}
