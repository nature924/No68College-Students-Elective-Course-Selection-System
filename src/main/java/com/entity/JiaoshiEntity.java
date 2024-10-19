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
 * 教师
 *
 * @author 
 * @email
 */
@TableName("jiaoshi")
public class JiaoshiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaoshiEntity() {

	}

	public JiaoshiEntity(T t) {
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
     * 工号
     */
    @ColumnInfo(comment="工号",type="varchar(200)")
    @TableField(value = "jiaoshi_uuid_number")

    private String jiaoshiUuidNumber;


    /**
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 教师姓名
     */
    @ColumnInfo(comment="教师姓名",type="varchar(200)")
    @TableField(value = "jiaoshi_name")

    private String jiaoshiName;


    /**
     * 头像
     */
    @ColumnInfo(comment="头像",type="varchar(255)")
    @TableField(value = "jiaoshi_photo")

    private String jiaoshiPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 联系方式
     */
    @ColumnInfo(comment="联系方式",type="varchar(200)")
    @TableField(value = "jiaoshi_phone")

    private String jiaoshiPhone;


    /**
     * 邮箱
     */
    @ColumnInfo(comment="邮箱",type="varchar(200)")
    @TableField(value = "jiaoshi_email")

    private String jiaoshiEmail;


    /**
     * 班级
     */
    @ColumnInfo(comment="班级",type="int(11)")
    @TableField(value = "banji_types")

    private Integer banjiTypes;


    /**
     * 假删
     */
    @ColumnInfo(comment="假删",type="int(11)")
    @TableField(value = "jiaoshi_delete")

    private Integer jiaoshiDelete;


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
	 * 获取：工号
	 */
    public String getJiaoshiUuidNumber() {
        return jiaoshiUuidNumber;
    }
    /**
	 * 设置：工号
	 */

    public void setJiaoshiUuidNumber(String jiaoshiUuidNumber) {
        this.jiaoshiUuidNumber = jiaoshiUuidNumber;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：教师姓名
	 */
    public String getJiaoshiName() {
        return jiaoshiName;
    }
    /**
	 * 设置：教师姓名
	 */

    public void setJiaoshiName(String jiaoshiName) {
        this.jiaoshiName = jiaoshiName;
    }
    /**
	 * 获取：头像
	 */
    public String getJiaoshiPhoto() {
        return jiaoshiPhoto;
    }
    /**
	 * 设置：头像
	 */

    public void setJiaoshiPhoto(String jiaoshiPhoto) {
        this.jiaoshiPhoto = jiaoshiPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：联系方式
	 */
    public String getJiaoshiPhone() {
        return jiaoshiPhone;
    }
    /**
	 * 设置：联系方式
	 */

    public void setJiaoshiPhone(String jiaoshiPhone) {
        this.jiaoshiPhone = jiaoshiPhone;
    }
    /**
	 * 获取：邮箱
	 */
    public String getJiaoshiEmail() {
        return jiaoshiEmail;
    }
    /**
	 * 设置：邮箱
	 */

    public void setJiaoshiEmail(String jiaoshiEmail) {
        this.jiaoshiEmail = jiaoshiEmail;
    }
    /**
	 * 获取：班级
	 */
    public Integer getBanjiTypes() {
        return banjiTypes;
    }
    /**
	 * 设置：班级
	 */

    public void setBanjiTypes(Integer banjiTypes) {
        this.banjiTypes = banjiTypes;
    }
    /**
	 * 获取：假删
	 */
    public Integer getJiaoshiDelete() {
        return jiaoshiDelete;
    }
    /**
	 * 设置：假删
	 */

    public void setJiaoshiDelete(Integer jiaoshiDelete) {
        this.jiaoshiDelete = jiaoshiDelete;
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
        return "Jiaoshi{" +
            ", id=" + id +
            ", jiaoshiUuidNumber=" + jiaoshiUuidNumber +
            ", username=" + username +
            ", password=" + password +
            ", jiaoshiName=" + jiaoshiName +
            ", jiaoshiPhoto=" + jiaoshiPhoto +
            ", sexTypes=" + sexTypes +
            ", jiaoshiPhone=" + jiaoshiPhone +
            ", jiaoshiEmail=" + jiaoshiEmail +
            ", banjiTypes=" + banjiTypes +
            ", jiaoshiDelete=" + jiaoshiDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
