package top.clydezhou.lab.demo.mybatis.spring.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author clyde
 * @date 2020-08-09 22:33
 */
public class BaseEntity implements Serializable {
    private Long id;
    private Date createTime;
    private Date lastUpdateTime;
    private Flag flag = Flag.NORMAL;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "BaseEntity{" + "id=" + id + ", createTime=" + createTime + ", lastUpdateTime=" + lastUpdateTime
            + ", flag=" + flag + '}';
    }
}
