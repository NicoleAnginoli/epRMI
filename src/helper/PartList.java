package helper;

import java.util.ArrayList;
import java.util.List;

import interfaces.Part;

public class PartList {

	List<Part> parts = new ArrayList<Part>();

	public List<Part> getParts() {
		return parts;
	}

	public void addPart(Part part) {
		this.parts.add(part);
	}
	
	
		
}
