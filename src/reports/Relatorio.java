package reports;

import controller.Conexao;
import java.sql.Connection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author mathe
 */
public class Relatorio {
    public void gerarRelatorio(String arquivo) {
        Connection con = Conexao.conectar();
        
        String src = "src/controller/reports/"+ arquivo +".jasper";
        
        JasperPrint jasper = null;
        
        try {
            jasper = JasperFillManager.fillReport(src, null, con);
        } catch (JRException ex) {
            System.out.println("Erro: " + ex);
        }
        
        JasperViewer view = new JasperViewer(jasper, false);
        view.setVisible(true);
    }
}
