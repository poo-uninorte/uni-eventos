package integrante;

/**
 *
 * @author Valde
 */
public abstract class Pessoa {
    private String nome;
    private String telefone;
    private String email;

    public Pessoa(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String informaNome() {
        return nome;
    }

    public void modificaNome(String nome) {
        this.nome = nome;
    }

    public String informaTelefone() {
        return telefone;
    }

    public void modificaTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String informaEmail() {
        return email;
    }

    public void modificaEmail(String email) {
        this.email = email;
    }
    
    
}
