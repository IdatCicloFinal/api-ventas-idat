package pe.edu.idat.api_ventas_idat.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productid;
    private String productname;
    private String quantityperunit;
    private Double unitprice;
    private Integer unitsinstock;
    private Integer reorderlevel;
    private Boolean descontinued;

    @ManyToOne
    @JoinColumn(name ="supplierid")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getQuantityperunit() {
        return quantityperunit;
    }

    public void setQuantityperunit(String quantityperunit) {
        this.quantityperunit = quantityperunit;
    }

    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    public Integer getUnitsinstock() {
        return unitsinstock;
    }

    public void setUnitsinstock(Integer unitsinstock) {
        this.unitsinstock = unitsinstock;
    }

    public Integer getReorderlevel() {
        return reorderlevel;
    }

    public void setReorderlevel(Integer reorderlevel) {
        this.reorderlevel = reorderlevel;
    }

    public Boolean getDescontinued() {
        return descontinued;
    }

    public void setDescontinued(Boolean descontinued) {
        this.descontinued = descontinued;
    }
}
