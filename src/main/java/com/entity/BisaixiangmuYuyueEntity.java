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
 * 项目报名
 *
 * @author 
 * @email
 */
@TableName("bisaixiangmu_yuyue")
public class BisaixiangmuYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BisaixiangmuYuyueEntity() {

	}

	public BisaixiangmuYuyueEntity(T t) {
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
     * 审核状态
     */
    @ColumnInfo(comment="审核状态",type="int(11)")
    @TableField(value = "bisaixiangmu_yuyue_yesno_types")

    private Integer bisaixiangmuYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "bisaixiangmu_yuyue_yesno_text")

    private String bisaixiangmuYuyueYesnoText;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：审核状态
	 */
    public Integer getBisaixiangmuYuyueYesnoTypes() {
        return bisaixiangmuYuyueYesnoTypes;
    }
    /**
	 * 设置：审核状态
	 */

    public void setBisaixiangmuYuyueYesnoTypes(Integer bisaixiangmuYuyueYesnoTypes) {
        this.bisaixiangmuYuyueYesnoTypes = bisaixiangmuYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getBisaixiangmuYuyueYesnoText() {
        return bisaixiangmuYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setBisaixiangmuYuyueYesnoText(String bisaixiangmuYuyueYesnoText) {
        this.bisaixiangmuYuyueYesnoText = bisaixiangmuYuyueYesnoText;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BisaixiangmuYuyue{" +
            ", id=" + id +
            ", bisaixiangmuId=" + bisaixiangmuId +
            ", yonghuId=" + yonghuId +
            ", bisaixiangmuYuyueYesnoTypes=" + bisaixiangmuYuyueYesnoTypes +
            ", bisaixiangmuYuyueYesnoText=" + bisaixiangmuYuyueYesnoText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
