package pe.edu.idat.api_ventas_idat.service;

import org.springframework.stereotype.Service;
import pe.edu.idat.api_ventas_idat.dto.DtoEntity;
import pe.edu.idat.api_ventas_idat.dto.ProductDto;
import pe.edu.idat.api_ventas_idat.model.Product;
import pe.edu.idat.api_ventas_idat.repository.ProductRepository;
import pe.edu.idat.api_ventas_idat.repository.projection.ProductStockProjection;
import pe.edu.idat.api_ventas_idat.util.ConvertDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ConvertDto convertDto;

    public ProductService(ProductRepository productRepository, ConvertDto convertDto) {
        this.productRepository = productRepository;
        this.convertDto = convertDto;
    }

    public List<Product> obtenerProductos(){
        //return productRepository.findByDiscontinued(false);
        //return productRepository.obtenerProductosActivos();
        return productRepository.obtenerProductosActivosSQL();
    }

    public List<DtoEntity> obtenerProductosDto(){
        List<DtoEntity> productDtoList = new ArrayList<>();
        productDtoList = productRepository.obtenerProductosActivosSQL()
                .stream()
                .map(p -> convertDto.convertirADto(p, new ProductDto()))
                .collect(Collectors.toList());
        if (productDtoList.isEmpty())
            return null;
        return productDtoList;
    }

    public List<ProductStockProjection> obtenerTodosLosProductos(Integer unitsInStock){
        return productRepository.obtenerTodosLosProductos(unitsInStock);
    }
}
