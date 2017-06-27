package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import model.EnderecoEntrega;
import model.Pedido;

@Named
@ViewScoped
public class CadastroPedidosBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<Integer> itens;
	
	private Pedido pedido;
	
	public CadastroPedidosBean(){
		pedido = new Pedido();
		pedido.setEnderecoEntrega(new EnderecoEntrega());
		itens = new ArrayList<>();
		itens.add(1);
	}
	
	
	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public List<Integer> getItens(){
		return itens;
	}
}
