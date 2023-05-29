import java.util.Observable;
import java.util.Observer;

public class Aluno implements Observer {

    private String nome;
    private String matricula;
    private String ultimaNotificacaoCardapio = "Não possui notificações";

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getUltimaNotificacaoCardapio(){ return this.ultimaNotificacaoCardapio; }

    public void emitirCarteirinha(RestauranteUniversitario restauranteUniversitario){ restauranteUniversitario.addObserver(this); }

    @Override
    public void update(Observable o, Object arg) {
        this.ultimaNotificacaoCardapio = "Cardápio Semanal: \n" + arg;
    }
}
