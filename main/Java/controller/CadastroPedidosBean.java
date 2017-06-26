package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
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
