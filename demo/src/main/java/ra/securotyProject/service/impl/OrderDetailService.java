package ra.securotyProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.securotyProject.exception.AlreadyExistException;
import ra.securotyProject.exception.NotfoundException;
import ra.securotyProject.model.domain.OrderDetail;
import ra.securotyProject.model.domain.RoleName;
import ra.securotyProject.model.domain.RoleOrderName;
import ra.securotyProject.model.dto.request.OrderDetailRequest;
import ra.securotyProject.model.dto.response.OrderDetailResponse;
import ra.securotyProject.repository.IOrderDetailRepository;
import ra.securotyProject.repository.IRoleOrderRepository;
import ra.securotyProject.service.IOrderDeTailService;
import ra.securotyProject.service.IRoleService;
import ra.securotyProject.service.Mapper.OrderdetailMapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService implements IOrderDeTailService {
    @Autowired
    private IOrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderdetailMapper orderdetailMapper;
    @Autowired
    private IRoleOrderRepository roleOrderRepository;
    @Autowired
    private IRoleService roleService;
    @Override
    public List<OrderDetailResponse> finAll() {
        return null;
    }

    @Override
    public OrderDetailResponse findById(Long id) {
        return null;
    }

    @Override
    public OrderDetailResponse save(OrderDetailRequest orderDetailRequest) throws AlreadyExistException {
        return null;
    }


    @Override
    public OrderDetailResponse update(OrderDetailRequest orderDetailRequest, Long id) throws NotfoundException {
        return null;
    }

    @Override
    public OrderDetailResponse delete(Long id) throws NotfoundException {
        return null;
    }

    @Override
    public OrderDetailResponse addSave(OrderDetailRequest request, Long idUser) {
        // kiểm tra sản phẩm đã có trong orderdetail chưa
        OrderDetail orderDetailcheck = (orderDetailRepository.findByProductAndUserAndColor(request.getProduct(),idUser, request.getColor()));
        if (orderDetailcheck == null){
            //check sản phẩm này có phải mua lại không
            if(orderDetailcheck.isStatus()){
                return orderdetailMapper.toResponse(orderDetailRepository.save(orderDetailcheck));
            }
        }
        // thêm mới sản phẩm lần đâu
        OrderDetail orderDetail = orderdetailMapper.toEntity(request);
        // thêm mới setRoleOrser
        orderDetail.setOrderDate(new Date());
        orderDetail.setRoleOrder(roleService.findByRoleOrderName(RoleOrderName.ROLE_LOADDING));
        return  orderdetailMapper.toResponse(orderDetailRepository.save(orderDetail));
    }
}
