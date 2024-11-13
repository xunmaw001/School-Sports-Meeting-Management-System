package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.BisaixiangmuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 项目信息
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("bisaixiangmu")
public class BisaixiangmuView extends BisaixiangmuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 项目类型的值
	*/
	@ColumnInfo(comment="项目类型的字典表值",type="varchar(200)")
	private String bisaixiangmuValue;




	public BisaixiangmuView() {

	}

	public BisaixiangmuView(BisaixiangmuEntity bisaixiangmuEntity) {
		try {
			BeanUtils.copyProperties(this, bisaixiangmuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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




	@Override
	public String toString() {
		return "BisaixiangmuView{" +
			", bisaixiangmuValue=" + bisaixiangmuValue +
			"} " + super.toString();
	}
}
