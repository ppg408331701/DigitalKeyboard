package com.ppg.digitalnumkeyboard;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ppg.digitalnumkeyboard.adapter.KeyBoardAdapter;
import com.ppg.digitalnumkeyboard.bean.BtnBean;

import java.util.ArrayList;

/**
 * Created by ppg777 on 2017/8/18.
 */

public class DigitalNumKeyboard extends RelativeLayout {

    private Context mContext;


    private int DK_text_color;
    private int DK_line_color;



    private GridView gridView;
    private ArrayList<BtnBean> NumList;


    private ImageView imgBack;

    private OnImgBackListener onImgBackListener;
    private OnNumBtnClickListener onNumBtnClickListener;
    private View line,line2,line3;
    private RelativeLayout layoutBack;
    public DigitalNumKeyboard(Context context) {
        this(context, null);
    }

    public DigitalNumKeyboard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DigitalNumKeyboard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.DigitalNumKeyboard);
        DK_text_color = typedArray.getColor(R.styleable.DigitalNumKeyboard_DK_text_color,
                ContextCompat.getColor(mContext, R.color.DK_text_color));
        DK_line_color = typedArray.getColor(R.styleable.DigitalNumKeyboard_DK_line_color,
                ContextCompat.getColor(mContext, R.color.DK_line_color));


        View Keyboardview = View.inflate(mContext, R.layout.layout_digital_num_keyboard, null);
        NumList = new ArrayList<>();


        gridView = (GridView) Keyboardview.findViewById(R.id.gv_keybord);
        imgBack = (ImageView) Keyboardview.findViewById(R.id.imgBack);

        line =  Keyboardview.findViewById(R.id.line);
        line2 =  Keyboardview.findViewById(R.id.line2);
        line3 =  Keyboardview.findViewById(R.id.line3);


        line.setBackgroundColor(DK_line_color);
        line2.setBackgroundColor(DK_line_color);
        line3.setBackgroundColor(DK_line_color);

        //为图片着色
        Drawable back_img = ContextCompat.getDrawable(mContext, R.mipmap.keyboard_back_img);
        Drawable drawable_back_img = DrawableCompat.wrap(back_img);
        DrawableCompat.setTint(drawable_back_img, DK_text_color);
        imgBack.setImageDrawable(drawable_back_img);



        gridView.setBackgroundColor(DK_line_color);

        imgBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onImgBackListener != null) {
                    onImgBackListener.ImgBackClickListener();
                }
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (onNumBtnClickListener!=null){
                    BtnBean btnBean = (BtnBean) parent.getAdapter().getItem(position);
                    onNumBtnClickListener.NumBtnClickListener(btnBean);
                }
            }
        });
        initNumList();
        setupView();
        addView(Keyboardview);
        typedArray.recycle();
    }


    private void initNumList() {
        // 初始化按钮上应该显示的数字
        BtnBean btnBean;
        for (int i = 1; i < 13; i++) {
            btnBean = new BtnBean();
            if (i < 10) {
                btnBean.setBtn_text(String.valueOf(i));
                btnBean.setBtn_type(BtnBean.BTN_TYPE_NUM);
            } else if (i == 10) {
                btnBean.setBtn_text(".");
                btnBean.setBtn_type(BtnBean.BTN_TYPE_POINT);
            } else if (i == 11) {
                btnBean.setBtn_text("0");
                btnBean.setBtn_type(BtnBean.BTN_TYPE_NUM);
            } else if (i == 12) {
                btnBean.setBtn_text("delete");
                btnBean.setBtn_type(BtnBean.BTN_TYPE_DELETE);
            }
            NumList.add(btnBean);
        }
    }

    public GridView getGridView() {
        return gridView;
    }



    public void setOnImgBackListener(OnImgBackListener onImgBackListener) {
        this.onImgBackListener = onImgBackListener;
    }

    public void setOnNumBtnClickListener(OnNumBtnClickListener onNumBtnClickListener) {
        this.onNumBtnClickListener = onNumBtnClickListener;
    }

    private void setupView() {
        KeyBoardAdapter keyBoardAdapter = new KeyBoardAdapter(mContext, NumList, DK_text_color);
        gridView.setAdapter(keyBoardAdapter);
    }

    public interface OnNumBtnClickListener{
        void NumBtnClickListener(BtnBean btnBean);
    }


    public interface OnImgBackListener {
        void ImgBackClickListener();
    }
}
