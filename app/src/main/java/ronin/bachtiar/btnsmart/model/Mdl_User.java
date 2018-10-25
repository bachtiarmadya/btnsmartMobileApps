package ronin.bachtiar.btnsmart.model;

public class Mdl_User {

    private Integer userId;
    private String name;
    private String phone;
    private String email;
    private String img;
    private String rbac;
    private String password;
    private String token;
    private String createdAt;

    public Mdl_User() {

    }

    public Mdl_User(Integer userId, String name, String phone, String email, String img, String rbac, String password, String token, String createdAt) {
        super();
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.img = img;
        this.rbac = rbac;
        this.password = password;
        this.token = token;
        this.createdAt = createdAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRbac() {
        return rbac;
    }

    public void setRbac(String rbac) {
        this.rbac = rbac;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
