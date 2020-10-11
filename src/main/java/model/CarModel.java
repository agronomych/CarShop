package model;

public class CarModel implements Identified<String>{

    private String Model;
    private String id;

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{\"Model\":\""+this.getModel()+"\"}";
    }
}
