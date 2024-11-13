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
 * 赛程安排
 *
 * @author 
 * @email
 */
@TableName("siachenganpai")
public class SiachenganpaiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SiachenganpaiEntity() {

	}

	public SiachenganpaiEntity(T t) {
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
     * 项目
     */
    @ColumnInfo(comment="项目",type="int(11)")
    @TableField(value = "bisaixiangmu_id")

    private Integer bisaixiangmuId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 比赛时间
     */
    @ColumnInfo(comment="比赛时间",type="varchar(200)")
    @TableField(value = "siachenganpai_fuzhenr")

    private String siachenganpaiFuzhenr;


    /**
     * 比赛场地
     */
    @ColumnInfo(comment="比赛场地",type="varchar(200)")
    @TableField(value = "siachenganpai_phone")

    private String siachenganpaiPhone;


    /**
     * 比赛状态
     */
    @ColumnInfo(comment="比赛状态",type="int(11)")
    @TableField(value = "zhuangtai_types")

    private Integer zhuangtaiTypes;


    /**
     * 比赛结果
     */
    @ColumnInfo(comment="比赛结果",type="int(11)")
    @TableField(value = "siachenganpai_types")

    private Integer siachenganpaiTypes;


    /**
     * 比赛详情
     */
    @ColumnInfo(comment="比赛详情",type="longtext")
    @TableField(value = "siachenganpai_content")

    private String siachenganpaiContent;


    /**
     * 发布日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="发布日期",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间   listShow
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
	 * 获取：项目
	 */
    public Integer getBisaixiangmuId() {
        return bisaixiangmuId;
    }
    /**
	 * 设置：项目
	 */

    public void setBisaixiangmuId(Integer bisaixiangmuId) {
        this.bisaixiangmuId = bisaixiangmuId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：比赛时间
	 */
    public String getSiachenganpaiFuzhenr() {
        return siachenganpaiFuzhenr;
    }
    /**
	 * 设置：比赛时间
	 */

    public void setSiachenganpaiFuzhenr(String siachenganpaiFuzhenr) {
        this.siachenganpaiFuzhenr = siachenganpaiFuzhenr;
    }
    /**
	 * 获取：比赛场地
	 */
    public String getSiachenganpaiPhone() {
        return siachenganpaiPhone;
    }
    /**
	 * 设置：比赛场地
	 */

    public void setSiachenganpaiPhone(String siachenganpaiPhone) {
        this.siachenganpaiPhone = siachenganpaiPhone;
    }
    /**
	 * 获取：比赛状态
	 */
    public Integer getZhuangtaiTypes() {
        return zhuangtaiTypes;
    }
    /**
	 * 设置：比赛状态
	 */

    public void setZhuangtaiTypes(Integer zhuangtaiTypes) {
        this.zhuangtaiTypes = zhuangtaiTypes;
    }
    /**
	 * 获取：比赛结果
	 */
    public Integer getSiachenganpaiTypes() {
        return siachenganpaiTypes;
    }
    /**
	 * 设置：比赛结果
	 */

    public void setSiachenganpaiTypes(Integer siachenganpaiTypes) {
        this.siachenganpaiTypes = siachenganpaiTypes;
    }
    /**
	 * 获取：比赛详情
	 */
    public String getSiachenganpaiContent() {
        return siachenganpaiContent;
    }
    /**
	 * 设置：比赛详情
	 */

    public void setSiachenganpaiContent(String siachenganpaiContent) {
        this.siachenganpaiContent = siachenganpaiContent;
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
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Siachenganpai{" +
            ", id=" + id +
            ", bisaixiangmuId=" + bisaixiangmuId +
            ", yonghuId=" + yonghuId +
            ", siachenganpaiFuzhenr=" + siachenganpaiFuzhenr +
            ", siachenganpaiPhone=" + siachenganpaiPhone +
            ", zhuangtaiTypes=" + zhuangtaiTypes +
            ", siachenganpaiTypes=" + siachenganpaiTypes +
            ", siachenganpaiContent=" + siachenganpaiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
