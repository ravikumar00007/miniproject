package in.ashokit.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepository;
import in.ashokit.request.SearchRequest;
import in.ashokit.util.EmailUtils;
import in.ashokit.util.ExcelGenerator;
import in.ashokit.util.PdfGenerator;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements IReportService {
	@Autowired
	private CitizenPlanRepository repo;
	@Autowired
	private ExcelGenerator generator;
	@Autowired
	private PdfGenerator pdfGenerator;
	@Autowired
	private EmailUtils email;
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
		File f=new File("plans.xls");
		List<CitizenPlan> plan = repo.findAll();
		generator.excelGenerator(response, plan,f);
		String sendEmail = email.sendEmail("<h2>excel downloaded</h2>", "ravikr2592@gmail.com", f);
		System.out.println(sendEmail);
		f.delete();
		
		return true;
	
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		List<CitizenPlan> findAll = repo.findAll();
		File f=new File("plans.pdf");
		pdfGenerator.generatePdf(response, findAll, f);
		String sendEmail = email.sendEmail("<h2>pdf downloaded</h2>", "ravikr2592@gmail.com", f);
		f.delete();
		return true;
	}

	

}
