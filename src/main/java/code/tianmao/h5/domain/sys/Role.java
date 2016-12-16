package code.tianmao.h5.domain.sys;

import code.tianmao.h5.domain.base.BaseDomain;

import javax.persistence.Table;

@Table(name = "sys_role")
public class Role extends BaseDomain<Long, Long> {

    private static final long serialVersionUID = -5524318932380869754L;

    private String name;

    private String valid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }
}