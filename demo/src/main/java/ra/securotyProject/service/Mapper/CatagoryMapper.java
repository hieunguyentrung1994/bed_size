package ra.securotyProject.service.Mapper;

import org.springframework.stereotype.Component;
import ra.securotyProject.model.domain.Catagory;
import ra.securotyProject.model.dto.request.CatagoryRequest;
import ra.securotyProject.model.dto.response.CatagoryResponse;
import ra.securotyProject.service.IGenericMapper;
@Component
public class CatagoryMapper implements IGenericMapper<Catagory, CatagoryRequest, CatagoryResponse> {
    @Override
    public Catagory toEntity(CatagoryRequest catagoryRequest) {
        return Catagory.builder().nameCatagory(catagoryRequest.getCatagoryName()).status(catagoryRequest.isStatus()).build();
    }
    @Override
    public CatagoryResponse toResponse(Catagory catagory) {
        return CatagoryResponse.builder().catagoryName(catagory.getNameCatagory()).status(catagory.isStatus()).id(catagory.getId()).build();
    }
}
