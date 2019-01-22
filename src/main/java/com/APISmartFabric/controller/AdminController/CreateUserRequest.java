package com.APISmartFabric.controller.AdminController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author aila.bogasieru@agys.ch
/identity/admin/users
createUser
 */

@Getter 
@Setter 
@AllArgsConstructor
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
 
}
