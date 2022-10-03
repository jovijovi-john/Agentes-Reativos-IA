import Models.Agente;
import Models.AgenteGenerico;
import Models.Mapa;

import java.util.Scanner;

public class Controller {
  public Mapa mapa;
  public AgenteGenerico agente;

  public Controller(Mapa mapa, AgenteGenerico agente) throws InterruptedException {
    this.mapa = mapa;
    this.agente = agente;

    mostraMapa();
//    Thread.sleep(10000);

    while (true) {
      if (this.agente.isFinished()) {
        break;
      }

      this.agente.funcaoDoAgente();
    }

    mostraMapa();
  }

  public void mostraMapa() {
    for (int i = 0; i < mapa.linhas; i++) {
      for (int j = 0; j < mapa.colunas; j++) {

        int posicao = mapa.matriz[i][j];

        switch (posicao) {
          case 0:
            System.out.print("* ");
            break;
          case 10:
            System.out.print("\u001B[31m" + 1 + " \u001B[0m");
            break;
          case 20:
            System.out.print("\u001B[34m" + 2 + " \u001B[0m");
            break;
          default:
            System.out.println("POSIÇÃO INVÁLIDA!!!");
        }
      }
      System.out.println("\n");
    }
  }
}
