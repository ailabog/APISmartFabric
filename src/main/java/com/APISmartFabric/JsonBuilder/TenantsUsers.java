package com.APISmartFabric.JsonBuilder;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TenantsUsers {

    private String code;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private String language;
    private String password;
    private String phone;
    private String status;
    private String title;
    private String token;
    private String tokenExpiry;
}
