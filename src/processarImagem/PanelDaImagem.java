package processarImagem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelDaImagem extends JPanel{
	
	private String caminhoDaImagem = "";
	private static final String COMENTARIO = "#";
	private static final String P2 = "P2";
	
	public int[][] matrizImagem;
	public int altura;
	public int largura;
	public static BufferedReader imagem;
	public BufferedImage imagemOriginal;

	public PanelDaImagem() {
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(new Rectangle(0, 0, 250, 250));
				
	}
	
	public void colocaImagemNoPainel(String caminhoDaImagem){
		try {
			imagem = new BufferedReader(new FileReader(caminhoDaImagem));
			geraImagem();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void geraImagem() throws Exception{
		
		String type = imagem.readLine();//Ler a primeira linha da mensagem e ignora a descricao do tipo da imagem
		
		if (type == null || !type.equals(P2)) {
            throw new Exception("Formato invalido - Tipo P2 requerido");
        }
		
		// Ignora as linhas com comentários            
        String linha = null;
        
        do {
            linha = imagem.readLine();
        } while (linha != null && linha.startsWith(COMENTARIO));
        
        //Le o número de linhas e colunas
        //linha possuirá a resolucao da imagem ex: 256 256
        String[] dimensao = linha.split(" ");
        altura  = Integer.parseInt(dimensao[0]);
        largura = Integer.parseInt(dimensao[1]);    
        matrizImagem = new int[altura][largura];
       
        String [] pixels;
        int line=0;//coluna onde o pixel se localiza
        
        /*A linha onde refere-se ao valor maximo que o pixel pode ter eh ignorado*/
        linha=imagem.readLine();
        linha=imagem.readLine();
        while(linha != null ){
        	
        	pixels = linha.split(" ");
        	for(int i = 0;i<pixels.length;i++){
        		matrizImagem[line][i] = Integer.parseInt(pixels[i]);            	
        	}
        	line++;
        	linha=imagem.readLine();
        }
        
        imagemOriginal = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i<altura; i++){
        	for(int j=0;j<largura;j++){
        		imagemOriginal.setRGB(j, i, corPixel(matrizImagem[i][j]));
        		repaint();
        	}
        	
        }
             
    }
	
	
	
	public int[][] getMatrizImagem() {
		return matrizImagem;
	}

	public void setMatrizImagem(int[][] matrizImagem) {
		this.matrizImagem = matrizImagem;
	}
	
	public BufferedImage getBufferedImage(){
		return imagemOriginal;
	}

	static int corPixel(int corRGB){
		Color cor = new Color(corRGB, corRGB, corRGB);
		return cor.getRGB();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage((Image) imagemOriginal, 0, 0, null);
	}

}
