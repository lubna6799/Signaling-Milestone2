package activity;

public class Product {
    private String name,description,image;
    private int Productid;
    public Product (String name,int Productid,String description, String image){

        this.name = name;
        this.image = image;
        this.description= description;
        this.Productid = Productid;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public String getImage() {
        return image;
   }

  public void setImage(String image) {
       this.image = image;
   }

   public String getDescription() {
        return description;
   }

  public void setPrice(String description) {
      this.description=description;
   }

    public int getProductid() {
        return Productid;
    }

    public void setProductid(int Productid) {
        this.Productid=Productid;
    }

    public String toString(){
        System.out.println("NAME, "+this.name);
        return null;
    }
}
