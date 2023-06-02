package com.ruoyi.xts.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 开票信息对象 xts_bill
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
public class XtsBill extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 开票id */
    private Long billId;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String name;

    /** 公司税号 */
    @Excel(name = "公司税号")
    private String sno;

    /** 单位地址 */
    @Excel(name = "单位地址")
    private String address;

    /** 开户银行 */
    @Excel(name = "开户银行")
    private String bank;

    /** 银行账户 */
    @Excel(name = "银行账户")
    private String bankNo;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 联系人名称 */
    @Excel(name = "联系人名称")
    private String conName;

    /** 联系人地址 */
    @Excel(name = "联系人地址")
    private String conAddress;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private String conPhone;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setBillId(Long billId) 
    {
        this.billId = billId;
    }

    public Long getBillId() 
    {
        return billId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSno(String sno) 
    {
        this.sno = sno;
    }

    public String getSno() 
    {
        return sno;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setBank(String bank) 
    {
        this.bank = bank;
    }

    public String getBank() 
    {
        return bank;
    }
    public void setBankNo(String bankNo) 
    {
        this.bankNo = bankNo;
    }

    public String getBankNo() 
    {
        return bankNo;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setConName(String conName) 
    {
        this.conName = conName;
    }

    public String getConName() 
    {
        return conName;
    }
    public void setConAddress(String conAddress) 
    {
        this.conAddress = conAddress;
    }

    public String getConAddress() 
    {
        return conAddress;
    }
    public void setConPhone(String conPhone) 
    {
        this.conPhone = conPhone;
    }

    public String getConPhone() 
    {
        return conPhone;
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
            .append("billId", getBillId())
            .append("name", getName())
            .append("sno", getSno())
            .append("address", getAddress())
            .append("bank", getBank())
            .append("bankNo", getBankNo())
            .append("phone", getPhone())
            .append("conName", getConName())
            .append("conAddress", getConAddress())
            .append("conPhone", getConPhone())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
