package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZixunCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 资讯收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zixun_collection")
public class ZixunCollectionView extends ZixunCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String zixunCollectionValue;

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
	//级联表 运动会资讯
		/**
		* 资讯标题
		*/

		@ColumnInfo(comment="资讯标题",type="varchar(200)")
		private String zixunName;
		/**
		* 资讯封面
		*/

		@ColumnInfo(comment="资讯封面",type="varchar(200)")
		private String zixunPhoto;
		/**
		* 视频
		*/

		@ColumnInfo(comment="视频",type="varchar(200)")
		private String zixunVideo;
		/**
		* 资讯类型
		*/
		@ColumnInfo(comment="资讯类型",type="int(11)")
		private Integer zixunTypes;
			/**
			* 资讯类型的值
			*/
			@ColumnInfo(comment="资讯类型的字典表值",type="varchar(200)")
			private String zixunValue;
		/**
		* 资讯热度
		*/

		@ColumnInfo(comment="资讯热度",type="int(11)")
		private Integer zixunClicknum;
		/**
		* 资讯介绍
		*/

		@ColumnInfo(comment="资讯介绍",type="longtext")
		private String zixunContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer zixunDelete;



	public ZixunCollectionView() {

	}

	public ZixunCollectionView(ZixunCollectionEntity zixunCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, zixunCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getZixunCollectionValue() {
		return zixunCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setZixunCollectionValue(String zixunCollectionValue) {
		this.zixunCollectionValue = zixunCollectionValue;
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
	//级联表的get和set 运动会资讯

		/**
		* 获取： 资讯标题
		*/
		public String getZixunName() {
			return zixunName;
		}
		/**
		* 设置： 资讯标题
		*/
		public void setZixunName(String zixunName) {
			this.zixunName = zixunName;
		}

		/**
		* 获取： 资讯封面
		*/
		public String getZixunPhoto() {
			return zixunPhoto;
		}
		/**
		* 设置： 资讯封面
		*/
		public void setZixunPhoto(String zixunPhoto) {
			this.zixunPhoto = zixunPhoto;
		}

		/**
		* 获取： 视频
		*/
		public String getZixunVideo() {
			return zixunVideo;
		}
		/**
		* 设置： 视频
		*/
		public void setZixunVideo(String zixunVideo) {
			this.zixunVideo = zixunVideo;
		}
		/**
		* 获取： 资讯类型
		*/
		public Integer getZixunTypes() {
			return zixunTypes;
		}
		/**
		* 设置： 资讯类型
		*/
		public void setZixunTypes(Integer zixunTypes) {
			this.zixunTypes = zixunTypes;
		}


			/**
			* 获取： 资讯类型的值
			*/
			public String getZixunValue() {
				return zixunValue;
			}
			/**
			* 设置： 资讯类型的值
			*/
			public void setZixunValue(String zixunValue) {
				this.zixunValue = zixunValue;
			}

		/**
		* 获取： 资讯热度
		*/
		public Integer getZixunClicknum() {
			return zixunClicknum;
		}
		/**
		* 设置： 资讯热度
		*/
		public void setZixunClicknum(Integer zixunClicknum) {
			this.zixunClicknum = zixunClicknum;
		}

		/**
		* 获取： 资讯介绍
		*/
		public String getZixunContent() {
			return zixunContent;
		}
		/**
		* 设置： 资讯介绍
		*/
		public void setZixunContent(String zixunContent) {
			this.zixunContent = zixunContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getZixunDelete() {
			return zixunDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setZixunDelete(Integer zixunDelete) {
			this.zixunDelete = zixunDelete;
		}


	@Override
	public String toString() {
		return "ZixunCollectionView{" +
			", zixunCollectionValue=" + zixunCollectionValue +
			", zixunName=" + zixunName +
			", zixunPhoto=" + zixunPhoto +
			", zixunVideo=" + zixunVideo +
			", zixunClicknum=" + zixunClicknum +
			", zixunContent=" + zixunContent +
			", zixunDelete=" + zixunDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
