package Models;

public class AgenteComModelos extends Agente{

    private int ultimoX;
    private int ultimoY;

    public AgenteComModelos(Mapa mapa) {
        super(mapa);
        this.ultimoY = 0;
        this.ultimoX = 0;
    }

    @Override
    public void funcaoDoAgente() throws InterruptedException {
//    Thread.sleep(200);

        if (this.ultimoY == 0 && this.ultimoX == 0) {
            andarNormalmente();
        } else {
            if (!hasItem()) {
                goToPonto(this.ultimoX, this.ultimoY);
                this.ultimoX = 0;
                this.ultimoY = 0;
            }
        }
    }

    public void andarNormalmente(){
        if (!hasItem()) {
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
        } else {
            this.atuadores("pegar");
            this.atuadores("base");
        };
    }

    @Override
    public void takeItem() {

        this.hasItem = true;
        this.score += mapa.matriz[x][y];
        mapa.matriz[x][y] = 0;

        System.out.println("peguei");
        System.out.println("pontuacao: " + this.score);

        this.ultimoX = this.x;
        this.ultimoY = this.y;

        mostraMapa();
    }

    private void goToPonto(int x, int y) {

        while (this.x != x) {
            this.irParaBaixo();
        }

        while (this.y != y) {
            System.out.println("Indo para direita");
            this.irParaDireita();
        }
    }

}
