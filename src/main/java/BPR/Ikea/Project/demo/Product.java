package BPR.Ikea.Project.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "productID", nullable = false)
    private int productID;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productType")
    private String productType;

    @Column(name = "productPrice")
    private double productPrice;

    @Column(name = "productWidth")
    private double productWidth;

    @Column(name = "productHeight")
    private double productHeight;

    @Column(name = "productWeight")
    private double productWeight;

    @Column(name = "productImage")
    private String productImage;

    @Column(name = "productPartAmount")
    private int productPartAmount;

    @Column(name = "productColor")
    private String productColor;

    @Column(name = "productPlanImage")
    private String productPlanImage;

    @Column(name = "productQRCode")
    private int productQRCode;

    @Column(name = "assembly")
    private Assembly assembly;

    public Product() {
    }

    public Product(int productID, String productName, String productType, double productPrice, double productWidth, double productHeight,
                   double productWeight,String productImage, int productPartAmount,String productColor,String productPlanImage, int productQRCode, Assembly assembly) {
        this.productID = productID;
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
        this.productWidth = productWidth;
        this.productHeight = productHeight;
        this.productWeight = productWeight;
        this.productImage = productImage;
        this.productPartAmount = productPartAmount;
        this.productColor = productColor;
        this.productPlanImage = productPlanImage;
        this.productQRCode = productQRCode;
        this.assembly = assembly;

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

    public int getProductQRCode() {
        return productQRCode;
    }

    public void setProductQRCode(int productQRCode) {
        this.productQRCode = productQRCode;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getProductPartAmount() {
        return productPartAmount;
    }

    public void setProductPartAmount(int productPartAmount) {
        this.productPartAmount = productPartAmount;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductPlanImage() {
        return productPlanImage;
    }

    public void setProductPlanImage(String productPlanImage) {
        this.productPlanImage = productPlanImage;
    }

    public Assembly getAssembly() {
        return assembly;
    }

    public void setAssembly(Assembly assembly) {
        this.assembly = assembly;
    }
}
