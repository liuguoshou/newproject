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
import com.ruoyi.xts.domain.XtsBill;
import com.ruoyi.xts.service.IXtsBillService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 开票信息Controller
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
@Controller
@RequestMapping("/xts/bill")
public class XtsBillController extends BaseController
{
    private String prefix = "xts/bill";

    @Autowired
    private IXtsBillService xtsBillService;

    @RequiresPermissions("xts:bill:view")
    @GetMapping()
    public String bill()
    {
        return prefix + "/bill";
    }

    /**
     * 查询开票信息列表
     */
    @RequiresPermissions("xts:bill:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XtsBill xtsBill)
    {
        startPage();
        List<XtsBill> list = xtsBillService.selectXtsBillList(xtsBill);
        return getDataTable(list);
    }

    /**
     * 导出开票信息列表
     */
    @RequiresPermissions("xts:bill:export")
    @Log(title = "开票信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XtsBill xtsBill)
    {
        List<XtsBill> list = xtsBillService.selectXtsBillList(xtsBill);
        ExcelUtil<XtsBill> util = new ExcelUtil<XtsBill>(XtsBill.class);
        return util.exportExcel(list, "开票信息数据");
    }

    /**
     * 新增开票信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存开票信息
     */
    @RequiresPermissions("xts:bill:add")
    @Log(title = "开票信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XtsBill xtsBill)
    {
        return toAjax(xtsBillService.insertXtsBill(xtsBill));
    }

    /**
     * 修改开票信息
     */
    @RequiresPermissions("xts:bill:edit")
    @GetMapping("/edit/{billId}")
    public String edit(@PathVariable("billId") Long billId, ModelMap mmap)
    {
        XtsBill xtsBill = xtsBillService.selectXtsBillByBillId(billId);
        mmap.put("xtsBill", xtsBill);
        return prefix + "/edit";
    }

    /**
     * 修改保存开票信息
     */
    @RequiresPermissions("xts:bill:edit")
    @Log(title = "开票信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XtsBill xtsBill)
    {
        return toAjax(xtsBillService.updateXtsBill(xtsBill));
    }

    /**
     * 删除开票信息
     */
    @RequiresPermissions("xts:bill:remove")
    @Log(title = "开票信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xtsBillService.deleteXtsBillByBillIds(ids));
    }
}
