package pe.edu.idat.api_ventas_idat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.idat.api_ventas_idat.model.Category;
import pe.edu.idat.api_ventas_idat.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository
            categoryRepository;
    public CategoryService(
            CategoryRepository categoryRepository) {
        this.categoryRepository
                = categoryRepository;
    }

    public List<Category> listarCategorias(){
        return categoryRepository
                .findAll();
    }
    public Category guardarCategoria(
            Category category){
        return categoryRepository
                .save(category);
    }

    public Optional<Category>
    obtenerCategoriaXid(Integer id){
        return categoryRepository.findById(id);
    }
}
