package org.supamassirichotiyakul.catermate.cartitem;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="CART_ITEMS")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @ManyToOne
//    @JoinColumn(name = "cart_id")
//    private Cart cart;

    private long menuItemId;

    @NotNull
    @Size(min=2, max=50)
    private String name;

    @NotNull
    private double price;

    @NotNull
    private int quantity;

    public CartItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public Cart getCart() {
//        return cart;
//    }
//
//    public void setCart(Cart cart) {
//        this.cart = cart;
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
        return String.format("$%.2f", getPrice());
    }

    public double getSubTotal() {
        return this.quantity*this.price;
    }

    public String getSubTotalDisplay() {
        return String.format("$%.2f", getSubTotal());
    }

//    public CartItem(Cart cart, MenuItem menuItem) {
//        this.cart = cart;
//        this.menuItemId = menuItem.getId();
//        this.name = menuItem.getName();
//        this.price = menuItem.getPrice();
//
////        System.out.println("quantity = " + cart.getCurrentItemQuantity());
//        this.quantity = cart.getCurrentItemQuantity();
//        cart.setCurrentItemQuantity(1);     // clear it back to 1 for the next item user wants to add
//    }

}
