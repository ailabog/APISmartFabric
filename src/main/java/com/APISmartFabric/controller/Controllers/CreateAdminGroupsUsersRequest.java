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
public class CreateAdminGroupsUsersRequest {
	

	private String groupId;
    private String id;
    private String isManager;
    private String userId;

}
