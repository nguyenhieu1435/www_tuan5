package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.backend.enums.SkillLevel;
import vn.edu.iuh.fit.backend.irepositories.ICandidateRepository;
import vn.edu.iuh.fit.backend.irepositories.ICandidateSkillRepository;
import vn.edu.iuh.fit.backend.irepositories.ISkillRepository;
import vn.edu.iuh.fit.backend.model.Candidate;
import vn.edu.iuh.fit.backend.model.CandidateSkill;
import vn.edu.iuh.fit.backend.model.JobSkill;
import vn.edu.iuh.fit.backend.model.Skill;

import java.util.List;

@Controller
@RequestMapping("/candidate_skills")
public class CandidateSkillController {
    private ICandidateSkillRepository candidateSkillRepository;
    private ICandidateRepository candidateRepository;
    private ISkillRepository skillRepository;
    @Autowired
    public CandidateSkillController(ICandidateSkillRepository candidateSkillRepository, ICandidateRepository candidateRepository, ISkillRepository skillRepository) {
        this.candidateSkillRepository = candidateSkillRepository;
        this.candidateRepository = candidateRepository;
        this.skillRepository = skillRepository;
    }


    @GetMapping("/getListByCandidateLogin")
    public ModelAndView getListByCandidateLogin(HttpServletRequest request){
        Candidate candidate = (Candidate) request.getSession().getAttribute("candidateLogin");
        ModelAndView modelAndView = new ModelAndView();
        if (candidate == null){
            modelAndView.setViewName("redirect:/open-sign-in");
            return modelAndView;
        }
        List<CandidateSkill> candidateSkills = candidateSkillRepository.getCandidateSkillByCandidate_Id(candidate.getId());

        modelAndView.addObject("candidateSkills", candidateSkills);
        modelAndView.addObject("candidate", candidate);
        modelAndView.setViewName("candidate_actions/list_candidate_skills");
        return modelAndView;
    }
    @GetMapping("/openAddCandSkill")
    public ModelAndView openAddCandSkill(@RequestParam("candidateID") long candidateID){
        Candidate candidate = candidateRepository.findById(candidateID).orElse(null);
        CandidateSkill candidateSkill = new CandidateSkill();
        candidateSkill.setCandidate(new Candidate());
        candidateSkill.setSkill(new Skill());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("candidateSkills", candidateSkill);
        assert candidate != null;
        modelAndView.addObject("candidateID", candidate.getId());
        modelAndView.addObject("skills", skillRepository.findAll());
        modelAndView.addObject("skillLevel", SkillLevel.values());
        modelAndView.setViewName("candidate_actions/add_candidate_skills");
        return modelAndView;
    }
    @PostMapping("/add")
    public String insertCandidateSkill(@ModelAttribute("candidateSkills")CandidateSkill candidateSkills){

        try {
            candidateSkillRepository.save(candidateSkills);

        } catch (Exception e){

        }
        return "redirect:/candidate_skills/getListByCandidateLogin";
    }
}
