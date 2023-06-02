package com.ruoyi.xts.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 联系人信息对象 xts_contacts
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
public class XtsContacts extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 联系人id */
    private Long conId;

    /** 联系人名称 */
    @Excel(name = "联系人名称")
    private String conName;

    /** 联系人职务 */
    @Excel(name = "联系人职务")
    private String title;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 所属公司 */
    @Excel(name = "所属公司")
    private String company;

    /** 联系状态（0正常 1停用） */
    @Excel(name = "联系状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setConId(Long conId) 
    {
        this.conId = conId;
    }

    public Long getConId() 
    {
        return conId;
    }
    public void setConName(String conName) 
    {
        this.conName = conName;
    }

    public String getConName() 
    {
        return conName;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setCompany(String company) 
    {
        this.company = company;
    }

    public String getCompany() 
    {
        return company;
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
            .append("conId", getConId())
            .append("conName", getConName())
            .append("title", getTitle())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("company", getCompany())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
