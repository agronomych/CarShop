package model;

public class ContractModel implements Identified<Long>{

    private Long id;
    private CarModel car;
    private ClientModel client;
    private ManagerModel manager;
    private String date;
    private long sum;

    public CarModel getCar() {
        return car;
    }

    public void setCar(CarModel car) {
        this.car = car;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public ManagerModel getManager() {
        return manager;
    }

    public void setManager(ManagerModel manager) {
        this.manager = manager;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   /* @Override
    public String toString() {
        return this.getId()+"";
    }*/
}
