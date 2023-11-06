package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.backend.irepositories.IJobRepository;
import vn.edu.iuh.fit.backend.model.Candidate;
import vn.edu.iuh.fit.backend.model.Company;
import vn.edu.iuh.fit.backend.model.Job;

import java.util.List;

@Controller
@RequestMapping("/jobs")
public class JobController {
    private IJobRepository jobRepository;
    @Autowired
    public JobController(IJobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    @GetMapping("/getAllByCompany")
    public ModelAndView getAllByCompany(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        Company company = (Company) request.getSession().getAttribute("companyLogin");
        if (company == null){
            modelAndView.setViewName("redirect:/open-sign-in");
            return modelAndView;
        }
        List<Job> jobs = jobRepository.findAllByCompany_Id(company.getId());
        modelAndView.addObject("jobs", jobs);
        modelAndView.setViewName("company_actions/list_job");
        return modelAndView;
    }
    @GetMapping("/findJobMatchWithMe")
    public ModelAndView findJobMatchWithMe(HttpServletRequest request){
        Candidate candidate = (Candidate) request.getSession().getAttribute("candidateLogin");
        List<Job> jobs = jobRepository.findAllJobMatchWithCandidate(candidate.getId());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("jobs", jobs);
        modelAndView.setViewName("candidate_actions/viewJobMatchWithMe");
        return modelAndView;
    }

}

