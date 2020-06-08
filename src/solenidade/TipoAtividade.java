package solenidade;

import integrante.Responsavel;
import java.util.ArrayList;

/**
 *
 * @author Valde
 */
public abstract class TipoAtividade implements Atividade{
    private String nome;
    private String tempo;
    private ArrayList<Responsavel> listaDeResponsavel;

    public TipoAtividade(String nome, String tempo) {
        this.nome = nome;
        this.tempo = tempo;
        listaDeResponsavel = new ArrayList();
    }
    
    public void AdicionarResponsavel(Responsavel R){
        listaDeResponsavel.add(R);
    }
}
