import javax.swing.*;
import java.awt.*;

public class TotalPoupado {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Total Poupado");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2));

        JLabel labelJuros = new JLabel("Juros ao mês (%)"); //cria o textinho
        JTextField campoJuros = new JTextField(); // cria o espaço pra digitar

        JLabel labelAnos = new JLabel("Anos");
        JTextField campoAnos = new JTextField();

        JLabel labelMensal = new JLabel("Depósito mensal (R$)");
        JTextField campoMensal = new JTextField();

        JButton botaoCalcular = new JButton("Calcular");
        JLabel resultado = new JLabel("   Total poupado: ");

        JButton botaoResetar = new JButton("Reset");

        botaoCalcular.addActionListener(e -> { // ação do botão
            String jurosTexto = campoJuros.getText().trim(); //usa o trim para tirar espaços
            String anosTexto = campoAnos.getText().trim();
            String mensalTexto = campoMensal.getText().trim();

            try {
                double juros = Double.parseDouble(jurosTexto) / 100;
                int anos = Integer.parseInt(anosTexto);
                double mensal = Double.parseDouble(mensalTexto);

                int meses = anos * 12;
                double total = 0;

                for (int i = 0; i < meses; i++) {
                    total = (total + mensal) * (1 + juros);
                }

                resultado.setText(String.format("   Total poupado: R$ %.2f", total));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Preencha todos os campos com valores válidos", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        botaoResetar.addActionListener(e -> {
            campoJuros.setText("");
            campoAnos.setText("");
            campoMensal.setText("");
            resultado.setText("   Total poupado: ");
        });

        frame.add(labelJuros);
        frame.add(campoJuros);

        frame.add(labelAnos);
        frame.add(campoAnos);

        frame.add(labelMensal);
        frame.add(campoMensal);

        frame.add(botaoCalcular);
        frame.add(resultado);

        frame.add(botaoResetar);
        frame.add(new JLabel(""));

        frame.setVisible(true);
    }
}
