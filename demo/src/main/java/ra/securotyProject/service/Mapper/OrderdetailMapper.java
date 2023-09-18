package ra.securotyProject.service.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ra.securotyProject.model.domain.*;
import ra.securotyProject.model.dto.request.OrderDetailRequest;
import ra.securotyProject.model.dto.response.OrderDetailResponse;
import ra.securotyProject.repository.IColorRepository;
import ra.securotyProject.repository.IProductRepository;
import ra.securotyProject.repository.IUserRepository;
import ra.securotyProject.service.IGenericMapper;



@Component
public class OrderdetailMapper implements IGenericMapper<OrderDetail, OrderDetailRequest, OrderDetailResponse> {
    @Autowired
    private IColorRepository colorRepository;
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public OrderDetail toEntity(OrderDetailRequest orderDetailRequest) {
        Color color = colorRepository.findById(orderDetailRequest.getColor()).get();
        Products products = productRepository.findById(orderDetailRequest.getProduct()).get();
        Users user = userRepository.findById(orderDetailRequest.getUser()).get();

        return OrderDetail.builder().color(color).product(products).user(user)
                .quantity(orderDetailRequest.getQuantity()).total(products.getPrice()*orderDetailRequest.getQuantity())
                // date va status lam ben service
                .build();
    }

    @Override
    public OrderDetailResponse toResponse(OrderDetail o) {
        return OrderDetailResponse.builder().id(o.getId()).quantity(o.getQuantity()).total(o.getTotal())
                .comment(o.getComment()).point(o.getPoint()).status(o.isStatus()).orderDate(o.getOrderDate())
                .color(o.getColor()).product(o.getProduct()).roleOrder(o.getRoleOrder()).user(o.getUser()).build();
    }
}
