package cn.zknu.l_fragmentviewpager.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.zknu.l_fragmentviewpager.R;
import cn.zknu.l_fragmentviewpager.adapter.MenuListAdapter;


public class LiteratureFragment extends Fragment{
    private RecyclerView mRecyclerView;
    private View mView;
    private LinearLayoutManager mLinearLayoutManager;
    private MenuListAdapter mMenuAdapter;
    private List<String> mCollegeList;

    private static final String TAG = "LiteratureFragment";

    public LiteratureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_literature, container, false);
        initData();
        initView();
        return mView;
    }

    private void initData() {
        mCollegeList = new ArrayList<>();
        mCollegeList.add("外语学院");
        mCollegeList.add("文学院");
        mCollegeList.add("音乐学院");
        mCollegeList.add("美术学院");
    }

    private void initView() {
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.recycler_view);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mMenuAdapter = new MenuListAdapter(R.layout.item_view, mCollegeList);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mMenuAdapter);
    }
}
