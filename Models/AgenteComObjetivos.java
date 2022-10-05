package Models;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenteComObjetivos extends AgenteComModelos{

    protected ArrayList<Ponto> pontos;

    public AgenteComObjetivos(Mapa mapa) {
        super(mapa);
        this.ultimoY = 0;
        this.ultimoX = 0;
        this.pontos = new ArrayList<Ponto>();
    }

    @Override
    public void funcaoDoAgente(){
        int i = 0;
        while (this.pontos.size() != this.mapa.qntdPontos) {
            preencherArrayDePontos();
        }

        atuadores("base");

        for (Ponto ponto : this.pontos) {
            goToPonto(ponto.x, ponto.y);

            atuadores("pegar");
            atuadores("base");
        }

    }


    public void preencherArrayDePontos(){
        System.out.println("Andando normalmente. Agente na posição (" + this.x + ", " + this.y + ")");
        if (!hasItem()) {
            andarNormalmente();
        } else {
            System.out.println("Achei um item na posição (" + this.x + ", " + this.y +  ")");

            int pontuacao = this.mapa.matriz[this.x][this.y];
            Ponto ponto = new Ponto(this.x, this.y, pontuacao);
            this.pontos.add(ponto);

            andarNormalmente();
            System.out.println("Ja tenho " + this.pontos.size() + " pontos");
        };
    }

    @Override
    public void andarNormalmente(){
        if (this.x % 2 == 0) {
            if (this.y >= this.mapa.colunas - 1) {
                this.atuadores("baixo");
            } else {
                this.atuadores("direita");
            }
        } else {
            if (y > 0) {
                this.atuadores("esquerda");
            } else {
                this.atuadores("baixo");
            }
        }
    }
}
