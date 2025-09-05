package org.kie.kogito.examples.quarkus.demo;

public class Order implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    private String orderNumber;
    private Boolean shipped;
    private Double total;

    public Order() {
    }

    public String getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Boolean isShipped() {
        return this.shipped;
    }

    public void setShipped(Boolean shipped) {
        this.shipped = shipped;
    }

    public Double getTotal() {
        return this.total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Order(String orderNumber, Boolean shipped,
            Double total) {
        this.orderNumber = orderNumber;
        this.shipped = shipped;
        this.total = total;
    }

    public String toString() {
        return "Order[" + this.orderNumber + "]";
    }
}