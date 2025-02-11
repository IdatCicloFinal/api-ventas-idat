package pe.edu.idat.api_ventas_idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.api_ventas_idat.model.Product;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Integer> {

}
