package bens.moveis;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        String[] opcoes = {
                "Cadastrar Bem",
                "Cadastrar Necessitado",
                "Listar Bens",
                "Marcar Bem como Doado",
                "Reservar Bem para Necessitado",
                "Sair"
        };

        while (true) {
            int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Sistema de Doações",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            if (escolha == 0) {
                String tipo = JOptionPane.showInputDialog("Tipo do bem (ex: cama, roupa, colchão):");
                String descricao = JOptionPane.showInputDialog("Descrição:");
                String local = JOptionPane.showInputDialog("Local de retirada:");
                String data = JOptionPane.showInputDialog("Data de disponibilidade:");
                String horario = JOptionPane.showInputDialog("Horário de disponibilidade:");
                String nome = JOptionPane.showInputDialog("Nome de contato (opcional):");
                String telefone = JOptionPane.showInputDialog("Telefone de contato (opcional):");
                String email = JOptionPane.showInputDialog("E-mail de contato (opcional):");

                Bem bem = new Bem(tipo, descricao, local, data, horario, nome, telefone, email);
                cadastro.adicionarBem(bem);
                JOptionPane.showMessageDialog(null, "Bem cadastrado com sucesso!");

            } else if (escolha == 1) {
                String nome = JOptionPane.showInputDialog("Nome:");
                String telefone = JOptionPane.showInputDialog("Telefone:");
                String endereco = JOptionPane.showInputDialog("Endereço:");
                String necessidade = JOptionPane.showInputDialog("O que está precisando?");
                String motivo = JOptionPane.showInputDialog("Motivo da necessidade:");

                Necessitado n = new Necessitado(nome, telefone, endereco, necessidade, motivo);
                cadastro.adicionarNecessitado(n);
                JOptionPane.showMessageDialog(null, "Necessitado cadastrado com sucesso!");

            } else if (escolha == 2) {
                StringBuilder sb = new StringBuilder("Bens Disponíveis:\n");
                int i = 0;
                for (Bem b : cadastro.listarBensDisponiveis()) {
                    sb.append(i++).append(" - ").append(b.getDescricaoCompleta()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());

            } else if (escolha == 3) {
                int index = Integer.parseInt(JOptionPane.showInputDialog("Digite o índice do bem a marcar como doado:"));
                Integer qtdBens = cadastro.listarBensDisponiveis().size() - 1;

                if (index > qtdBens) {
                    JOptionPane.showMessageDialog(null, "Índice não encontrado!");
                } else {

                    Bem b = cadastro.listarBensDisponiveis().get(index);
                    b.marcarComoDoado();
                    JOptionPane.showMessageDialog(null, "Bem marcado como doado!");
                }

            } else if (escolha == 4) {

                if (cadastro.getNecessitados().size() <= 0) {
                    JOptionPane.showMessageDialog(null, "Não há nenhum necessitado cadastrado, verifique!");
                    continue;
                }

                StringBuilder sb = new StringBuilder("Necessitados:\n");
                int j = 0;
                for (Necessitado n : cadastro.getNecessitados()) {
                    sb.append(j++).append(" - ").append(n.toString()).append("\n");
                }

                int idNec = Integer.parseInt(JOptionPane.showInputDialog(sb.toString() + "\nEscolha o número do necessitado:"));

                Integer qtdNecessitados = cadastro.getNecessitados().size() - 1;

                if (idNec > qtdNecessitados) {
                    JOptionPane.showMessageDialog(null, "Necessitado não encontrado, verifique!");
                    continue;
                }

                Necessitado escolhido = cadastro.getNecessitados().get(idNec);

                StringBuilder sb2 = new StringBuilder("Bens Disponíveis:\n");
                int i = 0;
                for (Bem b : cadastro.listarBensDisponiveis()) {
                    sb2.append(i++).append(" - ").append(b.getDescricaoCompleta()).append("\n");
                }
                int idBem = Integer.parseInt(JOptionPane.showInputDialog(sb2.toString() + "\nEscolha o número do bem a reservar:"));

                Bem b = cadastro.listarBensDisponiveis().get(idBem);
                b.reservarPara(escolhido.getNome());
                JOptionPane.showMessageDialog(null, "Bem reservado para " + escolhido.getNome());

            } else {
                break;
            }
        }
    }
}
