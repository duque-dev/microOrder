package co.com.order.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPARepository extends CrudRepository<OrderEntity, Long>, QueryByExampleExecutor<OrderEntity> {
}
