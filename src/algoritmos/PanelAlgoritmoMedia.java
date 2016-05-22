package algoritmos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelAlgoritmoMedia extends JPanel {

public BufferedImage imagemMedia;
	
	/**
	 * Create the panel.
	 */
	public PanelAlgoritmoMedia() {
		
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
        int CoeficienteDeNormalizacao = 0;
        
        int matrizImagem[][] = new int[altura][largura];       
        imagemMedia = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);
        
        for(int i = 0; i<altura; i++){
        	for(int j=0;j<largura;j++){
        		
        		CoeficienteDeNormalizacao = CoeficienteDeNormalizacao + matrizDaImagem1[i][j];
        	}
        }
        
        for(int i = 0; i<altura; i++){
        	for(int j=0;j<largura;j++){
        		
        		int soma = 0;

        		soma += matrizDaImagem1[i][j];
        		if ((i - 1) >= 0) {
        			soma += matrizDaImagem1[i - 1][j] / CoeficienteDeNormalizacao;
        		}
        		if ((i + 1) < largura) {
        			soma += matrizDaImagem1[i + 1][j] / CoeficienteDeNormalizacao;
        		}
        		if ((j - 1) >= 0) {
        			soma += matrizDaImagem1[i][j - 1] / CoeficienteDeNormalizacao;
        		}
        		if ((j + 1) < altura) {
        			soma += matrizDaImagem1[i][j + 1] / CoeficienteDeNormalizacao;
        		}
        		if (((i - 1) >= 0) && ((j - 1) >= 0)) {
        			soma += matrizDaImagem1[i - 1][j - 1] / CoeficienteDeNormalizacao;
        		}
        		if (((i + 1) < largura) && ((j - 1) >= 0)) {
        			soma += matrizDaImagem1[i + 1][j - 1] / CoeficienteDeNormalizacao;
        		}
        		if (((i - 1) >= 0) && ((j + 1) < altura)) {
        			soma += matrizDaImagem1[i - 1][j + 1] / CoeficienteDeNormalizacao;
        		}
        		if (((i + 1) < largura) && ((j + 1) < altura)) {
        			soma += matrizDaImagem1[i + 1][j + 1] / CoeficienteDeNormalizacao;
        		}
        		
        		matrizImagem[i][j] = Math.round(soma);
        		
        		//verificacao do valor do pixel caso o mesmo ultrapasse o valor de 255 (valor maximo)
        		if(matrizImagem[i][j] > 255){
        			matrizImagem[i][j] = 255;
        		}
        		
        		imagemMedia.setRGB(j, i, corPixel(matrizImagem[i][j]));
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
		g.drawImage(imagemMedia, 0, 0, null);
	}

}
