package com.agys.jsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class DataModelDefinitionVersion {
/**
* @author aila.bogasieru@agys.ch
 */
    private String diagram;
    private String fieldsId;
    private String fieldisBCReady;
    private String fieldisEmbeded;
    private String fieldisIndexable;
    private String fieldisList;
    private String fieldName;
    private String fieldType;
    private String id;
    private String isBCReady;
    private String name;
    private String type="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
}
