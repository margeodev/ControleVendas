package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import model.Categoria;
import model.Produto;
import repository.Categorias;
import service.CadastroProdutoService;
import utils.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Categorias categorias;
	
	@Inject
	private CadastroProdutoService cadastroProdutoService;
	
	private Categoria categoriaPai;	
	private Produto produto;	
	private List<Categoria> categoriasRaizes;
	private List<Categoria> subcategorias;
	
	
	public void inicializar(){	
		System.out.println("Inicializando...");
		if(FacesUtil.isNotPostback()){			
			categoriasRaizes = categorias.raizes();			
		
			if(this.categoriaPai != null){
				carregarSubcategorias();
			}
		}
		
	}
	
	public void carregarSubcategorias(){
		subcategorias = categorias.subcategoriasDe(categoriaPai);
	}
	
	public CadastroProdutoBean() {
		limpar();
	}
	
	public void salvar() {
		produto = cadastroProdutoService.salvar(produto);
		limpar();
		FacesUtil.addInfoMessage("Produto salvo com sucesso.");		
	}
	
	private void limpar(){
		produto = new Produto();
		categoriaPai = null;
		subcategorias = new ArrayList<>();
	}

	public boolean isEditando(){
		return this.produto.getId() != null;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
		if(this.produto!=null){
			this.categoriaPai = this.produto.getCategoria().getCategoriaPai();
		}
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
