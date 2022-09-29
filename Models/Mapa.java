package Models;

import java.util.Random;

public class Mapa {
    public int linhas;
    public int colunas;
    public int[][] matriz;

    public Mapa() {
        this.linhas = 20;
        this.colunas = 20;

        this.matriz = new int[20][20];
        preencherMatriz();
        generatePoints();
    }

    public void preencherMatriz() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 0; j++) {
                this.matriz[i][j] = 0;
            }
        }
    }

    public void generatePoints() {
        // 5 pontos vermelhos que valem 10
        // 5 pontos azuis que valem 20

        Random generator = new Random();

        // se nao tiver nenhum item no ponto, então adicione o item no ponto

        for (int i = 0; i < 5; i++) {
            // preenchendo os vermelho
            boolean preenchido = false;
            while (!preenchido) {
                int cordX = generator.nextInt(20);
                int cordY = generator.nextInt(20);

                if (this.matriz[cordX][cordX] == 0) {
                    this.matriz[cordX][cordY] = 10;
                    preenchido = true;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            // preenchendo os azuis
            boolean preenchido = false;
            while (!preenchido) {
                int cordX = generator.nextInt(20);
                int cordY = generator.nextInt(20);

                if (this.matriz[cordX][cordX] == 0) {
                    this.matriz[cordX][cordY] = 20;
                    preenchido = true;
                }
            }

            // preenchendo os vermelhos
        }
    }

}
