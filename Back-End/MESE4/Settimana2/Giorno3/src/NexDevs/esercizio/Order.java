package NexDevs.esercizio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private long id;
    private String status;
    private LocalDate orderData;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;
    private static List<Order> orders=new ArrayList<>();

    public Order(long id, String status, LocalDate orderData, LocalDate deliveryDate, List<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderData = orderData;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
        Order.orders.add(this);
    }

    public static List<Order> getOrders() {
        return orders;
    }

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrderData() {
        return orderData;
    }

    public LocalDate getDeliveryDate() {
        return  this.deliveryDate;
    }

    public List<Product> getProducts() {
        return  this.products;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public void addProduct(Product prodotto){
        this.products.add(prodotto);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderData=" + orderData +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}
