package solenidade;

import java.util.Date;
import organizacao.EquipeOrganizadora;

/**
 *
 * @author Valde
 */
public class Evento {
    private String sigla;
    private String titulo;
    private String nome;
    private Date periodo;
    private EquipeOrganizadora equipe;

    public Evento(String sigla, String titulo, String nome, Date periodo, EquipeOrganizadora equipe) {
        this.sigla = sigla;
        this.titulo = titulo;
        this.nome = nome;
        this.periodo = periodo;
        this.equipe = equipe;
    }
    
    public String informaNome() {
        return nome;
    }

    public void modificatNome(String nome) {
        this.nome = nome;
    }

    public Date informaPeriodo() {
        return periodo;
    }

    public void modificatPeriodo(Date periodo) {
        this.periodo = periodo;
    }

    public EquipeOrganizadora informaEquipe() {
        return equipe;
    }
    
    public void totalEnvolvidos(Atividade atividade){
        atividade.gerarListaDePessoas();
    }
}
