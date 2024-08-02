package co.com.order.usecase.order;

import co.com.order.model.order.Order;
import co.com.order.model.order.gateways.OrderRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class OrderUseCase {
    private final OrderRepository orderRepository;

    public Order getOrderById (Long id){
        return orderRepository.getOrderById(id);
    }

    public Order saveOrder (Order order){
        return  orderRepository.saveOrder(order);
    }

    public Order updateOrder (Order order){
        return  orderRepository.updateOrder(order);
    }

    public void deleteOrderById (Long id){
        orderRepository.deleteOrderById(id);
    }
}
