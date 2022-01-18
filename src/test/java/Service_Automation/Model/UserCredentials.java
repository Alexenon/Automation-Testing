package Service_Automation.Model;

import com.google.gson.annotations.SerializedName;

public class UserCredentials {

    @SerializedName("userName")
    private String userName;

    @SerializedName("password")
    private String password;

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
