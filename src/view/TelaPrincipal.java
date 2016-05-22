package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;


public class TelaPrincipal extends JFrame {

	public static JPanel contentPane;
	PanelPrincipal panelPrincipal = new PanelPrincipal();

	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setMinimumSize(new Dimension(1024, 720));
		setTitle("Projeto de Multimidia");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 720);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panelPrincipal.setBounds(0, 0, 1024, 682);
		contentPane.add(panelPrincipal);
		setVisible(true);
	}

}
