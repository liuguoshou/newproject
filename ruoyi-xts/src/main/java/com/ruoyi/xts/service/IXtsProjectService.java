package com.ruoyi.xts.service;

import java.util.List;
import com.ruoyi.xts.domain.XtsProject;

/**
 * 项目信息Service接口
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
public interface IXtsProjectService 
{
    /**
     * 查询项目信息
     * 
     * @param projectId 项目信息主键
     * @return 项目信息
     */
    public XtsProject selectXtsProjectByProjectId(Long projectId);

    /**
     * 查询项目信息列表
     * 
     * @param xtsProject 项目信息
     * @return 项目信息集合
     */
    public List<XtsProject> selectXtsProjectList(XtsProject xtsProject);

    /**
     * 新增项目信息
     * 
     * @param xtsProject 项目信息
     * @return 结果
     */
    public int insertXtsProject(XtsProject xtsProject);

    /**
     * 修改项目信息
     * 
     * @param xtsProject 项目信息
     * @return 结果
     */
    public int updateXtsProject(XtsProject xtsProject);

    /**
     * 批量删除项目信息
     * 
     * @param projectIds 需要删除的项目信息主键集合
     * @return 结果
     */
    public int deleteXtsProjectByProjectIds(String projectIds);

    /**
     * 删除项目信息信息
     * 
     * @param projectId 项目信息主键
     * @return 结果
     */
    public int deleteXtsProjectByProjectId(Long projectId);
}
