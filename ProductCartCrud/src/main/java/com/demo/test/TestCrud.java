package com.demo.test;

import com.demo.beans.Cart;
import com.demo.beans.Product;
import com.demo.dao.HibernateUtil;
import com.demo.service.CartService;
import com.demo.service.CartServiceImpl;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

import java.util.List;
import java.util.Scanner;

public class TestCrud {

    private static ProductService productService = new ProductServiceImpl();
    private static CartService cartService = new CartServiceImpl();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Product");
            System.out.println("2. List Products");
            System.out.println("3. Create Cart");
            System.out.println("4. Add Product To Cart");
            System.out.println("5. Remove Product From Cart");
            System.out.println("6. List Carts");
            System.out.println("7. Delete Product");
            System.out.println("8. Delete Cart");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String n = sc.nextLine();
                    System.out.print("Description: ");
                    String d = sc.nextLine();
                    System.out.print("Price: ");
                    double price = Double.parseDouble(sc.nextLine());
                    Product p = productService.addProduct(n, d, price);
                    System.out.println("Saved: " + p);
                    break;

                case 2:
                    List<Product> plist = productService.getAll();
                    plist.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Owner: ");
                    String owner = sc.nextLine();
                    Cart c = cartService.createCart(owner);
                    System.out.println("Cart Created: " + c);
                    break;

                case 4:
                    System.out.print("Cart ID: ");
                    Long cid = Long.parseLong(sc.nextLine());
                    System.out.print("Product ID: ");
                    Long pid = Long.parseLong(sc.nextLine());
                    Cart c1 = cartService.addProductToCart(cid, pid);
                    System.out.println("Updated: " + c1);
                    break;

                case 5:
                    System.out.print("Cart ID: ");
                    Long cid2 = Long.parseLong(sc.nextLine());
                    System.out.print("Product ID: ");
                    Long pid2 = Long.parseLong(sc.nextLine());
                    Cart c2 = cartService.removeProductFromCart(cid2, pid2);
                    System.out.println("Updated: " + c2);
                    break;

                case 6:
                    List<Cart> clist = cartService.getAll();
                    for (Cart cart : clist) {
                        System.out.println(cart);
                        if (cart.getProducts() != null) {
                            for (Product pr : cart.getProducts()) {
                                System.out.println("   " + pr);
                            }
                        }
                    }
                    break;

                case 7:
                    System.out.print("Product ID: ");
                    Long delId = Long.parseLong(sc.nextLine());
                    productService.deleteProduct(delId);
                    System.out.println("Deleted product " + delId);
                    break;

                case 8:
                    System.out.print("Cart ID: ");
                    Long delCid = Long.parseLong(sc.nextLine());
                    cartService.deleteCart(delCid);
                    System.out.println("Deleted cart " + delCid);
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 10);

        sc.close();
        HibernateUtil.getSf().close();
    }
}
