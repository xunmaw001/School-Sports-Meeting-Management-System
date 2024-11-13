package com.entity.model;

import com.entity.BisaixiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 项目信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BisaixiangmuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 项目标题
     */
    private String bisaixiangmuName;


    /**
     * 项目封面
     */
    private String bisaixiangmuPhoto;


    /**
     * 工作时间
     */
    private String bisaixiangmuShijian;


    /**
     * 负责人
     */
    private String bisaixiangmuFuzhenr;


    /**
     * 联系方式
     */
    private String bisaixiangmuPhone;


    /**
     * 项目类型
     */
    private Integer bisaixiangmuTypes;


    /**
     * 结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jieshuTime;


    /**
     * 项目详情
     */
    private String bisaixiangmuContent;


    /**
     * 逻辑删除
     */
    private Integer bisaixiangmuDelete;


    /**
     * 发布日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
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
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
