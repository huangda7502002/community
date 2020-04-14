package life.majiang.community.dto;

import life.majiang.community.entity.Question;
import life.majiang.community.entity.User;
import lombok.Data;

@Data
public class QuestionDTO extends Question {
    private User user;
}
