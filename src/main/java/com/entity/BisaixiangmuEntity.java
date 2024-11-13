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
 * 项目信息
 *
 * @author 
 * @email
 */
@TableName("bisaixiangmu")
public class BisaixiangmuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BisaixiangmuEntity() {

	}

	public BisaixiangmuEntity(T t) {
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
     * 项目标题
     */
    @ColumnInfo(comment="项目标题",type="varchar(200)")
    @TableField(value = "bisaixiangmu_name")

    private String bisaixiangmuName;


    /**
     * 项目封面
     */
    @ColumnInfo(comment="项目封面",type="varchar(200)")
    @TableField(value = "bisaixiangmu_photo")

    private String bisaixiangmuPhoto;


    /**
     * 工作时间
     */
    @ColumnInfo(comment="工作时间",type="varchar(200)")
    @TableField(value = "bisaixiangmu_shijian")

    private String bisaixiangmuShijian;


    /**
     * 负责人
     */
    @ColumnInfo(comment="负责人",type="varchar(200)")
    @TableField(value = "bisaixiangmu_fuzhenr")

    private String bisaixiangmuFuzhenr;


    /**
     * 联系方式
     */
    @ColumnInfo(comment="联系方式",type="varchar(200)")
    @TableField(value = "bisaixiangmu_phone")

    private String bisaixiangmuPhone;


    /**
     * 项目类型
     */
    @ColumnInfo(comment="项目类型",type="int(11)")
    @TableField(value = "bisaixiangmu_types")

    private Integer bisaixiangmuTypes;


    /**
     * 结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="结束时间",type="timestamp")
    @TableField(value = "jieshu_time")

    private Date jieshuTime;


    /**
     * 项目详情
     */
    @ColumnInfo(comment="项目详情",type="longtext")
    @TableField(value = "bisaixiangmu_content")

    private String bisaixiangmuContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "bisaixiangmu_delete")

    private Integer bisaixiangmuDelete;


    /**
     * 发布日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="发布日期",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间     homeMain
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
	 * 获取：项目标题
	 */
    public String getBisaixiangmuName() {
        return bisaixiangmuName;
    }
    /**
	 * 设置：项目标题
	 */

    public void setBisaixiangmuName(String bisaixiangmuName) {
        this.bisaixiangmuName = bisaixiangmuName;
    }
    /**
	 * 获取：项目封面
	 */
    public String getBisaixiangmuPhoto() {
        return bisaixiangmuPhoto;
    }
    /**
	 * 设置：项目封面
	 */

    public void setBisaixiangmuPhoto(String bisaixiangmuPhoto) {
        this.bisaixiangmuPhoto = bisaixiangmuPhoto;
    }
    /**
	 * 获取：工作时间
	 */
    public String getBisaixiangmuShijian() {
        return bisaixiangmuShijian;
    }
    /**
	 * 设置：工作时间
	 */

    public void setBisaixiangmuShijian(String bisaixiangmuShijian) {
        this.bisaixiangmuShijian = bisaixiangmuShijian;
    }
    /**
	 * 获取：负责人
	 */
    public String getBisaixiangmuFuzhenr() {
        return bisaixiangmuFuzhenr;
    }
    /**
	 * 设置：负责人
	 */

    public void setBisaixiangmuFuzhenr(String bisaixiangmuFuzhenr) {
        this.bisaixiangmuFuzhenr = bisaixiangmuFuzhenr;
    }
    /**
	 * 获取：联系方式
	 */
    public String getBisaixiangmuPhone() {
        return bisaixiangmuPhone;
    }
    /**
	 * 设置：联系方式
	 */

    public void setBisaixiangmuPhone(String bisaixiangmuPhone) {
        this.bisaixiangmuPhone = bisaixiangmuPhone;
    }
    /**
	 * 获取：项目类型
	 */
    public Integer getBisaixiangmuTypes() {
        return bisaixiangmuTypes;
    }
    /**
	 * 设置：项目类型
	 */

    public void setBisaixiangmuTypes(Integer bisaixiangmuTypes) {
        this.bisaixiangmuTypes = bisaixiangmuTypes;
    }
    /**
	 * 获取：结束时间
	 */
    public Date getJieshuTime() {
        return jieshuTime;
    }
    /**
	 * 设置：结束时间
	 */

    public void setJieshuTime(Date jieshuTime) {
        this.jieshuTime = jieshuTime;
    }
    /**
	 * 获取：项目详情
	 */
    public String getBisaixiangmuContent() {
        return bisaixiangmuContent;
    }
    /**
	 * 设置：项目详情
	 */

    public void setBisaixiangmuContent(String bisaixiangmuContent) {
        this.bisaixiangmuContent = bisaixiangmuContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getBisaixiangmuDelete() {
        return bisaixiangmuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setBisaixiangmuDelete(Integer bisaixiangmuDelete) {
        this.bisaixiangmuDelete = bisaixiangmuDelete;
    }
    /**
	 * 获取：发布日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：发布日期
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间     homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间     homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Bisaixiangmu{" +
            ", id=" + id +
            ", bisaixiangmuName=" + bisaixiangmuName +
            ", bisaixiangmuPhoto=" + bisaixiangmuPhoto +
            ", bisaixiangmuShijian=" + bisaixiangmuShijian +
            ", bisaixiangmuFuzhenr=" + bisaixiangmuFuzhenr +
            ", bisaixiangmuPhone=" + bisaixiangmuPhone +
            ", bisaixiangmuTypes=" + bisaixiangmuTypes +
            ", jieshuTime=" + DateUtil.convertString(jieshuTime,"yyyy-MM-dd") +
            ", bisaixiangmuContent=" + bisaixiangmuContent +
            ", bisaixiangmuDelete=" + bisaixiangmuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
