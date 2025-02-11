package pe.edu.idat.api_ventas_idat.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pe.edu.idat.api_ventas_idat.dto.DtoEntity;
import pe.edu.idat.api_ventas_idat.dto.ProductDto;
import pe.edu.idat.api_ventas_idat.model.Product;

@Component
public class ConvertDto {

    public DtoEntity convertirADto(Object object,
                                          DtoEntity dto){
        return new ModelMapper().map(object, dto.getClass());
    }

    /*
    public ProductDto convertirAProductDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setProductid(product.getProductid());
        productDto.setProductname(product.getProductname());
        return productDto;
    }*/
}
