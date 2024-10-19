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
 * 排课信息
 *
 * @author 
 * @email
 */
@TableName("paike")
public class PaikeEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PaikeEntity() {

	}

	public PaikeEntity(T t) {
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
     * 课程
     */
    @ColumnInfo(comment="课程",type="int(11)")
    @TableField(value = "kecheng_id")

    private Integer kechengId;


    /**
     * 上课时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="上课时间",type="timestamp")
    @TableField(value = "shangke_time")

    private Date shangkeTime;


    /**
     * 结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="结束时间",type="timestamp")
    @TableField(value = "xiake_time")

    private Date xiakeTime;


    /**
     * 第几节
     */
    @ColumnInfo(comment="第几节",type="int(11)")
    @TableField(value = "jieke_types")

    private Integer jiekeTypes;


    /**
     * 学期
     */
    @ColumnInfo(comment="学期",type="int(11)")
    @TableField(value = "xueqi_types")

    private Integer xueqiTypes;


    /**
     * 周次
     */
    @ColumnInfo(comment="周次",type="int(11)")
    @TableField(value = "xingqi_types")

    private Integer xingqiTypes;


    /**
     * 上课地点
     */
    @ColumnInfo(comment="上课地点",type="varchar(200)")
    @TableField(value = "paike_address")

    private String paikeAddress;


    /**
     * 教师
     */
    @ColumnInfo(comment="教师",type="int(11)")
    @TableField(value = "jiaoshi_id")

    private Integer jiaoshiId;


    /**
     * 假删
     */
    @ColumnInfo(comment="假删",type="int(11)")
    @TableField(value = "paike_delete")

    private Integer paikeDelete;


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
	 * 获取：课程
	 */
    public Integer getKechengId() {
        return kechengId;
    }
    /**
	 * 设置：课程
	 */

    public void setKechengId(Integer kechengId) {
        this.kechengId = kechengId;
    }
    /**
	 * 获取：上课时间
	 */
    public Date getShangkeTime() {
        return shangkeTime;
    }
    /**
	 * 设置：上课时间
	 */

    public void setShangkeTime(Date shangkeTime) {
        this.shangkeTime = shangkeTime;
    }
    /**
	 * 获取：结束时间
	 */
    public Date getXiakeTime() {
        return xiakeTime;
    }
    /**
	 * 设置：结束时间
	 */

    public void setXiakeTime(Date xiakeTime) {
        this.xiakeTime = xiakeTime;
    }
    /**
	 * 获取：第几节
	 */
    public Integer getJiekeTypes() {
        return jiekeTypes;
    }
    /**
	 * 设置：第几节
	 */

    public void setJiekeTypes(Integer jiekeTypes) {
        this.jiekeTypes = jiekeTypes;
    }
    /**
	 * 获取：学期
	 */
    public Integer getXueqiTypes() {
        return xueqiTypes;
    }
    /**
	 * 设置：学期
	 */

    public void setXueqiTypes(Integer xueqiTypes) {
        this.xueqiTypes = xueqiTypes;
    }
    /**
	 * 获取：周次
	 */
    public Integer getXingqiTypes() {
        return xingqiTypes;
    }
    /**
	 * 设置：周次
	 */

    public void setXingqiTypes(Integer xingqiTypes) {
        this.xingqiTypes = xingqiTypes;
    }
    /**
	 * 获取：上课地点
	 */
    public String getPaikeAddress() {
        return paikeAddress;
    }
    /**
	 * 设置：上课地点
	 */

    public void setPaikeAddress(String paikeAddress) {
        this.paikeAddress = paikeAddress;
    }
    /**
	 * 获取：教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }
    /**
	 * 设置：教师
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 获取：假删
	 */
    public Integer getPaikeDelete() {
        return paikeDelete;
    }
    /**
	 * 设置：假删
	 */

    public void setPaikeDelete(Integer paikeDelete) {
        this.paikeDelete = paikeDelete;
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
        return "Paike{" +
            ", id=" + id +
            ", kechengId=" + kechengId +
            ", shangkeTime=" + DateUtil.convertString(shangkeTime,"yyyy-MM-dd") +
            ", xiakeTime=" + DateUtil.convertString(xiakeTime,"yyyy-MM-dd") +
            ", jiekeTypes=" + jiekeTypes +
            ", xueqiTypes=" + xueqiTypes +
            ", xingqiTypes=" + xingqiTypes +
            ", paikeAddress=" + paikeAddress +
            ", jiaoshiId=" + jiaoshiId +
            ", paikeDelete=" + paikeDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
