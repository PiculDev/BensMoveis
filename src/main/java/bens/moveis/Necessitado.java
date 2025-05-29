package bens.moveis;

public class Necessitado {
    private String nome;
    private String telefone;
    private String endereco;
    private String necessidade;
    private String motivo;

    public Necessitado(String nome, String telefone, String endereco, String necessidade, String motivo) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.necessidade = necessidade;
        this.motivo = motivo;
    }

    public String getNome() { return nome; }

    @Override
    public String toString() {
        return nome + " precisa de " + necessidade + " - " + motivo + " (" + endereco + ")";
    }
}
