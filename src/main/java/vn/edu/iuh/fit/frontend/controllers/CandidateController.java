package vn.edu.iuh.fit.frontend.controllers;

import com.neovisionaries.i18n.CountryCode;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.backend.irepositories.IAddressRepository;
import vn.edu.iuh.fit.backend.irepositories.ICandidateRepository;
import vn.edu.iuh.fit.backend.irepositories.IJobRepository;
import vn.edu.iuh.fit.backend.model.Address;
import vn.edu.iuh.fit.backend.model.Candidate;
import vn.edu.iuh.fit.backend.model.Company;
import vn.edu.iuh.fit.backend.model.Job;

import java.util.List;

@Controller
@RequestMapping("/candidates")
public class CandidateController {
    private ICandidateRepository candidateRepository;
    private IAddressRepository addressRepository;
    private IJobRepository jobRepository;
    @Autowired
    public CandidateController(ICandidateRepository candidateRepository, IAddressRepository addressRepository
            , IJobRepository jobRepository) {
        this.candidateRepository = candidateRepository;
        this.addressRepository = addressRepository;
        this.jobRepository = jobRepository;
    }
    @PostMapping("/add-candidate")
    public String addCandidate(@ModelAttribute("candidate") Candidate candidate){
        addressRepository.save(candidate.getAddress());
        candidateRepository.save(candidate);
        return "redirect:/";
    }
    @GetMapping("/sign-up")
    public ModelAndView signUp(Model model){
        ModelAndView modelAndView = new ModelAndView();
        Candidate candidate = new Candidate();
        candidate.setAddress(new Address());
        modelAndView.addObject("candidate", candidate);
        modelAndView.addObject("address", candidate.getAddress());
        modelAndView.addObject("countries", CountryCode.values());

        modelAndView.setViewName("candidate_actions/signup_candidate");
        return modelAndView;
    }
    @GetMapping("/findCadidateMatchWithJobsOfCompany")
    public ModelAndView findCadidateMatchWithJobsOfCompany(HttpServletRequest request){
        Company company = (Company) request.getSession().getAttribute("companyLogin");
        List<Job> jobs = jobRepository.findAllByCompany_Id(company.getId());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("jobs", jobs);
        modelAndView.setViewName("company_actions/viewCandidateMatchWithCompanyJobs");
        return modelAndView;
    }
    @PostMapping("/seekingCandidateMatchWithJob")
    public ModelAndView seekingCandidateMatchWithJob(@RequestParam("jobID") long jobID, HttpServletRequest request){
        System.out.println(jobID);
        Company company = (Company) request.getSession().getAttribute("companyLogin");
        List<Candidate> candidates = candidateRepository.findCadidatesMatchWithJobs(jobID);
        System.out.println(candidates);
        ModelAndView modelAndView = new ModelAndView();
        List<Job> jobs = jobRepository.findAllByCompany_Id(company.getId());
        modelAndView.addObject("jobs", jobs);
        modelAndView.addObject("candidates", candidates);
        modelAndView.setViewName("company_actions/viewCandidateMatchWithCompanyJobs");
        return modelAndView;
    }
}
