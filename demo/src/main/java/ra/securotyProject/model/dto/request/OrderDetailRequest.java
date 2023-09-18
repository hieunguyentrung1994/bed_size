package ra.securotyProject.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.securotyProject.model.domain.Color;
import ra.securotyProject.model.domain.Products;
import ra.securotyProject.model.domain.RoleOrder;
import ra.securotyProject.model.domain.Users;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailRequest {
    private int quantity;

    private double total;

    private String comment;

    private double point;

    private Date orderDate;

    private Long color;

    private boolean status;

    private Long product;

    private Long roleOrder;

    private Long user;
}
