package com.APISmartFabric.JsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Login {
	private String tenantId;
	private String userEmail;
	private String userPassword;
}
