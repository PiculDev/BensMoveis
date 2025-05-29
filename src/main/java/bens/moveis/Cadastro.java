package bens.moveis;

import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    private List<Bem> bens = new ArrayList<>();
    private List<Necessitado> necessitados = new ArrayList<>();

    public void adicionarBem(Bem bem) {
        bens.add(bem);
    }

    public void adicionarNecessitado(Necessitado n) {
        necessitados.add(n);
    }

    public List<Bem> listarBensDisponiveis() {
        List<Bem> disponiveis = new ArrayList<>();
        for (Bem b : bens) {
            if (!b.isDoado()) {
                disponiveis.add(b);
            }
        }
        return disponiveis;
    }

    public List<Necessitado> getNecessitados() {
        return necessitados;
    }
}