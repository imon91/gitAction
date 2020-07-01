package services.wmsModels;

public class SellersListModel {

    /**
     * id : 3
     * name : Shishang
     * supplier_id : null
     */

    private int id;
    private String name;
    private Object supplier_id;

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

    public Object getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Object supplier_id) {
        this.supplier_id = supplier_id;
    }
}
