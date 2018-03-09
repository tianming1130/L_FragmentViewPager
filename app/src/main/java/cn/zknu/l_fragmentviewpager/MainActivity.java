package cn.zknu.l_fragmentviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import cn.zknu.l_fragmentviewpager.ui.fragment.CircleFragment;
import cn.zknu.l_fragmentviewpager.ui.fragment.FindFragment;
import cn.zknu.l_fragmentviewpager.ui.fragment.MeFragment;
import cn.zknu.l_fragmentviewpager.ui.fragment.MessageFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private FrameLayout mainContainer;
    private BottomNavigationBar btmNavBar;
    private Fragment mCircleFragment, mFindFragment, mMessageFragment, mMeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainContainer = (FrameLayout) findViewById(R.id.main_container);
        btmNavBar = (BottomNavigationBar) findViewById(R.id.btm_nav_bar);

        init();
    }

    private void init() {
        btmNavBar.addItem(new BottomNavigationItem(R.drawable.nav_circle_selector, "动态"))
                .addItem(new BottomNavigationItem(R.drawable.nav_find_selector, "发现"))
                .addItem(new BottomNavigationItem(R.drawable.nav_message_selector, "消息"))
                .addItem(new BottomNavigationItem(R.drawable.nav_me_selector, "我的"))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .initialise();

        btmNavBar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mCircleFragment = CircleFragment.newInstance("动态");
        transaction.replace(R.id.main_container, mCircleFragment);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fm = this.getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (mCircleFragment == null) {
                    mCircleFragment = CircleFragment.newInstance("动态");
                }
                transaction.replace(R.id.main_container, mCircleFragment);
                break;
            case 1:
                if (mFindFragment == null) {
                    mFindFragment = FindFragment.newInstance("发现");
                }
                transaction.replace(R.id.main_container, mFindFragment);
                break;
            case 2:
                if (mMessageFragment == null) {
                    mMessageFragment = MessageFragment.newInstance("消息");
                }
                transaction.replace(R.id.main_container, mMessageFragment);
                break;
            case 3:
                if (mMeFragment == null) {
                    mMeFragment = MeFragment.newInstance("我的");
                }
                transaction.replace(R.id.main_container, mMeFragment);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
