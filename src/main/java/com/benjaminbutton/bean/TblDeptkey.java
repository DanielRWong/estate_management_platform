package com.benjaminbutton.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 部门key
 * </p>
 *
 * @author wwx
 * @since 2020-06-24
 */
public class TblDeptkey extends Model<TblDeptkey> {

    private static final long serialVersionUID=1L;

    /**
     * Key编码
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * key名称
     */
    private String deptName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TblDeptkey{" +
        "id=" + id +
        ", deptName=" + deptName +
        "}";
    }
}
