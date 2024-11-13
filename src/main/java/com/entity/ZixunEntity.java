package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 运动会资讯
 *
 * @author 
 * @email
 */
@TableName("zixun")
public class ZixunEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZixunEntity() {

	}

	public ZixunEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 资讯标题
     */
    @ColumnInfo(comment="资讯标题",type="varchar(200)")
    @TableField(value = "zixun_name")

    private String zixunName;


    /**
     * 资讯封面
     */
    @ColumnInfo(comment="资讯封面",type="varchar(200)")
    @TableField(value = "zixun_photo")

    private String zixunPhoto;


    /**
     * 视频
     */
    @ColumnInfo(comment="视频",type="varchar(200)")
    @TableField(value = "zixun_video")

    private String zixunVideo;


    /**
     * 资讯类型
     */
    @ColumnInfo(comment="资讯类型",type="int(11)")
    @TableField(value = "zixun_types")

    private Integer zixunTypes;


    /**
     * 资讯热度
     */
    @ColumnInfo(comment="资讯热度",type="int(11)")
    @TableField(value = "zixun_clicknum")

    private Integer zixunClicknum;


    /**
     * 资讯介绍
     */
    @ColumnInfo(comment="资讯介绍",type="longtext")
    @TableField(value = "zixun_content")

    private String zixunContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "zixun_delete")

    private Integer zixunDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Zixun{" +
            ", id=" + id +
            ", zixunName=" + zixunName +
            ", zixunPhoto=" + zixunPhoto +
            ", zixunVideo=" + zixunVideo +
            ", zixunTypes=" + zixunTypes +
            ", zixunClicknum=" + zixunClicknum +
            ", zixunContent=" + zixunContent +
            ", zixunDelete=" + zixunDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
