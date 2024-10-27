package pe.edu.cibertec.lp2final;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.cibertec.lp2final.bd.MySQLDataSource;

@SpringBootApplication
public class SpringProjectLp2finalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectLp2finalApplication.class, args);
	}
	
	@RequestMapping(value = "/AlumnoReport", method = RequestMethod.GET)
	public void personaReporte(HttpServletResponse response) throws JRException, IOException {
		System.out.println("Generando reporte...");
		
		InputStream is = this.getClass().getResourceAsStream("/ReporteAlumno.jasper");
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		JasperReport jasperReport = (JasperReport)JRLoader.loadObject(is);
		
		Connection con = MySQLDataSource.getMySQLConnection();
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);
		
		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "inline; filename=alumnoreport.pdf");
		
		OutputStream outputStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	}

}
