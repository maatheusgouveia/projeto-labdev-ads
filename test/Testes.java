
import controller.Conexao;
import controller.UsuarioDAO;

public class Testes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexao.conectar();
        Conexao.desconectar();
    }
    
}
