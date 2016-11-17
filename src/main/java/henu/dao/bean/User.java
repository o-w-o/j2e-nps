package henu.dao.bean;

public class User {

    private String id;
    private String password;
    private String utype;
    private String email;
    private String name;
    private String uwords;
    private String brithday;
    private String gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getUwords() {
        return uwords;
    }

    public void setUwords(String uwords) {
        this.uwords = uwords;
    }

    public String getBrithday() {
        return brithday;
    }

    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getUtype() {
        return utype;
    }
    
    public void setUtype(String utype) {
        this.utype = utype;
    }
}
