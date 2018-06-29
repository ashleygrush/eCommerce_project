package eCommerce.Model;

public class Platforms {

    private int id;
    private String platform_name;
    private String platform_url;
    private double sales_fee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlatform_name() {
        return platform_name;
    }

    public void setPlatform_name(String platform_name) {
        this.platform_name = platform_name;
    }

    public String getPlatform_url() {
        return platform_url;
    }

    public void setPlatform_url(String platform_url) {
        this.platform_url = platform_url;
    }

    public double getSales_fee() {
        return sales_fee;
    }

    public void setSales_fee(double sales_fee) {
        this.sales_fee = sales_fee;
    }

    @Override
    public String toString() {
        return "Platforms {" +
                "id =" + id +
                ", platform_name ='" + platform_name + '\'' +
                ", platform_url ='" + platform_url + '\'' +
                ", sales_fee =" + sales_fee +
                '}';
    }
}
