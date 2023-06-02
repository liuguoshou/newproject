package com.ruoyi.xts.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目信息对象 xts_project
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
public class XtsProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目id */
    private Long projectId;

    /** 开票id */
    @Excel(name = "开票id")
    private Long billId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 客户id */
    @Excel(name = "客户id")
    private Long customId;

    /** 联系人id */
    @Excel(name = "联系人id")
    private Long contactId;

    /** 商务费用 */
    @Excel(name = "商务费用")
    private String swfy;

    /** 净利润 */
    @Excel(name = "净利润")
    private String jlr;

    /** 分包工作量 */
    @Excel(name = "分包工作量")
    private String fbGzl;

    /** 分包金额 */
    @Excel(name = "分包金额")
    private String fbJe;

    /** 分包开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "分包开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fbBtime;

    /** 分包结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "分包结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fbEtime;

    /** 项目状态（0正常 1停用） */
    @Excel(name = "项目状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }
    public void setBillId(Long billId) 
    {
        this.billId = billId;
    }

    public Long getBillId() 
    {
        return billId;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setCustomId(Long customId) 
    {
        this.customId = customId;
    }

    public Long getCustomId() 
    {
        return customId;
    }
    public void setContactId(Long contactId) 
    {
        this.contactId = contactId;
    }

    public Long getContactId() 
    {
        return contactId;
    }
    public void setSwfy(String swfy) 
    {
        this.swfy = swfy;
    }

    public String getSwfy() 
    {
        return swfy;
    }
    public void setJlr(String jlr) 
    {
        this.jlr = jlr;
    }

    public String getJlr() 
    {
        return jlr;
    }
    public void setFbGzl(String fbGzl) 
    {
        this.fbGzl = fbGzl;
    }

    public String getFbGzl() 
    {
        return fbGzl;
    }
    public void setFbJe(String fbJe) 
    {
        this.fbJe = fbJe;
    }

    public String getFbJe() 
    {
        return fbJe;
    }
    public void setFbBtime(Date fbBtime) 
    {
        this.fbBtime = fbBtime;
    }

    public Date getFbBtime() 
    {
        return fbBtime;
    }
    public void setFbEtime(Date fbEtime) 
    {
        this.fbEtime = fbEtime;
    }

    public Date getFbEtime() 
    {
        return fbEtime;
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
            .append("projectId", getProjectId())
            .append("billId", getBillId())
            .append("projectName", getProjectName())
            .append("customId", getCustomId())
            .append("contactId", getContactId())
            .append("swfy", getSwfy())
            .append("jlr", getJlr())
            .append("fbGzl", getFbGzl())
            .append("fbJe", getFbJe())
            .append("fbBtime", getFbBtime())
            .append("fbEtime", getFbEtime())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
