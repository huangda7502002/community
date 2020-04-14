package life.majiang.community.controller;

import life.majiang.community.entity.Question;
import life.majiang.community.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Question)表控制层
 *
 * @author makejava
 * @since 2020-04-14 21:18:19
 */
@RestController
@RequestMapping("question")
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

}
