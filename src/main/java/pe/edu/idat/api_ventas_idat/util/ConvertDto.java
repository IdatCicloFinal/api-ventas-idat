package pe.edu.idat.api_ventas_idat.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pe.edu.idat.api_ventas_idat.dto.DtoEntity;

@Component
public class ConvertDto {

    public DtoEntity convertirADto(Object object,
                                          DtoEntity dto){
        return new ModelMapper().map(object, dto.getClass());
    }
}
