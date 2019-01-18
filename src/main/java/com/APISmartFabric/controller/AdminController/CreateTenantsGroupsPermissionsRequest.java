package com.APISmartFabric.controller.AdminController;
/**
 * @author aila.bogasieru@agys.ch
 * 
 */
public class CreateTenantsGroupsPermissionsRequest {

	private String groupId;
    private String id;
    private String permission;
    private String permissionType;
    private String targetId;
  
    public CreateTenantsGroupsPermissionsRequest(String groupId, String id, String permission, String permissionType, String targetId){
    	
    	this.groupId = groupId;
    	this.id = id;
    	this.permission = permission;
    	this.permissionType = permissionType;
    	this.targetId = targetId;
      }
    
    public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
}	
