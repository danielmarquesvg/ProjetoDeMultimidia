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
import algoritmos.PanelAlgoritmoMedia;
import processarImagem.PanelDaImagem;

public class PanelMedia extends JPanel {

	PanelDaImagem panelDaImagem1 = new PanelDaImagem();
	PanelAlgoritmoMedia panelDaImagem2 = new PanelAlgoritmoMedia();
	
	public PanelMedia(){
		setSize(1024, 720);
		setLayout(null);
		setVisible(true);
		
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
				        
					JOptionPane.showMessageDialog(null, "Não foi possivel carregar a imagem.");  
				        
				}    
				
			}
		});
		botaoSelecionarImagem.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		botaoSelecionarImagem.setBackground(new Color(0, 102, 255));
		botaoSelecionarImagem.setBounds(204, 364, 250, 35);
		add(botaoSelecionarImagem);
		
		JButton botaoMedia = new JButton("Processar Media");
		botaoMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				panelDaImagem2.colocaImagemNoPainel(panelDaImagem1.altura, panelDaImagem1.largura, panelDaImagem1.matrizImagem);
				
			}
		});
		botaoMedia.setForeground(Color.WHITE);
		botaoMedia.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoMedia.setBackground(new Color(0, 102, 255));
		botaoMedia.setBounds(204, 410, 250, 250);
		add(botaoMedia);
		
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
}
