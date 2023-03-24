package one.digitalinnovation.collection.map.exemploOrdenacaoMap.exercicio3;

public class Contato{
    private String contato;
    private Integer telefone;

    public Contato(String contato, Integer telefone) {
        this.contato = contato;
        this.telefone = telefone;
    }

    public String getContato() {
        return contato;
    }

    public Integer getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "{" +
                "contato='" + contato + '\'' +
                ", telefone=" + telefone +
                '}';
    }
}
