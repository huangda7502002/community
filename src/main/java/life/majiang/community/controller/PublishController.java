package life.majiang.community.controller;

import life.majiang.community.entity.Question;
import life.majiang.community.entity.User;
import life.majiang.community.service.impl.QuestionServiceImpl;
import life.majiang.community.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    @Autowired
    private QuestionServiceImpl questionService;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(@RequestParam String title,
                            @RequestParam String tag,
                            @RequestParam String description,
                            @CookieValue String token,
                            HttpServletRequest request,
                            Model model) {

        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);

        if (title == null || title == "") {
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if (description == null || description == "") {
            model.addAttribute("error", "描述不能为空");
            return "publish";
        }
        if (tag == null || tag == "") {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }

        User byToken = userService.findByToken(token);
        if (byToken != null) {
            request.getSession().setAttribute("user", byToken);
        } else {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }

        Question question = new Question();
        question.setTitle(title);
        question.setTag(tag);
        question.setDescription(description);
        question.setCreator(byToken.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());

        questionService.insert(question);
        return "redirect:/";
    }

}
