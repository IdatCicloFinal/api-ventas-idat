package pe.edu.idat.api_ventas_idat.dto;

public class CategoryDto implements DtoEntity {
    private String categoryname;

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
}
