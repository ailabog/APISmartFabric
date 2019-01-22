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
public class CreateAdminRequest {

  	private String code;
    private String id;
    private String name;
    private String tenanatId;
    private String type;
   
}
