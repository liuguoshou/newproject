package com.ruoyi.xts.service;

import java.util.List;
import com.ruoyi.xts.domain.XtsWork;

/**
 * 周报信息Service接口
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
public interface IXtsWorkService 
{
    /**
     * 查询周报信息
     * 
     * @param workId 周报信息主键
     * @return 周报信息
     */
    public XtsWork selectXtsWorkByWorkId(Long workId);

    /**
     * 查询周报信息列表
     * 
     * @param xtsWork 周报信息
     * @return 周报信息集合
     */
    public List<XtsWork> selectXtsWorkList(XtsWork xtsWork);

    /**
     * 新增周报信息
     * 
     * @param xtsWork 周报信息
     * @return 结果
     */
    public int insertXtsWork(XtsWork xtsWork);

    /**
     * 修改周报信息
     * 
     * @param xtsWork 周报信息
     * @return 结果
     */
    public int updateXtsWork(XtsWork xtsWork);

    /**
     * 批量删除周报信息
     * 
     * @param workIds 需要删除的周报信息主键集合
     * @return 结果
     */
    public int deleteXtsWorkByWorkIds(String workIds);

    /**
     * 删除周报信息信息
     * 
     * @param workId 周报信息主键
     * @return 结果
     */
    public int deleteXtsWorkByWorkId(Long workId);
}
