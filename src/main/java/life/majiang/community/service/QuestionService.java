package life.majiang.community.service;

import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.entity.Question;

import java.util.List;

/**
 * (Question)表服务接口
 *
 * @author makejava
 * @since 2020-04-14 21:18:19
 */
public interface QuestionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Question queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Question> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param question 实例对象
     * @return 实例对象
     */
    Question insert(Question question);

    /**
     * 修改数据
     *
     * @param question 实例对象
     * @return 实例对象
     */
    Question update(Question question);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    QuestionDTO getById(Integer id);

    List<QuestionDTO> findByUserId(Integer userId);

}
