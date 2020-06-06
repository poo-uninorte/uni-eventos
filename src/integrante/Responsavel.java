package integrante;

/**
 *
 * @author Valde
 */
public class Responsavel extends Pessoa {
    
    public Responsavel(String nome, String telefone, String email) {
        super(nome, telefone, email);
    }
    
    public boolean confirmar(Participante participante){
        boolean status = false;
        if(participante.informaInscrito()){
            System.out.println("Participante inscrito!");
            status = true;
        } else {
            System.out.println("Participante não encontrado!");                     
        }
        return status;
    }
}
