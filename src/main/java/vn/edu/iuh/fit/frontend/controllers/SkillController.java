package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.backend.enums.SkillType;
import vn.edu.iuh.fit.backend.irepositories.ISkillRepository;
import vn.edu.iuh.fit.backend.model.Candidate;
import vn.edu.iuh.fit.backend.model.Job;
import vn.edu.iuh.fit.backend.model.Skill;

import java.util.List;

@Controller
@RequestMapping("/skills")
public class SkillController {
    private ISkillRepository skillRepository;
    @Autowired
    public SkillController(ISkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }
    @GetMapping("/openAddForm")
    public ModelAndView openAddForm(Model model){
        ModelAndView modelAndView = new ModelAndView();
        Skill skill = new Skill();
        modelAndView.addObject("skill", skill);
        modelAndView.addObject("skillTypes", SkillType.values());
        modelAndView.setViewName("common/addSkill");
        return modelAndView;
    }
    @PostMapping("/add")
    public String insertSkill(@ModelAttribute("skill") Skill skill, Model model){
        try {
            skillRepository.save(skill);
            model.addAttribute("sttAdd", "Thêm thành công!");

        } catch (Exception e){
            model.addAttribute("sttAdd", "Thêm thất bại!");
        }
        return "common/addSkill";
    }
    @GetMapping("/findSkillShouldLearn")
    public ModelAndView findSkillShouldLearn(HttpServletRequest request){
        Candidate candidate = (Candidate) request.getSession().getAttribute("candidateLogin");
        List<Skill> skills = skillRepository.findSkillCandidateShouldLearn(candidate.getId());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("skills", skills);
        modelAndView.setViewName("candidate_actions/suggestSkillShouldLearn");
        return modelAndView;
    }

}
