package com.ruoyi.xts.service;

import java.util.List;
import com.ruoyi.xts.domain.XtsPay;

/**
 * 付款信息Service接口
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
public interface IXtsPayService 
{
    /**
     * 查询付款信息
     * 
     * @param payId 付款信息主键
     * @return 付款信息
     */
    public XtsPay selectXtsPayByPayId(Long payId);

    /**
     * 查询付款信息列表
     * 
     * @param xtsPay 付款信息
     * @return 付款信息集合
     */
    public List<XtsPay> selectXtsPayList(XtsPay xtsPay);

    /**
     * 新增付款信息
     * 
     * @param xtsPay 付款信息
     * @return 结果
     */
    public int insertXtsPay(XtsPay xtsPay);

    /**
     * 修改付款信息
     * 
     * @param xtsPay 付款信息
     * @return 结果
     */
    public int updateXtsPay(XtsPay xtsPay);

    /**
     * 批量删除付款信息
     * 
     * @param payIds 需要删除的付款信息主键集合
     * @return 结果
     */
    public int deleteXtsPayByPayIds(String payIds);

    /**
     * 删除付款信息信息
     * 
     * @param payId 付款信息主键
     * @return 结果
     */
    public int deleteXtsPayByPayId(Long payId);
}
