package com.ruoyi.xts.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.xts.mapper.XtsCustomMapper;
import com.ruoyi.xts.domain.XtsCustom;
import com.ruoyi.xts.service.IXtsCustomService;
import com.ruoyi.common.core.text.Convert;

/**
 * 客户信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
@Service
public class XtsCustomServiceImpl implements IXtsCustomService 
{
    @Autowired
    private XtsCustomMapper xtsCustomMapper;

    /**
     * 查询客户信息
     * 
     * @param cusId 客户信息主键
     * @return 客户信息
     */
    @Override
    public XtsCustom selectXtsCustomByCusId(Long cusId)
    {
        return xtsCustomMapper.selectXtsCustomByCusId(cusId);
    }

    /**
     * 查询客户信息列表
     * 
     * @param xtsCustom 客户信息
     * @return 客户信息
     */
    @Override
    public List<XtsCustom> selectXtsCustomList(XtsCustom xtsCustom)
    {
        return xtsCustomMapper.selectXtsCustomList(xtsCustom);
    }

    /**
     * 新增客户信息
     * 
     * @param xtsCustom 客户信息
     * @return 结果
     */
    @Override
    public int insertXtsCustom(XtsCustom xtsCustom)
    {
        xtsCustom.setCreateTime(DateUtils.getNowDate());
        return xtsCustomMapper.insertXtsCustom(xtsCustom);
    }

    /**
     * 修改客户信息
     * 
     * @param xtsCustom 客户信息
     * @return 结果
     */
    @Override
    public int updateXtsCustom(XtsCustom xtsCustom)
    {
        xtsCustom.setUpdateTime(DateUtils.getNowDate());
        return xtsCustomMapper.updateXtsCustom(xtsCustom);
    }

    /**
     * 批量删除客户信息
     * 
     * @param cusIds 需要删除的客户信息主键
     * @return 结果
     */
    @Override
    public int deleteXtsCustomByCusIds(String cusIds)
    {
        return xtsCustomMapper.deleteXtsCustomByCusIds(Convert.toStrArray(cusIds));
    }

    /**
     * 删除客户信息信息
     * 
     * @param cusId 客户信息主键
     * @return 结果
     */
    @Override
    public int deleteXtsCustomByCusId(Long cusId)
    {
        return xtsCustomMapper.deleteXtsCustomByCusId(cusId);
    }
}
