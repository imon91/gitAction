package services.responseModels.commerceModels;

public class UserProfileModel {


    /**
     * status : true
     * error :
     * success :
     * email : iamasthme@gmail.com
     * name : Ataur
     * phone : 8801877755590
     * gender : 11
     * localisation_enabled : true
     */

    private String status;
    private String error;
    private String success;
    private String email;
    private String name;
    private String phone;
    private String gender;
    private boolean localisation_enabled;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isLocalisation_enabled() {
        return localisation_enabled;
    }

    public void setLocalisation_enabled(boolean localisation_enabled) {
        this.localisation_enabled = localisation_enabled;
    }
}
