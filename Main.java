import Models.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Mapa mapa = new Mapa();
        AgenteGenerico agente = new Agente(mapa);

        Controller controller = new Controller(mapa, agente);
    }
}