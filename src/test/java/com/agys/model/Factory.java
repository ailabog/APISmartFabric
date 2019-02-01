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

//    public static final AdminGroupsUsers adminGroupsUsers = AdminGroupsUsers.builder()
//            .groupId(UUID.randomUUID().toString())
//            //.id(id)will be filled by POST
//            .isManager(Boolean.TRUE)
//            .userId(userId).build();
}
