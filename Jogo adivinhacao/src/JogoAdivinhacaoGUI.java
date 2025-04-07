import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class JogoAdivinhacaoGUI extends JFrame {
    private  int numeroSecreto;
    private int tentativas;
    private JTextField inputPalpite;
    private JLabel resultadoLabel;
    private JLabel tentativasLabel;

    public JogoAdivinhacaoGUI() {
        super("🎯 Jogo de Adivinhação");

        numeroSecreto = new Random().nextInt(100) + 1;
        tentativas = 0;

        //configuraçoes da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,200);
        setLayout(new GridLayout(4, 1));

        //titulo
        JLabel tituloLabel = new JLabel("Adivinhe o número entre 1 e 100" , SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial",Font.BOLD,16));
        add(tituloLabel);

        //campo de entrada
        inputPalpite = new JTextField();
        inputPalpite.setHorizontalAlignment(JTextField.CENTER);
        add(inputPalpite);

        // botao de enviar
        JButton btnAdivinhar = new JButton("Enviar Palpite");
        btnAdivinhar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarPalpite();
            }
        });
        add(btnAdivinhar);
        // resultado
        resultadoLabel = new JLabel("",SwingConstants.CENTER);
        tentativasLabel = new JLabel("Tentativas: 0", SwingConstants.CENTER );
        add(resultadoLabel);
        add(tentativasLabel);
        setVisible(true);
    }
    private  void verificarPalpite() {
        try {
            int palpite = Integer.parseInt(inputPalpite.getText());
            tentativas++;

            if (palpite < numeroSecreto) {
                resultadoLabel.setText("🔻 Muito baixo!");
            }else if (palpite > numeroSecreto) {
                resultadoLabel.setText("🔺 Muito alto!");
            }else {
                resultadoLabel.setText("✅ Você acertou em " + tentativas + " tentativas!");
                inputPalpite.setEditable(false);
            }
            tentativasLabel.setText(" tentativas:" + tentativas);
            inputPalpite.setText("");
        } catch (NumberFormatException ex) {
            resultadoLabel.setText("⚠️ Digite um número válido!");
        }

    }
}
