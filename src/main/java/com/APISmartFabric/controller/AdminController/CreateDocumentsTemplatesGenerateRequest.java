package com.APISmartFabric.controller.AdminController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author aila.bogasieru@agys.ch
 * 
 */

@Getter 
@Setter 
@AllArgsConstructor
public class CreateDocumentsTemplatesGenerateRequest {

	private String processInstanceId;
    private String documentTemplateId;
    private String fileName;
    private String savePath;
}	
