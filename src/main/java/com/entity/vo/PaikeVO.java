package com.entity.vo;

import com.entity.PaikeEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 排课信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("paike")
public class PaikeVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 课程
     */

    @TableField(value = "kecheng_id")
    private Integer kechengId;


    /**
     * 上课时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shangke_time")
    private Date shangkeTime;


    /**
     * 结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "xiake_time")
    private Date xiakeTime;


    /**
     * 第几节
     */

    @TableField(value = "jieke_types")
    private Integer jiekeTypes;


    /**
     * 学期
     */

    @TableField(value = "xueqi_types")
    private Integer xueqiTypes;


    /**
     * 周次
     */

    @TableField(value = "xingqi_types")
    private Integer xingqiTypes;


    /**
     * 上课地点
     */

    @TableField(value = "paike_address")
    private String paikeAddress;


    /**
     * 教师
     */

    @TableField(value = "jiaoshi_id")
    private Integer jiaoshiId;


    /**
     * 假删
     */

    @TableField(value = "paike_delete")
    private Integer paikeDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：课程
	 */
    public Integer getKechengId() {
        return kechengId;
    }


    /**
	 * 获取：课程
	 */

    public void setKechengId(Integer kechengId) {
        this.kechengId = kechengId;
    }
    /**
	 * 设置：上课时间
	 */
    public Date getShangkeTime() {
        return shangkeTime;
    }


    /**
	 * 获取：上课时间
	 */

    public void setShangkeTime(Date shangkeTime) {
        this.shangkeTime = shangkeTime;
    }
    /**
	 * 设置：结束时间
	 */
    public Date getXiakeTime() {
        return xiakeTime;
    }


    /**
	 * 获取：结束时间
	 */

    public void setXiakeTime(Date xiakeTime) {
        this.xiakeTime = xiakeTime;
    }
    /**
	 * 设置：第几节
	 */
    public Integer getJiekeTypes() {
        return jiekeTypes;
    }


    /**
	 * 获取：第几节
	 */

    public void setJiekeTypes(Integer jiekeTypes) {
        this.jiekeTypes = jiekeTypes;
    }
    /**
	 * 设置：学期
	 */
    public Integer getXueqiTypes() {
        return xueqiTypes;
    }


    /**
	 * 获取：学期
	 */

    public void setXueqiTypes(Integer xueqiTypes) {
        this.xueqiTypes = xueqiTypes;
    }
    /**
	 * 设置：周次
	 */
    public Integer getXingqiTypes() {
        return xingqiTypes;
    }


    /**
	 * 获取：周次
	 */

    public void setXingqiTypes(Integer xingqiTypes) {
        this.xingqiTypes = xingqiTypes;
    }
    /**
	 * 设置：上课地点
	 */
    public String getPaikeAddress() {
        return paikeAddress;
    }


    /**
	 * 获取：上课地点
	 */

    public void setPaikeAddress(String paikeAddress) {
        this.paikeAddress = paikeAddress;
    }
    /**
	 * 设置：教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 获取：教师
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 设置：假删
	 */
    public Integer getPaikeDelete() {
        return paikeDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setPaikeDelete(Integer paikeDelete) {
        this.paikeDelete = paikeDelete;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
