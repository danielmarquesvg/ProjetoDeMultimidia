package algoritmos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelAlgoritmoMediana extends JPanel {

public BufferedImage imagemMediana;
	
	/**
	 * Create the panel.
	 */
	public PanelAlgoritmoMediana() {
		
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
        imagemMediana = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);
        
        for(int i = 0; i<altura; i++){
        	for(int j=0;j<largura;j++){
        		
        		int[] array = new int[9];
    		    
        		array[0] += matrizDaImagem1[i][j];
        		if ((i - 1) >= 0) {
        			array[1] += matrizDaImagem1[i-1][j];
        		}
        		if ((i + 1) < largura) {
        			array[2] += matrizDaImagem1[i + 1][j];
        		}
        		if ((j - 1) >= 0) {
        			array[3] += matrizDaImagem1[i][j - 1];
        		}
        		if ((j + 1) < altura) {
        			array[4] += matrizDaImagem1[i][j + 1];
        		}
        		if (((i - 1) >= 0) && ((j - 1) >= 0)) {
        			array[5] += matrizDaImagem1[i - 1][j - 1];
        		}
        		if (((i + 1) < altura && ((j - 1) >= 0))) {
        			array[6] += matrizDaImagem1[i + 1][j - 1];
        		}
        		if (((i - 1) >= 0) && ((j + 1) < altura)) {
        			array[7] += matrizDaImagem1[i - 1][j + 1];
        		}
        		if (((i + 1) < altura) && ((j + 1) < altura)) {
        			array[8] += matrizDaImagem1[i + 1][j + 1];
        		}
        		
        		quicksort(array, 0, 8);
        		
        		matrizImagem[i][j] = array[4];
        		
        		//verificacao do valor do pixel caso o mesmo ultrapasse o valor de 255 (valor maximo)
        		if(matrizImagem[i][j] > 255){
        			matrizImagem[i][j] = 255;
        		}
        		
        		imagemMediana.setRGB(j, i, corPixel(matrizImagem[i][j]));
        		repaint();
        	}
        } 
    }
	
	private static void quicksort(int[] vetor, int ini, int fim) {
		int j;
		if (ini < fim) {
			j = separaVetor(vetor, ini, fim);
			quicksort(vetor, ini, j - 1);
			quicksort(vetor, j + 1, fim);
		}// if
	}
	
	private static int separaVetor(int[] vetor, int ini, int fim) {
		int aux, c = vetor[ini], i = ini + 1, j = fim;
		while (i <= j) {
			if (vetor[i] <= c)
				++i;
			else if (c < vetor[j])
				--j;
			else {
				aux = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux;
				++i;
				--j;
			}// if
		}// while

		aux = vetor[ini];
		vetor[ini] = vetor[j];
		vetor[j] = aux;
		return j;
	}
	
	static int corPixel(int corRGB){
		Color cor = new Color(corRGB, corRGB, corRGB);
		return cor.getRGB();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(imagemMediana, 0, 0, null);
	}

}
