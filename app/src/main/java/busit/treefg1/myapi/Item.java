package busit.treefg1.myapi;

public class Item {
    String name;
    String discription;
    int image;

    public Item(String name, String discription, int image) {
        this.name = name;
        this.discription = discription;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
