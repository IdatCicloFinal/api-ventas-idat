package pe.edu.idat.api_ventas_idat.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class ProductOrderId
        implements Serializable {
    private Integer orderid;
    private Integer productid;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }
}
