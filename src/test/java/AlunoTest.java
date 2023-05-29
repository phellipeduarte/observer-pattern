import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {

    @Test
    void deveNotificarCardapioAluno(){

        RestauranteUniversitario restaurante = new RestauranteUniversitario("UFJF", 1.90f);
        Aluno aluno = new Aluno("Phellipe", "123");

        aluno.emitirCarteirinha(restaurante);
        restaurante.atualizarCardapioSemana("Strogonoff de Frango", "Strogonoff de Palmito", "Arroz Branco");

        String resposta = "Cardápio Semanal: \nproteina: Strogonoff de Frango\nopção vegetariana: Strogonoff de Palmito\nacompanhamento: Arroz Branco";

        assertEquals(resposta, aluno.getUltimaNotificacaoCardapio());
    }

    @Test
    void naoDeveNotificarAluno(){

        RestauranteUniversitario restaurante = new RestauranteUniversitario("UFJF", 1.90f);
        Aluno aluno = new Aluno("Phellipe", "123");

        restaurante.atualizarCardapioSemana("Strogonoff de Frango", "Strogonoff de Palmito", "Arroz Branco");

        String resposta = "Não possui notificações";

        assertEquals(resposta, aluno.getUltimaNotificacaoCardapio());

    }

    @Test
    void deveNotificarCardapioAlunos(){

        RestauranteUniversitario restaurante = new RestauranteUniversitario("UFJF", 1.90f);
        Aluno aluno1 = new Aluno("Phellipe", "123");
        Aluno aluno2 = new Aluno("Jão", "456");

        aluno1.emitirCarteirinha(restaurante);
        aluno2.emitirCarteirinha(restaurante);

        restaurante.atualizarCardapioSemana("Strogonoff de Frango", "Strogonoff de Palmito", "Arroz Branco");

        String resposta = "Cardápio Semanal: \nproteina: Strogonoff de Frango\nopção vegetariana: Strogonoff de Palmito\nacompanhamento: Arroz Branco";

        assertEquals(resposta, aluno1.getUltimaNotificacaoCardapio(), aluno2.getUltimaNotificacaoCardapio());
    }

    @Test
    void deveNotificarApenasAlunoCarteirinha(){

        RestauranteUniversitario restaurante = new RestauranteUniversitario("UFJF", 1.90f);
        Aluno aluno1 = new Aluno("Phellipe", "123");
        Aluno aluno2 = new Aluno("Jão", "456");

        aluno1.emitirCarteirinha(restaurante);

        restaurante.atualizarCardapioSemana("Strogonoff de Frango", "Strogonoff de Palmito", "Arroz Branco");

        String resposta1 = "Cardápio Semanal: \nproteina: Strogonoff de Frango\nopção vegetariana: Strogonoff de Palmito\nacompanhamento: Arroz Branco";
        String resposta2 = "Não possui notificações";

        assertEquals(resposta1, aluno1.getUltimaNotificacaoCardapio());
        assertEquals(resposta2, aluno2.getUltimaNotificacaoCardapio());
    }
}
