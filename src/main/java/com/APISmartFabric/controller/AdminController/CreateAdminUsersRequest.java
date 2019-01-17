package com.APISmartFabric.controller.AdminController;

/**
 * @author aila.bogasieru@agys.ch
 */
public class CreateAdminUsersRequest {


	private String code;
    private String department;
    private String email;
    private String firstName;
    private String gender;
    private String id;
    private String language;
    private String lastName;
    private String password;
    private String passwordLastUpdate;
    private String phone;
    private String position;
    private String reportsTo;
    private String status;
    private String title;
    private String token;
    private String tokenExpiry;
	private String username;
 
    
    public CreateAdminUsersRequest(String code, String department, String email, String firstName, String gender, String id, String language, String lastName, String password, 
    		String passwordLastUpdate, String phone, String position, String reportsTo, String status, String title, String token, String tokenExpiry, String username){
    	
    	this.code = code;
    	this.department = department;
    	this.email = email;
    	this.firstName = firstName;
    	this.gender = gender;
    	this.id = id;
    	this.language = language;
    	this.lastName = lastName;
     	this.password = password;
     	this.passwordLastUpdate = code;
     	this.gender = passwordLastUpdate;
     	this.phone = phone;
     	this.position = position;
     	this.reportsTo = reportsTo;
     	this.status = status;
       	this.position = position;
       	this.title = title;
       	this.token = token;
       	this.tokenExpiry = tokenExpiry;
       	this.username = username;
    }
    
    
    
    public String getCode() {
  		return code;
  	}


  	public void setCode(String code) {
  		this.code = code;
  	}


  	public String getDepartment() {
  		return department;
  	}


  	public void setDepartment(String department) {
  		this.department = department;
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

  	public String getId() {
  		return id;
  	}

  	public void setId(String id) {
  		this.id = id;
  	}

  	public String getLanguage() {
  		return language;
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

  	public String getPasswordLastUpdate() {
  		return passwordLastUpdate;
  	}

  	public void setPasswordLastUpdate(String passwordLastUpdate) {
  		this.passwordLastUpdate = passwordLastUpdate;
  	}

  	public String getPhone() {
  		return phone;
  	}

  	public void setPhone(String phone) {
  		this.phone = phone;
  	}

  	public String getPosition() {
  		return position;
  	}

  	public void setPosition(String position) {
  		this.position = position;
  	}

  	public String getReportsTo() {
  		return reportsTo;
  	}

  	public void setReportsTo(String reportsTo) {
  		this.reportsTo = reportsTo;
  	}

  	public String getStatus() {
  		return status;
  	}

  	public void setStatus(String status) {
  		this.status = status;
  	}

  	public String getTitle() {
  		return title;
  	}

  	public void setTitle(String title) {
  		this.title = title;
  	}

  	public String getToken() {
  		return token;
  	}

  	public void setToken(String token) {
  		this.token = token;
  	}
 
    public void setTokenExpiry(String tokenExpiry) {
		this.tokenExpiry = tokenExpiry;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	   public String getTokenExpiry() {
			return tokenExpiry;
		}
   
}
