package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import algoritmos.PanelAlgoritmoMediana;
import processarImagem.PanelDaImagem;

public class PanelMediana extends JPanel {

	PanelDaImagem panelDaImagem1 = new PanelDaImagem();
	PanelAlgoritmoMediana panelDaImagem2 = new PanelAlgoritmoMediana();

	public PanelMediana() {
		setSize(1024, 720);
		setLayout(null);
		setVisible(true);

		// Painel lateral
		

		// INICIO PANEL SUPERIOR

		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(SystemColor.windowBorder);
		panelSuperior.setBounds(194, 0, 830, 102);
		add(panelSuperior);
		panelSuperior.setLayout(null);

		// Corpo do sistema
		JLabel labelFiltroMediana = new JLabel("Filtros > Mediana");
		labelFiltroMediana.setForeground(Color.WHITE);
		labelFiltroMediana.setFont(new Font("Segoe UI Semilight", Font.PLAIN,
				24));
		labelFiltroMediana.setBounds(10, 24, 730, 55);
		panelSuperior.add(labelFiltroMediana);

		panelDaImagem1 = new PanelDaImagem();
		panelDaImagem1.setBounds(204, 113, 250, 250);
		add(panelDaImagem1);

		panelDaImagem2.setBounds(491, 410, 250, 250);
		panelDaImagem2.setVisible(true);
		add(panelDaImagem2);

		JButton botaoSelecionarImagem = new JButton("Escolher imagem");
		botaoSelecionarImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {

				try {

					// Instanciacao de fileChooser e alteracao do diretorio para
					// buscar a imagem
					final JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(new File("src/imagens"));

					// Verificacao do fileChooser
					if (fileChooser.showOpenDialog(botaoSelecionarImagem) == JFileChooser.APPROVE_OPTION) {

						// Cria um file onde eh armazenada a imagem
						File file = fileChooser.getSelectedFile();

						panelDaImagem1.colocaImagemNoPainel(file.getPath());
						repaint();
					}

				} catch (Exception erro) {

					JOptionPane.showMessageDialog(null,
							"Não foi possivel carregar a imagem.");

				}

			}
		});
		botaoSelecionarImagem
				.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		botaoSelecionarImagem.setBackground(new Color(0, 102, 255));
		botaoSelecionarImagem.setBounds(204, 364, 250, 35);
		add(botaoSelecionarImagem);

		JButton botaoMediana = new JButton("Processar Mediana");
		botaoMediana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {

				panelDaImagem2.colocaImagemNoPainel(panelDaImagem1.altura,
						panelDaImagem1.largura, panelDaImagem1.matrizImagem);

			}
		});
		botaoMediana.setForeground(Color.WHITE);
		botaoMediana.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoMediana.setBackground(new Color(0, 102, 255));
		botaoMediana.setBounds(204, 410, 250, 250);
		add(botaoMediana);

	}

}
