package in.ashokit.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import in.ashokit.entity.CitizenPlan;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class PdfGenerator {
	public void generatePdf(HttpServletResponse response,List<CitizenPlan> plans,File file)throws Exception {
		Document document=new Document(PageSize.A4);
		 PdfWriter.getInstance(document, response.getOutputStream());
		 PdfWriter.getInstance(document,new FileOutputStream(file));
		
		document.open();
		Paragraph p=new Paragraph("citizen plan info");
		PdfPTable table=new PdfPTable(6);
		table.addCell("ID");
		table.addCell("Citizen Name");
		table.addCell("Plan name");
		table.addCell("Plan Satus");
		table.addCell("Plan Start DAte");
		table.addCell("Plan End DAte");
		//List<CitizenPlan> findAll = repo.findAll();
		for(CitizenPlan plan:plans) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanNames());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getPlanStartDate()+"");
			table.addCell(plan.getPlanEndDate()+"");
		}
		
		
		document.add(p);
		document.add(table);
		document.close();
	}
}
