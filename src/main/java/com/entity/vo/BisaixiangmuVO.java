package com.entity.vo;

import com.entity.BisaixiangmuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 项目信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("bisaixiangmu")
public class BisaixiangmuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 项目标题
     */

    @TableField(value = "bisaixiangmu_name")
    private String bisaixiangmuName;


    /**
     * 项目封面
     */

    @TableField(value = "bisaixiangmu_photo")
    private String bisaixiangmuPhoto;


    /**
     * 工作时间
     */

    @TableField(value = "bisaixiangmu_shijian")
    private String bisaixiangmuShijian;


    /**
     * 负责人
     */

    @TableField(value = "bisaixiangmu_fuzhenr")
    private String bisaixiangmuFuzhenr;


    /**
     * 联系方式
     */

    @TableField(value = "bisaixiangmu_phone")
    private String bisaixiangmuPhone;


    /**
     * 项目类型
     */

    @TableField(value = "bisaixiangmu_types")
    private Integer bisaixiangmuTypes;


    /**
     * 结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jieshu_time")
    private Date jieshuTime;


    /**
     * 项目详情
     */

    @TableField(value = "bisaixiangmu_content")
    private String bisaixiangmuContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "bisaixiangmu_delete")
    private Integer bisaixiangmuDelete;


    /**
     * 发布日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
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
	 * 设置：项目标题
	 */
    public String getBisaixiangmuName() {
        return bisaixiangmuName;
    }


    /**
	 * 获取：项目标题
	 */

    public void setBisaixiangmuName(String bisaixiangmuName) {
        this.bisaixiangmuName = bisaixiangmuName;
    }
    /**
	 * 设置：项目封面
	 */
    public String getBisaixiangmuPhoto() {
        return bisaixiangmuPhoto;
    }


    /**
	 * 获取：项目封面
	 */

    public void setBisaixiangmuPhoto(String bisaixiangmuPhoto) {
        this.bisaixiangmuPhoto = bisaixiangmuPhoto;
    }
    /**
	 * 设置：工作时间
	 */
    public String getBisaixiangmuShijian() {
        return bisaixiangmuShijian;
    }


    /**
	 * 获取：工作时间
	 */

    public void setBisaixiangmuShijian(String bisaixiangmuShijian) {
        this.bisaixiangmuShijian = bisaixiangmuShijian;
    }
    /**
	 * 设置：负责人
	 */
    public String getBisaixiangmuFuzhenr() {
        return bisaixiangmuFuzhenr;
    }


    /**
	 * 获取：负责人
	 */

    public void setBisaixiangmuFuzhenr(String bisaixiangmuFuzhenr) {
        this.bisaixiangmuFuzhenr = bisaixiangmuFuzhenr;
    }
    /**
	 * 设置：联系方式
	 */
    public String getBisaixiangmuPhone() {
        return bisaixiangmuPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setBisaixiangmuPhone(String bisaixiangmuPhone) {
        this.bisaixiangmuPhone = bisaixiangmuPhone;
    }
    /**
	 * 设置：项目类型
	 */
    public Integer getBisaixiangmuTypes() {
        return bisaixiangmuTypes;
    }


    /**
	 * 获取：项目类型
	 */

    public void setBisaixiangmuTypes(Integer bisaixiangmuTypes) {
        this.bisaixiangmuTypes = bisaixiangmuTypes;
    }
    /**
	 * 设置：结束时间
	 */
    public Date getJieshuTime() {
        return jieshuTime;
    }


    /**
	 * 获取：结束时间
	 */

    public void setJieshuTime(Date jieshuTime) {
        this.jieshuTime = jieshuTime;
    }
    /**
	 * 设置：项目详情
	 */
    public String getBisaixiangmuContent() {
        return bisaixiangmuContent;
    }


    /**
	 * 获取：项目详情
	 */

    public void setBisaixiangmuContent(String bisaixiangmuContent) {
        this.bisaixiangmuContent = bisaixiangmuContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getBisaixiangmuDelete() {
        return bisaixiangmuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setBisaixiangmuDelete(Integer bisaixiangmuDelete) {
        this.bisaixiangmuDelete = bisaixiangmuDelete;
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
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
