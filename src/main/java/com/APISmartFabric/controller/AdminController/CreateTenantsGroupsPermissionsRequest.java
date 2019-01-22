package com.APISmartFabric.controller.AdminController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author aila.bogasieru@agys.ch
 * 
 */
@Getter 
@Setter 
@AllArgsConstructor

public class CreateTenantsGroupsPermissionsRequest {

	private String groupId;
    private String id;
    private String permission;
    private String permissionType;
    private String targetId;
}	
