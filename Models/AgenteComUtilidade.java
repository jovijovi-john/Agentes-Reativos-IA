package Models;

import java.util.ArrayList;
import java.util.Comparator;

public class AgenteComUtilidade extends AgenteComObjetivos {

    public AgenteComUtilidade(Mapa mapa) {
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

        // ordenar os pontos do que vale mais pro que vale menos
        this.pontos.sort((o2, o1) -> Integer.compare(o1.getPontuacao(), o2.getPontuacao()));

        System.out.print("[");
        for (Ponto ponto : this.pontos){
            System.out.print(ponto);
        }
        System.out.println("]");

        atuadores("base");

        for (Ponto ponto : this.pontos) {
            goToPonto(ponto.x, ponto.y);

            atuadores("pegar");
            atuadores("base");
        }

    }


}
