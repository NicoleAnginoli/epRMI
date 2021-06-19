package interfaces;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import impl.PartImpl;

public interface Part {

//	Código da peça
	public String getPartCode();

	public void setPartCode(String partCod);

	
//	Nome da peça
	public String getPartName();

	public void setPartName(String partNome) ;

	
//	Descrição da peça
	public String getPartDescription() ;

	public void setPartDescription(String partDesc);
	
	
//	Lista de componentes
	public List<Part> getComponentsList(String partCode);
		
//	Retorna um componente específico pelo código
	public PartImpl getComponent(String partCode);

//	Retorna a quantidade de componentes
	public int getComponentsQuantity(String partCode);
	
//	Adiciona um componente
	public void addComponent(Part part);	

}
