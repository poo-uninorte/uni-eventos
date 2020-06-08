
package organizacao;

import java.util.List;

/**
 *
 * @author Valde
 */
public class EquipeOrganizadora {
    
    private List Pessoa;
    private String descricao;


    public String informaDescricao() {
        return descricao;
    }

    public List informaPessoa() {
        return Pessoa;
    }

    public EquipeOrganizadora(List Pessoa, String descricao) {
        this.Pessoa = Pessoa;
        this.descricao = descricao;
    }
       
}
