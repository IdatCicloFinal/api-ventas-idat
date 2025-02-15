package pe.edu.idat.api_ventas_idat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.idat.api_ventas_idat.dto.DtoEntity;
import pe.edu.idat.api_ventas_idat.dto.GenericResponseDto;
import pe.edu.idat.api_ventas_idat.model.Product;
import pe.edu.idat.api_ventas_idat.repository.ProductRepository;
import pe.edu.idat.api_ventas_idat.repository.projection.ProductStockProjection;
import pe.edu.idat.api_ventas_idat.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    /*@GetMapping
    public ResponseEntity<List<Product>> obtenerProductos(){
        return new ResponseEntity<>(
                productService.obtenerProductos(),
                HttpStatus.OK);
    }*/
    @GetMapping
    public ResponseEntity<GenericResponseDto<List<DtoEntity>>>
        obtenerProductos(){
        List<DtoEntity> productDtoList =
                productService.obtenerProductosDto();
        GenericResponseDto<List<DtoEntity>> response
                = new GenericResponseDto<>();
        response.setCorrecto(true);
        response.setMensaje("Lista de productos");
        response.setRespuesta(productDtoList);
        return new ResponseEntity<>(response,
                HttpStatus.OK);
    }


    @GetMapping("/unit-stock")
    public ResponseEntity<GenericResponseDto<List<ProductStockProjection>>>
    obtenerProductosxStock(@RequestParam Integer stock){
        List<ProductStockProjection> productDtoList =
                productService.obtenerTodosLosProductos(stock);
        GenericResponseDto<List<ProductStockProjection>>
                response = new GenericResponseDto<>();
        response.setCorrecto(true);
        response.setMensaje("Lista de productos por stock");
        response.setRespuesta(productDtoList);
        return new ResponseEntity<>(response,
                HttpStatus.OK);
    }
}
