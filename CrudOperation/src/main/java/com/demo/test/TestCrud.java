package com.demo.test;

import com.demo.beans.Cart;
import com.demo.beans.Product;
import com.demo.dao.HibernateUtil;
import com.demo.service.CartServiceImpl;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

import java.util.List;
import java.util.Scanner;

public class TestCrud {
    private static ProductService productService = new ProductServiceImpl();
    private static com.demo.service.CartService cartService = new CartServiceImpl();

    public static void main(String[] args) {
        System.out.println("=== Cart-Product CRUD Demo (sf style) ===");
        seedProducts();

        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            printMenu();
            String c = sc.nextLine().trim();
            try {
                switch (c) {
                    case "1": addProduct(sc); break;
                    case "2": listProducts(); break;
                    case "3": addCart(sc); break;
                    case "4": addProductToCart(sc); break;
                    case "5": removeProductFromCart(sc); break;
                    case "6": listCarts(); break;
                    case "7": deleteProduct(sc); break;
                    case "8": deleteCart(sc); break;
                    case "0": running = false; break;
                    default: System.out.println("Invalid choice");
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        sc.close();
        HibernateUtil.getSf().close();
    }

    private static void printMenu() {
        System.out.println("\nMenu:\n1) Add Product\n2) List Products\n3) Add Cart\n4) Add Product to Cart\n5) Remove Product from Cart\n6) List Carts\n7) Delete Product\n8) Delete Cart\n0) Exit\nChoose: ");
    }

    private static void seedProducts() {
        List<Product> p = productService.getAllProducts();
        if (p == null || p.isEmpty()) {
            productService.createProduct(new Product("Pen", "Ballpoint", 10.0));
            productService.createProduct(new Product("Notebook", "A4", 50.0));
            productService.createProduct(new Product("Eraser", "Rubber", 5.0));
            System.out.println("Seeded sample products");
        }
    }

    private static void addProduct(Scanner sc) {
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Desc: "); String d = sc.nextLine();
        System.out.print("Price: "); double price = Double.parseDouble(sc.nextLine());
        Product prod = new Product(name, d, price);
        productService.createProduct(prod);
        System.out.println("Saved: " + prod);
    }

    private static void listProducts() {
        List<Product> all = productService.getAllProducts();
        if (all == null || all.isEmpty()) System.out.println("No products");
        else all.forEach(System.out::println);
    }

    private static void addCart(Scanner sc) {
        System.out.print("Owner name: "); String owner = sc.nextLine();
        Cart c = new Cart(owner);
        cartService.createCart(c);
        System.out.println("Saved cart: " + c);
    }

    private static void addProductToCart(Scanner sc) {
        System.out.print("Cart id: "); Long cid = Long.parseLong(sc.nextLine());
        System.out.print("Product id: "); Long pid = Long.parseLong(sc.nextLine());
        Cart c = cartService.addProductToCart(cid, pid);
        if (c != null) System.out.println("Product added. Cart now: " + c);
        else System.out.println("Add failed (cart or product not found)");
    }

    private static void removeProductFromCart(Scanner sc) {
        System.out.print("Cart id: "); Long cid = Long.parseLong(sc.nextLine());
        System.out.print("Product id: "); Long pid = Long.parseLong(sc.nextLine());
        Cart c = cartService.removeProductFromCart(cid, pid);
        if (c != null) System.out.println("Product removed. Cart now: " + c);
        else System.out.println("Remove failed");
    }

    private static void listCarts() {
        List<Cart> all = cartService.getAllCarts();
        if (all == null || all.isEmpty()) System.out.println("No carts");
        else {
            for (Cart c : all) {
                System.out.println(c);
                if (c.getProducts() != null && !c.getProducts().isEmpty()) {
                    for (Product p : c.getProducts()) {
                        System.out.println("   " + p);
                    }
                }
            }
        }
    }

    private static void deleteProduct(Scanner sc) {
        System.out.print("Product id: "); Long id = Long.parseLong(sc.nextLine());
        productService.deleteProduct(id);
        System.out.println("Deleted product id=" + id);
    }

    private static void deleteCart(Scanner sc) {
        System.out.print("Cart id: "); Long id = Long.parseLong(sc.nextLine());
        cartService.deleteCart(id);
        System.out.println("Deleted cart id=" + id);
    }
}
