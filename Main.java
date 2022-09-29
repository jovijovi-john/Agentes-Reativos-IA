import Models.Mapa;

public class Main {
    public static void main(String[] args) {
        Mapa mapa = new Mapa();

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {

                int posicao = mapa.matriz[i][j];

                if (posicao == 0) {
                    System.out.print("* ");
                } else if (posicao == 10) {
                    System.out.print("\u001B[31m" + posicao + "\u001B[0m");
                } else if (posicao == 20) {
                    System.out.print("\u001B[34m" + posicao + "\u001B[0m");
                }
            }
            System.out.println("\n");
        }

    }
}