package impl;

import java.util.List;

import interfaces.Part;

public class PartImpl implements Part{
	
	private String partCode;

	private String partName;
	
	private String partDescription;
	
	private List<Part> componentsList;
	
	public String getPartCode() {
		return partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	@Override
	public List<Part> getComponentsList(String partCode) {
		return componentsList;
	}

	@Override
	public PartImpl getComponent(String partCod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getComponentsQuantity(String partCode) {
		return this.componentsList.size();

	}

	@Override
	public void addComponent(Part part) {
		// TODO Auto-generated method stub
		
	}



}
