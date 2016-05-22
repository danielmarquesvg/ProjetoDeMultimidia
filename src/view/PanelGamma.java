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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import algoritmos.PanelAlgoritmoGamma;
import processarImagem.PanelDaImagem;

public class PanelGamma extends JPanel {

	PanelDaImagem panelDaImagem1 = new PanelDaImagem();
	PanelAlgoritmoGamma panelDaImagem2 = new PanelAlgoritmoGamma();
	private JTextField textField_valorGamma;
	
	public PanelGamma(){
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
		botaoSelecionarImagem.setForeground(Color.WHITE);
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
		botaoSelecionarImagem.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoSelecionarImagem.setBackground(new Color(0, 102, 255));
		botaoSelecionarImagem.setBounds(204, 364, 250, 35);
		add(botaoSelecionarImagem);
		
		textField_valorGamma = new JTextField();
		textField_valorGamma.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		textField_valorGamma.setBounds(491, 208, 250, 46);
		add(textField_valorGamma);
		textField_valorGamma.setColumns(10);
		
		JButton botaoGamma = new JButton("Processar Gamma");
		botaoGamma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				textField_valorGamma.setText(textField_valorGamma.getText().replace(",", "."));
				float valorGamma = Float.parseFloat(textField_valorGamma.getText());
				
				if(valorGamma > 1){
					valorGamma = 1;
				}
				
				if(valorGamma < 0){
					valorGamma = 0;
				}
				
				float valorC = 1;
				
				panelDaImagem2.colocaImagemNoPainel(panelDaImagem1.altura, panelDaImagem1.largura, panelDaImagem1.matrizImagem, 
						valorGamma, valorC);
				
			}
		});
		botaoGamma.setForeground(Color.WHITE);
		botaoGamma.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoGamma.setBackground(new Color(0, 102, 255));
		botaoGamma.setBounds(204, 410, 250, 250);
		add(botaoGamma);
		
		JLabel labelGamma = new JLabel("Gamma \u03B3  ( 0 \u2264 \u03B3 \u2264 1 )");
		labelGamma.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		labelGamma.setBounds(491, 174, 194, 35);
		add(labelGamma);
		
		JLabel labelC = new JLabel("C = 1");
		labelC.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		labelC.setBounds(491, 113, 194, 35);
		add(labelC);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 153, 204));
		panel.setBounds(0, 0, 1024, 42);
		add(panel);
		
		JLabel labelTituloGamma = new JLabel("Gamma");
		labelTituloGamma.setForeground(Color.WHITE);
		labelTituloGamma.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		labelTituloGamma.setBounds(10, 11, 273, 27);
		panel.add(labelTituloGamma);

	}
}
