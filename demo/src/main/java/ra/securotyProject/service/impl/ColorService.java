package ra.securotyProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.securotyProject.exception.AlreadyExistException;
import ra.securotyProject.exception.NotfoundException;
import ra.securotyProject.model.domain.Catagory;
import ra.securotyProject.model.domain.Color;
import ra.securotyProject.model.dto.request.ColorRequest;
import ra.securotyProject.model.dto.response.CatagoryResponse;
import ra.securotyProject.model.dto.response.ColorResponse;
import ra.securotyProject.repository.IColorRepository;
import ra.securotyProject.service.IColorService;
import ra.securotyProject.service.Mapper.ColorMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ColorService implements IColorService {
@Autowired
private IColorRepository colorRepository;
@Autowired
private ColorMapper colorMapper;
@Override
    public List<ColorResponse> finAll() {
        List<Color> colorslist = colorRepository.findAll();
        List<ColorResponse> colorResponses = colorslist.stream()
                .map(color -> colorMapper.toResponse(color))
                .filter(response -> response.isStatus() == true) // Điều kiện lọc được thêm vào đây
                .collect(Collectors.toList());
        return colorResponses;
    }

    @Override
    public ColorResponse findById(Long id) {
        Optional<Color> colorOptional = colorRepository.findById(id);
        if(!colorOptional.isPresent()){
            return colorMapper.toResponse(colorOptional.get());
        }
        return null;
    }

    @Override
    public ColorResponse save(ColorRequest colorRequest) throws AlreadyExistException {
        if (colorRepository.existsByNameColor(colorRequest.getColorName())){
            throw new AlreadyExistException("Color của bạn đã tồn tại !!!");
        }
       Color color = colorMapper.toEntity(colorRequest);
        color.setStatus(true);
        return colorMapper.toResponse(colorRepository.save(color));
    }

    @Override
    public ColorResponse update(ColorRequest colorRequest, Long id) throws NotfoundException {
        Optional<Color> check = colorRepository.findById(id);
        if(!check.isPresent()) {
            throw new  NotfoundException("Không tìm thấy Color cần sửa !!!");
        }
        Color color = colorMapper.toEntity(colorRequest);
        color.setId(id);
        colorRepository.save(color);
        return colorMapper.toResponse(color);
    }

    @Override
    public ColorResponse delete(Long id) throws NotfoundException {
        Optional<Color> color = colorRepository.findById(id);
        Color co = color.get();
        if (color.isPresent()) {
            if (co.isStatus() == true){
                co.setStatus(false);
            }else {
            co.setStatus(true);}
            colorRepository.save(co);
            return  colorMapper.toResponse(color.get());
        }
        throw new NotfoundException("Không tìm thấy Color !!!");
    }
}
