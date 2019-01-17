package com.APISmartFabric.Enums;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

public enum TenantDomainEnum {
	
	TENANT_DOMAIN_OK1("4525f6a0-f5a3-4120-9c20-933260bf37a1"),
	TENANT_DOMAIN_OK2("c7dca69a-cfc2-45fc-a055-c3d1544ce22a"),
	TENANT_DOMAIN_OK3("37d8bd57-0cb1-431e-be69-edc1d23c9a98"),
	TENANT_DOMAIN_OK4("a0b041bf-a6ad-468a-8b4a-79dff7456624"),
	TENANT_DOMAIN_OK5("40baa609-c2e2-40b7-bc51-4fa68c9de7cc"),
	TENANT_DOMAIN_INVALID("15JK1267a-6bcb-4afb-a948-5a6201c1a0"),
	TENANT_DOMAIN_NULL("null");
	
	private String id;
	
	TenantDomainEnum(String id) {
		this.id = id;
}
	
	public String getId() {
		return id;
	}
}
