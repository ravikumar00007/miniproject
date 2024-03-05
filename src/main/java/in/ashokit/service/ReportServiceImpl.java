package in.ashokit.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepository;
import in.ashokit.request.SearchRequest;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements IReportService {
	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public String saveCitizen(List<CitizenPlan> list) {
		repo.saveAll(list);
		return "citizen is registered";
	}

	@Override
	public List<String> getPlanName() {
		List<String> planName = repo.getPlanNames();
		return planName;
	}

	@Override
	public List<String> getPlanStatus() {
		List<String> planStatus = repo.getPlanStatus();
		return planStatus;
	}

	@Override
	public List<CitizenPlan> serchRequest(SearchRequest request) {
		CitizenPlan cp = new CitizenPlan();
		if (null != request.getPlanNames()   && !"".equals(request.getPlanNames()))
			cp.setPlanNames(request.getPlanNames());
		if (null != request.getPlanStatus()  && !"".equals(request.getPlanStatus()))
			cp.setPlanStatus(request.getPlanStatus());
		if (null != request.getGender()  && !"".equals(request.getGender()))
			cp.setGender(request.getGender());
		if (null != request.getStartDate()  && !"".equals(request.getStartDate())) {
			
			cp.setPlanStartDate(request.getStartDate());
		}
		if (null != request.getEndDate()  && !"".equals(request.getEndDate())) {
		
		cp.setPlanEndDate(request.getEndDate());
		}
		
		List<CitizenPlan> findAll = repo.findAll(Example.of(cp));
		//findAll.forEach(System.out::println);
		return findAll;
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		
		
		Workbook workbook=new HSSFWorkbook();
		Sheet sheet=workbook.createSheet("plans-data");
		Row headerRow= sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Plan Name");
		headerRow.createCell(3).setCellValue("Plan Status");
		headerRow.createCell(4).setCellValue("Plan Start Date");
		headerRow.createCell(5).setCellValue("Plan End Date");
		headerRow.createCell(6).setCellValue("Benifit Amount");
		List<CitizenPlan> records = repo.findAll();
		int i=1;
		for(CitizenPlan plan:records){
		
			Row dataRow= sheet.createRow(i);
			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getPlanNames());
			dataRow.createCell(3).setCellValue(plan.getPlanStatus());
			dataRow.createCell(4).setCellValue(plan.getPlanStartDate());
			dataRow.createCell(5).setCellValue(plan.getPlanEndDate());
			if(null!=plan.getBenifitAmount()) {
				dataRow.createCell(6).setCellValue(plan.getBenifitAmount());
			}
			else { 
				dataRow.createCell(6).setCellValue("N/A");}
			i++;
		}
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		Paragraph p=new Paragraph("citizen plan info");
		PdfPTable table=new PdfPTable(6);
		table.addCell("ID");
		table.addCell("Citizen Name");
		table.addCell("Plan name");
		table.addCell("Plan Satus");
		table.addCell("Plan Start DAte");
		table.addCell("Plan End DAte");
		List<CitizenPlan> findAll = repo.findAll();
		for(CitizenPlan plan:findAll) {
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
		
		return true;
	}

	

}
