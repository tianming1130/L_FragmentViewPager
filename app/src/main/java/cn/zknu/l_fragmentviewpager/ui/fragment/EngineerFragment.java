package cn.zknu.l_fragmentviewpager.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.zknu.l_fragmentviewpager.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EngineerFragment extends Fragment {


    public EngineerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_engineer, container, false);
    }

}
