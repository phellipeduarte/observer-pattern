import java.util.Observable;

public class RestauranteUniversitario extends Observable {

    private String universidade;
    private String cardapioSemanal;
    private Float precoRefeicao;

    public RestauranteUniversitario(String universidade, Float precoRefeicao) {
        this.universidade = universidade;
        this.precoRefeicao = precoRefeicao;
    }

    public void atualizarCardapioSemana(String proteina, String opcaoVegetariana, String acompanhamento){
        this.cardapioSemanal = "proteina: " + proteina + "\n" + "opção vegetariana: " + opcaoVegetariana +"\n" + "acompanhamento: " + acompanhamento;
        setChanged();
        notifyObservers(this.cardapioSemanal);
    }
}
