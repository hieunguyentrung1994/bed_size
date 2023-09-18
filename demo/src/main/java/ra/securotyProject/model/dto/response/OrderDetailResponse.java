package ra.securotyProject.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.securotyProject.model.domain.Color;
import ra.securotyProject.model.domain.Products;
import ra.securotyProject.model.domain.RoleOrder;
import ra.securotyProject.model.domain.Users;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailResponse {

    private Long id;

    private int quantity;

    private double total;

    private String comment;


    private double point;

    private Date orderDate;

    private Color color;

    private boolean status;

    private Products product;

    private RoleOrder roleOrder;

    private Users user;
}
