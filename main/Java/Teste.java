import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Cliente;
import model.Endereco;
import model.TipoPessoa;

public class Teste {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Maria da Penha");
		cliente.setEmail("maria@gmail.com");
		cliente.setDocumentoReceitaFederal("123.123.123-11");
		cliente.setTipo(TipoPessoa.FISICA);
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua projetada");
		endereco.setCep("58000-000");
		endereco.setNumero("111");
		endereco.setCidade("João Pessoa");
		endereco.setUf("PB");
		endereco.setCliente(cliente);
		
		cliente.getEnderecos().add(endereco);
		
		manager.persist(cliente);
		
		trx.commit();
		
	}
}
