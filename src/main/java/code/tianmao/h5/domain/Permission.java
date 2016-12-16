package code.tianmao.h5.domain;

import javax.persistence.Table;

@Table(name = "sys_permission")
public class Permission extends BaseDomain<Long, Long> {

    private static final long serialVersionUID = -5524308932380869754L;
    /**
     * 权限名
     */
    private String name;

    /**
     * 权限类型
     */
    private String type;

    /**
     * 地址
     */
    private String url;

    /**
     * 权限标签
     */
    private String percode;

    /**
     * 父权限ID
     */
    private Long parentid;

    /**
     * 父权限层级
     */
    private String parentids;

    /**
     * 排序
     */
    private int sort;

    /**
     * 是否有效
     */
    private Boolean valid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPercode() {
        return percode;
    }

    public void setPercode(String percode) {
        this.percode = percode;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public String getParentids() {
        return parentids;
    }

    public void setParentids(String parentids) {
        this.parentids = parentids;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}