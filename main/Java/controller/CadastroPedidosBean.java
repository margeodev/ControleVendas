package controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CadastroPedidosBean {
	
	private List<Integer> itens;
	
	public CadastroPedidosBean(){
		itens = new ArrayList<>();
		for(int i = 0; i<2; i++){
			itens.add(i);
		}
	}
	
	public List<Integer> getItens(){
		return itens;
	}
}
