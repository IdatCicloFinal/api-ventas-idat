package pe.edu.idat.api_ventas_idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.idat.api_ventas_idat.model.Product;

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




}
