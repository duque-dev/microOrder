package co.com.order.model.order.gateways;

import co.com.order.model.order.Order;

public interface OrderRepository {

    Order getOrderById (Long id);
    Order saveOrder (Order order);

    Order updateOrder (Order order);

    void deleteOrderById(Long id);
}
