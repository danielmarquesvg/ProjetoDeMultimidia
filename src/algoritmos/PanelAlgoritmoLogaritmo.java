package algoritmos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelAlgoritmoLogaritmo extends JPanel {

public BufferedImage imagemLogaritmo;
	
	/**
	 * Create the panel.
	 */
	public PanelAlgoritmoLogaritmo() {
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(new Rectangle(0, 0, 250, 250));

	}
	
	public void colocaImagemNoPainel(int alturaDaImagem1, int larguraDaImagem1, int matrizDaImagem1[][],
			float constanteA){
		try {
			geraImagem(alturaDaImagem1, larguraDaImagem1, matrizDaImagem1, constanteA);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void geraImagem(int alturaDaImagem1, int larguraDaImagem1, int matrizDaImagem1[][], float constanteA) throws Exception{
		
        int altura = alturaDaImagem1;
        int largura = larguraDaImagem1;
        
        int matrizImagem[][] = new int[altura][largura];       
        imagemLogaritmo = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);
        
        for(int i = 0; i<altura; i++){
        	for(int j=0;j<largura;j++){
        		
        		matrizImagem[i][j] = (int)(constanteA * (Math.log(matrizDaImagem1[i][j] + 1)));
        		
        		//verificacao do valor do pixel caso o mesmo ultrapasse o valor de 255 (valor maximo)
        		if(matrizImagem[i][j] > 255){
        			matrizImagem[i][j] = 255;
        		}
        		
        		//verificacao do valor do pixel caso o mesmo ultrapasse o valor de 0 (valor minimo)
        		if(matrizImagem[i][j] < 0){
        			matrizImagem[i][j] = 0;
        		}
        		
        		imagemLogaritmo.setRGB(j, i, corPixel(matrizImagem[i][j]));
        		repaint();
        	}
        } 
    }
	
	static int corPixel(int corRGB){
		Color cor = new Color(corRGB, corRGB, corRGB);
		return cor.getRGB();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(imagemLogaritmo, 0, 0, null);
	}

}
