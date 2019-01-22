package com.APISmartFabric.controller.AdminController;
/**
 * @author aila.bogasieru@agys.ch
 */
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
    
    public CreateDocumentsTemplatesRequest(String description, String h, String id, String isActive, String isAdvanced, String iteration, String name, String ownerId, String processDefinitionId, 
    		String template, String usedAttributes, String versionId, String w){
    	
    	this.description = description;
    	this.h = h;
    	this.id = id;
    	this.isActive = isActive;
    	this.isAdvanced = isAdvanced;
    	this.iteration = iteration;
    	this.name = name;
    	this.ownerId = ownerId;
     	this.processDefinitionId = processDefinitionId;
     	this.template = template;
     	this.usedAttributes = usedAttributes;
     	this.versionId = versionId;
     	this.w = w;
    }
    
    public String getDescription() {
  		return description;
  	}

  	public void setDescription(String description) {
  		this.description = description;
  	}

  	public String getH() {
  		return h;
  	}

  	public void setH(String h) {
  		this.h = h;
  	}

  	public String getId() {
  		return id;
  	}

  	public void setId(String id) {
  		this.id = id;
  	}

  	public String getIsActive() {
  		return isActive;
  	}

  	public void setIsActive(String isActive) {
  		this.isActive = isActive;
  	}

  	public String getIsAdvanced() {
  		return isAdvanced;
  	}

  	public void setIsAdvanced(String isAdvanced) {
  		this.isAdvanced = isAdvanced;
  	}

  	public String getIteration() {
  		return iteration;
  	}

  	public void setIteration(String iteration) {
  		this.iteration = iteration;
  	}

  	public String getName() {
  		return name;
  	}

  	public void setName(String name) {
  		this.name = name;
  	}

  	public String getOwnerId() {
  		return ownerId;
  	}

  	public void setOwnerId(String ownerId) {
  		this.ownerId = ownerId;
  	}

  	public String getProcessDefinitionId() {
  		return processDefinitionId;
  	}

  	public void setProcessDefinitionId(String processDefinitionId) {
  		this.processDefinitionId = processDefinitionId;
  	}

  	public String getTemplate() {
  		return template;
  	}

  	public void setTemplate(String template) {
  		this.template = template;
  	}

  	public String getUsedAttributes() {
  		return usedAttributes;
  	}

  	public void setUsedAttributes(String usedAttributes) {
  		this.usedAttributes = usedAttributes;
  	}

  	public String getVersionId() {
  		return versionId;
  	}

  	public void setVersionId(String versionId) {
  		this.versionId = versionId;
  	}

  	public String getW() {
  		return w;
  	}

  	public void setW(String w) {
  		this.w = w;
  	}
}
