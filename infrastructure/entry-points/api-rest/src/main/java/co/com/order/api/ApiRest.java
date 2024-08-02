package co.com.order.api;
import co.com.order.model.order.Order;
import co.com.order.usecase.order.OrderUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/restaurante/order", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final OrderUseCase orderUseCase;
//    private final MyUseCase useCase;


    @GetMapping(path = "/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long  id) {
//      return useCase.doAction();
        return ResponseEntity.ok(orderUseCase.getOrderById(id));
    }

    @PostMapping(path = "/")
    public ResponseEntity<Order> saveBook(@RequestBody Order order){
        System.out.println(order);
        return ResponseEntity.ok(orderUseCase.saveOrder(order));
    }
    @PutMapping(path = "/")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        System.out.println(order);
        return ResponseEntity.ok(orderUseCase.updateOrder(order));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long  id) {
        orderUseCase.deleteOrderById(id);
        return ResponseEntity.ok("Libro eliminado exitosamente");
    }
}
