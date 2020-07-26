package top.clydezhou.lab.demo.springboot.dao.dataobject;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Data
public class UserDO {
    private Long id;

    private String name;

    private Integer age;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;
}
