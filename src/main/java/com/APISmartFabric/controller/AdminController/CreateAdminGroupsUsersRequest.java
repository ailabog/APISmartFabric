package com.APISmartFabric.controller.AdminController;
/**
 * @author aila.bogasieru@agys.ch
/identity/admin/users
createUser
 */
public class CreateAdminGroupsUsersRequest {
	

	private String groupId;
    private String id;
    private String isManager;
    private String userId;
 
    
    public CreateAdminGroupsUsersRequest(String groupId, String id, String isManager, String userId){
    	
    	this.groupId = groupId;
    	this.id = id;
    	this.id = id;
    	this.isManager = isManager;
    	this.userId = userId;
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


	public String getIsManager() {
		return isManager;
	}


	public void setIsManager(String isManager) {
		this.isManager = isManager;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}
}
