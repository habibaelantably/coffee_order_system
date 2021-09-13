package habiba.h.coffeeordersystem;

import java.io.Serializable;

public class datamodel implements Serializable
{
    String name;
    String total;
    String category;

    public datamodel(String name, String total, String category) {
        this.name = name;
        this.total = total;
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal() {
        return total;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
