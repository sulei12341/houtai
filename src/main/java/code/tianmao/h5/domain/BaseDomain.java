package code.tianmao.h5.domain;
/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import code.tianmao.h5.sysconfig.mybatis.annotation.CreatedBy;
import code.tianmao.h5.sysconfig.mybatis.annotation.CreatedDate;
import code.tianmao.h5.sysconfig.mybatis.annotation.LastModifiedBy;
import code.tianmao.h5.sysconfig.mybatis.annotation.LastModifiedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>类简述：系统中所有实体的父类</p>
 * <p>
 * <p>描述：该类定义了主键，版本和审计需要的必须字段</p>
 * <p>
 * <p>补充：</p>
 *
 * @param <U>  审计当前实体的主键类型
 * @param <PK> 当前实体的主键类型
 * @author Jupeng.Su
 */
@MappedSuperclass
public class BaseDomain<U, PK extends Serializable> implements Serializable {

    private static final long serialVersionUID = -5554308939380869754L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private PK id;

    @CreatedBy
    public U createdBy;

    @CreatedDate
    public Date createTime;

    @LastModifiedBy
    public U updateBy;

    @LastModifiedDate
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
