package pe.edu.idat.api_ventas_idat.model;


import jakarta.persistence.*;

@Entity
@Table(name = "orderdetails")
public class OrderDetail {
    @EmbeddedId
    private ProductOrderId id;
    private Double unitprice;
    private Integer quantity;
    private Double discount;

    @ManyToOne
    @MapsId("productid")
    @JoinColumn(name = "productid")
    private Product product;
    @ManyToOne
    @MapsId("orderid")
    @JoinColumn(name = "orderid")
    private Order order;

    public ProductOrderId getId() {
        return id;
    }

    public void setId(ProductOrderId id) {
        this.id = id;
    }

    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
