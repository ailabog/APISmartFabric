package com.APISmartFabric.controller.Controllers;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author aila.bogasieru@agys.ch
 */

@Getter
@Setter
@AllArgsConstructor
public class DataCatalogsDerfinitionVersionRequest {
    private String description;
    private String idFields;
    private String nameFields;
    private String type;
    private String idDescription;
    private String nameDescription;
    private String removed;
}
