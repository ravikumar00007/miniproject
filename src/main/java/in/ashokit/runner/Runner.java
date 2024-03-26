package in.ashokit.runner;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepository;
import in.ashokit.service.ReportServiceImpl;

@Component
public class Runner implements ApplicationRunner {

	@Autowired
	private ReportServiceImpl service;
	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// cash plan data
		repo.deleteAll();
		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("rajesh");
		c1.setGender("male");
		c1.setPlanNames("cash");
		c1.setPlanStatus("approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(2));
		c1.setBenifitAmount(5000.0);
		//
		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("subah");
		c2.setGender("female");
		c2.setPlanNames("cash");
		c2.setPlanStatus("approved");
		c2.setPlanStartDate(LocalDate.now());
		c2.setPlanEndDate(LocalDate.now().plusMonths(2));
		c2.setBenifitAmount(54000.0);

		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("kiran");
		c3.setGender("female");
		c3.setPlanNames("cash");
		c3.setPlanStatus("terminated");
		c3.setTerminationDate(LocalDate.now().plusMonths(4));
		c3.setTerminationReason("Employeed");

		CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("kalyani");
		c4.setGender("female");
		c4.setPlanNames("food");
		c4.setPlanStatus("approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(4));
		c4.setBenifitAmount(54000.0);

		CitizenPlan c5 = new CitizenPlan();
		c5.setCitizenName("priyanka");
		c5.setGender("female");
		c5.setPlanNames("food");
		c5.setPlanStatus("terminated");
		c5.setPlanStartDate(LocalDate.now());
		c5.setPlanEndDate(LocalDate.now().plusMonths(6));
		c5.setBenifitAmount(54000.0);

		CitizenPlan c6 = new CitizenPlan();
		c6.setCitizenName("mangru");
		c6.setGender("male");
		c6.setPlanNames("medical");
		c6.setPlanStatus("approved");
		c6.setPlanStartDate(LocalDate.now());
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBenifitAmount(54000.0);

		CitizenPlan c7 = new CitizenPlan();
		c7.setCitizenName("david");
		c7.setGender("male");
		c7.setPlanNames("medical");
		c7.setPlanStatus("terminated");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(8));
		c7.setBenifitAmount(54000.0);

		CitizenPlan c8 = new CitizenPlan();
		c8.setCitizenName("peter");
		c8.setGender("male");
		c8.setPlanNames("medical");
		c8.setPlanStatus("terminated");
		c8.setPlanStartDate(LocalDate.now());
		c8.setPlanEndDate(LocalDate.now().plusMonths(6));
		c8.setTerminationReason("employee");

		CitizenPlan c9 = new CitizenPlan();
		c9.setCitizenName("john");
		c9.setGender("male");
		c9.setPlanNames("food");
		c9.setPlanStatus("approved");
		c9.setPlanStartDate(LocalDate.now());
		c9.setPlanEndDate(LocalDate.now().plusMonths(9));
		c9.setBenifitAmount(54000.0);

		CitizenPlan c10 = new CitizenPlan();
		c10.setCitizenName("didu");
		c10.setGender("female");
		c10.setPlanNames("medical");
		c10.setPlanStatus("approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c10.setBenifitAmount(54000.0);

		CitizenPlan c11 = new CitizenPlan();
		c11.setCitizenName("jack");
		c11.setGender("male");
		c11.setPlanNames("food");
		c11.setPlanStatus("approved");
		c11.setPlanStartDate(LocalDate.now());
		c11.setPlanEndDate(LocalDate.now().plusMonths(9));
		c11.setBenifitAmount(54000.0);

		CitizenPlan c12 = new CitizenPlan();
		c12.setCitizenName("virendra");
		c12.setGender("male");
		c12.setPlanNames("cash");
		c12.setPlanStatus("terminated");
		c12.setPlanStartDate(LocalDate.now());
		c12.setPlanEndDate(LocalDate.now().plusMonths(9));
		c12.setTerminationReason("gov employee");
		
		CitizenPlan c13 = new CitizenPlan();
		c13.setCitizenName("sadhna");
		c13.setGender("female");
		c13.setPlanNames("cash");
		c13.setPlanStatus("terminated");
		c13.setPlanStartDate(LocalDate.now());
		c13.setPlanEndDate(LocalDate.now().plusMonths(9));
		c13.setTerminationReason("gov employee");
		
		CitizenPlan c14 = new CitizenPlan();
		c14.setCitizenName("rajnandani");
		c14.setGender("female");
		c14.setPlanNames("food");
		c14.setPlanStatus("terminated");
		c14.setPlanStartDate(LocalDate.now());
		c14.setPlanEndDate(LocalDate.now().plusMonths(9));
		c14.setTerminationReason("gov employee");
		
		CitizenPlan c15 = new CitizenPlan();
		c15.setCitizenName("ravi");
		c15.setGender("male");
		c15.setPlanNames("cash");
		c15.setPlanStatus("terminated");
		c15.setPlanStartDate(LocalDate.now());
		c15.setPlanEndDate(LocalDate.now().plusMonths(9));
		c15.setTerminationReason("gov employee");
		
		CitizenPlan c16 = new CitizenPlan();
		c15.setCitizenName("swastika");
		c15.setGender("female");
		c15.setPlanNames("cash");
		c15.setPlanStatus("terminated");
		c15.setPlanStartDate(LocalDate.now());
		c15.setPlanEndDate(LocalDate.now().plusMonths(9));
		c15.setTerminationReason("gov employee");

		List<CitizenPlan> list = List.of(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15);
		String str = service.saveCitizen(list);
		System.out.println(str);

	}

}
