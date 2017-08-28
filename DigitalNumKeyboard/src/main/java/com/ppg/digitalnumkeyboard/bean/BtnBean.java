package com.ppg.digitalnumkeyboard.bean;

/**
 * Created by ppg777 on 2017/8/18.
 */

public class BtnBean {

    public static final int BTN_TYPE_NUM = 1;
    public static final int BTN_TYPE_POINT = 2;
    public static final int BTN_TYPE_DELETE = 3;

    private String btn_text;
    private int btn_type;


    public String getBtn_text() {
        return btn_text;
    }

    public void setBtn_text(String btn_text) {
        this.btn_text = btn_text;
    }


    public int getBtn_type() {
        return btn_type;
    }

    public void setBtn_type(int btn_type) {
        this.btn_type = btn_type;
    }
}
