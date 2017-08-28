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
