package com.APISmartFabric.controller.AdminController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author aila.bogasieru@agys.ch
 */

@Getter 
@Setter 
@AllArgsConstructor
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
 
}
