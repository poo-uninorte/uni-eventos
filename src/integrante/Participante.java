package integrante;

/**
 *
 * @author Valde
 */
public class Participante extends Pessoa{
    private boolean status = false;
    
    
    
    public Participante(String nome, String telefone, String email) {
        super(nome, telefone, email);
    }

    public boolean informaInscrito() {
        return status;
    }
    
    public void inscrever(){
        
    }
}
