package com.sdjzu.knowledgequiz.pojo;

import com.sdjzu.knowledgequiz.util.Msg;

import java.util.HashMap;
import java.util.Map;

public class IPagePojo {
    //二次封装mybatis-plus分页。
    private Map<String,Object> extend = new HashMap<String,Object>();

    public static IPagePojo init() {
        IPagePojo result = new IPagePojo();

        return result;

    }
    public IPagePojo add(String key ,Object value) {
        this.getExtend().put(key, value);
        return this;

    }
    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
