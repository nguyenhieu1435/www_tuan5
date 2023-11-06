package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.backend.irepositories.ICandidateRepository;
import vn.edu.iuh.fit.backend.irepositories.ICompanyRepository;
import vn.edu.iuh.fit.backend.model.Candidate;
import vn.edu.iuh.fit.backend.model.Company;

@Controller
@RequestMapping("")
public class CommonController {
    private ICandidateRepository candidateRepository;
    private ICompanyRepository companyRepository;

    @Autowired
    public CommonController(ICandidateRepository candidateRepository, ICompanyRepository companyRepository) {
        this.candidateRepository = candidateRepository;
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/open-sign-in")
    public String openSignIn() {
        return "common/signin";
    }

    @PostMapping("/sign-in")
    public String signin(Model model , @RequestParam("username") String usename, @RequestParam("password") String password,
                         @RequestParam("role") String role, HttpServletRequest request) {
        Candidate candidate = null;
        Company company = null;
        if (role.equalsIgnoreCase("candidate")) {
            candidate = candidateRepository.findCandidateByUsernameAndPassword(usename, password).orElse(null);
        } else {
           company  = companyRepository.findCompaniesByUsernameAndPassword(usename, password).orElse(null);
        }
        if (candidate == null && company == null){
            model.addAttribute("errMsg", "Tài khoản không tồn tại!");
            return "common/signin";
        }

        HttpSession session =  request.getSession(true);
        session.setAttribute("candidateLogin", candidate);
        session.setAttribute("companyLogin", company);

        return "redirect:/";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }
}
