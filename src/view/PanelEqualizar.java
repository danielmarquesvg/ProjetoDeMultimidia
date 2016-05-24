package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import algoritmos.PanelAlgoritmoEqualizar;
import algoritmos.PanelAlgoritmoHistograma;
import algoritmos.PanelAlgoritmoHistogramaMatriz;
import processarImagem.PanelDaImagem;
import processarImagem.PanelDaImagemMatriz;

public class PanelEqualizar extends JPanel {

	private static final long serialVersionUID = 1L;

	BufferedImage imagemOriginal;

	public PanelEqualizar() {
		setSize(1024, 720);
		setLayout(null);
		setVisible(true);

		PanelDaImagem panelDaImagem1 = new PanelDaImagem();
		panelDaImagem1.setLocation(221, 135);
		add(panelDaImagem1);

		PanelDaImagemMatriz panelDaImagemEqualizada = new PanelDaImagemMatriz();
		panelDaImagemEqualizada.setLocation(221, 432);
		add(panelDaImagemEqualizada);

		PanelAlgoritmoHistograma panelAlgoritmoHistograma = new PanelAlgoritmoHistograma();
		panelAlgoritmoHistograma.setLocation(552, 135);
		panelAlgoritmoHistograma.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panelAlgoritmoHistograma);

		PanelAlgoritmoHistogramaMatriz panelAlgoritmoHistogramaMatriz = new PanelAlgoritmoHistogramaMatriz();
		panelAlgoritmoHistogramaMatriz.setLocation(552, 432);
		panelAlgoritmoHistogramaMatriz.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panelAlgoritmoHistogramaMatriz);

		JButton btnEscolherImagem = new JButton("Escolher imagem");
		btnEscolherImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					// Instanciacao de fileChooser e alteracao do diretorio para
					// buscar a imagem
					final JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(new File("src/imagens/"));

					// Verificacao do fileChooser
					if (fileChooser.showOpenDialog(btnEscolherImagem) == JFileChooser.APPROVE_OPTION) {

						// Cria um file onde eh armazenada a imagem
						File file = fileChooser.getSelectedFile();

						panelDaImagem1.colocaImagemNoPainel(file.getPath());
						repaint();

						panelAlgoritmoHistograma.colocaImagemNoPainel(file.getPath());

						int[][] matrizOriginal = panelDaImagem1
								.getMatrizImagem();

						int[][] matrizEqualizada = PanelAlgoritmoEqualizar
								.equalizarImagem(matrizOriginal);

						panelDaImagemEqualizada
								.colocaImagemNoPainel(matrizEqualizada);

						panelAlgoritmoHistogramaMatriz
								.colocaImagemNoPainel(matrizEqualizada);

						repaint();

					}

				} catch (Exception erro) {

					JOptionPane.showMessageDialog(null,
							"Não foi possivel carregar a imagem.");
				}
			}
		});
		btnEscolherImagem.setBackground(new Color(0, 102, 255));
		btnEscolherImagem.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		btnEscolherImagem.setBounds(221, 385, 250, 35);
		add(btnEscolherImagem);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setLayout(null);
		panelSuperior.setBackground(new Color(0, 153, 204));
		panelSuperior.setBounds(0, 0, 1024, 42);
		add(panelSuperior);
		
		JLabel labelTitulo = new JLabel("Filtro da Media");
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		labelTitulo.setBounds(10, 11, 273, 27);
		panelSuperior.add(labelTitulo);
		
		ImageIcon imageIcon = new ImageIcon(PanelPrincipal.class.getResource("/imagens/homeIcon.png"));
		int scale = 2; // 2 times smaller
		int width = imageIcon.getIconWidth();
		int newWidth = width / scale;
		
		JButton botaoPaginaInicial = new JButton("Página Inicial");
		botaoPaginaInicial.setForeground(Color.WHITE);
		botaoPaginaInicial.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		botaoPaginaInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeCliqueDeMouse) {

				PanelPrincipal panelPrincipal = new PanelPrincipal();
				TelaPrincipal.contentPane.removeAll();
				TelaPrincipal.contentPane.add(panelPrincipal);
				TelaPrincipal.contentPane.validate();
				TelaPrincipal.contentPane.repaint();

			}
		});
		botaoPaginaInicial.setBounds(794, 11, 204, 27);
		panelSuperior.add(botaoPaginaInicial);
		botaoPaginaInicial.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(newWidth, -1, java.awt.Image.SCALE_SMOOTH)));
		botaoPaginaInicial.setOpaque(false);
		botaoPaginaInicial.setContentAreaFilled(false);
		botaoPaginaInicial.setBorderPainted(true);

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage((Image) imagemOriginal, 0, 0, null);
	}
	
	

}
