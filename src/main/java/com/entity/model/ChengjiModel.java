package com.entity.model;

import com.entity.ChengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 学生成绩
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChengjiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 成绩标题
     */
    private String chengjiName;


    /**
     * 成绩类型
     */
    private Integer chengjiTypes;


    /**
     * 成绩
     */
    private Integer xuenfenNumber;


    /**
     * 备注
     */
    private String chengjiContent;


    /**
     * 学生
     */
    private Integer yonghuId;


    /**
     * 假删
     */
    private Integer chengjiDelete;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
