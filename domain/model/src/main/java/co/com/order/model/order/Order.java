package co.com.order.model.order;
import lombok.*;
//import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class Order {

    private Long id;
    private String clientId;
    private List<String> menuItems;
    private double totalPrice;

}
