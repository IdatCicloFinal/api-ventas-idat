package pe.edu.idat.api_ventas_idat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.idat.api_ventas_idat.model.Product;
import pe.edu.idat.api_ventas_idat.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public ResponseEntity<List<Product>> obtenerProductos(){
        return new ResponseEntity<>(
                productService.obtenerProductos(),
                HttpStatus.OK);
    }
}
