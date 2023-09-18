package ra.securotyProject.service.Mapper;

import org.springframework.stereotype.Component;
import ra.securotyProject.model.domain.Trademark;
import ra.securotyProject.model.dto.request.TrademarkRequest;
import ra.securotyProject.model.dto.response.TrademarkResponse;
import ra.securotyProject.service.IGenericMapper;
@Component
public class TrademarkMapper implements IGenericMapper<Trademark, TrademarkRequest, TrademarkResponse> {
    @Override
    public Trademark toEntity(TrademarkRequest trademarkRequest) {
        return Trademark.builder().nameTrademark(trademarkRequest.getNameTrademark())
                .status(trademarkRequest.isStatus()).build();
    }

    @Override
    public TrademarkResponse toResponse(Trademark trademark) {
        return TrademarkResponse.builder().id(trademark.getId()).nameTrademark(trademark.getNameTrademark())
                .status(trademark.isStatus()).build();
    }
}
