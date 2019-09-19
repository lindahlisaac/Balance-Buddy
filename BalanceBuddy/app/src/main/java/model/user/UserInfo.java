package model.user;

import java.io.Serializable;

public class UserInfo implements Serializable {
    String fName = "";//required
    String lName = "";//optional
    String profession;//optional
    String housingType;//rent or own

    //add all attributes to Map<String, boolean> - true if field is required, false if optional

    public UserInfo(String fName, String lName) {
        super();
        this.fName = fName;
        this.lName = lName;

        toString("<UserInfo --> [FIRST NAME: " + this.fName + ", LAST NAME: " + this.lName + "]");
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setHousingType(String housingType) {
        this.housingType = housingType;
    }

    public void toString(String string) {
        System.out.println(string);
    }
}
