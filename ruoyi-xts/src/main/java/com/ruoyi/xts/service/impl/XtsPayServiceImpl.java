package com.ruoyi.xts.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.xts.mapper.XtsPayMapper;
import com.ruoyi.xts.domain.XtsPay;
import com.ruoyi.xts.service.IXtsPayService;
import com.ruoyi.common.core.text.Convert;

/**
 * 付款信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
@Service
public class XtsPayServiceImpl implements IXtsPayService 
{
    @Autowired
    private XtsPayMapper xtsPayMapper;

    /**
     * 查询付款信息
     * 
     * @param payId 付款信息主键
     * @return 付款信息
     */
    @Override
    public XtsPay selectXtsPayByPayId(Long payId)
    {
        return xtsPayMapper.selectXtsPayByPayId(payId);
    }

    /**
     * 查询付款信息列表
     * 
     * @param xtsPay 付款信息
     * @return 付款信息
     */
    @Override
    public List<XtsPay> selectXtsPayList(XtsPay xtsPay)
    {
        return xtsPayMapper.selectXtsPayList(xtsPay);
    }

    /**
     * 新增付款信息
     * 
     * @param xtsPay 付款信息
     * @return 结果
     */
    @Override
    public int insertXtsPay(XtsPay xtsPay)
    {
        xtsPay.setCreateTime(DateUtils.getNowDate());
        return xtsPayMapper.insertXtsPay(xtsPay);
    }

    /**
     * 修改付款信息
     * 
     * @param xtsPay 付款信息
     * @return 结果
     */
    @Override
    public int updateXtsPay(XtsPay xtsPay)
    {
        xtsPay.setUpdateTime(DateUtils.getNowDate());
        return xtsPayMapper.updateXtsPay(xtsPay);
    }

    /**
     * 批量删除付款信息
     * 
     * @param payIds 需要删除的付款信息主键
     * @return 结果
     */
    @Override
    public int deleteXtsPayByPayIds(String payIds)
    {
        return xtsPayMapper.deleteXtsPayByPayIds(Convert.toStrArray(payIds));
    }

    /**
     * 删除付款信息信息
     * 
     * @param payId 付款信息主键
     * @return 结果
     */
    @Override
    public int deleteXtsPayByPayId(Long payId)
    {
        return xtsPayMapper.deleteXtsPayByPayId(payId);
    }
}
