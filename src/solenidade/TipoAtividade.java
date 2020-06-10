package solenidade;

import integrante.Participante;
import integrante.Responsavel;
import java.util.ArrayList;

/**
 *
 * @author Valde
 */
public abstract class TipoAtividade implements Atividade{
    private String nome;
    private String tempo;
    private ArrayList<Responsavel> listaDeResponsaveis;
    private ArrayList<Participante> listaDeParticipantes;

    public TipoAtividade(String nome, String tempo) {
        this.nome = nome;
        this.tempo = tempo;
        listaDeResponsaveis = new ArrayList();
        listaDeParticipantes = new ArrayList();
    }
    
    public void AdicionarResponsavel(Responsavel R){
        listaDeResponsaveis.add(R);
    }
    
    public void AdicionarParticipante(Participante P){
        listaDeParticipantes.add(P);
    }
    
    
}
