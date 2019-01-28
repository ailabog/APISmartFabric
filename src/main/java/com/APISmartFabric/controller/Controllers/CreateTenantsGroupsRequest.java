package com.APISmartFabric.controller.Controllers;

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
public class CreateTenantsGroupsRequest {

    private String code;
    private String id;
    private String name;
    private String tenantId;
    private String type;
  
   
}	
