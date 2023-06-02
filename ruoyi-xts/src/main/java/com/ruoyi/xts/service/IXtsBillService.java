package com.ruoyi.xts.service;

import java.util.List;
import com.ruoyi.xts.domain.XtsBill;

/**
 * 开票信息Service接口
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
public interface IXtsBillService 
{
    /**
     * 查询开票信息
     * 
     * @param billId 开票信息主键
     * @return 开票信息
     */
    public XtsBill selectXtsBillByBillId(Long billId);

    /**
     * 查询开票信息列表
     * 
     * @param xtsBill 开票信息
     * @return 开票信息集合
     */
    public List<XtsBill> selectXtsBillList(XtsBill xtsBill);

    /**
     * 新增开票信息
     * 
     * @param xtsBill 开票信息
     * @return 结果
     */
    public int insertXtsBill(XtsBill xtsBill);

    /**
     * 修改开票信息
     * 
     * @param xtsBill 开票信息
     * @return 结果
     */
    public int updateXtsBill(XtsBill xtsBill);

    /**
     * 批量删除开票信息
     * 
     * @param billIds 需要删除的开票信息主键集合
     * @return 结果
     */
    public int deleteXtsBillByBillIds(String billIds);

    /**
     * 删除开票信息信息
     * 
     * @param billId 开票信息主键
     * @return 结果
     */
    public int deleteXtsBillByBillId(Long billId);
}
