package pe.edu.idat.api_ventas_idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.idat.api_ventas_idat.model.Product;
import pe.edu.idat.api_ventas_idat.repository.projection.ProductStockProjection;

import java.util.List;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Integer> {

    //select * from products where discontinued = ?;
    List<Product> findByDiscontinued(Boolean discontinued);

    //Sintaxis JPQL
    @Query("SELECT p FROM Product p WHERE p.discontinued=false")
    List<Product> obtenerProductosActivos();

    @Query(value = "SELECT * FROM products WHERE discontinued=0",
    nativeQuery = true)
    List<Product> obtenerProductosActivosSQL();




    @Query(value = "select p.ProductID, p.ProductName, p.UnitPrice, " +
            "c.CategoryName, s.CompanyName, p.UnitsInStock   from products p " +
            "inner join categories c on P.CategoryID = C.CategoryID " +
            "inner join suppliers s on P.SupplierID = S.SupplierID " +
            "where p.UnitsInStock <= :unitsInStock",
    nativeQuery = true)
    List<ProductStockProjection> obtenerTodosLosProductos(
            @Param("unitsInStock") Integer unitsInStock);




}
