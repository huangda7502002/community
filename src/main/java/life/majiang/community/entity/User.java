package life.majiang.community.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-04-14 22:06:16
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -56022176829966431L;

    private Integer id;

    private String accountId;

    private String name;

    private String token;

    private Long gmtCreate;

    private Long gmtModified;

    private String bio;

    private String avatarUrl;

}
