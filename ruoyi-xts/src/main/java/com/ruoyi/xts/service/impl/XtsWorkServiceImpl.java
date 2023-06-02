package com.ruoyi.xts.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.xts.mapper.XtsWorkMapper;
import com.ruoyi.xts.domain.XtsWork;
import com.ruoyi.xts.service.IXtsWorkService;
import com.ruoyi.common.core.text.Convert;

/**
 * 周报信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
@Service
public class XtsWorkServiceImpl implements IXtsWorkService 
{
    @Autowired
    private XtsWorkMapper xtsWorkMapper;

    /**
     * 查询周报信息
     * 
     * @param workId 周报信息主键
     * @return 周报信息
     */
    @Override
    public XtsWork selectXtsWorkByWorkId(Long workId)
    {
        return xtsWorkMapper.selectXtsWorkByWorkId(workId);
    }

    /**
     * 查询周报信息列表
     * 
     * @param xtsWork 周报信息
     * @return 周报信息
     */
    @Override
    public List<XtsWork> selectXtsWorkList(XtsWork xtsWork)
    {
        return xtsWorkMapper.selectXtsWorkList(xtsWork);
    }

    /**
     * 新增周报信息
     * 
     * @param xtsWork 周报信息
     * @return 结果
     */
    @Override
    public int insertXtsWork(XtsWork xtsWork)
    {
        xtsWork.setCreateTime(DateUtils.getNowDate());
        return xtsWorkMapper.insertXtsWork(xtsWork);
    }

    /**
     * 修改周报信息
     * 
     * @param xtsWork 周报信息
     * @return 结果
     */
    @Override
    public int updateXtsWork(XtsWork xtsWork)
    {
        xtsWork.setUpdateTime(DateUtils.getNowDate());
        return xtsWorkMapper.updateXtsWork(xtsWork);
    }

    /**
     * 批量删除周报信息
     * 
     * @param workIds 需要删除的周报信息主键
     * @return 结果
     */
    @Override
    public int deleteXtsWorkByWorkIds(String workIds)
    {
        return xtsWorkMapper.deleteXtsWorkByWorkIds(Convert.toStrArray(workIds));
    }

    /**
     * 删除周报信息信息
     * 
     * @param workId 周报信息主键
     * @return 结果
     */
    @Override
    public int deleteXtsWorkByWorkId(Long workId)
    {
        return xtsWorkMapper.deleteXtsWorkByWorkId(workId);
    }
}
