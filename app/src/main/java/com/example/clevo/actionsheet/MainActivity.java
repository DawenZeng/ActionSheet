package com.example.clevo.actionsheet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.baoyz.actionsheet.ActionSheet;

public class MainActivity extends AppCompatActivity {

    Button main_button;
    Button list_button;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //设置了相同属性，此处将不起作用
//        setTheme(R.style.themeStyle2);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_button = (Button) findViewById(R.id.main_button);
        list_button = (Button) findViewById(R.id.list_button);

        main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AndroidActionSheetFragment.build(getSupportFragmentManager()).setChoice(AndroidActionSheetFragment.Builder.CHOICE.ITEM).setTitle("标题").setTag("MainActivity")
//                        .setItems(new String[]{"1", "2", "3", "4", "5", "6"}).setOnItemClickListener(new AndroidActionSheetFragment.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(int position) {
//
//                    }
//                }).show();
                AndroidActionSheetFragment.build(getSupportFragmentManager()).setChoice(AndroidActionSheetFragment.Builder.CHOICE.GRID).setTitle("分享平台").setTag("MainActivity")
                        .setItems(new String[]{"QQ", "微信", "微博", "Facebook", "Twitter"}).setImages(
                        new int[]{R.mipmap.ic_qq, R.mipmap.ic_wechat, R.mipmap.ic_sina, R.mipmap.ic_share_facebook, R.mipmap.ic_share_twitter}).setOnItemClickListener(new AndroidActionSheetFragment.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Toast.makeText(getApplicationContext(), position + "", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });

        list_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionSheet.createBuilder(getApplicationContext(), getSupportFragmentManager())
                        .setCancelButtonTitle("取消")
                        .setOtherButtonTitles("QQ", "微信", "微博", "Facebook", "Twitter")//小写字母会变大小字母
                        .setCancelableOnTouchOutside(true)//dialog弹出后会点击屏幕，dialog是否消失
                        .setListener(new ActionSheet.ActionSheetListener() {
                            @Override
                            public void onDismiss(ActionSheet actionSheet, boolean isCancel) {

                            }

                            @Override
                            public void onOtherButtonClick(ActionSheet actionSheet, int index) {
                                switch (index) {
                                    case 0://QQ
                                        name = "QQ";
                                        break;
                                    case 1://微信
                                        name = "微信";
                                        break;
                                    case 2://微博
                                        name = "微博";
                                        break;
                                    case 3://Facebook
                                        name = "Facebook";
                                        break;
                                    case 4://Twitter
                                        name = "Twitter";
                                        break;
                                }
                                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
    }
}
