package life.majiang.community.service.impl;

import life.majiang.community.dao.QuestionDao;
import life.majiang.community.dao.UserDao;
import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.entity.Question;
import life.majiang.community.entity.User;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Question)表服务实现类
 *
 * @author makejava
 * @since 2020-04-14 21:18:19
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
    @Resource
    private QuestionDao questionDao;
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Question queryById(Integer id) {
        return this.questionDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Question> queryAllByLimit(int offset, int limit) {
        return this.questionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param question 实例对象
     * @return 实例对象
     */
    @Override
    public Question insert(Question question) {
        this.questionDao.insert(question);
        return question;
    }

    /**
     * 修改数据
     *
     * @param question 实例对象
     * @return 实例对象
     */
    @Override
    public Question update(Question question) {
        this.questionDao.update(question);
        return this.queryById(question.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.questionDao.deleteById(id) > 0;
    }

    public List<QuestionDTO> list() {
        List<Question> questions = questionDao.queryAll(new Question());
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userDao.queryById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
