package in.ashokit.request;

import java.time.LocalDate;

import lombok.Data;
@Data
public class SearchRequest {
	private String planNames;
	private String planStatus;
	private String gender;
	private LocalDate startDate;
	private LocalDate endDate;
}
