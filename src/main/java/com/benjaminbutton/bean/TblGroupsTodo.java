package com.benjaminbutton.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 分组待办事项
 * </p>
 *
 * @author wwx
 * @since 2020-06-24
 */
public class TblGroupsTodo extends Model<TblGroupsTodo> {

    private static final long serialVersionUID=1L;

    /**
     * 分组id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 待办事项id
     */
    private String todoId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTodoId() {
        return todoId;
    }

    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TblGroupsTodo{" +
        "id=" + id +
        ", todoId=" + todoId +
        "}";
    }
}
