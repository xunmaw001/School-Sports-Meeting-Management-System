package com.entity.model;

import com.entity.SiachenganpaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 赛程安排
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SiachenganpaiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 项目
     */
    private Integer bisaixiangmuId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 比赛时间
     */
    private String siachenganpaiFuzhenr;


    /**
     * 比赛场地
     */
    private String siachenganpaiPhone;


    /**
     * 比赛状态
     */
    private Integer zhuangtaiTypes;


    /**
     * 比赛结果
     */
    private Integer siachenganpaiTypes;


    /**
     * 比赛详情
     */
    private String siachenganpaiContent;


    /**
     * 发布日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
