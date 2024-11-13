package com.entity.vo;

import com.entity.SiachenganpaiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 赛程安排
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("siachenganpai")
public class SiachenganpaiVO implements Serializable {
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
     * 比赛时间
     */

    @TableField(value = "siachenganpai_fuzhenr")
    private String siachenganpaiFuzhenr;


    /**
     * 比赛场地
     */

    @TableField(value = "siachenganpai_phone")
    private String siachenganpaiPhone;


    /**
     * 比赛状态
     */

    @TableField(value = "zhuangtai_types")
    private Integer zhuangtaiTypes;


    /**
     * 比赛结果
     */

    @TableField(value = "siachenganpai_types")
    private Integer siachenganpaiTypes;


    /**
     * 比赛详情
     */

    @TableField(value = "siachenganpai_content")
    private String siachenganpaiContent;


    /**
     * 发布日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 设置：比赛时间
	 */
    public String getSiachenganpaiFuzhenr() {
        return siachenganpaiFuzhenr;
    }


    /**
	 * 获取：比赛时间
	 */

    public void setSiachenganpaiFuzhenr(String siachenganpaiFuzhenr) {
        this.siachenganpaiFuzhenr = siachenganpaiFuzhenr;
    }
    /**
	 * 设置：比赛场地
	 */
    public String getSiachenganpaiPhone() {
        return siachenganpaiPhone;
    }


    /**
	 * 获取：比赛场地
	 */

    public void setSiachenganpaiPhone(String siachenganpaiPhone) {
        this.siachenganpaiPhone = siachenganpaiPhone;
    }
    /**
	 * 设置：比赛状态
	 */
    public Integer getZhuangtaiTypes() {
        return zhuangtaiTypes;
    }


    /**
	 * 获取：比赛状态
	 */

    public void setZhuangtaiTypes(Integer zhuangtaiTypes) {
        this.zhuangtaiTypes = zhuangtaiTypes;
    }
    /**
	 * 设置：比赛结果
	 */
    public Integer getSiachenganpaiTypes() {
        return siachenganpaiTypes;
    }


    /**
	 * 获取：比赛结果
	 */

    public void setSiachenganpaiTypes(Integer siachenganpaiTypes) {
        this.siachenganpaiTypes = siachenganpaiTypes;
    }
    /**
	 * 设置：比赛详情
	 */
    public String getSiachenganpaiContent() {
        return siachenganpaiContent;
    }


    /**
	 * 获取：比赛详情
	 */

    public void setSiachenganpaiContent(String siachenganpaiContent) {
        this.siachenganpaiContent = siachenganpaiContent;
    }
    /**
	 * 设置：发布日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：发布日期
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
