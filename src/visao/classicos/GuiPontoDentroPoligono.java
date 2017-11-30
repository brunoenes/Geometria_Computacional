package visao.classicos;

import java.awt.Color;
import java.awt.Graphics;

import modelo.Poligono;
import modelo.Ponto;
import problemas.Problemas_Classicos;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

/**
 *
 * @author MSDubov
 */
public class GuiPontoDentroPoligono extends javax.swing.JFrame {

	public static ArrayList<Ponto> listaPonto;
	public static Ponto p;
	public static int state;
	private JButton btnCalcular = new JButton("Calcular");
	private JButton btnAdicionarPonto = new JButton("Adicionar Ponto");
	private Problemas_Classicos classicos = new Problemas_Classicos();
	private static boolean desenha = false;
	private static boolean limpar = false;
	private static boolean addPonto = false;
	public static int pontoAux = 0;

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GuiAreaPoligono.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GuiAreaPoligono.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GuiAreaPoligono.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GuiAreaPoligono.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				GuiPontoDentroPoligono distancia = new GuiPontoDentroPoligono();
				distancia.setVisible(true);

			}
		});
	}

	/** Creates new form MainFrame */
	public GuiPontoDentroPoligono() {
		setResizable(false);
		setAutoRequestFocus(false);
		initComponents();
		setLocationRelativeTo(null);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { btnCalcular, jPanel1, getContentPane() }));
		state = 0;
		listaPonto = new ArrayList<>();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel() {
			@Override
			public void paintComponent(Graphics g) {

				if (limpar) {
					g.clearRect(0, 0, this.getWidth(), this.getHeight());
					g.setColor(Color.BLACK);
					limpar = false;
					addPonto = false;
					return;
				}

				if (pontoAux == 0) {
					if (!addPonto) {
						g.clearRect(0, 0, this.getWidth(), this.getHeight());
						g.setColor(Color.BLACK);
						if (desenha) {

							if (state == 0) {
								g.fillOval((int) listaPonto.get(state).x - 3, (int) listaPonto.get(state).y - 3, 7, 7);
								g.drawLine((int) listaPonto.get(state).x, (int) listaPonto.get(state).y, (int) mouseX,
										(int) mouseY);
							} else {
								for (int i = 0; i < listaPonto.size() - 1; i++) {
									g.fillOval((int) listaPonto.get(i).x - 3, (int) listaPonto.get(i).y - 3, 7, 7);
									g.drawLine((int) (int) listaPonto.get(i).x, (int) listaPonto.get(i).y,
											(int) listaPonto.get(i + 1).x, (int) listaPonto.get(i + 1).y);
								}
								g.fillOval((int) listaPonto.get(listaPonto.size() - 1).x - 3,
										(int) listaPonto.get(listaPonto.size() - 1).y - 3, 7, 7);
								g.drawLine((int) listaPonto.get(listaPonto.size() - 1).x,
										(int) listaPonto.get(listaPonto.size() - 1).y, (int) listaPonto.get(0).x,
										(int) listaPonto.get(0).y);

							}

						}
					} else {
						if (p != null) {
							g.setColor(Color.RED);
							g.fillOval((int) p.x - 3, (int) p.y - 3, 7, 7);
							btnCalcular.setEnabled(true);
							pontoAux = 1;
						}
					}

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
		btnAdicionarPonto.setEnabled(false);

		btnAdicionarPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPonto = true;
			}
		});

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desenha = false;
				btnCalcular.setEnabled(false);
				limpar = true;
				btnAdicionarPonto.setEnabled(false);
				state = 0;
				p = null;
				listaPonto.clear();
				pontoAux = 0;
				jPanel1.repaint();
				
				
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jPanel1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup().addComponent(btnCalcular).addGap(18)
								.addComponent(btnAdicionarPonto)
								.addPreferredGap(ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
								.addComponent(btnLimpar)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(btnCalcular)
								.addComponent(btnLimpar).addComponent(btnAdicionarPonto))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		btnCalcular.setEnabled(false);
		jPanel1.setLayout(null);

		// calcula a distancia entre o ponto e a reta
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Poligono poligono = new Poligono();
				for (Ponto ponto : listaPonto) {
					poligono.insereVertice(ponto);
				}
				boolean resultado = classicos.pontoDentroPoligono(poligono, p);

				String texto = "Lista de Pontos: \n";

				for (Ponto ponto : listaPonto) {
					texto += "Ponto: (" + ponto.x + "," + ponto.y + ")\n";
				}

				texto += "\n\nPonto Verificado: (" + p.x + "," + p.y + ")";

				texto += "\n\nEsta Dentro ? " + resultado;
				JOptionPane.showMessageDialog(null, texto);

			}
		});
		getContentPane().setLayout(layout);

		pack();
	}

	double mouseX, mouseY;

	private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {

		if ((!addPonto) || (limpar)) {
			mouseX = evt.getX();
			mouseY = evt.getY();
			jPanel1.repaint();
		}
	}

	private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {

		if (!addPonto) {
			Ponto aux = new Ponto(evt.getX(), evt.getY());
			if (listaPonto.isEmpty()) {
				listaPonto.add(aux);
				desenha = true;
			} else {
				listaPonto.add(aux);
				state++;
			}

			if (state >= 2) {				
				btnAdicionarPonto.setEnabled(true);
			}
			jPanel1.repaint();
		} else {
			p = new Ponto(evt.getX(), evt.getY());
			jPanel1.repaint();
		}

	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel jPanel1;
	// End of variables declaration//GEN-END:variables
}
