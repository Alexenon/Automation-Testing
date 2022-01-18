package service_automation.Model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("userID")
    private String userId;
    @SerializedName("username")
    private String userName;
    @SerializedName("books")
    private Books books;

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
