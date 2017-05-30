package cc.sustccs.sustcmobile;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by asus on 2017/5/24.
 */

public class MainActivity extends AppCompatActivity implements  RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener {

    //UI Objects
    private RadioGroup bottom_menu;
    private RadioButton restaurant_btn_normal;
    private RadioButton box_btn_normal;
    private RadioButton notification_btn_normal;
    private RadioButton explore_btn_normal;
    private ViewPager vpager;

    private MyFragmentPagerAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
        restaurant_btn_normal.setChecked(true);
    }

    private void bindViews() {
        bottom_menu = (RadioGroup) findViewById(R.id.bottom_menu);
        restaurant_btn_normal = (RadioButton) findViewById(R.id.restaurant_btn_normal);
        box_btn_normal = (RadioButton) findViewById(R.id.box_btn_normal);
        notification_btn_normal = (RadioButton) findViewById(R.id.notification_btn_normal);
        explore_btn_normal = (RadioButton) findViewById(R.id.explore_btn_normal);
        bottom_menu.setOnCheckedChangeListener(this);

        vpager = (ViewPager) findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.restaurant_btn_normal:
                vpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.box_btn_normal:
                vpager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.notification_btn_normal:
                vpager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.explore_btn_normal:
                vpager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }

    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    restaurant_btn_normal.setChecked(true);
                    break;
                case PAGE_TWO:
                    box_btn_normal.setChecked(true);
                    break;
                case PAGE_THREE:
                    notification_btn_normal.setChecked(true);
                    break;
                case PAGE_FOUR:
                    explore_btn_normal.setChecked(true);
                    break;
            }
        }
    }
}
