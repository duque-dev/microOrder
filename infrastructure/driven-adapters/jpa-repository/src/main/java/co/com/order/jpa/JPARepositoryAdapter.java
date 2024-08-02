package co.com.order.jpa;

import co.com.order.jpa.helper.AdapterOperations;
import co.com.order.model.order.Order;
import co.com.order.model.order.gateways.OrderRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JPARepositoryAdapter extends AdapterOperations<Order, OrderEntity, Long, JPARepository>
implements OrderRepository
// implements ModelRepository from domain
{

    public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d,Order.class));
    }

    @Override
    public Order getOrderById(Long id) {
        return this.toEntity(this.repository.findById((id)).orElse(new OrderEntity()));
    }

    @Override
    public Order saveOrder(Order order) {
        return (Order) this.toEntity((OrderEntity)
                ((JPARepository)this.repository).save((OrderEntity)this.toData(order)));
    }

    @Override
    public Order updateOrder(Order order) {
        return (Order) this.toEntity((OrderEntity)
                ((JPARepository)this.repository).save((OrderEntity)this.toData(order)));
    }

    @Override
    public void deleteOrderById(Long id) {
        ((JPARepository)this.repository).deleteById(id);
    }
}
