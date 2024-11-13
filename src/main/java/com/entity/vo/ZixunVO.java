package com.entity.vo;

import com.entity.ZixunEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 运动会资讯
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zixun")
public class ZixunVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 资讯标题
     */

    @TableField(value = "zixun_name")
    private String zixunName;


    /**
     * 资讯封面
     */

    @TableField(value = "zixun_photo")
    private String zixunPhoto;


    /**
     * 视频
     */

    @TableField(value = "zixun_video")
    private String zixunVideo;


    /**
     * 资讯类型
     */

    @TableField(value = "zixun_types")
    private Integer zixunTypes;


    /**
     * 资讯热度
     */

    @TableField(value = "zixun_clicknum")
    private Integer zixunClicknum;


    /**
     * 资讯介绍
     */

    @TableField(value = "zixun_content")
    private String zixunContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "zixun_delete")
    private Integer zixunDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：资讯标题
	 */
    public String getZixunName() {
        return zixunName;
    }


    /**
	 * 获取：资讯标题
	 */

    public void setZixunName(String zixunName) {
        this.zixunName = zixunName;
    }
    /**
	 * 设置：资讯封面
	 */
    public String getZixunPhoto() {
        return zixunPhoto;
    }


    /**
	 * 获取：资讯封面
	 */

    public void setZixunPhoto(String zixunPhoto) {
        this.zixunPhoto = zixunPhoto;
    }
    /**
	 * 设置：视频
	 */
    public String getZixunVideo() {
        return zixunVideo;
    }


    /**
	 * 获取：视频
	 */

    public void setZixunVideo(String zixunVideo) {
        this.zixunVideo = zixunVideo;
    }
    /**
	 * 设置：资讯类型
	 */
    public Integer getZixunTypes() {
        return zixunTypes;
    }


    /**
	 * 获取：资讯类型
	 */

    public void setZixunTypes(Integer zixunTypes) {
        this.zixunTypes = zixunTypes;
    }
    /**
	 * 设置：资讯热度
	 */
    public Integer getZixunClicknum() {
        return zixunClicknum;
    }


    /**
	 * 获取：资讯热度
	 */

    public void setZixunClicknum(Integer zixunClicknum) {
        this.zixunClicknum = zixunClicknum;
    }
    /**
	 * 设置：资讯介绍
	 */
    public String getZixunContent() {
        return zixunContent;
    }


    /**
	 * 获取：资讯介绍
	 */

    public void setZixunContent(String zixunContent) {
        this.zixunContent = zixunContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getZixunDelete() {
        return zixunDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setZixunDelete(Integer zixunDelete) {
        this.zixunDelete = zixunDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
