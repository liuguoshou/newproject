package com.ruoyi.xts.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户信息对象 xts_custom
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
public class XtsCustom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 客户id */
    private Long cusId;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String cusName;

    /** 客户简称 */
    @Excel(name = "客户简称")
    private String shortname;

    /** 客户编码 */
    @Excel(name = "客户编码")
    private String no;

    /** 客户状态（0正常 1停用） */
    @Excel(name = "客户状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setCusId(Long cusId) 
    {
        this.cusId = cusId;
    }

    public Long getCusId() 
    {
        return cusId;
    }
    public void setCusName(String cusName) 
    {
        this.cusName = cusName;
    }

    public String getCusName() 
    {
        return cusName;
    }
    public void setShortname(String shortname) 
    {
        this.shortname = shortname;
    }

    public String getShortname() 
    {
        return shortname;
    }
    public void setNo(String no) 
    {
        this.no = no;
    }

    public String getNo() 
    {
        return no;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
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
            .append("cusId", getCusId())
            .append("cusName", getCusName())
            .append("shortname", getShortname())
            .append("no", getNo())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
