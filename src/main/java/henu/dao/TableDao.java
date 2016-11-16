package henu.dao;

import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dot
 */
public interface TableDao {
    
    /**
     * 创建表格(结构)
     *
     * @return 成功返回 true,否则 false Map<Table, TableData>>
     */
    public boolean createTable();

    /**
     * 删除表格结构及数据
     * @return 
     */
    public boolean deleteTable();

    /**
     * 获取 TID 表格结构
     * @param tid
     * @return 
     */
    public Map getTable(String tid);

    /**
     * 追加表格数据
     * @return
     */
    public boolean appendTableDate();

    /**
     * 删除表格数据
     * @return 
     */
    public boolean deleteTableDate();

    /**
     * 修改表格数据
     * @return String uid, Map <ArrayList index, Map<int indexId,  TableData>
     */
    public boolean alterTableDate();
    
    /**
     * 获取表格数据
     * @param tid
     * @return 
     */
    public Map getTableData(String tid);
    
    /**
     * 
     * @return 
     */
    public boolean invateFriends();
    
    /**
     * 
     * @return 
     */
    public boolean getInvatedFriendsList();
}
