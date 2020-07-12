package services.responseModels.wmsModels;

public class PackagesListModel {

    /**
     * id : 204
     * purchase_order_id : 31
     * grn_id : null
     * warehouse_id : 1
     * variant_id : 25
     * warehouse_bin_id : null
     * pick_list_item_id : null
     * manifest_id : null
     * status : qc_failed
     * vaccount_id : 1
     * created_at : 2018-01-23T17:14:11.000+06:00
     * updated_at : 2020-02-27T11:41:27.000+06:00
     * reference_number : null
     * deleted_at : null
     * previous_id : null
     * sku_code : 17123_DSL007_32_KI
     * notes : Brenco Black Slim Fit Mid Rise Men's Stretch Jeans
     * quantity : 1
     * status_code : QC_FAILED
     */

    private int id;
    private int purchase_order_id;
    private Object grn_id;
    private int warehouse_id;
    private int variant_id;
    private Object warehouse_bin_id;
    private Object pick_list_item_id;
    private Object manifest_id;
    private String status;
    private int vaccount_id;
    private String created_at;
    private String updated_at;
    private Object reference_number;
    private Object deleted_at;
    private Object previous_id;
    private String sku_code;
    private String notes;
    private int quantity;
    private String status_code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPurchase_order_id() {
        return purchase_order_id;
    }

    public void setPurchase_order_id(int purchase_order_id) {
        this.purchase_order_id = purchase_order_id;
    }

    public Object getGrn_id() {
        return grn_id;
    }

    public void setGrn_id(Object grn_id) {
        this.grn_id = grn_id;
    }

    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public int getVariant_id() {
        return variant_id;
    }

    public void setVariant_id(int variant_id) {
        this.variant_id = variant_id;
    }

    public Object getWarehouse_bin_id() {
        return warehouse_bin_id;
    }

    public void setWarehouse_bin_id(Object warehouse_bin_id) {
        this.warehouse_bin_id = warehouse_bin_id;
    }

    public Object getPick_list_item_id() {
        return pick_list_item_id;
    }

    public void setPick_list_item_id(Object pick_list_item_id) {
        this.pick_list_item_id = pick_list_item_id;
    }

    public Object getManifest_id() {
        return manifest_id;
    }

    public void setManifest_id(Object manifest_id) {
        this.manifest_id = manifest_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Object getReference_number() {
        return reference_number;
    }

    public void setReference_number(Object reference_number) {
        this.reference_number = reference_number;
    }

    public Object getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Object deleted_at) {
        this.deleted_at = deleted_at;
    }

    public Object getPrevious_id() {
        return previous_id;
    }

    public void setPrevious_id(Object previous_id) {
        this.previous_id = previous_id;
    }

    public String getSku_code() {
        return sku_code;
    }

    public void setSku_code(String sku_code) {
        this.sku_code = sku_code;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }
}
