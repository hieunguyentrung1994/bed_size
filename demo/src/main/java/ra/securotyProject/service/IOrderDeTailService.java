package ra.securotyProject.service;

import ra.securotyProject.model.dto.request.OrderDetailRequest;
import ra.securotyProject.model.dto.response.OrderDetailResponse;

public interface IOrderDeTailService extends IGenericService < OrderDetailResponse,OrderDetailRequest,Long> {
    OrderDetailResponse addSave(OrderDetailRequest request, Long idUser);
}
