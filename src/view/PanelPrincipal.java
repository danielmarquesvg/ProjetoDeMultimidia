package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class PanelPrincipal extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelPrincipal() {
		setBackground(Color.WHITE);
		
		setSize(1024, 720);
		setLayout(null);
		
		JPanel panelCabecalho = new JPanel();
		panelCabecalho.setBackground(new Color(0, 153, 204));
		panelCabecalho.setBounds(0, 0, 1024, 42);
		add(panelCabecalho);
		panelCabecalho.setLayout(null);
		
		JLabel labelTituloDoCabecalho = new JLabel("Projeto de Multimidia");
		labelTituloDoCabecalho.setForeground(Color.WHITE);
		labelTituloDoCabecalho.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		labelTituloDoCabecalho.setBounds(10, 11, 273, 27);
		panelCabecalho.add(labelTituloDoCabecalho);
		
		setSize(1024, 720);
		setLayout(null);
		setVisible(true);
		
		JButton botaoMedia = new JButton("Media");
		botaoMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
			}
		});
		botaoMedia.setForeground(Color.WHITE);
		botaoMedia.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoMedia.setBackground(new Color(0, 102, 255));
		botaoMedia.setBounds(25, 110, 181, 70);
		add(botaoMedia);
		
		JButton botaoMediana = new JButton("Mediana");
		botaoMediana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				TelaFiltros telaFiltros = new TelaFiltros();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaFiltros);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				*/
				
			}
		});
		botaoMediana.setForeground(Color.WHITE);
		botaoMediana.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoMediana.setBackground(new Color(0, 102, 255));
		botaoMediana.setBounds(216, 110, 181, 70);
		add(botaoMediana);
		
		JButton botaoPassaAlta = new JButton("Passa Alta");
		botaoPassaAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {

			}
		});
		botaoPassaAlta.setForeground(Color.WHITE);
		botaoPassaAlta.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoPassaAlta.setBackground(new Color(0, 102, 255));
		botaoPassaAlta.setBounds(407, 110, 181, 70);
		add(botaoPassaAlta);
		
		JButton botaoPrewitt = new JButton("Prewitt");
		botaoPrewitt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoPrewitt.setForeground(Color.WHITE);
		botaoPrewitt.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoPrewitt.setBackground(new Color(0, 102, 255));
		botaoPrewitt.setBounds(598, 110, 181, 70);
		add(botaoPrewitt);
		
		JButton botaoRoberts = new JButton("Roberts");
		botaoRoberts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoRoberts.setForeground(Color.WHITE);
		botaoRoberts.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoRoberts.setBackground(new Color(0, 102, 255));
		botaoRoberts.setBounds(789, 110, 181, 70);
		add(botaoRoberts);
		
		JButton botaoRobertsCruzado = new JButton("Roberts Cruzado");
		botaoRobertsCruzado.setForeground(Color.WHITE);
		botaoRobertsCruzado.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoRobertsCruzado.setBackground(new Color(0, 102, 255));
		botaoRobertsCruzado.setBounds(25, 191, 181, 70);
		add(botaoRobertsCruzado);
		
		JLabel labelTransformacoes = new JLabel("Transformações");
		labelTransformacoes.setForeground(new Color(0, 153, 204));
		labelTransformacoes.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		labelTransformacoes.setBounds(25, 324, 273, 27);
		add(labelTransformacoes);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 349, 932, 10);
		add(separator);
		
		JLabel labelFiltros = new JLabel("Filtros");
		labelFiltros.setForeground(new Color(0, 153, 204));
		labelFiltros.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		labelFiltros.setBounds(25, 74, 273, 27);
		add(labelFiltros);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(25, 100, 932, 10);
		add(separator_1);
		
		JLabel labelEqualizacao = new JLabel("Equalização");
		labelEqualizacao.setForeground(new Color(0, 153, 204));
		labelEqualizacao.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		labelEqualizacao.setBounds(25, 498, 273, 27);
		add(labelEqualizacao);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(25, 527, 932, 10);
		add(separator_2);
		
		JButton botaoSobel = new JButton("Sobel");
		botaoSobel.setForeground(Color.WHITE);
		botaoSobel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoSobel.setBackground(new Color(0, 102, 255));
		botaoSobel.setBounds(216, 191, 181, 70);
		add(botaoSobel);
		
		JButton botaoNegativo = new JButton("Negativo");
		botaoNegativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PanelNegativo panelNegativo = new PanelNegativo();
				TelaPrincipal.contentPane.removeAll();
				TelaPrincipal.contentPane.add(panelNegativo);
				TelaPrincipal.contentPane.validate();
				TelaPrincipal.contentPane.repaint();
				
				
			}
		});
		botaoNegativo.setForeground(Color.WHITE);
		botaoNegativo.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoNegativo.setBackground(new Color(0, 102, 255));
		botaoNegativo.setBounds(25, 362, 181, 70);
		add(botaoNegativo);
		
		JButton botaoGamma = new JButton("Gamma");
		botaoGamma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				PanelGamma panelGamma = new PanelGamma();
				TelaPrincipal.contentPane.removeAll();
				TelaPrincipal.contentPane.add(panelGamma);
				TelaPrincipal.contentPane.validate();
				TelaPrincipal.contentPane.repaint();
				
			}
		});
		botaoGamma.setForeground(Color.WHITE);
		botaoGamma.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoGamma.setBackground(new Color(0, 102, 255));
		botaoGamma.setBounds(216, 362, 181, 70);
		add(botaoGamma);
		
		JButton botaoLogaritmo = new JButton("Logaritmo");
		botaoLogaritmo.setForeground(Color.WHITE);
		botaoLogaritmo.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoLogaritmo.setBackground(new Color(0, 102, 255));
		botaoLogaritmo.setBounds(407, 362, 181, 70);
		add(botaoLogaritmo);
		
		JButton botaoEqualizar = new JButton("Equalizar");
		botaoEqualizar.setForeground(Color.WHITE);
		botaoEqualizar.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoEqualizar.setBackground(new Color(0, 102, 255));
		botaoEqualizar.setBounds(25, 536, 181, 70);
		add(botaoEqualizar);

	}
}

