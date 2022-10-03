import Models.Agente;
import Models.Mapa;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Mapa mapa = new Mapa();
        Agente agente = new Agente(mapa);

        Controller controller = new Controller(mapa, agente);

    }
}