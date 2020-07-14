package redt.app.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import redt.app.model.Feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import redt.app.service.feedback.FeedbackService;
import redt.app.service.reaction.ReactionService;

import java.util.List;

@Controller
public class HomeController {
	@Autowired
	private FeedbackService feedbackService;

	@Autowired
	private ReactionService reactionService;

	@GetMapping("/")
	public String index(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = 2) Pageable pageable, Model model){
		Page<Feedback> pages = feedbackService.findAll(pageable);
		model.addAttribute("pages", pages);
		return "index";
	}

	@PostMapping("/")
	public String indexPost(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = 2) Pageable pageable, @ModelAttribute Feedback feedback, Model model){
		feedbackService.save(feedback);
		Page<Feedback> pages = feedbackService.findAll(pageable);
		model.addAttribute("pages", pages);
		return "index";
	}

	@GetMapping("/reaction")
	public String reaction(@RequestParam String r, @RequestParam Long id,  Model model){
		Feedback feedback = feedbackService.findById(id);
		if (feedback != null){
			switch (r){
				case "Like":
					reactionService.reactions("Like", feedback);
					break;

				case "Love":
					reactionService.reactions("Love", feedback);
					break;

				case "Haha":
					reactionService.reactions("Haha", feedback);
					break;

				case "Angry":
					reactionService.reactions("Angry", feedback);
					break;

				case "Cry":
					reactionService.reactions("Cry", feedback);
					break;
			}
		}

		return "redirect:/";
	}
}
