package activity;

public class ShopProduct {
    int id;
    int shopId;
    int productId;
    int Price;
    String SpecialOffer;

    public ShopProduct(int id, int shopId, int productId, int price, String specialOffer) {
        this.id = id;
        this.shopId = shopId;
        this.productId = productId;
        Price = price;
        SpecialOffer = specialOffer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getSpecialOffer() {
        return SpecialOffer;
    }

    public void setSpecialOffer(String specialOffer) {
        SpecialOffer = specialOffer;
    }
}
