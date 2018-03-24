package cn.zknu.l_fragmentviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

import cn.zknu.l_fragmentviewpager.ui.fragment.CircleFragment;
import cn.zknu.l_fragmentviewpager.ui.fragment.FindFragment;
import cn.zknu.l_fragmentviewpager.ui.fragment.MeFragment;
import cn.zknu.l_fragmentviewpager.ui.fragment.MessageFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar
        .OnTabSelectedListener {

    private BottomNavigationBar mBottomNavigationBar;
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.btm_nav_bar);
        init();
    }

    private void init() {

        mFragments = new ArrayList<>();
        mFragments.add(new CircleFragment());
        mFragments.add(new FindFragment());
        mFragments.add(new MessageFragment());
        mFragments.add(new MeFragment());

        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.nav_circle_selector, "动态"))
                .addItem(new BottomNavigationItem(R.drawable.nav_find_selector, "发现"))
                .addItem(new BottomNavigationItem(R.drawable.nav_message_selector, "消息"))
                .addItem(new BottomNavigationItem(R.drawable.nav_me_selector, "我的"))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.main_container, mFragments.get(0));
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fm = this.getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.main_container, mFragments.get(position));
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
