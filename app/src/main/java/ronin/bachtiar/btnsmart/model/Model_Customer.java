package ronin.bachtiar.btnsmart.model;

public class Model_Customer {
    private String updatedAt;

    private String custId;

    private String custAddress;

    private String custPhoto;

    private String custPhone;

    private String createdAt;

    private String locLang;

    private String salesId;

    private String custName;

    private String locLat;

    public Model_Customer() {

    }

    public Model_Customer(String updatedAt, String custId, String custAddress, String custPhone, String createdAt, String locLang, String locLat, String salesId, String custName) {
        super();
        this.custId = custId;
        this.custName = custName;
        this.custPhone = custPhone;
        this.custAddress = custAddress;
        this.salesId = salesId;
        this.locLang = locLang;
        this.locLat = locLat;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhoto() {
        return custPhoto;
    }

    public void setCustPhoto(String custPhoto) {
        this.custPhoto = custPhoto;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLocLang() {
        return locLang;
    }

    public void setLocLang(String locLang) {
        this.locLang = locLang;
    }

    public String getSalesId() {
        return salesId;
    }

    public void setSalesId(String salesId) {
        this.salesId = salesId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getLocLat() {
        return locLat;
    }

    public void setLocLat(String locLat) {
        this.locLat = locLat;
    }
}
