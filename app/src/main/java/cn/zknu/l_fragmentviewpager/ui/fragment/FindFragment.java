package cn.zknu.l_fragmentviewpager.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.zknu.l_fragmentviewpager.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FindFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FindFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    private ViewPager viewPager;
    private TabLayout tabLayout;

    public FindFragment() {
        // Required empty public constructor
    }

    public static FindFragment newInstance(String param1) {
        FindFragment fragment = new FindFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_find, container, false);

        tabLayout = (TabLayout)view.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("文史"));
        tabLayout.addTab(tabLayout.newTab().setText("理工"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        final PagerAdapter adapter = new PagerAdapter
                (getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }

    private class PagerAdapter extends FragmentStatePagerAdapter{
        int nNumOfTabs;
        public PagerAdapter(FragmentManager fm, int nNumOfTabs)
        {
            super(fm);
            this.nNumOfTabs=nNumOfTabs;
        }
        @Override
        public Fragment getItem(int position) {
            switch(position)
            {
                case 0:
                    LiteratureFragment tab1=new LiteratureFragment();
                    return tab1;
                case 1:
                    EngineerFragment tab2=new EngineerFragment();
                    return tab2;
            }
            return null;
        }

        @Override
        public int getCount() {
            return nNumOfTabs;
        }
    }
}
