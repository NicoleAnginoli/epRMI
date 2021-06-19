package interfaces;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import impl.PartImpl;

public interface Part {

//	C�digo da pe�a
	public String getPartCode();

	public void setPartCode(String partCod);

	
//	Nome da pe�a
	public String getPartName();

	public void setPartName(String partNome) ;

	
//	Descri��o da pe�a
	public String getPartDescription() ;

	public void setPartDescription(String partDesc);
	
	
//	Lista de componentes
	public List<Part> getComponentsList(String partCode);
		
//	Retorna um componente espec�fico pelo c�digo
	public PartImpl getComponent(String partCode);

//	Retorna a quantidade de componentes
	public int getComponentsQuantity(String partCode);
	
//	Adiciona um componente
	public void addComponent(Part part);	

}
