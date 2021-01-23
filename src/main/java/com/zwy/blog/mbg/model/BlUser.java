package com.zwy.blog.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class BlUser implements Serializable {
    /**
     * 用户id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * 用户名
     *
     * @mbggenerated
     */
    private String username;

    /**
     * 密码
     *
     * @mbggenerated
     */
    private String password;

    /**
     * 姓名
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 性别。1男2女
     *
     * @mbggenerated
     */
    private Integer sex;

    /**
     * 头像
     *
     * @mbggenerated
     */
    private String header;

    /**
     * 昵称
     *
     * @mbggenerated
     */
    private String nickname;

    /**
     * 邮箱
     *
     * @mbggenerated
     */
    private String userEmail;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createdTime;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 乐观锁
     *
     * @mbggenerated
     */
    private Integer version;

    /**
     * 是否删除。0否1是
     *
     * @mbggenerated
     */
    private Integer deleted;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", header=").append(header);
        sb.append(", nickname=").append(nickname);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", version=").append(version);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}