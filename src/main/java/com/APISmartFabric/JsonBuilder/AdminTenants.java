package com.APISmartFabric.JsonBuilder;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AdminTenants {

    private String defaultUserEmail;
    private String defaultUserPassword;
    private String domain;
    private String name;
    private String status;

}
