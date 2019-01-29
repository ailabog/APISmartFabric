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
public class DataCatalogsContentExportVersionRequest {

    private String catalogs;
    private String processDefinitionId;
    private String vresionId;
}
