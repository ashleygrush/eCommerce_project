package eCommerce.Model;

// Products pojo
public class Products {

    // class variables
    private int id;
    private String name;
    private String description;

    // getters + setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // toString
    @Override
    public String toString() {
        return "Products {" +
                "id =" + id +
                ", name= '" + name + '\'' +
                ", description ='" + description + '\'' +
                '}';
    }
}
