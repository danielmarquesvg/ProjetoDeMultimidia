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

		// Painel lateral
		JPanel panelOpcaoLateral = new JPanel();
		panelOpcaoLateral.setBackground(SystemColor.scrollbar);
		panelOpcaoLateral.setBounds(0, 0, 194, 720);
		add(panelOpcaoLateral);
		panelOpcaoLateral.setLayout(null);

		
		// INICIO PANEL SUPERIOR

		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(SystemColor.windowBorder);
		panelSuperior.setBounds(194, 0, 830, 102);
		add(panelSuperior);
		panelSuperior.setLayout(null);

		// Corpo do sistema
		JLabel labelEqualizarImagem = new JLabel("Equalizar Imagem");
		labelEqualizarImagem.setForeground(Color.WHITE);
		labelEqualizarImagem.setFont(new Font("Segoe UI Semilight", Font.PLAIN,
				24));
		labelEqualizarImagem.setBounds(10, 24, 730, 55);
		panelSuperior.add(labelEqualizarImagem);

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

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage((Image) imagemOriginal, 0, 0, null);
	}

}
