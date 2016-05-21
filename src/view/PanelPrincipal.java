package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JButton botaoFiltros = new JButton("Filtros");
		botaoFiltros.addActionListener(new ActionListener() {
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
		botaoFiltros.setForeground(Color.WHITE);
		botaoFiltros.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoFiltros.setBackground(new Color(0, 102, 255));
		botaoFiltros.setBounds(420, 99, 385, 180);
		add(botaoFiltros);
		
		JButton botaoTransformacoes = new JButton("Transformações");
		botaoTransformacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {

			}
		});
		botaoTransformacoes.setForeground(Color.WHITE);
		botaoTransformacoes.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoTransformacoes.setBackground(new Color(0, 102, 255));
		botaoTransformacoes.setBounds(25, 99, 385, 180);
		add(botaoTransformacoes);
		
		JButton botaoEqualizarImagem = new JButton("Equalizar Imagem");
		botaoEqualizarImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
			}
		});
		botaoEqualizarImagem.setForeground(Color.WHITE);
		botaoEqualizarImagem.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoEqualizarImagem.setBackground(new Color(0, 102, 255));
		botaoEqualizarImagem.setBounds(25, 293, 385, 180);
		add(botaoEqualizarImagem);

	}
}

