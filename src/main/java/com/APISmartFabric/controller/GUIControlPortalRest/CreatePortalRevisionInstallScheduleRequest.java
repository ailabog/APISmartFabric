package com.APISmartFabric.controller.GUIControlPortalRest;
/**
 * @author aila.bogasieru@agys.ch
 */
public class CreatePortalRevisionInstallScheduleRequest {


   
	private String active;
    private String guiControlId;
    private String installedGUIControlRevisionId;
    private String instanceId;
    private String toBeInstalledGUIControlRevisionId;
  
    public CreatePortalRevisionInstallScheduleRequest(String active, String guiControlId, String installedGUIControlRevisionId, String instanceId, String toBeInstalledGUIControlRevisionId){
    	
    	this.active = active;
    	this.guiControlId = guiControlId;
    	this.installedGUIControlRevisionId = installedGUIControlRevisionId;
    	this.instanceId = instanceId;
    	this.toBeInstalledGUIControlRevisionId = toBeInstalledGUIControlRevisionId;
      }
    
    public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getGuiControlId() {
		return guiControlId;
	}

	public void setGuiControlId(String guiControlId) {
		this.guiControlId = guiControlId;
	}

	public String getInstalledGUIControlRevisionId() {
		return installedGUIControlRevisionId;
	}

	public void setInstalledGUIControlRevisionId(String installedGUIControlRevisionId) {
		this.installedGUIControlRevisionId = installedGUIControlRevisionId;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getToBeInstalledGUIControlRevisionId() {
		return toBeInstalledGUIControlRevisionId;
	}

	public void setToBeInstalledGUIControlRevisionId(String toBeInstalledGUIControlRevisionId) {
		this.toBeInstalledGUIControlRevisionId = toBeInstalledGUIControlRevisionId;
	}
 
}	
