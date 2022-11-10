package Model;

public class ProductModel {

    private String productName;
    private String price;
    private String discountRate;
    private String bodySize;
    private String oldPrice;

    public ProductModel(String productName, String price, String discountRate, String bodySize) {
        this.productName = productName;
        this.price = price;
        this.discountRate = discountRate;
        this.bodySize = bodySize;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate;
    }

    public String getBodySize() {
        return bodySize;
    }

    public void setBodySize(String bodySize) {
        this.bodySize = bodySize;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

}
