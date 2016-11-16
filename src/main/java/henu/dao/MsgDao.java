/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henu.dao;

/**
 *
 * @author dot
 */
public interface MsgDao{
        
    
    /**
     * 发送信息给某人
     *
     * @param msg
     * @param uid
     * @param fid
     * @param category
     * @return
     */
    public boolean notice(String msg, String uid, String fid, int category);
    
    /**
     * 群发通知
     * @param msg
     * @param uid
     * @param fids
     * @param category
     * @return 
     */
    public boolean noticeBatch(String msg, String uid, String[] fids, int category);
    
    /**
     * 系统通知
     * @param msg
     * @return 
     */
    public boolean noticeAllUsers(String msg);
}