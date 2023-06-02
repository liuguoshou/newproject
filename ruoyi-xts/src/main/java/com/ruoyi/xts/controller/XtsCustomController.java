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
import com.ruoyi.xts.domain.XtsCustom;
import com.ruoyi.xts.service.IXtsCustomService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户信息Controller
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
@Controller
@RequestMapping("/xts/custom")
public class XtsCustomController extends BaseController
{
    private String prefix = "xts/custom";

    @Autowired
    private IXtsCustomService xtsCustomService;

    @RequiresPermissions("xts:custom:view")
    @GetMapping()
    public String custom()
    {
        return prefix + "/custom";
    }

    /**
     * 查询客户信息列表
     */
    @RequiresPermissions("xts:custom:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XtsCustom xtsCustom)
    {
        startPage();
        List<XtsCustom> list = xtsCustomService.selectXtsCustomList(xtsCustom);
        return getDataTable(list);
    }

    /**
     * 导出客户信息列表
     */
    @RequiresPermissions("xts:custom:export")
    @Log(title = "客户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XtsCustom xtsCustom)
    {
        List<XtsCustom> list = xtsCustomService.selectXtsCustomList(xtsCustom);
        ExcelUtil<XtsCustom> util = new ExcelUtil<XtsCustom>(XtsCustom.class);
        return util.exportExcel(list, "客户信息数据");
    }

    /**
     * 新增客户信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存客户信息
     */
    @RequiresPermissions("xts:custom:add")
    @Log(title = "客户信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XtsCustom xtsCustom)
    {
        return toAjax(xtsCustomService.insertXtsCustom(xtsCustom));
    }

    /**
     * 修改客户信息
     */
    @RequiresPermissions("xts:custom:edit")
    @GetMapping("/edit/{cusId}")
    public String edit(@PathVariable("cusId") Long cusId, ModelMap mmap)
    {
        XtsCustom xtsCustom = xtsCustomService.selectXtsCustomByCusId(cusId);
        mmap.put("xtsCustom", xtsCustom);
        return prefix + "/edit";
    }

    /**
     * 修改保存客户信息
     */
    @RequiresPermissions("xts:custom:edit")
    @Log(title = "客户信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XtsCustom xtsCustom)
    {
        return toAjax(xtsCustomService.updateXtsCustom(xtsCustom));
    }

    /**
     * 删除客户信息
     */
    @RequiresPermissions("xts:custom:remove")
    @Log(title = "客户信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xtsCustomService.deleteXtsCustomByCusIds(ids));
    }
}
