package org.supamassirichotiyakul.catermate.order;

import org.springframework.format.annotation.DateTimeFormat;
import org.supamassirichotiyakul.catermate.orderitem.OrderItem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String customerFirstName;

    private String customerLastName;

    private String deliveryAddress;

    private String customerPhone;

    private String deliveryOption;

    private String location;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;

    @DateTimeFormat(pattern="HH:mm")
    @Temporal(TemporalType.TIME)
    private Date kitchenReadyTime;

    private double subTotal;

    private double tax;

    private double total;

//    @OneToMany(mappedBy = "order", targetEntity = OrderItem.class,
    @OneToMany(targetEntity = OrderItem.class,
            fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<OrderItem> orderItemList;

    public Order() {
        orderItemList = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getDeliveryOption() {
        return deliveryOption;
    }

    public void setDeliveryOption(String deliveryOption) {
        this.deliveryOption = deliveryOption;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getKitchenReadyTime() {
        return kitchenReadyTime;
    }

    public void setKitchenReadyTime(Date kitchenReadyTime) {
        this.kitchenReadyTime = kitchenReadyTime;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Double.compare(order.subTotal, subTotal) == 0 && Double.compare(order.tax, tax) == 0 && Double.compare(order.total, total) == 0 && Objects.equals(customerFirstName, order.customerFirstName) && Objects.equals(customerLastName, order.customerLastName) && Objects.equals(deliveryAddress, order.deliveryAddress) && Objects.equals(customerPhone, order.customerPhone) && Objects.equals(deliveryOption, order.deliveryOption) && Objects.equals(location, order.location) && Objects.equals(deliveryDate, order.deliveryDate) && Objects.equals(kitchenReadyTime, order.kitchenReadyTime) && Objects.equals(orderItemList, order.orderItemList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerFirstName, customerLastName, deliveryAddress, customerPhone, deliveryOption, location, deliveryDate, kitchenReadyTime, subTotal, tax, total, orderItemList);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", deliveryOption='" + deliveryOption + '\'' +
                ", location='" + location + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", kitchenReadyTime=" + kitchenReadyTime +
                ", subTotal=" + subTotal +
                ", tax=" + tax +
                ", total=" + total +
                ", orderItemList=" + orderItemList +
                '}';
    }

    // ------------ custom methods start here ------------
    public String getSubTotalDisplay() {
        return String.format("$%.2f", getSubTotal());
    }

    public String getTaxDisplay() {
        return String.format("$%.2f", getTax());
    }

    public String getTotalDisplay() {
        return String.format("$%.2f", getTotal());
    }
}