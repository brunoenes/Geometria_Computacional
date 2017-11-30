package visao.classicos;

import java.awt.Color;
import java.awt.Graphics;
import modelo.Ponto;
import modelo.Reta;
import problemas.Problemas_Classicos;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class GuiDistanciaPontoReta extends javax.swing.JFrame {

	/** Creates new form MainFrame */
	public GuiDistanciaPontoReta() {
		setResizable(false);
		setAutoRequestFocus(false);
		initComponents();
		setLocationRelativeTo(null);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnCalcularDistancia, jPanel1, getContentPane()}));
		state = 0;
	}


	@SuppressWarnings("unchecked")	
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				g.clearRect(0, 0, this.getWidth(), this.getHeight());
				g.setColor(Color.BLACK);

				if (state == 1) {
					g.drawLine((int) p1.getX(), (int) p1.getY(), (int) mouseX, (int) mouseY);
				}
				if (state >= 2) {
					g.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY());
				}
				if (state == 3) {
					g.fillOval((int) p3.getX(), (int) p3.getY(), 5, 5);
				}
				
				
				
			}
		};

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Distancia entre Reta e Ponto");

		jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jPanel1MousePressed(evt);
			}
		});
		jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseMoved(java.awt.event.MouseEvent evt) {
				jPanel1MouseMoved(evt);
			}
		});
		
		

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jPanel1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
						.addComponent(btnCalcularDistancia))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnCalcularDistancia)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		jPanel1.setLayout(null);
		
		// calcula a distancia entre o ponto e a reta
		btnCalcularDistancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				reta = new Reta(p1,p2);
				double resultado = classicos.distanciaPontoReta(p3, reta);	
				
				String texto = "Reta [\nPonto 1: (" + reta.p1.x +"," + reta.p1.y + ")" +				
						       "\nPonto 2: (" + reta.p2.x +"," + reta.p2.y + ")" + "\n]" +
						       "\n\n Ponto 3: (" + p3.x +"," + p3.y + ")" +
						       "\n\nResultado: " + resultado;
						       ;
				JOptionPane.showMessageDialog(null, "Valor da Distancia:  \n" + texto);							
			}
		});
		btnCalcularDistancia.setEnabled(false);
		getContentPane().setLayout(layout);

		pack();
	}
	
	double mouseX, mouseY;

	private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {
		mouseX = evt.getX();
		mouseY = evt.getY();

		jPanel1.repaint();
	}

	private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {

		if (state == 3)
			state = 0;

		if (state == 0) {
			p1 = new Ponto(evt.getX(), evt.getY());
			btnCalcularDistancia.setEnabled(false);
			state++;
		} else if (state == 1) {
			p2 = new Ponto(evt.getX(), evt.getY());
			btnCalcularDistancia.setEnabled(false);
			state++;
		} else if (state == 2) {
			p3 = new Ponto(evt.getX(), evt.getY());
			btnCalcularDistancia.setEnabled(true);
			state++;
		} else 
			return;

		jPanel1.repaint();
	}
	
	private Reta reta;
	private Ponto p1, p2, p3;
	private int state;
	private JButton btnCalcularDistancia = new JButton("Calcular Distancia");
	private Problemas_Classicos classicos = new Problemas_Classicos();  
	
	
	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GuiDistanciaPontoReta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GuiDistanciaPontoReta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GuiDistanciaPontoReta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GuiDistanciaPontoReta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				GuiDistanciaPontoReta distancia = new GuiDistanciaPontoReta();
				distancia.setVisible(true);
			
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel jPanel1;
	// End of variables declaration//GEN-END:variables
}
