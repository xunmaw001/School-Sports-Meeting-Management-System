package com.entity.vo;

import com.entity.BisaixiangmuYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 项目报名
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("bisaixiangmu_yuyue")
public class BisaixiangmuYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 项目
     */

    @TableField(value = "bisaixiangmu_id")
    private Integer bisaixiangmuId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 审核状态
     */

    @TableField(value = "bisaixiangmu_yuyue_yesno_types")
    private Integer bisaixiangmuYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "bisaixiangmu_yuyue_yesno_text")
    private String bisaixiangmuYuyueYesnoText;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：项目
	 */
    public Integer getBisaixiangmuId() {
        return bisaixiangmuId;
    }


    /**
	 * 获取：项目
	 */

    public void setBisaixiangmuId(Integer bisaixiangmuId) {
        this.bisaixiangmuId = bisaixiangmuId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getBisaixiangmuYuyueYesnoTypes() {
        return bisaixiangmuYuyueYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setBisaixiangmuYuyueYesnoTypes(Integer bisaixiangmuYuyueYesnoTypes) {
        this.bisaixiangmuYuyueYesnoTypes = bisaixiangmuYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getBisaixiangmuYuyueYesnoText() {
        return bisaixiangmuYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setBisaixiangmuYuyueYesnoText(String bisaixiangmuYuyueYesnoText) {
        this.bisaixiangmuYuyueYesnoText = bisaixiangmuYuyueYesnoText;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
