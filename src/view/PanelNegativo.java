package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import algoritmos.PanelAlgoritmoNegativo;
import processarImagem.PanelDaImagem;

public class PanelNegativo extends JPanel{

	PanelDaImagem panelDaImagem1 = new PanelDaImagem();
	PanelAlgoritmoNegativo panelDaImagem2 = new PanelAlgoritmoNegativo();
	
	public PanelNegativo(){
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
					fileChooser.setCurrentDirectory(new File ("src/"));
					
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
		
		JButton botaoNegativo = new JButton("Processar Negativo");
		botaoNegativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				panelDaImagem2.colocaImagemNoPainel(panelDaImagem1.altura, panelDaImagem1.largura, panelDaImagem1.matrizImagem);
				
			}
		});
		botaoNegativo.setForeground(Color.WHITE);
		botaoNegativo.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoNegativo.setBackground(new Color(0, 102, 255));
		botaoNegativo.setBounds(204, 410, 250, 250);
		add(botaoNegativo);

	}
}
