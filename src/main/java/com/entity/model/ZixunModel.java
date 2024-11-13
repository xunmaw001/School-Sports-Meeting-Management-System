package com.entity.model;

import com.entity.ZixunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 运动会资讯
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZixunModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 资讯标题
     */
    private String zixunName;


    /**
     * 资讯封面
     */
    private String zixunPhoto;


    /**
     * 视频
     */
    private String zixunVideo;


    /**
     * 资讯类型
     */
    private Integer zixunTypes;


    /**
     * 资讯热度
     */
    private Integer zixunClicknum;


    /**
     * 资讯介绍
     */
    private String zixunContent;


    /**
     * 逻辑删除
     */
    private Integer zixunDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：资讯标题
	 */
    public String getZixunName() {
        return zixunName;
    }


    /**
	 * 设置：资讯标题
	 */
    public void setZixunName(String zixunName) {
        this.zixunName = zixunName;
    }
    /**
	 * 获取：资讯封面
	 */
    public String getZixunPhoto() {
        return zixunPhoto;
    }


    /**
	 * 设置：资讯封面
	 */
    public void setZixunPhoto(String zixunPhoto) {
        this.zixunPhoto = zixunPhoto;
    }
    /**
	 * 获取：视频
	 */
    public String getZixunVideo() {
        return zixunVideo;
    }


    /**
	 * 设置：视频
	 */
    public void setZixunVideo(String zixunVideo) {
        this.zixunVideo = zixunVideo;
    }
    /**
	 * 获取：资讯类型
	 */
    public Integer getZixunTypes() {
        return zixunTypes;
    }


    /**
	 * 设置：资讯类型
	 */
    public void setZixunTypes(Integer zixunTypes) {
        this.zixunTypes = zixunTypes;
    }
    /**
	 * 获取：资讯热度
	 */
    public Integer getZixunClicknum() {
        return zixunClicknum;
    }


    /**
	 * 设置：资讯热度
	 */
    public void setZixunClicknum(Integer zixunClicknum) {
        this.zixunClicknum = zixunClicknum;
    }
    /**
	 * 获取：资讯介绍
	 */
    public String getZixunContent() {
        return zixunContent;
    }


    /**
	 * 设置：资讯介绍
	 */
    public void setZixunContent(String zixunContent) {
        this.zixunContent = zixunContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getZixunDelete() {
        return zixunDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setZixunDelete(Integer zixunDelete) {
        this.zixunDelete = zixunDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
