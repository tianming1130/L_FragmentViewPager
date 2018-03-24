package cn.zknu.l_fragmentviewpager.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.zknu.l_fragmentviewpager.R;

/**
 * Created by Administrator on 2018\3\21 0021.
 */

public class MenuListAdapter extends BaseQuickAdapter<String,BaseViewHolder>{


    public MenuListAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_college, item);
    }
}
