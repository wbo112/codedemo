package com.itheima.bean;

import javax.persistence.Table;

@Table(name="lock_record")
public class LockRecord {
    private Integer id;
    private String lockName;

    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
