package com.task2.student2.model;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table (name = "Product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "img")
    private String img;
    @Column(name = "price")
    private double price;

    @ManyToOne
    private Category category;

    public Product() {

    }

    public Product(int id, String name, double price, String description, String img, int categoryId) {
        this.id = id;
        this.name = name;
        this.price=price;
        this.description=description;
        this.img = img;
        this.category = new Category(categoryId, "");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
