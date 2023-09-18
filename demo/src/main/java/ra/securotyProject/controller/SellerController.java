package ra.securotyProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.securotyProject.exception.AlreadyExistException;
import ra.securotyProject.exception.NotfoundException;
import ra.securotyProject.model.dto.request.ColorRequest;
import ra.securotyProject.model.dto.request.FormProductRequestSeller;
import ra.securotyProject.model.dto.request.TrademarkRequest;
import ra.securotyProject.model.dto.response.ColorResponse;
import ra.securotyProject.model.dto.response.ProductReponseSeller;
import ra.securotyProject.model.dto.response.TrademarkResponse;
import ra.securotyProject.service.IColorService;
import ra.securotyProject.service.IProductService;
import ra.securotyProject.service.ITrandemarkService;

import java.util.List;

@RestController
@RequestMapping("/api/seller")
public class SellerController {

    @Autowired
    private IProductService productService;

    @PostMapping("/addProduct/{idUser}")
    public ResponseEntity<ProductReponseSeller> addProduct(@ModelAttribute FormProductRequestSeller forrm, @PathVariable Long idUser) throws AlreadyExistException {
        return new ResponseEntity(productService.saveADD(forrm,idUser),HttpStatus.OK);
    }

    @GetMapping("/showAllProducts/{idUser}")
    public ResponseEntity<List<ProductReponseSeller>> showAllProducts(@PathVariable Long idUser){
        return new  ResponseEntity(productService.ShowAllPruct(idUser),HttpStatus.OK);
    }
    @PatchMapping("/updateProduct/{id}")
    public ResponseEntity<ProductReponseSeller> updateProduct(@PathVariable Long id,@ModelAttribute FormProductRequestSeller forrm) throws NotfoundException {
        return new ResponseEntity(productService.update(forrm,id),HttpStatus.OK);
    }
    @DeleteMapping("/blockProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) throws NotfoundException {
        productService.delete(id);
        return new ResponseEntity<>("Thành công",HttpStatus.OK);
    }
}
