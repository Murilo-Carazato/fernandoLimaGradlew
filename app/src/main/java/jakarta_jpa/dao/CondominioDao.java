package jakarta_jpa.dao;

import java.io.Serializable;
import java.util.List;

import jakarta_jpa.beans.Condominio;
import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Dependent
public class CondominioDao implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Condominio> pesquisar() {
		return em.createNativeQuery("select * from Condominio", Condominio.class).getResultList();
	}
	
	public Condominio getCondominio(Integer id) {
		return em.find(Condominio.class, id);
	}

	public void cadastrar(Condominio c) {
		em.persist(c);
	}

	public void remover(Condominio c) {
		em.remove(c);
	}
}
