package com.ruoyi.xts.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 付款信息对象 xts_pay
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
public class XtsPay extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 付款id */
    private Long payId;

    /** 项目id */
    @Excel(name = "项目id")
    private Long projectId;

    /** 期数 */
    @Excel(name = "期数")
    private String payPeriod;

    /** 比例% */
    @Excel(name = "比例%")
    private String rate;

    /** 金额 */
    @Excel(name = "金额")
    private String money;

    /** 验收状态 */
    @Excel(name = "验收状态")
    private String ysFlag;

    /** 开票状态 */
    @Excel(name = "开票状态")
    private String kpFlag;

    /** 付款状态 */
    @Excel(name = "付款状态")
    private String fkFlag;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setPayId(Long payId) 
    {
        this.payId = payId;
    }

    public Long getPayId() 
    {
        return payId;
    }
    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }
    public void setPayPeriod(String payPeriod) 
    {
        this.payPeriod = payPeriod;
    }

    public String getPayPeriod() 
    {
        return payPeriod;
    }
    public void setRate(String rate) 
    {
        this.rate = rate;
    }

    public String getRate() 
    {
        return rate;
    }
    public void setMoney(String money) 
    {
        this.money = money;
    }

    public String getMoney() 
    {
        return money;
    }
    public void setYsFlag(String ysFlag) 
    {
        this.ysFlag = ysFlag;
    }

    public String getYsFlag() 
    {
        return ysFlag;
    }
    public void setKpFlag(String kpFlag) 
    {
        this.kpFlag = kpFlag;
    }

    public String getKpFlag() 
    {
        return kpFlag;
    }
    public void setFkFlag(String fkFlag) 
    {
        this.fkFlag = fkFlag;
    }

    public String getFkFlag() 
    {
        return fkFlag;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("payId", getPayId())
            .append("projectId", getProjectId())
            .append("payPeriod", getPayPeriod())
            .append("rate", getRate())
            .append("money", getMoney())
            .append("ysFlag", getYsFlag())
            .append("kpFlag", getKpFlag())
            .append("fkFlag", getFkFlag())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
