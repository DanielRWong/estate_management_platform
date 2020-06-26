package com.benjaminbutton.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 常用短信
 * </p>
 *
 * @author wwx
 * @since 2020-06-24
 */
public class TblCommonMessage extends Model<TblCommonMessage> {

    private static final long serialVersionUID=1L;

    /**
     * 短信编码
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 短信内容
     */
    private String messageContent;

    /**
     * 类型
     */
    private Long messageType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Long getMessageType() {
        return messageType;
    }

    public void setMessageType(Long messageType) {
        this.messageType = messageType;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TblCommonMessage{" +
        "id=" + id +
        ", messageContent=" + messageContent +
        ", messageType=" + messageType +
        "}";
    }
}
