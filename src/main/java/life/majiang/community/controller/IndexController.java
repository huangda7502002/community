package life.majiang.community.controller;

import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.service.impl.QuestionServiceImpl;
import life.majiang.community.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private QuestionServiceImpl questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        List<QuestionDTO> list = questionService.list();
        model.addAttribute("questions", list);
        return "index";
    }
}
