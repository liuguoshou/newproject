package com.ruoyi.xts.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.xts.mapper.XtsProjectMapper;
import com.ruoyi.xts.domain.XtsProject;
import com.ruoyi.xts.service.IXtsProjectService;
import com.ruoyi.common.core.text.Convert;

/**
 * 项目信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
@Service
public class XtsProjectServiceImpl implements IXtsProjectService 
{
    @Autowired
    private XtsProjectMapper xtsProjectMapper;

    /**
     * 查询项目信息
     * 
     * @param projectId 项目信息主键
     * @return 项目信息
     */
    @Override
    public XtsProject selectXtsProjectByProjectId(Long projectId)
    {
        return xtsProjectMapper.selectXtsProjectByProjectId(projectId);
    }

    /**
     * 查询项目信息列表
     * 
     * @param xtsProject 项目信息
     * @return 项目信息
     */
    @Override
    public List<XtsProject> selectXtsProjectList(XtsProject xtsProject)
    {
        return xtsProjectMapper.selectXtsProjectList(xtsProject);
    }

    /**
     * 新增项目信息
     * 
     * @param xtsProject 项目信息
     * @return 结果
     */
    @Override
    public int insertXtsProject(XtsProject xtsProject)
    {
        xtsProject.setCreateTime(DateUtils.getNowDate());
        return xtsProjectMapper.insertXtsProject(xtsProject);
    }

    /**
     * 修改项目信息
     * 
     * @param xtsProject 项目信息
     * @return 结果
     */
    @Override
    public int updateXtsProject(XtsProject xtsProject)
    {
        xtsProject.setUpdateTime(DateUtils.getNowDate());
        return xtsProjectMapper.updateXtsProject(xtsProject);
    }

    /**
     * 批量删除项目信息
     * 
     * @param projectIds 需要删除的项目信息主键
     * @return 结果
     */
    @Override
    public int deleteXtsProjectByProjectIds(String projectIds)
    {
        return xtsProjectMapper.deleteXtsProjectByProjectIds(Convert.toStrArray(projectIds));
    }

    /**
     * 删除项目信息信息
     * 
     * @param projectId 项目信息主键
     * @return 结果
     */
    @Override
    public int deleteXtsProjectByProjectId(Long projectId)
    {
        return xtsProjectMapper.deleteXtsProjectByProjectId(projectId);
    }
}
