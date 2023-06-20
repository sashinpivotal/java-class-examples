package org.supamassirichotiyakul.catermate.menuitem;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name="MENU_ITEMS")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min=2, max=50)
    private String name;

    @NotNull
    private double price;

    public MenuItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return id == menuItem.id && Double.compare(menuItem.price, price) == 0 && name.equals(menuItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    // ------------ custom methods start here ------------
    public String getPriceDisplay() {
        return String.format("$%.2f", price);
    }
}
