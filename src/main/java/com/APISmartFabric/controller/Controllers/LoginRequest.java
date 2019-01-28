package com.APISmartFabric.controller.Controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */
/*/identity/auth/tenant-user-login
        tenantUserLogin*/
@Getter 
@Setter 
@AllArgsConstructor
public class LoginRequest {
	private String tenantDomain;
    private String userEmail;
    private String userPassword;
}
