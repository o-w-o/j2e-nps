var api = new Object();

api.ustatus = false;

/**
 * 
 * @type Object
 */
api.ajax = {
    conf: function (e) {

    },
    fbox: {
    },
    tbox: {
        eid: null,
        conf: function (e) {

        },
        set: function () {

        }
    },
    mbox: {
    },
    ubox: {
    },
    ubtn: {
    }
};

api.controller = {
    
};

/**
 * 信息提示 组件
 * comfirm:确认框,
 * alert: 警告框
 * tooltips: 提示框
 * @type Object
 */
api.msg = {
    /**
     * 警告框
     * @param {String} msg
     * @returns {null}
     */
    alert: function (msg) {
        $('#modal-msg').html(msg);
        $('#modal').modal('show');
        return true;
    },
    /**
     * 确定框
     * @param {String} msg
     * @returns {Boolean}
     */
    comfirm: function (msg) {
        return true;
    },
    /**
     * 提示框
     * @param {String} msg
     * @returns {null}
     */
    snackbar: function (msg) {
        $('#snackbar').snackbar({
            alive: 10000,
            content: msg + '<a data-dismiss="snackbar"">我知道了</a>'
        });
    }
};

/**
 * 正则表达验证 组件
 * @type Object
 */
api.regx = {
    password: null,
    cname: null,
    ename: null,
    email: null,
    uid: null
};


api.uinfo = {
    uid:0,
    uname:"anonymous",
    uwords:"I'm the honor !",
    ugender:"boy",
    
    set:function(){
        
    }
};

api.ufriends = {
    /**
     * [{
     * gid:num,
     * gname:str,
     * gdata:{fid:num, fname:str},..
     * },...]
     * @type Friends List JSON Object
     */
    list:[],
    
    set:function(){
        
    }
};

api.utables = {
    list:[],
    
    setTablesList:function(){
        
    },
    
    thistable:{
        
    },
    
    setThisTable:function(){
        
    }
};

api.umsg = {
    
};








//===============================================================
