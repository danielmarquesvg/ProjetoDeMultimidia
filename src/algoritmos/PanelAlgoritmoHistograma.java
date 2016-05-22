package algoritmos;

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

public class PanelAlgoritmoHistograma extends JPanel {

	private static final String COMENTARIO = "#";
	private static final String P2 = "P2";
	
	public int[][] matrizImagem;
	public int altura;
	public int largura;
	public static BufferedReader imagem;
	private static BufferedImage imagemOriginal;
	
	public PanelAlgoritmoHistograma() {
		
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
        int[] freq = new int[255];
        
      //coluna onde o pixel se localiza
        int line=0, quant = 0;
        
        /*A linha onde refere-se ao valor maximo que o pixel pode ter eh ignorado*/
        linha=imagem.readLine();
        linha=imagem.readLine();
        while(linha != null ) {        	
        	pixels = linha.split(" ");
        	for(int i = 0;i<pixels.length;i++){
        		matrizImagem[line][i] = Integer.parseInt(pixels[i]);
        		freq[Integer.parseInt(pixels[i])]++;
        		quant++;
        	}
        	line++;
        	linha=imagem.readLine();
        }
        
        setImagemOriginal(new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB));
        
        for (int i = 0; i < altura; i++) {
			for (int j = 0; j < largura; j++) {
				getImagemOriginal().setRGB(i, j, Color.WHITE.getRGB());
			}
		}
        
        int maior = 0;
        for (int i = 0; i < freq.length; i++) {
			if (maior < freq[i]) {
				maior = freq[i];
			}
		}
        
        
        for (int i = 0; i < largura-1; i++) {
        	int funcao = (100*freq[i])/maior;
			for (int j = 0; j < funcao; j++) {
				try {
					getImagemOriginal().setRGB(i, altura -1 - j, Color.RED.getRGB());
				} catch (Exception e) {
					System.out.print("ERRO ");
				}				
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
		g.drawImage((Image) getImagemOriginal(), 0, 0, null);
	}

	/**
	 * @return the imagemOriginal
	 */
	public BufferedImage getImagemOriginal() {
		return imagemOriginal;
	}

	/**
	 * @param imagemOriginal the imagemOriginal to set
	 */
	public static void setImagemOriginal(BufferedImage imagemOriginal) {
		PanelAlgoritmoHistograma.imagemOriginal = imagemOriginal;
	}

}
