package in.ashokit.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.request.SearchRequest;
import in.ashokit.service.ReportServiceImpl;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {
	@Autowired
	private ReportServiceImpl service;
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception{
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment;filename=plans.pdf");
		service.exportPdf(response);
	}
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception{
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename=plans.xls");
		service.exportExcel(response);
	}
	@GetMapping("/")
	public String showReport(Map<String, Object> map) {
		map.put("serchRequest", new SearchRequest());
		init(map);
		return "index";
	}


	private void init(Map<String, Object> map) {
		//map.put("serchRequest", new SearchRequest());
		map.put("planNames", service.getPlanName());
		map.put("planStatus", service.getPlanStatus());
	}
	
	
	@PostMapping("/search")
	public String serchReport(Map<String,Object> map, @ModelAttribute("serchRequest")SearchRequest request) {
		System.out.println(request);
		
		List<CitizenPlan> list = service.serchRequest(request);
		map.put("list", list);
		init(map);
		return "index";
	}
	@InitBinder
	public void myDateBinder(WebDataBinder binder) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,true));
	}

}
