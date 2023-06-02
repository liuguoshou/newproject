package com.ruoyi.xts.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 周报信息对象 xts_work
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
public class XtsWork extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 周报id */
    private Long workId;

    /** 项目id */
    @Excel(name = "项目id")
    private Long projectId;

    /** 周报名称 */
    @Excel(name = "周报名称")
    private String workName;

    /** 周报状态（0正常 1停用） */
    @Excel(name = "周报状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setWorkId(Long workId) 
    {
        this.workId = workId;
    }

    public Long getWorkId() 
    {
        return workId;
    }
    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }
    public void setWorkName(String workName) 
    {
        this.workName = workName;
    }

    public String getWorkName() 
    {
        return workName;
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
            .append("workId", getWorkId())
            .append("projectId", getProjectId())
            .append("workName", getWorkName())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
