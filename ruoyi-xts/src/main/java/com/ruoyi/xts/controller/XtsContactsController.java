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
import com.ruoyi.xts.domain.XtsContacts;
import com.ruoyi.xts.service.IXtsContactsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 联系人信息Controller
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
@Controller
@RequestMapping("/xts/contacts")
public class XtsContactsController extends BaseController
{
    private String prefix = "xts/contacts";

    @Autowired
    private IXtsContactsService xtsContactsService;

    @RequiresPermissions("xts:contacts:view")
    @GetMapping()
    public String contacts()
    {
        return prefix + "/contacts";
    }

    /**
     * 查询联系人信息列表
     */
    @RequiresPermissions("xts:contacts:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XtsContacts xtsContacts)
    {
        startPage();
        List<XtsContacts> list = xtsContactsService.selectXtsContactsList(xtsContacts);
        return getDataTable(list);
    }

    /**
     * 导出联系人信息列表
     */
    @RequiresPermissions("xts:contacts:export")
    @Log(title = "联系人信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XtsContacts xtsContacts)
    {
        List<XtsContacts> list = xtsContactsService.selectXtsContactsList(xtsContacts);
        ExcelUtil<XtsContacts> util = new ExcelUtil<XtsContacts>(XtsContacts.class);
        return util.exportExcel(list, "联系人信息数据");
    }

    /**
     * 新增联系人信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存联系人信息
     */
    @RequiresPermissions("xts:contacts:add")
    @Log(title = "联系人信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XtsContacts xtsContacts)
    {
        return toAjax(xtsContactsService.insertXtsContacts(xtsContacts));
    }

    /**
     * 修改联系人信息
     */
    @RequiresPermissions("xts:contacts:edit")
    @GetMapping("/edit/{conId}")
    public String edit(@PathVariable("conId") Long conId, ModelMap mmap)
    {
        XtsContacts xtsContacts = xtsContactsService.selectXtsContactsByConId(conId);
        mmap.put("xtsContacts", xtsContacts);
        return prefix + "/edit";
    }

    /**
     * 修改保存联系人信息
     */
    @RequiresPermissions("xts:contacts:edit")
    @Log(title = "联系人信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XtsContacts xtsContacts)
    {
        return toAjax(xtsContactsService.updateXtsContacts(xtsContacts));
    }

    /**
     * 删除联系人信息
     */
    @RequiresPermissions("xts:contacts:remove")
    @Log(title = "联系人信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xtsContactsService.deleteXtsContactsByConIds(ids));
    }
}
