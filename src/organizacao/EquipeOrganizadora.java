
package organizacao;

import java.util.List;

/**
 *
 * @author Valde
 */
public class EquipeOrganizadora {
    
    private List Pessoa;
    private String descricao;

    public List informaPessoa() {
        return Pessoa;
    }

    public String informaDescricao() {
        return descricao;
    }

    public EquipeOrganizadora(List Pessoa, String descricao) {
        this.Pessoa = Pessoa;
        this.descricao = descricao;
    }
        
}
