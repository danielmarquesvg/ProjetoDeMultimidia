package algoritmos;

public class PanelAlgoritmoEqualizar {

	public static int[][] equalizarImagem(int matrizDaImagemOriginal [][]){
		
		/*
		 * Posicao [i][0] - K 	- Nivel de Cinza
		 * Posicao [i][1] - nK 	- Frequência em que o nível de cinza se repete
		 * Posicao [i][2] - rK 	- Valor do pixel dividido pelo valor maximo do pixel (255)
		 * Posicao [i][3] - Pr(rK) - Probabilidade de rK (nK dividido pela quantidade de pixels da imagem)
		 * Posicao [i][4] - SK 	- Soma acumulada de Pr(rK)
		 * Posicao [i][5] - Round (255 * SK) - Arredondamento da multiplicacao do valor maximo do pixel pelo valor de SK
		 */
		
		float [][] matrizDeEqualizacao = new float[255][6];
		int [][] matrizResultado = new int [matrizDaImagemOriginal.length][matrizDaImagemOriginal[0].length];
		
		//inicializando o nível de cinza e a frequência dos níveis de cinza
		for (int i = 0; i < matrizDeEqualizacao.length; i++) {
			matrizDeEqualizacao[i][0] = 1000;
			matrizDeEqualizacao[i][1] = 0;
		}
		
		//Inserindo os níveis de cinza, incrementando as suas frequências de repetições e calculando rK (valor do pixel / 255)
		for (int i = 0; i < matrizResultado.length; i++) {
			for (int j = 0; j < matrizResultado.length; j++) {
				matrizDeEqualizacao[matrizDaImagemOriginal[i][j]][0] = matrizDaImagemOriginal[i][j];
				matrizDeEqualizacao[matrizDaImagemOriginal[i][j]][1] += 1;
				matrizDeEqualizacao[matrizDaImagemOriginal[i][j]][2] = matrizDaImagemOriginal[i][j] / 255;
			}
		}
		/*
		for (int i = 0; i < matrizDaImagemOriginal.length; i++) {
			for (int j = 0; j < matrizDaImagemOriginal.length; j++) {
				System.out.print(matrizDaImagemOriginal[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("\n");
		
		for (int i = 0; i < matrizDeEqualizacao.length; i++) {
			System.out.println("Nível de Cinza = "+matrizDeEqualizacao[i][0]);
			System.out.println("Frequência do Nível de Cinza = "+matrizDeEqualizacao[i][1]);
			System.out.println("Valor de rk: "+matrizDeEqualizacao[i][2]);
			System.out.println();
		}
		
		System.out.println("\n");
		*/
		matrizDeEqualizacao = ordenarMatriz(matrizDeEqualizacao);
		/*
		for (int i = 0; i < matrizDeEqualizacao.length; i++) {
			System.out.println("Nível de Cinza = "+matrizDeEqualizacao[i][0]);
			System.out.println("Frequência do Nível de Cinza = "+matrizDeEqualizacao[i][1]);
			System.out.println("Valor de rk: "+matrizDeEqualizacao[i][2]);
			System.out.println();
		}
		*/
		
		//calculando Pr(rk)
		int contador = 0;
		while(matrizDeEqualizacao[contador][0] != 1000){
			
			//frequencia do pixel dividido pela quantidade de pixels
			matrizDeEqualizacao[contador][3] = matrizDeEqualizacao[contador][1] / (255*255);
			contador = contador + 1;
		}
		
		//calculando Sk - Soma acumulada de Pr(rk)
		contador = 0;
		while(matrizDeEqualizacao[contador][0] != 1000){
			
			if(contador == 0){
				matrizDeEqualizacao[contador][4] = matrizDeEqualizacao[contador][3];
			} else {
				matrizDeEqualizacao[contador][4] = matrizDeEqualizacao[contador][3] + matrizDeEqualizacao[contador - 1][4];
			}
			contador = contador + 1;
		}
		
		//calculando Round(255 * Sk)
		contador = 0;
		while(matrizDeEqualizacao[contador][0] != 1000){
			matrizDeEqualizacao[contador][5] = (int)Math.round(255 * matrizDeEqualizacao[contador][4]);
			if(matrizDeEqualizacao[contador][5] > 255){
				matrizDeEqualizacao[contador][5] = 255;
			}
			contador = contador + 1;
		}
		
		//printando a matriz original
		for (int i = 0; i < matrizDaImagemOriginal.length; i++) {
			for (int j = 0; j < matrizDaImagemOriginal.length; j++) {
				System.out.print(matrizDaImagemOriginal[i][j]+" ");
			}
			System.out.println();
		}
		
		//printando a tabela do excel
		System.out.println("\n");
		System.out.print("K\t\tNk\t\trK\t\tPr(rk)\t\t\tSk\t\tRound(255 * sk)\n");
		contador = 0;
		while(matrizDeEqualizacao[contador][0] != 1000){
			System.out.print(matrizDeEqualizacao[contador][0]+"\t\t"+matrizDeEqualizacao[contador][1]+"\t\t"+
					matrizDeEqualizacao[contador][2]+"\t\t"+matrizDeEqualizacao[contador][3]+"\t\t"+
					matrizDeEqualizacao[contador][4]+"\t\t"+matrizDeEqualizacao[contador][5]+"\t\t\n");
			contador = contador + 1;
		}
		
		
		for (int i = 0; i < matrizDaImagemOriginal.length; i++) {
			for (int j = 0; j < matrizDaImagemOriginal[0].length; j++) {
				
				int valorDoPixel = matrizDaImagemOriginal[i][j];
				int contador2 = 0;
				
				while(matrizDeEqualizacao[contador2][0] != valorDoPixel){
					contador2 = contador2 + 1;
				}
				
				matrizResultado[i][j] = (int)matrizDeEqualizacao[contador2][5];
				
			}
			
		}
		/*
		//printando a matriz resultado (matriz equalizada)
		for (int i = 0; i < matrizResultado.length; i++) {
			for (int j = 0; j < matrizResultado.length; j++) {
				System.out.print(matrizResultado[i][j]+" ");
			}
			System.out.println();
		}
		*/

		return matrizResultado;
	}
	
	public static float [][] ordenarMatriz(float matrizDeEqualizacao [][]){
		
		boolean houveTroca = true;
		while(houveTroca == true){
			houveTroca = false;
			
			for (int i = 0; i < matrizDeEqualizacao.length - 1; i++) {
				if(matrizDeEqualizacao[i][0] > matrizDeEqualizacao[i+1][0]){
					float variavelAuxiliar0, variavelAuxiliar1, variavelAuxiliar2, variavelAuxiliar3;
					
					variavelAuxiliar0 = matrizDeEqualizacao[i][0];
					variavelAuxiliar1 = matrizDeEqualizacao[i][1];
					variavelAuxiliar2 = matrizDeEqualizacao[i][2];
					variavelAuxiliar3 = matrizDeEqualizacao[i][3];
					
					matrizDeEqualizacao[i][0] = matrizDeEqualizacao[i+1][0];
					matrizDeEqualizacao[i][1] = matrizDeEqualizacao[i+1][1];
					matrizDeEqualizacao[i][2] = matrizDeEqualizacao[i+1][2];
					matrizDeEqualizacao[i][3] = matrizDeEqualizacao[i+1][3];
					
					matrizDeEqualizacao[i+1][0] = variavelAuxiliar0;
					matrizDeEqualizacao[i+1][1] = variavelAuxiliar1;
					matrizDeEqualizacao[i+1][2] = variavelAuxiliar2;
					matrizDeEqualizacao[i+1][3] = variavelAuxiliar3;
					
					houveTroca = true;
					
				}
			}
			
		}
		
		return matrizDeEqualizacao;
	}

}
