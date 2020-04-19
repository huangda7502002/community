package life.majiang.community.controller;

import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.entity.User;
import life.majiang.community.service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private QuestionServiceImpl questionService;

    @GetMapping("/profile/{action}")
    public String profile(@PathVariable String action, Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        List<QuestionDTO> questions = questionService.findByUserId(user.getId());
        if ("questions".equals(action)) {
            model.addAttribute("questions", questions);
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
        }
        return "profile";
    }

}
