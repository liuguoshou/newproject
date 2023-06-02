package com.ruoyi.xts.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.xts.mapper.XtsContactsMapper;
import com.ruoyi.xts.domain.XtsContacts;
import com.ruoyi.xts.service.IXtsContactsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 联系人信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
@Service
public class XtsContactsServiceImpl implements IXtsContactsService 
{
    @Autowired
    private XtsContactsMapper xtsContactsMapper;

    /**
     * 查询联系人信息
     * 
     * @param conId 联系人信息主键
     * @return 联系人信息
     */
    @Override
    public XtsContacts selectXtsContactsByConId(Long conId)
    {
        return xtsContactsMapper.selectXtsContactsByConId(conId);
    }

    /**
     * 查询联系人信息列表
     * 
     * @param xtsContacts 联系人信息
     * @return 联系人信息
     */
    @Override
    public List<XtsContacts> selectXtsContactsList(XtsContacts xtsContacts)
    {
        return xtsContactsMapper.selectXtsContactsList(xtsContacts);
    }

    /**
     * 新增联系人信息
     * 
     * @param xtsContacts 联系人信息
     * @return 结果
     */
    @Override
    public int insertXtsContacts(XtsContacts xtsContacts)
    {
        xtsContacts.setCreateTime(DateUtils.getNowDate());
        return xtsContactsMapper.insertXtsContacts(xtsContacts);
    }

    /**
     * 修改联系人信息
     * 
     * @param xtsContacts 联系人信息
     * @return 结果
     */
    @Override
    public int updateXtsContacts(XtsContacts xtsContacts)
    {
        xtsContacts.setUpdateTime(DateUtils.getNowDate());
        return xtsContactsMapper.updateXtsContacts(xtsContacts);
    }

    /**
     * 批量删除联系人信息
     * 
     * @param conIds 需要删除的联系人信息主键
     * @return 结果
     */
    @Override
    public int deleteXtsContactsByConIds(String conIds)
    {
        return xtsContactsMapper.deleteXtsContactsByConIds(Convert.toStrArray(conIds));
    }

    /**
     * 删除联系人信息信息
     * 
     * @param conId 联系人信息主键
     * @return 结果
     */
    @Override
    public int deleteXtsContactsByConId(Long conId)
    {
        return xtsContactsMapper.deleteXtsContactsByConId(conId);
    }
}
