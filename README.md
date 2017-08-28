# DigitalKeyboard
简单的仿微信数字键盘
===

![image](https://github.com/ppg408331701/DigitalKeyboard/blob/master/img/ezgif.com-video-to-gif.gif)  

### 公司有多个项目都需要这样的数字键盘,并不是用来代替传统的keyboard,
### 而是在输入类似 PIN码或者支付密码时使用,一般把它放在dialog或者popupwindow中弹出

对于Android Studio的用户，可以选择添加:

```java
allprojects {
	repositories {
	...
	maven { url 'https://jitpack.io' }
	}
}
```

```java
	   compile 'com.github.ppg408331701:DigitalKeyboard:v1.0.0'
```



<table>
  <tdead>
    <tr>
      <th align="center">配置参数</th>
      <th align="center">参数含义</th>
    </tr>
  </tdead>
  <tbody>
    <tr>
      <td align="center">DK_text_color</td>
      <td align="center">键盘中的所有文本的颜色</td>
    </tr>
    <tr>
      <td align="center">DK_line_color</td>
      <td align="center">键盘中分割线和边框的颜色</td>
    </tr>
  </tbody>
</table>



在xml中使用
```java

 <com.ppg.digitalnumkeyboard.DigitalNumKeyboard
        android:id="@+id/DigitalNumKeyboard"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true">
    </com.ppg.digitalnumkeyboard.DigitalNumKeyboard>
```

```
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
```

