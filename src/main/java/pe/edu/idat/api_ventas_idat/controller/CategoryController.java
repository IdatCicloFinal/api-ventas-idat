package pe.edu.idat.api_ventas_idat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.api_ventas_idat.exception.ResourceNotFoundException;
import pe.edu.idat.api_ventas_idat.model.Category;
import pe.edu.idat.api_ventas_idat.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService
            categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> listarCategorias(){
        List<Category> categoryList
                = categoryService
                .listarCategorias();
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> obtenerCategoria(
            @PathVariable Integer id){
        Category category = categoryService
                .obtenerCategoriaXid(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "La categoria buscada no existe"));
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> registrarCategoria(
            @RequestBody Category category){
        return new ResponseEntity<>(
                categoryService.guardarCategoria(category),
                HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> actualizarCategoria(
            @PathVariable Integer id,
            @RequestBody Category category){
        Category currentCategory = categoryService
                .obtenerCategoriaXid(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                                "La categoria buscada no existe"));
        currentCategory.setCategoryname(category.getCategoryname());
        currentCategory.setDescription(category.getDescription());
        return new ResponseEntity<>(
                categoryService.guardarCategoria(currentCategory),
                HttpStatus.OK);
    }
}
