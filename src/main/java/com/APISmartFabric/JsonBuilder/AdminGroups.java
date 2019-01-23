package com.APISmartFabric.JsonBuilder;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AdminGroups {
    private String code;
    private String id;
    private String name;
    private String tenantId;
    private String type;



}
