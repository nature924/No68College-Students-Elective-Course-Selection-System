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
 * 选课限制
 *
 * @author 
 * @email
 */
@TableName("xuankexianzhi")
public class XuankexianzhiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XuankexianzhiEntity() {

	}

	public XuankexianzhiEntity(T t) {
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
     * 选课数量
     */
    @ColumnInfo(comment="选课数量",type="int(11)")
    @TableField(value = "xuankexianzhi_number")

    private Integer xuankexianzhiNumber;


    /**
     * 开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="开始时间",type="timestamp")
    @TableField(value = "kaishi_time")

    private Date kaishiTime;


    /**
     * 结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="结束时间",type="timestamp")
    @TableField(value = "jieshu_time")

    private Date jieshuTime;


    /**
     * 创建时间
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
	 * 获取：选课数量
	 */
    public Integer getXuankexianzhiNumber() {
        return xuankexianzhiNumber;
    }
    /**
	 * 设置：选课数量
	 */

    public void setXuankexianzhiNumber(Integer xuankexianzhiNumber) {
        this.xuankexianzhiNumber = xuankexianzhiNumber;
    }
    /**
	 * 获取：开始时间
	 */
    public Date getKaishiTime() {
        return kaishiTime;
    }
    /**
	 * 设置：开始时间
	 */

    public void setKaishiTime(Date kaishiTime) {
        this.kaishiTime = kaishiTime;
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
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Xuankexianzhi{" +
            ", id=" + id +
            ", xuankexianzhiNumber=" + xuankexianzhiNumber +
            ", kaishiTime=" + DateUtil.convertString(kaishiTime,"yyyy-MM-dd") +
            ", jieshuTime=" + DateUtil.convertString(jieshuTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
