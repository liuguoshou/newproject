package com.ruoyi.xts.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.xts.mapper.XtsBillMapper;
import com.ruoyi.xts.domain.XtsBill;
import com.ruoyi.xts.service.IXtsBillService;
import com.ruoyi.common.core.text.Convert;

/**
 * 开票信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
@Service
public class XtsBillServiceImpl implements IXtsBillService 
{
    @Autowired
    private XtsBillMapper xtsBillMapper;

    /**
     * 查询开票信息
     * 
     * @param billId 开票信息主键
     * @return 开票信息
     */
    @Override
    public XtsBill selectXtsBillByBillId(Long billId)
    {
        return xtsBillMapper.selectXtsBillByBillId(billId);
    }

    /**
     * 查询开票信息列表
     * 
     * @param xtsBill 开票信息
     * @return 开票信息
     */
    @Override
    public List<XtsBill> selectXtsBillList(XtsBill xtsBill)
    {
        return xtsBillMapper.selectXtsBillList(xtsBill);
    }

    /**
     * 新增开票信息
     * 
     * @param xtsBill 开票信息
     * @return 结果
     */
    @Override
    public int insertXtsBill(XtsBill xtsBill)
    {
        xtsBill.setCreateTime(DateUtils.getNowDate());
        return xtsBillMapper.insertXtsBill(xtsBill);
    }

    /**
     * 修改开票信息
     * 
     * @param xtsBill 开票信息
     * @return 结果
     */
    @Override
    public int updateXtsBill(XtsBill xtsBill)
    {
        xtsBill.setUpdateTime(DateUtils.getNowDate());
        return xtsBillMapper.updateXtsBill(xtsBill);
    }

    /**
     * 批量删除开票信息
     * 
     * @param billIds 需要删除的开票信息主键
     * @return 结果
     */
    @Override
    public int deleteXtsBillByBillIds(String billIds)
    {
        return xtsBillMapper.deleteXtsBillByBillIds(Convert.toStrArray(billIds));
    }

    /**
     * 删除开票信息信息
     * 
     * @param billId 开票信息主键
     * @return 结果
     */
    @Override
    public int deleteXtsBillByBillId(Long billId)
    {
        return xtsBillMapper.deleteXtsBillByBillId(billId);
    }
}
