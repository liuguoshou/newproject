package com.ruoyi.xts.mapper;

import java.util.List;
import com.ruoyi.xts.domain.XtsContacts;

/**
 * 联系人信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
public interface XtsContactsMapper 
{
    /**
     * 查询联系人信息
     * 
     * @param conId 联系人信息主键
     * @return 联系人信息
     */
    public XtsContacts selectXtsContactsByConId(Long conId);

    /**
     * 查询联系人信息列表
     * 
     * @param xtsContacts 联系人信息
     * @return 联系人信息集合
     */
    public List<XtsContacts> selectXtsContactsList(XtsContacts xtsContacts);

    /**
     * 新增联系人信息
     * 
     * @param xtsContacts 联系人信息
     * @return 结果
     */
    public int insertXtsContacts(XtsContacts xtsContacts);

    /**
     * 修改联系人信息
     * 
     * @param xtsContacts 联系人信息
     * @return 结果
     */
    public int updateXtsContacts(XtsContacts xtsContacts);

    /**
     * 删除联系人信息
     * 
     * @param conId 联系人信息主键
     * @return 结果
     */
    public int deleteXtsContactsByConId(Long conId);

    /**
     * 批量删除联系人信息
     * 
     * @param conIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXtsContactsByConIds(String[] conIds);
}
