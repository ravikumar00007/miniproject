package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.request.SearchRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface IReportService {

	public String saveCitizen(List<CitizenPlan> info);

	public List<String> getPlanName();

	public List<String> getPlanStatus();

	public boolean exportExcel(HttpServletResponse response) throws Exception;

	public boolean exportPdf(HttpServletResponse response) throws Exception;

	public List<CitizenPlan> serchRequest(SearchRequest request);
}
