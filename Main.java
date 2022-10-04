import Models.Agente;
import Models.AgenteComModelos;
import Models.Mapa;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Mapa mapa = new Mapa();
        AgenteComModelos agente = new AgenteComModelos(mapa);

        Controller controller = new Controller(mapa, agente);
    }
}