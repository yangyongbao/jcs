package com.yz.jcs.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

public class JsonpView implements View {

    private String jsonString;
    private String encoding = "utf-8";

    public JsonpView(String jsonString) {
        this.jsonString = jsonString == null ? "{}" : jsonString;
    }

    public JsonpView(String jsonString, String encoding) {
        this.jsonString = jsonString == null ? "{}" : jsonString;
        this.encoding = encoding;
    }

    @Override
    public String getContentType() {
        return ResponseHelper.MT_JSONP.concat("; charset=").concat(encoding);
    }

    @Override
    public void render(Map map, HttpServletRequest req,HttpServletResponse res) throws Exception {
        String callback = req.getParameter("callback");
        String message = jsonString;
        if (callback != null) {
            message = callback.concat("(").concat(message).concat(")");
        }
        ResponseHelper.send(req, res, message, ResponseHelper.MT_JSON, encoding);
    }


}

