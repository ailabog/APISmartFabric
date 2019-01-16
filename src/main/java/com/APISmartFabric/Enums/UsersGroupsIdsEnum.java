package com.APISmartFabric.Enums;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

public enum UsersGroupsIdsEnum {
	
	USERSGROUPS_OK1("00000000-0000-0000-0000-000000000001"),
	USERSGROUPS_OK2("78c38837-8af3-438a-8560-0d73d8915ceb"),
	USERSGROUPS_OK3("533ab97d-c5dc-4a17-8990-afd9c15ec210"),
	USERSGROUPS_OK4("97a62e19-bbf2-4edc-932a-31a1d2507659"),
	USERSGROUPS_OK5("87c93d66-8fda-492b-ab8a-e278d7270a33"),
	USERSGROUPS_INVALID("d634b20d-128e-4a57-78cf-7b7c01aeb001"),
	USERSGROUPS_NULL("null");
	
	private String id;
	
	UsersGroupsIdsEnum(String id) {
		this.id = id;
}
	
	public String getId() {
		return id;
	}

}
