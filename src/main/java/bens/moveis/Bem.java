package bens.moveis;

public class Bem {
    private String tipo;
    private String descricao;
    private String localRetirada;
    private String dataDisponibilidade;
    private String horarioDisponibilidade;
    private String contatoNome;
    private String contatoTelefone;
    private String contatoEmail;
    private boolean doado;
    private String reservadoPara;

    public Bem(String tipo, String descricao, String localRetirada, String dataDisponibilidade,
               String horarioDisponibilidade, String contatoNome, String contatoTelefone, String contatoEmail) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.localRetirada = localRetirada;
        this.dataDisponibilidade = dataDisponibilidade;
        this.horarioDisponibilidade = horarioDisponibilidade;
        this.contatoNome = contatoNome;
        this.contatoTelefone = contatoTelefone;
        this.contatoEmail = contatoEmail;
        this.doado = false;
        this.reservadoPara = null;
    }

    public boolean isDoado() { return doado; }
    public void marcarComoDoado() { this.doado = true; this.reservadoPara = null; }
    public void reservarPara(String nome) { this.reservadoPara = nome; }
    public void liberarReserva() { this.reservadoPara = null; }
    public String getDescricaoCompleta() {
        return tipo + " - " + descricao + " (" + (doado ? "Doado" : "Disponível") + ")";
    }
}
