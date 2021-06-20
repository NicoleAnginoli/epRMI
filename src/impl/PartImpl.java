package impl;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import interfaces.Part;
import interfaces.PartRepository;

public class PartImpl implements Serializable, Part {

	private static final long serialVersionUID = -137878037795619547L;

	private String partCode = UUID.randomUUID().toString();

	private String partName;
	
	private String partDescription;
	
	private List<Part> componentsList;
	
	private PartRepository partRepository;
	
	public PartImpl(String name, String desc) {
		this.partName = name;
		this.partDescription = desc;
	}
	
	public PartImpl() {
	}
	
	public PartRepository getPartRepository() {
		return partRepository;
	}

	public void setPartRepository(PartRepository partRepository) {
		this.partRepository = partRepository;
	}

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
