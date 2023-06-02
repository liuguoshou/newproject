package com.ruoyi.xts.mapper;

import java.util.List;
import com.ruoyi.xts.domain.XtsCustom;

/**
 * 客户信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
public interface XtsCustomMapper 
{
    /**
     * 查询客户信息
     * 
     * @param cusId 客户信息主键
     * @return 客户信息
     */
    public XtsCustom selectXtsCustomByCusId(Long cusId);

    /**
     * 查询客户信息列表
     * 
     * @param xtsCustom 客户信息
     * @return 客户信息集合
     */
    public List<XtsCustom> selectXtsCustomList(XtsCustom xtsCustom);

    /**
     * 新增客户信息
     * 
     * @param xtsCustom 客户信息
     * @return 结果
     */
    public int insertXtsCustom(XtsCustom xtsCustom);

    /**
     * 修改客户信息
     * 
     * @param xtsCustom 客户信息
     * @return 结果
     */
    public int updateXtsCustom(XtsCustom xtsCustom);

    /**
     * 删除客户信息
     * 
     * @param cusId 客户信息主键
     * @return 结果
     */
    public int deleteXtsCustomByCusId(Long cusId);

    /**
     * 批量删除客户信息
     * 
     * @param cusIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXtsCustomByCusIds(String[] cusIds);
}
