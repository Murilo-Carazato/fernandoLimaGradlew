package jakarta.controlador;

import java.io.Serializable;
import java.util.List;

import jakarta.beans.Morador;
import jakarta.beans.Casa;
import jakarta.dao.MoradorDao;
import jakarta.dao.CasaDao;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.uteis.Util;

@SessionScoped
@Named
public class MoradorControlador implements Serializable {

	private static final long serialVersionUID = 1L;

	private Morador novaMorador;
	private List<Morador> moradors;
	private List<Casa> casas;
	private Integer idSelecionadoCasa;

	public void excluir(Morador e) {
		MoradorDao dao = new MoradorDao();
		dao.remover(e);
		moradors = dao.pesquisar();
	}

	public String prepararTelaConsulta() {
		MoradorDao dao = new MoradorDao();
		moradors = dao.pesquisar();
		return "consultarmorador.xhtml";
	}

	public String voltar() {
		return "menuprincipal.xhtml";
	}

	public String prepararTelaCadastro() {
		novaMorador = new Morador();
		casas = new CasaDao().pesquisar();
		return "cadastrarmorador.xhtml";
	}

	public String gravar() {
		if (!validarDados()) {
			return null;
		}
		MoradorDao dao = new MoradorDao();
		// busca a casa selecionada
		Casa f = casas.stream()
				.filter(fam -> fam.getId().equals(idSelecionadoCasa))
				.findFirst().orElse(null);
		novaMorador.setCasa(f);
		dao.cadastrar(novaMorador);
		new Util().adicionarMensagem("Morador cadastrada com sucesso");
		return "menuprincipal.xhtml";
	}

	private boolean validarDados() {
		MoradorDao dao = new MoradorDao();
		if (dao.existe(novaMorador)) {
			new Util().adicionarMensagem("Morador existente!");
			return false;
		}
		return true;
	}

	public Morador getNovaMorador() {
		return novaMorador;
	}

	public void setNovaMorador(Morador novaMorador) {
		this.novaMorador = novaMorador;
	}

	public List<Morador> getMoradors() {
		return moradors;
	}

	public void setMoradors(List<Morador> moradors) {
		this.moradors = moradors;
	}

	public List<Casa> getCasas() {
		return casas;
	}

	public void setCasas(List<Casa> casas) {
		this.casas = casas;
	}

	public Integer getIdSelecionadoCasa() {
		return idSelecionadoCasa;
	}

	public void setIdSelecionadoCasa(Integer idSelecionadoCasa) {
		this.idSelecionadoCasa = idSelecionadoCasa;
	}

}
