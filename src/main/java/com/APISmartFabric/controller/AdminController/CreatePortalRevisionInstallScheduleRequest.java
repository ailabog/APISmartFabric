package com.APISmartFabric.controller.AdminController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author aila.bogasieru@agys.ch
 */

@Getter 
@Setter 
@AllArgsConstructor

public class CreatePortalRevisionInstallScheduleRequest {
   
	private String active;
    private String guiControlId;
    private String installedGUIControlRevisionId;
    private String instanceId;
    private String toBeInstalledGUIControlRevisionId;
 
 
}	
