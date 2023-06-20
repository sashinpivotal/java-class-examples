package org.supamassirichotiyakul.catermate.cart;

import org.supamassirichotiyakul.catermate.cartitem.CartItem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CART")
public class Cart {
    @Transient
    private static final double SALES_TAX = 0.08;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<CartItem> cartItemList;

    @Transient
    private int currentItemQuantity;

    @Transient
    private double subTotal;

    @Transient
    private double tax;

    @Transient
    private double total;

    public Cart() {
        currentItemQuantity = 1;
        cartItemList = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCurrentItemQuantity() {
        return currentItemQuantity;
    }

    public void setCurrentItemQuantity(int currentItemQuantity) {
        this.currentItemQuantity = currentItemQuantity;
    }

    public double getSubTotal() {
        subTotal = 0.0d;
        cartItemList.forEach(i -> subTotal += i.getSubTotal());

        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTax() {
        return getSubTotal() * SALES_TAX;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return getSubTotal() + getTax();
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", cartItemList=" + cartItemList +
                ", currentItemQuantity=" + currentItemQuantity +
                ", subTotal=" + subTotal +
                ", tax=" + tax +
                ", total=" + total +
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

    public void addCartItemToCart(CartItem cartItem) {
        cartItem.setQuantity(this.getCurrentItemQuantity());
        this.getCartItemList().add(cartItem);
        this.setCurrentItemQuantity(1);
    }
}
