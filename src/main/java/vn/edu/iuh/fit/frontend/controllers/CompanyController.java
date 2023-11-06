package vn.edu.iuh.fit.frontend.controllers;

import com.neovisionaries.i18n.CountryCode;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.backend.irepositories.IAddressRepository;
import vn.edu.iuh.fit.backend.irepositories.ICompanyRepository;
import vn.edu.iuh.fit.backend.irepositories.IJobRepository;
import vn.edu.iuh.fit.backend.model.*;

@Controller
@RequestMapping("/companys")
public class CompanyController {
    private IAddressRepository addressRepository;
    private ICompanyRepository companyRepository;
    private IJobRepository jobRepository;
    @Autowired
    public CompanyController(IAddressRepository addressRepository, ICompanyRepository companyRepository, IJobRepository jobRepository) {
        this.addressRepository = addressRepository;
        this.companyRepository = companyRepository;
        this.jobRepository = jobRepository;
    }

    @PostMapping("/add-company")
    public String addCompany(@ModelAttribute("company") Company company){
        addressRepository.save(company.getAddress());
        companyRepository.save(company);
        return "redirect:/";
    }
    @GetMapping("/sign-up")
    public ModelAndView signUp(Model model){
        ModelAndView modelAndView = new ModelAndView();
        Company company = new Company();
        company.setAddress(new Address());
        modelAndView.addObject("company", company);
        modelAndView.addObject("address", company.getAddress());
        modelAndView.addObject("countries", CountryCode.values());
        modelAndView.setViewName("company_actions/signup_company");
        return modelAndView;
    }
    @PostMapping("/post-job")
    public String postJob(@ModelAttribute("job") Job job, HttpServletRequest request){
        Company company = (Company) request.getSession().getAttribute("companyLogin");
        job.setCompany(company);
        jobRepository.save(job);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return "redirect:/jobs/getAllByCompany";
    }
    @GetMapping("/openPostJob")
    public ModelAndView postJob(){
        ModelAndView modelAndView = new ModelAndView();
        Job job = new Job();

        modelAndView.addObject("job", job);
        modelAndView.setViewName("company_actions/post_job");
        return modelAndView;
    }

}
