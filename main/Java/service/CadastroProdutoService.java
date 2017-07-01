package service;

import java.io.Serializable;

import javax.inject.Inject;

import model.Produto;
import repository.Produtos;
import utils.jpa.Transactional;

public class CadastroProdutoService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Produtos produtos;
	
	@Transactional
	public Produto salvar(Produto produto){
		Produto pe = produtos.porSku(produto.getSku());
		
		if(pe!=null && !pe.equals(produto)){
			throw new NegocioException("Já existe um produto com SKU informado.");
		}
		return produtos.guardar(produto);
	}
}
