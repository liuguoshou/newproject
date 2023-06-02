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
import com.ruoyi.xts.domain.XtsWork;
import com.ruoyi.xts.service.IXtsWorkService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 周报信息Controller
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
@Controller
@RequestMapping("/xts/work")
public class XtsWorkController extends BaseController
{
    private String prefix = "xts/work";

    @Autowired
    private IXtsWorkService xtsWorkService;

    @RequiresPermissions("xts:work:view")
    @GetMapping()
    public String work()
    {
        return prefix + "/work";
    }

    /**
     * 查询周报信息列表
     */
    @RequiresPermissions("xts:work:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XtsWork xtsWork)
    {
        startPage();
        List<XtsWork> list = xtsWorkService.selectXtsWorkList(xtsWork);
        return getDataTable(list);
    }

    /**
     * 导出周报信息列表
     */
    @RequiresPermissions("xts:work:export")
    @Log(title = "周报信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XtsWork xtsWork)
    {
        List<XtsWork> list = xtsWorkService.selectXtsWorkList(xtsWork);
        ExcelUtil<XtsWork> util = new ExcelUtil<XtsWork>(XtsWork.class);
        return util.exportExcel(list, "周报信息数据");
    }

    /**
     * 新增周报信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存周报信息
     */
    @RequiresPermissions("xts:work:add")
    @Log(title = "周报信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XtsWork xtsWork)
    {
        return toAjax(xtsWorkService.insertXtsWork(xtsWork));
    }

    /**
     * 修改周报信息
     */
    @RequiresPermissions("xts:work:edit")
    @GetMapping("/edit/{workId}")
    public String edit(@PathVariable("workId") Long workId, ModelMap mmap)
    {
        XtsWork xtsWork = xtsWorkService.selectXtsWorkByWorkId(workId);
        mmap.put("xtsWork", xtsWork);
        return prefix + "/edit";
    }

    /**
     * 修改保存周报信息
     */
    @RequiresPermissions("xts:work:edit")
    @Log(title = "周报信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XtsWork xtsWork)
    {
        return toAjax(xtsWorkService.updateXtsWork(xtsWork));
    }

    /**
     * 删除周报信息
     */
    @RequiresPermissions("xts:work:remove")
    @Log(title = "周报信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xtsWorkService.deleteXtsWorkByWorkIds(ids));
    }
}
