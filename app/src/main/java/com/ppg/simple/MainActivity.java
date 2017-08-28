package com.ppg.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ppg.digitalnumkeyboard.DigitalNumKeyboard;
import com.ppg.digitalnumkeyboard.bean.BtnBean;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private EditText edit;
    private DigitalNumKeyboard digitalNumKeyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text = (TextView) findViewById(R.id.text);
        edit = (EditText) findViewById(R.id.edit);
        digitalNumKeyboard = (DigitalNumKeyboard) findViewById(R.id.DigitalNumKeyboard);

        digitalNumKeyboard.setOnImgBackListener(new DigitalNumKeyboard.OnImgBackListener() {
            @Override
            public void ImgBackClickListener() {
                digitalNumKeyboard.setVisibility(View.GONE);
            }
        });
        digitalNumKeyboard.setOnNumBtnClickListener(new DigitalNumKeyboard.OnNumBtnClickListener() {
            @Override
            public void NumBtnClickListener(BtnBean btnBean) {
                if (btnBean.getBtn_type() == BtnBean.BTN_TYPE_NUM) {
                    edit.setText(edit.getText().toString() + btnBean.getBtn_text());
                } else if (btnBean.getBtn_type() == BtnBean.BTN_TYPE_POINT) {
                    edit.setText(edit.getText().toString() + btnBean.getBtn_text());
                } else if (btnBean.getBtn_type() == BtnBean.BTN_TYPE_DELETE && edit.getText().length() > 0) {
                    int index = edit.getText().length();   //获取Edittext光标所在位置
                    edit.getText().delete(index - 1, index);
                }
                edit.setSelection(edit.getText().length());
            }
        });
    }
}
