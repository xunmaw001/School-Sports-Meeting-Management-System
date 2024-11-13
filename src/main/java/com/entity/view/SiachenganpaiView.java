package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.SiachenganpaiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 赛程安排
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("siachenganpai")
public class SiachenganpaiView extends SiachenganpaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 比赛状态的值
	*/
	@ColumnInfo(comment="比赛状态的字典表值",type="varchar(200)")
	private String zhuangtaiValue;
	/**
	* 比赛结果的值
	*/
	@ColumnInfo(comment="比赛结果的字典表值",type="varchar(200)")
	private String siachenganpaiValue;

	//级联表 项目信息
		/**
		* 项目标题
		*/

		@ColumnInfo(comment="项目标题",type="varchar(200)")
		private String bisaixiangmuName;
		/**
		* 项目封面
		*/

		@ColumnInfo(comment="项目封面",type="varchar(200)")
		private String bisaixiangmuPhoto;
		/**
		* 工作时间
		*/

		@ColumnInfo(comment="工作时间",type="varchar(200)")
		private String bisaixiangmuShijian;
		/**
		* 负责人
		*/

		@ColumnInfo(comment="负责人",type="varchar(200)")
		private String bisaixiangmuFuzhenr;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String bisaixiangmuPhone;
		/**
		* 项目类型
		*/
		@ColumnInfo(comment="项目类型",type="int(11)")
		private Integer bisaixiangmuTypes;
			/**
			* 项目类型的值
			*/
			@ColumnInfo(comment="项目类型的字典表值",type="varchar(200)")
			private String bisaixiangmuValue;
		/**
		* 结束时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="结束时间",type="timestamp")
		private Date jieshuTime;
		/**
		* 项目详情
		*/

		@ColumnInfo(comment="项目详情",type="longtext")
		private String bisaixiangmuContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer bisaixiangmuDelete;
	//级联表 用户
		/**
		* 用户名称
		*/

		@ColumnInfo(comment="用户名称",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;



	public SiachenganpaiView() {

	}

	public SiachenganpaiView(SiachenganpaiEntity siachenganpaiEntity) {
		try {
			BeanUtils.copyProperties(this, siachenganpaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 比赛状态的值
	*/
	public String getZhuangtaiValue() {
		return zhuangtaiValue;
	}
	/**
	* 设置： 比赛状态的值
	*/
	public void setZhuangtaiValue(String zhuangtaiValue) {
		this.zhuangtaiValue = zhuangtaiValue;
	}
	//当前表的
	/**
	* 获取： 比赛结果的值
	*/
	public String getSiachenganpaiValue() {
		return siachenganpaiValue;
	}
	/**
	* 设置： 比赛结果的值
	*/
	public void setSiachenganpaiValue(String siachenganpaiValue) {
		this.siachenganpaiValue = siachenganpaiValue;
	}


	//级联表的get和set 项目信息

		/**
		* 获取： 项目标题
		*/
		public String getBisaixiangmuName() {
			return bisaixiangmuName;
		}
		/**
		* 设置： 项目标题
		*/
		public void setBisaixiangmuName(String bisaixiangmuName) {
			this.bisaixiangmuName = bisaixiangmuName;
		}

		/**
		* 获取： 项目封面
		*/
		public String getBisaixiangmuPhoto() {
			return bisaixiangmuPhoto;
		}
		/**
		* 设置： 项目封面
		*/
		public void setBisaixiangmuPhoto(String bisaixiangmuPhoto) {
			this.bisaixiangmuPhoto = bisaixiangmuPhoto;
		}

		/**
		* 获取： 工作时间
		*/
		public String getBisaixiangmuShijian() {
			return bisaixiangmuShijian;
		}
		/**
		* 设置： 工作时间
		*/
		public void setBisaixiangmuShijian(String bisaixiangmuShijian) {
			this.bisaixiangmuShijian = bisaixiangmuShijian;
		}

		/**
		* 获取： 负责人
		*/
		public String getBisaixiangmuFuzhenr() {
			return bisaixiangmuFuzhenr;
		}
		/**
		* 设置： 负责人
		*/
		public void setBisaixiangmuFuzhenr(String bisaixiangmuFuzhenr) {
			this.bisaixiangmuFuzhenr = bisaixiangmuFuzhenr;
		}

		/**
		* 获取： 联系方式
		*/
		public String getBisaixiangmuPhone() {
			return bisaixiangmuPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setBisaixiangmuPhone(String bisaixiangmuPhone) {
			this.bisaixiangmuPhone = bisaixiangmuPhone;
		}
		/**
		* 获取： 项目类型
		*/
		public Integer getBisaixiangmuTypes() {
			return bisaixiangmuTypes;
		}
		/**
		* 设置： 项目类型
		*/
		public void setBisaixiangmuTypes(Integer bisaixiangmuTypes) {
			this.bisaixiangmuTypes = bisaixiangmuTypes;
		}


			/**
			* 获取： 项目类型的值
			*/
			public String getBisaixiangmuValue() {
				return bisaixiangmuValue;
			}
			/**
			* 设置： 项目类型的值
			*/
			public void setBisaixiangmuValue(String bisaixiangmuValue) {
				this.bisaixiangmuValue = bisaixiangmuValue;
			}

		/**
		* 获取： 结束时间
		*/
		public Date getJieshuTime() {
			return jieshuTime;
		}
		/**
		* 设置： 结束时间
		*/
		public void setJieshuTime(Date jieshuTime) {
			this.jieshuTime = jieshuTime;
		}

		/**
		* 获取： 项目详情
		*/
		public String getBisaixiangmuContent() {
			return bisaixiangmuContent;
		}
		/**
		* 设置： 项目详情
		*/
		public void setBisaixiangmuContent(String bisaixiangmuContent) {
			this.bisaixiangmuContent = bisaixiangmuContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getBisaixiangmuDelete() {
			return bisaixiangmuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setBisaixiangmuDelete(Integer bisaixiangmuDelete) {
			this.bisaixiangmuDelete = bisaixiangmuDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户名称
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户名称
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "SiachenganpaiView{" +
			", zhuangtaiValue=" + zhuangtaiValue +
			", siachenganpaiValue=" + siachenganpaiValue +
			", bisaixiangmuName=" + bisaixiangmuName +
			", bisaixiangmuPhoto=" + bisaixiangmuPhoto +
			", bisaixiangmuShijian=" + bisaixiangmuShijian +
			", bisaixiangmuFuzhenr=" + bisaixiangmuFuzhenr +
			", bisaixiangmuPhone=" + bisaixiangmuPhone +
			", jieshuTime=" + DateUtil.convertString(jieshuTime,"yyyy-MM-dd") +
			", bisaixiangmuContent=" + bisaixiangmuContent +
			", bisaixiangmuDelete=" + bisaixiangmuDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
