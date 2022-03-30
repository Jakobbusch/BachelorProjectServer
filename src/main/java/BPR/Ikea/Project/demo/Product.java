package BPR.Ikea.Project.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "productID", nullable = false)
    public int productID;

    @Column(name = "productName")
    public String productName;

    @Column(name = "productType")
    public String productType;

    @Column(name = "productPrice")
    public double productPrice;

    @Column(name = "productWidth")
    public double productWidth;

    @Column(name = "productHeight")
    public double productHeight;

    @Column(name = "productWeight")
    public double productWeight;

    public Product() {
    }

    public Product(int productID, String productName, String productType, double productPrice, double productWidth, double productHeight, double productWeight) {
        this.productID = productID;
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
        this.productWidth = productWidth;
        this.productHeight = productHeight;
        this.productWeight = productWeight;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(double productWidth) {
        this.productWidth = productWidth;
    }

    public double getProductHeight() {
        return productHeight;
    }

    public void setProductHeight(double productHeight) {
        this.productHeight = productHeight;
    }

    public double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(double productWeight) {
        this.productWeight = productWeight;
    }
}
