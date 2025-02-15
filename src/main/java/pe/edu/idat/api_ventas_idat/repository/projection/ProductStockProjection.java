package pe.edu.idat.api_ventas_idat.repository.projection;

import org.springframework.beans.factory.annotation.Value;

public interface ProductStockProjection {
    //Para los atributos definidos con _ (Ejemplo reorder_level) utilizar @Value("#{target.reorder_level}")
    @Value("#{target.ProductID}")
    Integer getProductId();
    @Value("#{target.ProductName}")
    String getProductName();
    @Value("#{target.UnitPrice}")
    Double getUnitPrice();
    @Value("#{target.CategoryName}")
    String getCategoryName();
    @Value("#{target.CompanyName}")
    String getCompanyName();
    @Value("#{target.UnitsInStock}")
    Integer getUnitsInStock();
}
