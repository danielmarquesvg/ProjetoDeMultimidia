package algoritmos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelAlgoritmoSobel extends JPanel {

public BufferedImage imagemSobel;
	
	/**
	 * Create the panel.
	 */
	public PanelAlgoritmoSobel() {
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(new Rectangle(0, 0, 250, 250));

	}
	
	public void colocaImagemNoPainel(int alturaDaImagem1, int larguraDaImagem1, int matrizDaImagem1[][]){
		try {
			geraImagem(alturaDaImagem1, larguraDaImagem1, matrizDaImagem1);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void geraImagem(int alturaDaImagem1, int larguraDaImagem1, int matrizDaImagem1[][]) throws Exception{
		
        int altura = alturaDaImagem1;
        int largura = larguraDaImagem1;
        
        int matrizImagem[][] = new int[altura][largura];       
        imagemSobel = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);
        
        for(int i = 0; i<altura; i++){
        	for(int j=0;j<largura;j++){
        		
        		int fatA = 0;
        		int fatB = 0;
        		int fatC = 0;
        		int fatD = 0;
        		if ((i - 1) >= 0) {
        			fatD += 2*matrizDaImagem1[i - 1][j];
        		}
        		if ((i + 1) < largura) {
        			fatC += 2*matrizDaImagem1[i + 1][j];
        		}
        		if ((j - 1) >= 0) {
        			fatB += 2*matrizDaImagem1[i][j - 1];
        		}
        		if ((j + 1) < altura) {
        			fatA += 2*matrizDaImagem1[i][j + 1];
        		}
        		if (((i - 1) >= 0) && ((j - 1) >= 0)) {
        			fatB += matrizDaImagem1[i - 1][j - 1];
        			fatD += matrizDaImagem1[i - 1][j - 1];
        		}
        		if (((i + 1) < largura) && ((j - 1) >= 0)) {
        			fatB += matrizDaImagem1[i + 1][j - 1];
        			fatC += matrizDaImagem1[i + 1][j - 1];
        		}
        		if (((i - 1) >= 0) && ((j + 1) < altura)) {
        			fatA += matrizDaImagem1[i - 1][j + 1];
        			fatD += matrizDaImagem1[i - 1][j + 1];
        		}
        		if (((i + 1) < largura) && ((j + 1) < altura)) {
        			fatA += matrizDaImagem1[i + 1][j + 1];
        			fatC += matrizDaImagem1[i + 1][j + 1];;
        		}

        		int aux1 = fatA - fatB;
        		int aux2 = fatC - fatD;
        		int mag = Math.abs(aux1) + Math.abs(aux2);
        		
        		matrizImagem[i][j] = mag;
        		
        		//verificacao do valor do pixel caso o mesmo ultrapasse o valor de 255 (valor maximo)
        		if(matrizImagem[i][j] > 255){
        			matrizImagem[i][j] = 255;
        		}
        		
        		//verificacao do valor do pixel caso o mesmo ultrapasse o valor de 0 (valor minimo)
        		if(matrizImagem[i][j] < 0){
        			matrizImagem[i][j] = 0;
        		}
        		
        		imagemSobel.setRGB(j, i, corPixel(matrizImagem[i][j]));
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
		g.drawImage(imagemSobel, 0, 0, null);
	}


}
