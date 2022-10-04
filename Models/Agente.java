package Models;

import java.io.*;
import java.lang.Thread;

public class Agente implements AgenteGenerico {

  public int x;
  public int y;
  public int score;
  public Mapa mapa;

  protected boolean hasItem;
  protected boolean finished;

  public Agente(Mapa mapa) {
    this.mapa = mapa;
    this.hasItem = false;
    this.finished = false;
  }

  @Override
  public void funcaoDoAgente() throws InterruptedException {
//    Thread.sleep(200);

    if (!hasItem()) {
      if (this.x % 2 == 0) {
        if (this.y >= this.mapa.colunas - 1) {
          atuadores("baixo");
        } else {
          atuadores("direita");
        }
      } else {
        if (y > 0) {
          atuadores("esquerda");
        } else {
          atuadores("baixo");
        }
      }
    } else {
      atuadores("pegar");
      atuadores("base");
    };
  }

  @Override
  public void atuadores(String acao) {
    System.out.println("Atuadores: Posição do agente: " + x +  "," + y);
    switch (acao) {

      case "base":
        voltarParaBase();
        break;

      case "cima":
        irParaCima();
        break;

      case "esquerda":
        irParaEsquerda();
        break;

      case "direita":
        irParaDireita();
        break;

      case "baixo":
        irParaBaixo();
        break;

      case "pegar":
        takeItem();
        isFinished();
        break;

      default:
        System.out.println("Ação não identificada!");
        break;
    }

  }

  public void irParaCima() {
    if (this.x > 0) {
      this.x -= 1;
    }
  }

  public void irParaBaixo() {
    System.out.println("baixo");
    if (this.x + 1 < this.mapa.linhas) {
      this.x += 1;
    }
  }

  public void irParaEsquerda() {
    if (this.y - 1 >= 0) {
      this.y -= 1;
    }
  }

  public void irParaDireita() {
    if (this.y + 1 < this.mapa.colunas) {
      this.y += 1;
    }
  }

  public void voltarParaBase() {

    System.out.println("Voltando para base");

    while (this.y != 0) {
      System.out.println("Posição do agente: " + x +  "," + y);
      irParaEsquerda();
    }

    while (this.x != 0) {
      System.out.println("Posição do agente: " + x +  "," + y);
      irParaCima();
    }

    this.hasItem = false;
  }

  public boolean hasItem() {

    if (mapa.matriz[x][y] > 0 && !this.hasItem) {
      System.out.println("tem Item");
      return true;
    }

    return false;
  }

  public void takeItem() {


    this.hasItem = true;
    this.score += mapa.matriz[x][y];
    mapa.matriz[x][y] = 0;


    System.out.println("peguei");
    System.out.println("pontuacao: " + this.score);


    mostraMapa();
  }

  @Override
  public boolean isFinished() {
    if (this.score == 150) {
      finish();
      return true;
    }

    return false;
  }

  public void finish() {
      this.finished = true;
      System.out.println("finalizado");
      System.out.println("Pontuação: " +  this.score);
  }

  public void mostraMapa() {
    for (int i = 0; i < mapa.linhas; i++) {
      for (int j = 0; j < mapa.colunas; j++) {

        int posicao = mapa.matriz[i][j];

        if (i == this.x && j == this.y) {
          System.out.print("\u001B[32m" + "A" + " \u001B[0m");
          continue;
        }

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