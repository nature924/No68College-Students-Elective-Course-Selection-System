package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.KechengEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 课程信息
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("kecheng")
public class KechengView extends KechengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 课程类型的值
	*/
	@ColumnInfo(comment="课程类型的字典表值",type="varchar(200)")
	private String kechengValue;




	public KechengView() {

	}

	public KechengView(KechengEntity kechengEntity) {
		try {
			BeanUtils.copyProperties(this, kechengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 课程类型的值
	*/
	public String getKechengValue() {
		return kechengValue;
	}
	/**
	* 设置： 课程类型的值
	*/
	public void setKechengValue(String kechengValue) {
		this.kechengValue = kechengValue;
	}




	@Override
	public String toString() {
		return "KechengView{" +
			", kechengValue=" + kechengValue +
			"} " + super.toString();
	}
}
