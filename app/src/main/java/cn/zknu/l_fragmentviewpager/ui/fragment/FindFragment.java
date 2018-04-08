package cn.zknu.l_fragmentviewpager.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.zknu.l_fragmentviewpager.R;

public class FindFragment extends Fragment {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<Fragment> mFragments;
    private View mView;
    private String[] titles={"文史","理工"};
    public FindFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_find, container, false);
        initView();
        init();
       return mView;
    }

    private void initView() {
        mTabLayout = (TabLayout) mView.findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) mView.findViewById(R.id.view_pager);
    }

    private void init() {
        mFragments = new ArrayList<>();

        mFragments.add(new LiteratureFragment());
        mFragments.add(new EngineerFragment());

        PagerAdapter adapter = new PagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewPager); //此行代码必须放在下面两行代码前边

        mTabLayout.getTabAt(0).setText("文史");
        mTabLayout.getTabAt(1).setText("理工");

    }

    private class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
           return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

//        @Override
//        public CharSequence getPageTitle(int position) {
//            return titles[position];
//        }
    }
}
