package vn.edu.iuh.fit.frontend.controllers.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.backend.irepositories.ICandidateRepository;
import vn.edu.iuh.fit.backend.model.Candidate;
import vn.edu.iuh.fit.backend.services.CandidateService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class CandidateController {
    private ICandidateRepository candidateRepository;
    private CandidateService candidateService;
    @Autowired
    public CandidateController(ICandidateRepository candidateRepository, CandidateService candidateService) {
        this.candidateRepository = candidateRepository;
        this.candidateService = candidateService;
    }
    @GetMapping("/list")
    public String showCandidateList(Model model){
        model.addAttribute("candidates", candidateRepository.findAll());
        return "candidates/candidates";
    }
    @GetMapping("/candidates")
    public String showCandidateListPaging(Model model, @RequestParam("page")Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int currentSize = size.orElse(10);
        Page<Candidate> candidatePage = candidateService.findAll(currentPage, currentSize, "id", "asc");
        model.addAttribute("candidatePage", candidatePage);
        int totalPages = candidatePage.getTotalPages();
        if (totalPages > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);

        }
        return "candidates/candidates-paging";
    }
//    @PostMapping("/candidates/add")
//    public String addCandidate(Model model){
//
//    }
    @GetMapping("/candidates/add")
    public String getAddCandidatePage(Model model){

        return "candidates/add-candidate";
    }
}
