package com.nhom2_kot104.ungdungdatcomtam.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nhom2_kot104.ungdungdatcomtam.model.Order
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OrderViewModel:ViewModel() {
    private val _orders = MutableStateFlow<List<Order>>(emptyList())
    val orders: StateFlow<List<Order>> = _orders
    fun updateOrderStatus(orderId: String, newStatus: Int) {
        viewModelScope.launch {
            val updatedOrders = _orders.value.map { order ->
                if (order.orderId == orderId) {
                    order.copy(status = newStatus)
                } else {
                    order
                }
            }
            _orders.value = updatedOrders
        }
    }

    init {
        // Tải dữ liệu đơn hàng ban đầu, nếu cần
    }
}