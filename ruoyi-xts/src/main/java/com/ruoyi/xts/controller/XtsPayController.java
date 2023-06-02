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
import com.ruoyi.xts.domain.XtsPay;
import com.ruoyi.xts.service.IXtsPayService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 付款信息Controller
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
@Controller
@RequestMapping("/xts/pay")
public class XtsPayController extends BaseController
{
    private String prefix = "xts/pay";

    @Autowired
    private IXtsPayService xtsPayService;

    @RequiresPermissions("xts:pay:view")
    @GetMapping()
    public String pay()
    {
        return prefix + "/pay";
    }

    /**
     * 查询付款信息列表
     */
    @RequiresPermissions("xts:pay:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XtsPay xtsPay)
    {
        startPage();
        List<XtsPay> list = xtsPayService.selectXtsPayList(xtsPay);
        return getDataTable(list);
    }

    /**
     * 导出付款信息列表
     */
    @RequiresPermissions("xts:pay:export")
    @Log(title = "付款信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XtsPay xtsPay)
    {
        List<XtsPay> list = xtsPayService.selectXtsPayList(xtsPay);
        ExcelUtil<XtsPay> util = new ExcelUtil<XtsPay>(XtsPay.class);
        return util.exportExcel(list, "付款信息数据");
    }

    /**
     * 新增付款信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存付款信息
     */
    @RequiresPermissions("xts:pay:add")
    @Log(title = "付款信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XtsPay xtsPay)
    {
        return toAjax(xtsPayService.insertXtsPay(xtsPay));
    }

    /**
     * 修改付款信息
     */
    @RequiresPermissions("xts:pay:edit")
    @GetMapping("/edit/{payId}")
    public String edit(@PathVariable("payId") Long payId, ModelMap mmap)
    {
        XtsPay xtsPay = xtsPayService.selectXtsPayByPayId(payId);
        mmap.put("xtsPay", xtsPay);
        return prefix + "/edit";
    }

    /**
     * 修改保存付款信息
     */
    @RequiresPermissions("xts:pay:edit")
    @Log(title = "付款信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XtsPay xtsPay)
    {
        return toAjax(xtsPayService.updateXtsPay(xtsPay));
    }

    /**
     * 删除付款信息
     */
    @RequiresPermissions("xts:pay:remove")
    @Log(title = "付款信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xtsPayService.deleteXtsPayByPayIds(ids));
    }
}
