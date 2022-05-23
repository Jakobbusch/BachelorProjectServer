package BPR.Ikea.Project.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "iD", nullable = false)
    private int iD;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private double price;

    @Column(name = "width")
    private double width;

    @Column(name = "height")
    private double height;

    @Column(name = "weight")
    private double weight;

    @Column(name = "text")
    private String text;

    @Column(name = "image")
    private String image;

    @Column(name = "image2")
    private String image2;

    @Column(name = "partAmount")
    private int partAmount;

    @Column(name = "color")
    private String color;

    @Column(name = "planImage")
    private String planImage;

    @Column(name = "qrCode")
    private int qrCode;

    @Column(name = "assembly")
    private Assembly assembly;

    public Product() {
    }

    public Product(int iD, String name, String type, double price, double width, double height,
                   double weight,String text, String image,String image2, int partAmount, String color, String planImage, int qrCode, Assembly assembly) {
        this.iD = iD;
        this.name = name;
        this.type = type;
        this.price = price;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.text = text;
        this.image = image;
        this.image2 = image2;
        this.partAmount = partAmount;
        this.color = color;
        this.planImage = planImage;
        this.qrCode = qrCode;
        this.assembly = assembly;

    }

    public int getID() {
        return iD;
    }

    public void setID(int iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQrCode() {
        return qrCode;
    }

    public void setQrCode(int qrCode) {
        this.qrCode = qrCode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPartAmount() {
        return partAmount;
    }

    public void setPartAmount(int partAmount) {
        this.partAmount = partAmount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlanImage() {
        return planImage;
    }

    public void setPlanImage(String planImage) {
        this.planImage = planImage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public Assembly getAssembly() {
        return assembly;
    }

    public void setAssembly(Assembly assembly) {
        this.assembly = assembly;
    }
}
