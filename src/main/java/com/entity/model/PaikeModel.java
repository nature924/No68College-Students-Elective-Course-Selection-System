package com.entity.model;

import com.entity.PaikeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 排课信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PaikeModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 课程
     */
    private Integer kechengId;


    /**
     * 上课时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shangkeTime;


    /**
     * 结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xiakeTime;


    /**
     * 第几节
     */
    private Integer jiekeTypes;


    /**
     * 学期
     */
    private Integer xueqiTypes;


    /**
     * 周次
     */
    private Integer xingqiTypes;


    /**
     * 上课地点
     */
    private String paikeAddress;


    /**
     * 教师
     */
    private Integer jiaoshiId;


    /**
     * 假删
     */
    private Integer paikeDelete;


    /**
     * 创建时间
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

    }
