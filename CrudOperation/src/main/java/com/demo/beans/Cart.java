package com.demo.beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String owner;

    // simple ManyToMany between cart and product for this demo (no CartItem)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cart_products",
        joinColumns = @JoinColumn(name = "cart_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products = new ArrayList<>();

    public Cart() {}

    public Cart(String owner) { this.owner = owner; }

    // helpers
    public void addProduct(Product p) {
        if (!products.contains(p)) products.add(p);
    }

    public void removeProduct(Product p) {
        products.remove(p);
    }

    // getters / setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }

    @Override
    public String toString() {
        return "Cart{" + "id=" + id + ", owner='" + owner + '\'' + ", products=" + products.size() + '}';
    }
}
