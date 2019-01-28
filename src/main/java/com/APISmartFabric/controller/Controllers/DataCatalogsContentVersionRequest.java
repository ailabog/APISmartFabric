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
public class DataCatalogsContentVersionRequest {

    private String filters;
    private String options;
    private String all_languages;
    private String ascending;
    private String sort_by;
    private String type;
}
