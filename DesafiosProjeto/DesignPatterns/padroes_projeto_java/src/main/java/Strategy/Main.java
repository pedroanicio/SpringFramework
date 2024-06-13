package Strategy;
//simplificar a variação de algorítmos para a resolução
//de um mesmo problema
public class Main {
    public static void main(String[] args) {
        Comportamento normal = new ComportamentoNormal();

        Comportamento agressivo = new ComportamentoAgressivo();

        Comportamento defensivo = new ComportamentoDefensivo();

        Robo robo = new Robo();
        robo.setComportamento(normal);

        robo.mover();
        robo.mover();

        robo.setComportamento(defensivo);

        robo.mover();
        robo.mover();
    }
}
