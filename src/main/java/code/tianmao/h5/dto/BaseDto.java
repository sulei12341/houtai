package code.tianmao.h5.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Junpeng.Su
 * @date 2016/11/18
 */
public class BaseDto<U, PK extends Serializable> implements Serializable {

    private static final long serialVersionUID = -3761675344684204302L;

    public PK id;

    public U createdBy;

    public Date createTime;

    public U updateBy;

    public Date updateTime;

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }

    public U getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(U createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public U getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(U updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
