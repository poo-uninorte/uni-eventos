package solenidade;

import java.util.List;

/**
 *
 * @author Valde
 */
public class Minicurso extends TipoAtividade{
    private List Interessado;

    public Minicurso(String nome, String tempo) {
        super(nome, tempo);
    }

    public List informaInteressado() {
        return Interessado;
    }

    @Override
    public void gerarListaDePessoas() {
        
    }    
}
