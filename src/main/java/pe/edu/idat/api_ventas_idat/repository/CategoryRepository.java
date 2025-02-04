package pe.edu.idat.api_ventas_idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.api_ventas_idat.model.Category;

@Repository
public interface CategoryRepository
    extends JpaRepository<Category, Integer>
{

}
