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

    /**
     * empty constructor
     */
    public Product() {
    }

    /**
     * Main constructor Product
     * @param iD
     * @param name
     * @param type
     * @param price
     * @param width
     * @param height
     * @param weight
     * @param text
     * @param image
     * @param image2
     * @param partAmount
     * @param color
     * @param planImage
     * @param qrCode
     * @param assembly
     */
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

    /**
     *  To get id
     * @return id
     */
    public int getID() {
        return iD;
    }

    /**
     * To set id
     * @param iD
     */
    public void setID(int iD) {
        this.iD = iD;
    }

    /**
     * To get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * To set name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * To get type
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * To set type
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * To get price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * To set price
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * To get width
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * To set width
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * To get height
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * To set height
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * To get weight
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * To set weight
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * To get QR code
     * @return qrCode
     */
    public int getQrCode() {
        return qrCode;
    }

    /**
     * To set QR code
     * @param qrCode
     */
    public void setQrCode(int qrCode) {
        this.qrCode = qrCode;
    }

    /**
     * To get image
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * To set image
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * To get number of parts
     * @return partAmount
     */
    public int getPartAmount() {
        return partAmount;
    }
    /**
     * To set number of parts
     * @param partAmount
     */
    public void setPartAmount(int partAmount) {
        this.partAmount = partAmount;
    }

    /**
     * To get color
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * To set color
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * To get planImage
     * @return planImage
     */
    public String getPlanImage() {
        return planImage;
    }

    /**
     * To set planImage
     * @param planImage
     */
    public void setPlanImage(String planImage) {
        this.planImage = planImage;
    }

    /**
     * To get text
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * To set text
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * To get image2
     * @return image2
     */
    public String getImage2() {
        return image2;
    }

    /**
     * To set image2
     * @param image2
     */
    public void setImage2(String image2) {
        this.image2 = image2;
    }

    /**
     * To get assembly class
     * @return assembly
     */
    public Assembly getAssembly() {
        return assembly;
    }

    /**
     * To set assembly class
     * @param assembly
     */
    public void setAssembly(Assembly assembly) {
        this.assembly = assembly;
    }
}
