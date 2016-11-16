package henu.dao.impl;

import henu.dao.MsgDao;

/**
 *
 * @author dot
 */
public class MsgDaoImpl implements MsgDao{

    @Override
    public boolean notice(String msg, String uid, String fid, int category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean noticeBatch(String msg, String uid, String[] fids, int category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean noticeAllUsers(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        

}