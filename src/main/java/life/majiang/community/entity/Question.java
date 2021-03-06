package life.majiang.community.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Question)实体类
 *
 * @author makejava
 * @since 2020-04-14 21:18:19
 */
@Data
public class Question implements Serializable {
    private static final long serialVersionUID = -89502090960133949L;

    private Integer id;

    private String title;

    private String description;

    private Long gmtCreate;

    private Long gmtModified;

    private Integer creator;

    private Integer commentCount;

    private Integer viewCount;

    private Integer likeCount;

    private String tag;

}
