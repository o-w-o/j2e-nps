/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henu.dao.bean;

/**
 *
 * @author dot
 */
public class Msg {
    private String mid;
    private String uid;
    private String[] fids;
    private String msg;
    private String sentime;
    private boolean type;

    /**
     * @return the mid
     */
    public String getMid() {
        return mid;
    }

    /**
     * @param mid the mid to set
     */
    public void setMid(String mid) {
        this.mid = mid;
    }

    /**
     * @return the uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return the fids
     */
    public String[] getFids() {
        return fids;
    }

    /**
     * @param fids the fids to set
     */
    public void setFids(String[] fids) {
        this.fids = fids;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the sentime
     */
    public String getSentime() {
        return sentime;
    }

    /**
     * @param sentime the sentime to set
     */
    public void setSentime(String sentime) {
        this.sentime = sentime;
    }

    /**
     * @return the type
     */
    public boolean isType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(boolean type) {
        this.type = type;
    }
}
