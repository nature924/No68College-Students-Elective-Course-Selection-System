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
 * 学生成绩
 *
 * @author 
 * @email
 */
@TableName("chengji")
public class ChengjiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChengjiEntity() {

	}

	public ChengjiEntity(T t) {
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
     * 成绩标题
     */
    @ColumnInfo(comment="成绩标题",type="varchar(200)")
    @TableField(value = "chengji_name")

    private String chengjiName;


    /**
     * 成绩类型
     */
    @ColumnInfo(comment="成绩类型",type="int(11)")
    @TableField(value = "chengji_types")

    private Integer chengjiTypes;


    /**
     * 成绩
     */
    @ColumnInfo(comment="成绩",type="int(11)")
    @TableField(value = "xuenfen_number")

    private Integer xuenfenNumber;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="text")
    @TableField(value = "chengji_content")

    private String chengjiContent;


    /**
     * 学生
     */
    @ColumnInfo(comment="学生",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 假删
     */
    @ColumnInfo(comment="假删",type="int(11)")
    @TableField(value = "chengji_delete")

    private Integer chengjiDelete;


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
	 * 获取：成绩标题
	 */
    public String getChengjiName() {
        return chengjiName;
    }
    /**
	 * 设置：成绩标题
	 */

    public void setChengjiName(String chengjiName) {
        this.chengjiName = chengjiName;
    }
    /**
	 * 获取：成绩类型
	 */
    public Integer getChengjiTypes() {
        return chengjiTypes;
    }
    /**
	 * 设置：成绩类型
	 */

    public void setChengjiTypes(Integer chengjiTypes) {
        this.chengjiTypes = chengjiTypes;
    }
    /**
	 * 获取：成绩
	 */
    public Integer getXuenfenNumber() {
        return xuenfenNumber;
    }
    /**
	 * 设置：成绩
	 */

    public void setXuenfenNumber(Integer xuenfenNumber) {
        this.xuenfenNumber = xuenfenNumber;
    }
    /**
	 * 获取：备注
	 */
    public String getChengjiContent() {
        return chengjiContent;
    }
    /**
	 * 设置：备注
	 */

    public void setChengjiContent(String chengjiContent) {
        this.chengjiContent = chengjiContent;
    }
    /**
	 * 获取：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：假删
	 */
    public Integer getChengjiDelete() {
        return chengjiDelete;
    }
    /**
	 * 设置：假删
	 */

    public void setChengjiDelete(Integer chengjiDelete) {
        this.chengjiDelete = chengjiDelete;
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
        return "Chengji{" +
            ", id=" + id +
            ", chengjiName=" + chengjiName +
            ", chengjiTypes=" + chengjiTypes +
            ", xuenfenNumber=" + xuenfenNumber +
            ", chengjiContent=" + chengjiContent +
            ", yonghuId=" + yonghuId +
            ", chengjiDelete=" + chengjiDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
