package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "materials")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_code;
    private String name;
    private String importDate;
    private String decription;
    private Float price;
    private String quantity;
    private String image;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public Material() {
    }

    public Material(String name, String importDate, String decription, Float price, String quantity, String image) {
        this.name = name;
        this.importDate = importDate;
        this.decription = decription;
        this.price = price;
        this.quantity = quantity;
        this.image = image;

    }

    public Long getId_code() {
        return id_code;
    }

    public void setId_code(Long id_code) {
        this.id_code = id_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
