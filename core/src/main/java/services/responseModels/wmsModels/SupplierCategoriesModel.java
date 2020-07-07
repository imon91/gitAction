package services.responseModels.wmsModels;

public class SupplierCategoriesModel {

    /**
     * id : 1
     * name : Saree
     * vaccount_id : 1
     * created_at : 2017-10-13T13:24:51.000+06:00
     * updated_at : 2017-10-13T13:24:51.000+06:00
     */

    private int id;
    private String name;
    private int vaccount_id;
    private String created_at;
    private String updated_at;

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

    public int getVaccount_id() {
        return vaccount_id;
    }

    public void setVaccount_id(int vaccount_id) {
        this.vaccount_id = vaccount_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
