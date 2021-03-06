package service_automation.Model;

import com.google.gson.annotations.SerializedName;

public class UserCredentials {

    @SerializedName("userName")
    private final String userName;

    @SerializedName("password")
    private final String password;

    public UserCredentials(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
