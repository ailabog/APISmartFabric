package com.APISmartFabric.controller.AdminController;
/**
 * @author aila.bogasieru@agys.ch
/identity/admin/users
createUser
 */
public class CreateUserRequest {


    private String email;
    private String firstName;
    private String gender;
    private String language;
    private String lastName;
    private String password;
    private String phone;
    private String token;
    private String title;
    private String tokenExpiry;
    private String code;
    private String status;
    
    public CreateUserRequest(String language, String lastName, String password, String phone, String title, String token, String tokenExpiry, String code, String firstName, 
    		String gender, String email, String status){
    	
    	this.language = language;
    	this.lastName = lastName;
    	this.firstName = firstName;
    	this.email = email;
    	this.password = password;
    	this.phone = phone;
    	this.title = title;
    	this.token = token;
     	this.tokenExpiry = tokenExpiry;
     	this.code = code;
     	this.gender = gender;
     	this.lastName = lastName;
     	this.status = status;
    }

    public String getLanguage() {
        return language;
    }
    
    public String getStatus() {
        return status;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTokenExpiry() {
        return tokenExpiry;
    }

    public void setTokenExpiry(String tokenExpiry) {
        this.tokenExpiry = tokenExpiry;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
