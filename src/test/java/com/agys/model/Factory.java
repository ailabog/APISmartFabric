package com.agys.model;

import com.agys.jsonBuilder.AdminTenants;

import java.util.UUID;

public class Factory {
    public static final AdminTenants adminTenantsJson = AdminTenants.builder()
            .defaultUserEmail(UUID.randomUUID().toString() + "@agys.ch")
            .defaultUserPassword("testPasswd")
            .domain(("d." + UUID.randomUUID().toString()).replaceAll("[^a-zA-Z0-9]", ""))
            .name(UUID.randomUUID().toString())
            .status("ACTIVE").build();

}