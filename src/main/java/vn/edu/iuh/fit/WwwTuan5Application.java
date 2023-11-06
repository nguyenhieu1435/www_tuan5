package vn.edu.iuh.fit;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.backend.irepositories.IAddressRepository;
import vn.edu.iuh.fit.backend.irepositories.ICandidateRepository;
import vn.edu.iuh.fit.backend.model.Address;
import vn.edu.iuh.fit.backend.model.Candidate;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class WwwTuan5Application {

	public static void main(String[] args) {
		SpringApplication.run(WwwTuan5Application.class, args);
	}
//	@Autowired
//	private ICandidateRepository candidateRepository;
//	@Autowired
//	private IAddressRepository addressRepository;
//	@Bean
//	CommandLineRunner initData(){
//		return args -> {
//			Random rnd =new Random();
//			for (int i = 1; i < 1000; i++) {
////				Address add = new Address(rnd.nextInt(1,1000)+"","Quang Trung","HCM",
////						rnd.nextInt(70000,80000)+"", CountryCode.VN );
//				Address add = new Address(CountryCode.VN, "HCM", rnd.nextInt(70000,80000)+""
//						,"Quang Trung", rnd.nextInt(1,1000)+"");
//
//				addressRepository.save(add);
//
//				/*Candidate can=new Candidate("Name #"+i,
//						LocalDate.of(1998,rnd.nextInt(1,13),rnd.nextInt(1,29)),
//						add,
//						rnd.nextLong(1111111111L,9999999999L)+"",
//						"email_"+i+"@gmail.com");*/
//				Candidate can=new Candidate("Name #"+i,
//						rnd.nextLong(1111111111L,9999999999L)+"",
//						"email_"+i+"@gmail.com",
//						LocalDate.of(1998,rnd.nextInt(1,13),rnd.nextInt(1,29)),
//						add);
//				candidateRepository.save(can);
//				System.out.println("Added: " +can);
//			}
//		};
//	}
}
