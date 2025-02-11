package pe.edu.idat.api_ventas_idat.service;

import org.springframework.stereotype.Service;
import pe.edu.idat.api_ventas_idat.model.Product;
import pe.edu.idat.api_ventas_idat.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> obtenerProductos(){
        return productRepository.findByDiscontinued(false);
    }
}
