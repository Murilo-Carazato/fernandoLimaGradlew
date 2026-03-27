package jakarta.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Casa {

    private Integer codigo;
    private String nome;
    private Condominio condominio;
    private List<Morador> moradores = new ArrayList<Morador>();

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Casa other = (Casa) obj;
        return Objects.equals(codigo, other.codigo);
    }
    

    public void associarMorador(Morador morador) {
        moradores.add(morador);
        morador.setCasa(this);
    }

    @Override
    public String toString() {
        String result = "Casa [codigo=" + codigo
                + ", nome=" + nome
                + ", condominio=" + (condominio != null ? condominio.getNome() : "null")
                + ", moradores=[";
        for (Morador morador : moradores) {
            result += "{codigo=" + morador.getCodigo() + ", nome=" + morador.getNome() + "}, ";
        }
        result += "]]";
        return result;
    }

    // @Override
    // public String toString() {
    //     return "Casa { codigo=" + codigo + ", nome='" + nome + "' }";
    // }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public List<Morador> getMoradores() {
        return moradores;
    }

    public void setMoradores(List<Morador> moradores) {
        this.moradores = moradores;
    }

}
