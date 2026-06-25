import java.util.*;

public class Client {
    private String nome;
    private Collection<Rent> tapesAlugadas = new Vector<>();

    public Client(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionaRent(Rent rent) {
        tapesAlugadas.add(rent);
    }

    private double calcularValorTotal() {
        double total = 0;
        for (Rent rent : tapesAlugadas) {
            total += rent.getValor();
        }
        return total;
    }

    private int calcularPontosTotal() {
        int pontos = 0;
        for (Rent rent : tapesAlugadas) {
            pontos += rent.getPontosBonus();
        }
        return pontos;
    }

    public String extratoTexto() {
        final String nl = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append("Registro de Alugueis de ").append(getNome()).append(nl);
        for (Rent rent : tapesAlugadas) {
            sb.append("\t").append(rent.getTape().getTitulo())
              .append("\t").append(rent.getValor()).append(nl);
        }
        sb.append("Valor total devido: ").append(calcularValorTotal()).append(nl);
        sb.append("Voce acumulou ").append(calcularPontosTotal())
          .append(" pontos de alugador frequente");
        return sb.toString();
    }

    public String extratoHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>Registro de Alugueis de ").append(getNome()).append("</h1>\n");
        sb.append("<table>\n");
        for (Rent rent : tapesAlugadas) {
            sb.append("  <tr><td>").append(rent.getTape().getTitulo())
              .append("</td><td>").append(rent.getValor()).append("</td></tr>\n");
        }
        sb.append("</table>\n");
        sb.append("<p>Valor total devido: <strong>")
          .append(calcularValorTotal()).append("</strong></p>\n");
        sb.append("<p>Voce acumulou <strong>").append(calcularPontosTotal())
          .append("</strong> pontos de alugador frequente</p>");
        return sb.toString();
    }
}
