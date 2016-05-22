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

import algoritmos.PanelAlgoritmoSobel;
import processarImagem.PanelDaImagem;

public class PanelSobel extends JPanel {

	PanelDaImagem panelDaImagem1 = new PanelDaImagem();
	PanelAlgoritmoSobel panelDaImagem2 = new PanelAlgoritmoSobel();
	
	public PanelSobel(){
		setSize(1024, 720);
		setLayout(null);
		setVisible(true);


		// INICIO PANEL SUPERIOR

		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(SystemColor.windowBorder);
		panelSuperior.setBounds(194, 0, 830, 102);
		add(panelSuperior);
		panelSuperior.setLayout(null);

		// Corpo do sistema
		JLabel labelFiltrosSobel = new JLabel("Filtros > Sobel");
		labelFiltrosSobel.setForeground(Color.WHITE);
		labelFiltrosSobel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
		labelFiltrosSobel.setBounds(10, 24, 730, 55);
		panelSuperior.add(labelFiltrosSobel);
		
		panelDaImagem1 = new PanelDaImagem();
		panelDaImagem1.setBounds(204, 113, 250, 250);
		add(panelDaImagem1);
		
		panelDaImagem2.setBounds(491, 410, 250, 250);
		panelDaImagem2.setVisible(true);
		add(panelDaImagem2);
		
		JButton botaoSelecionarImagem = new JButton("Escolher imagem");
		botaoSelecionarImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				try{  
					
					//Instanciacao de fileChooser e alteracao do diretorio para buscar a imagem
					final JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(new File ("src/imagens"));
					
					//Verificacao do fileChooser
					if (fileChooser.showOpenDialog(botaoSelecionarImagem) == JFileChooser.APPROVE_OPTION) {
						
						//Cria um file onde eh armazenada a imagem
						File file = fileChooser.getSelectedFile();
						
						panelDaImagem1.colocaImagemNoPainel(file.getPath());			
						repaint();
					}
					
				}catch(Exception erro){  
				        
					JOptionPane.showMessageDialog(null, "N�o foi possivel carregar a imagem.");  
				        
				}    
				
			}
		});
		botaoSelecionarImagem.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		botaoSelecionarImagem.setBackground(new Color(0, 102, 255));
		botaoSelecionarImagem.setBounds(204, 364, 250, 35);
		add(botaoSelecionarImagem);
		
		JButton botaoSobel = new JButton("Processar Sobel");
		botaoSobel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				panelDaImagem2.colocaImagemNoPainel(panelDaImagem1.altura, panelDaImagem1.largura, panelDaImagem1.matrizImagem);
				
			}
		});
		botaoSobel.setForeground(Color.WHITE);
		botaoSobel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoSobel.setBackground(new Color(0, 102, 255));
		botaoSobel.setBounds(204, 410, 250, 250);
		add(botaoSobel);

	}

}
