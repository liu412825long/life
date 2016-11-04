package cn.sh.life.etc.entity;

import java.util.Date;

public class Message {
    private Integer id;

    private Integer userid;

    private String message;

    private Integer notifyid;

    private Date createdate;

    private Integer consumedetailid;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Integer getNotifyid() {
        return notifyid;
    }

    public void setNotifyid(Integer notifyid) {
        this.notifyid = notifyid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getConsumedetailid() {
        return consumedetailid;
    }

    public void setConsumedetailid(Integer consumedetailid) {
        this.consumedetailid = consumedetailid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}