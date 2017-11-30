package visao;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import problemas.Troco;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiTrocoMinimo extends JFrame {

	private static final long serialVersionUID = 458912768796140968L;
	private JPanel contentPane;
	private JTextField edtContaAPagar;
	private JTextField edtDinheiro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiTrocoMinimo frame = new GuiTrocoMinimo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiTrocoMinimo() {
		setBackground(Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 408);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Valor da Conta a Pagar: ");
		lblNewLabel.setBounds(23, 45, 118, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblDinheiro = new JLabel("Dinheiro :");
		lblDinheiro.setBounds(95, 96, 46, 14);
		contentPane.add(lblDinheiro);
		
		edtContaAPagar = new JTextField();
		edtContaAPagar.setBounds(151, 45, 102, 20);
		contentPane.add(edtContaAPagar);
		edtContaAPagar.setColumns(10);
		
		edtDinheiro = new JTextField();
		edtDinheiro.setBounds(151, 92, 102, 20);
		contentPane.add(edtDinheiro);
		edtDinheiro.setColumns(10);
		
		JButton btnCalcularTroco = new JButton("Calcular Troco");
		btnCalcularTroco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double conta, pago;
				
				try {
					
					// recebe os valolres
					conta =  Double.parseDouble(edtContaAPagar.getText());
					pago =   Double.parseDouble(edtDinheiro.getText());
					
					//calcula o troco minimo
					Troco troco = new Troco();
					String resultado = troco.calculaTroco(conta, pago);			
					// exibe a mensagem para o usuario
					JOptionPane.showMessageDialog(null, resultado);
					// limpa os campos
					edtContaAPagar.setText("");
					edtDinheiro.setText("");
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Formato Incorreto");
				}
				
				
				
				
			}
		});
		btnCalcularTroco.setBounds(95, 163, 138, 23);
		contentPane.add(btnCalcularTroco);
	}
}
