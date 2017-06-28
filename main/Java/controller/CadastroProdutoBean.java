package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import model.Categoria;
import model.Produto;
import repository.Categorias;
import utils.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Categorias categorias;
	
	private Categoria categoriaPai;	
	private Produto produto;	
	private List<Categoria> categoriasRaizes;
	private List<Categoria> subcategorias;
	
	
	public void inicializar(){	
		System.out.println("Inicializando...");
		if(FacesUtil.isNotPostback()){			
			categoriasRaizes = categorias.raizes();			
		}
		
	}
	
	public void carregarSubcategorias(){
		subcategorias = categorias.subcategoriasDe(categoriaPai);
	}
	
	public CadastroProdutoBean() {
		produto = new Produto();
	}
	
	public void salvar() {
	}

	public Produto getProduto() {
		return produto;
	}

	public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}

	@NotNull
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}
	
	@NotNull
	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}
	
}
