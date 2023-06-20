package org.supamassirichotiyakul.catermate.orderitem;

import org.supamassirichotiyakul.catermate.cartitem.CartItem;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ORDER_ITEMS")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;

    private long menuItemId;

    @NotNull
    @Size(min=2, max=50)
    private String name;

    @NotNull
    private double price;

    @NotNull
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(CartItem cartItem) {
        this.menuItemId = cartItem.getMenuItemId();
        this.name = cartItem.getName();
        this.price = cartItem.getPrice();
        this.quantity = cartItem.getQuantity();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }

    public long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // ------------ custom methods start here ------------
    public String getPriceDisplay() {
        return String.format("$%.2f", price);
    }

    public double getSubTotal() {
        return this.quantity*this.price;
    }

    public String getSubTotalDisplay() {
        return String.format("$%.2f", getSubTotal());
    }
}