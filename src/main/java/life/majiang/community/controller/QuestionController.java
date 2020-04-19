package life.majiang.community.controller;

import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.entity.Question;
import life.majiang.community.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

/**
 * (Question)表控制层
 *
 * @author makejava
 * @since 2020-04-14 21:18:19
 */
@Controller
public class QuestionController {
    /**
     * 服务对象
     */
    @Resource
    private QuestionService questionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Question selectOne(Integer id) {
        return this.questionService.queryById(id);
    }

    @GetMapping("/question/{id}")
    public String question(@PathVariable Integer id, Model model) {
        QuestionDTO questionDTO = questionService.getById(id);
        model.addAttribute("question", questionDTO);
        return "question";
    }
}
