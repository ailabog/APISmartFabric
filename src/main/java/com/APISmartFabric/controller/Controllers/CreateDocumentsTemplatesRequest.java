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
public class CreateDocumentsTemplatesRequest {

 
	private String description;
    private String h;
    private String id;
    private String isActive;
    private String isAdvanced;
    private String iteration;
    private String name;
    private String ownerId;
    private String processDefinitionId;
    private String template;
    private String usedAttributes;
    private String versionId;
    private String w;
 }
