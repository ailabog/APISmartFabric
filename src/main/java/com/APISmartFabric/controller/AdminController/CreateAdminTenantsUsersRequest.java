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
public class CreateAdminTenantsUsersRequest {


    private String id;
    private String status;
    private String tenantId;
    private String userId;
   
}	
