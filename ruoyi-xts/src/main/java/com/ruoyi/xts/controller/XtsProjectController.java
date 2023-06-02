package com.ruoyi.xts.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.xts.domain.XtsProject;
import com.ruoyi.xts.service.IXtsProjectService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目信息Controller
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
@Controller
@RequestMapping("/xts/project")
public class XtsProjectController extends BaseController
{
    private String prefix = "xts/project";

    @Autowired
    private IXtsProjectService xtsProjectService;

    @RequiresPermissions("xts:project:view")
    @GetMapping()
    public String project()
    {
        return prefix + "/project";
    }

    /**
     * 查询项目信息列表
     */
    @RequiresPermissions("xts:project:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XtsProject xtsProject)
    {
        startPage();
        List<XtsProject> list = xtsProjectService.selectXtsProjectList(xtsProject);
        return getDataTable(list);
    }

    /**
     * 导出项目信息列表
     */
    @RequiresPermissions("xts:project:export")
    @Log(title = "项目信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XtsProject xtsProject)
    {
        List<XtsProject> list = xtsProjectService.selectXtsProjectList(xtsProject);
        ExcelUtil<XtsProject> util = new ExcelUtil<XtsProject>(XtsProject.class);
        return util.exportExcel(list, "项目信息数据");
    }

    /**
     * 新增项目信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存项目信息
     */
    @RequiresPermissions("xts:project:add")
    @Log(title = "项目信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XtsProject xtsProject)
    {
        return toAjax(xtsProjectService.insertXtsProject(xtsProject));
    }

    /**
     * 修改项目信息
     */
    @RequiresPermissions("xts:project:edit")
    @GetMapping("/edit/{projectId}")
    public String edit(@PathVariable("projectId") Long projectId, ModelMap mmap)
    {
        XtsProject xtsProject = xtsProjectService.selectXtsProjectByProjectId(projectId);
        mmap.put("xtsProject", xtsProject);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目信息
     */
    @RequiresPermissions("xts:project:edit")
    @Log(title = "项目信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XtsProject xtsProject)
    {
        return toAjax(xtsProjectService.updateXtsProject(xtsProject));
    }

    /**
     * 删除项目信息
     */
    @RequiresPermissions("xts:project:remove")
    @Log(title = "项目信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xtsProjectService.deleteXtsProjectByProjectIds(ids));
    }
}
