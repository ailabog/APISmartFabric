package com.agys.jsonBuilder;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TenantsGroups {
    final String code;
    final String id;
    final String name;
    final String tenantId;
    final String type;

}
