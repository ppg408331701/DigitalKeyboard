package com.ppg.digitalnumkeyboard.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ppg.digitalnumkeyboard.R;
import com.ppg.digitalnumkeyboard.bean.BtnBean;

import java.util.ArrayList;

/**
 * 九宫格键盘适配器
 */
public class KeyBoardAdapter extends BaseAdapter {


    private Context mContext;
    private ArrayList<BtnBean> valueList;
    private int text_color;


    public KeyBoardAdapter(Context mContext, ArrayList<BtnBean> valueList, int text_color) {
        this.mContext = mContext;
        this.valueList = valueList;
        this.text_color = text_color;

    }

    @Override
    public int getCount() {
        return valueList.size();
    }

    @Override
    public Object getItem(int position) {
        return valueList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.grid_item_virtual_keyboard, null);
            viewHolder = new ViewHolder();
            viewHolder.btnKey = (TextView) convertView.findViewById(R.id.btn_keys);
            viewHolder.imgDelete = (RelativeLayout) convertView.findViewById(R.id.imgDelete);
            viewHolder.ll_keyboard = (RelativeLayout) convertView.findViewById(R.id.ll_keyboard);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.btnKey.setTextColor(text_color);
        //为图片着色
        Drawable delete_img = ContextCompat.getDrawable(mContext, R.mipmap.keyboard_delete_img);
        Drawable drawable_delete_img = DrawableCompat.wrap(delete_img);
        DrawableCompat.setTint(drawable_delete_img, text_color);


        if (position == 9) {
            viewHolder.imgDelete.setVisibility(View.INVISIBLE);
            viewHolder.btnKey.setVisibility(View.VISIBLE);
            viewHolder.btnKey.setText(valueList.get(position).getBtn_text());
        } else if (position == 11) {
            viewHolder.btnKey.setBackgroundDrawable(drawable_delete_img);
            viewHolder.imgDelete.setVisibility(View.VISIBLE);
            viewHolder.btnKey.setVisibility(View.INVISIBLE);
        } else {
            viewHolder.imgDelete.setVisibility(View.INVISIBLE);
            viewHolder.btnKey.setVisibility(View.VISIBLE);
            viewHolder.btnKey.setText(valueList.get(position).getBtn_text());
        }

        return convertView;
    }

    /**
     * 存放控件
     */
    public final class ViewHolder {
        public TextView btnKey;
        public RelativeLayout ll_keyboard;
        public RelativeLayout imgDelete;
    }
}
