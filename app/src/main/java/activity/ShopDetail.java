package activity;

public class ShopDetail {
    private int Shop_Id;
    private String name;
    private double longtitude;
    private double latitude;
    private int id;
    private int ProductId;
    private int Price;
    private String SpecialOffer;


    public ShopDetail(int shop_Id, String name, double longtitude, double latitude, int id, int productId, int price, String specialOffer) {
        Shop_Id = shop_Id;
        this.name = name;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.id = id;
        ProductId = productId;
        Price = price;
        SpecialOffer = specialOffer;
    }

    public int getShop_Id() {
        return Shop_Id;
    }

    public void setShop_Id(int shop_Id) {
        Shop_Id = shop_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
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

    public String toString(){
        return "shop id: "+getShop_Id()+" name : "+name+" longitude : "+getLongtitude()+" latitude : "+getLatitude()+
                " product id : "+getProductId()+" price : "+getPrice()+" special offer : "+getSpecialOffer();
    }
}
