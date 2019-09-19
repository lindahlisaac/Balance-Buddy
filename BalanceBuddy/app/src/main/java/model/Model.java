package model;

import java.io.Serializable;

import model.user.UserInfo;

public class Model implements Serializable {

    public UserInfo userInfo;
    String fName = "";
    String lName = "";

    public Model() {
        super();
    }

    public void initUserInfo(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        userInfo = new UserInfo(this.fName, this.lName);
        System.out.println("UserInfo Object Created");
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
}
