package jakarta_jpa.controlador;

import java.io.Serializable;
import java.util.List;

import jakarta_jpa.beans.Morador;
import jakarta_jpa.beans.Casa;
import jakarta_jpa.dao.MoradorDao;
import jakarta_jpa.dao.CasaDao;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta_jpa.uteis.Util;

@SessionScoped
@Named
public class MoradorControlador implements Serializable {

	private static final long serialVersionUID = 1L;

	private Morador novoMorador;
	private List<Morador> moradores;
	private List<Casa> casas;
	private Integer idSelecionadaCasa;
	
	@Inject
	private MoradorDao dao;
	
	@Inject
	private CasaDao daoCasa;
	
	public void excluir(Morador m) {
		dao.remover(m);
		moradores = dao.pesquisar();
	}

	public String prepararTelaConsulta() {
		moradores = dao.pesquisar();
		return "consultarmorador.xhtml";
	}

	public String voltar() {
		return "menuprincipal.xhtml";
	}

	public boolean isMostrarPainel() {
		return moradores != null && moradores.size() > 0;
	}

	public String prepararTelaCadastro() {
		novoMorador = new Morador();
		casas = daoCasa.pesquisar();
		return "cadastrarmorador.xhtml";
	}

	public String gravar() {
		if (!validarDados()) {
			return null;
		}
		// In the professor's EstadoControlador, getting the object from the combo
		// For ArrayList based dao we might need to find the Casa object first. 
		// Actually, since CasaDao uses ArrayList and not JPA, we don't have getCasa(id). 
		// Let's iterate or find it. Wait, the array list version didn't have getId based lookup in CidadeDao.
		// Let's implement getCasa in CasaDao so this works.
		Casa c = getCasaSelecionada();
		novoMorador.setCasa(c);
		dao.cadastrar(novoMorador);
		new Util().adicionarMensagem("Morador cadastrado com sucesso");
		return "menuprincipal.xhtml";
	}

	private Casa getCasaSelecionada() {
		for (Casa c : casas) {
			if (c.getId() != null && c.getId().equals(idSelecionadaCasa)) {
				return c;
			}
		}
		return null;
	}

	private boolean validarDados() {
		return true; // Simple validation
	}

	public Morador getNovoMorador() {
		return novoMorador;
	}

	public void setNovoMorador(Morador novoMorador) {
		this.novoMorador = novoMorador;
	}

	public List<Morador> getMoradores() {
		return moradores;
	}

	public void setMoradores(List<Morador> moradores) {
		this.moradores = moradores;
	}

	public List<Casa> getCasas() {
		return casas;
	}

	public void setCasas(List<Casa> casas) {
		this.casas = casas;
	}

	public Integer getIdSelecionadaCasa() {
		return idSelecionadaCasa;
	}

	public void setIdSelecionadaCasa(Integer idSelecionadaCasa) {
		this.idSelecionadaCasa = idSelecionadaCasa;
	}

}
