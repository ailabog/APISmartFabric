package com.APISmartFabric.JsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author aila.bogasieru@agys.ch
 */

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DataCatalogsContentExportJson {

    private String catalogs;
    private String processDefinitionId;
}
