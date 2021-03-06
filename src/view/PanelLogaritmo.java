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

import algoritmos.PanelAlgoritmoLogaritmo;
import processarImagem.PanelDaImagem;


public class PanelLogaritmo extends JPanel {

	PanelDaImagem panelDaImagem1 = new PanelDaImagem();
	PanelAlgoritmoLogaritmo panelDaImagem2 = new PanelAlgoritmoLogaritmo();
	private JTextField textField_valorConstanteA;
	
	public PanelLogaritmo(){
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
				        
					JOptionPane.showMessageDialog(null, "N�o foi possivel carregar a imagem.");  
				        
				}    
				
			}
		});
		botaoSelecionarImagem.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoSelecionarImagem.setBackground(new Color(0, 102, 255));
		botaoSelecionarImagem.setBounds(204, 364, 250, 35);
		add(botaoSelecionarImagem);
		
		textField_valorConstanteA = new JTextField();
		textField_valorConstanteA.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		textField_valorConstanteA.setBounds(491, 208, 250, 46);
		add(textField_valorConstanteA);
		textField_valorConstanteA.setColumns(10);
		
		JButton botaoGamma = new JButton("Processar Gamma");
		botaoGamma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				textField_valorConstanteA.setText(textField_valorConstanteA.getText().replace(",", "."));
				float valorConstanteA = Float.parseFloat(textField_valorConstanteA.getText());
				
				panelDaImagem2.colocaImagemNoPainel(panelDaImagem1.altura, panelDaImagem1.largura, panelDaImagem1.matrizImagem, 
						valorConstanteA);
				
			}
		});
		botaoGamma.setForeground(Color.WHITE);
		botaoGamma.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoGamma.setBackground(new Color(0, 102, 255));
		botaoGamma.setBounds(204, 410, 250, 250);
		add(botaoGamma);
		
		JLabel labelConstanteA = new JLabel("Constante A)");
		labelConstanteA.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		labelConstanteA.setBounds(491, 174, 194, 35);
		add(labelConstanteA);
		
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
		
		JButton botaoPaginaInicial = new JButton("P�gina Inicial");
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
