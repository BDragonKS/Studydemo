package com.jinglu.studydemo.tree;

import com.jinglu.studydemo.R;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import me.texy.treeview.TreeNode;
import me.texy.treeview.base.CheckableNodeViewBinder;

/**
 * Created by zxy on 17/4/23.
 */

public class ThirdLevelNodeViewBinder extends CheckableNodeViewBinder {
    TextView textView;

    public ThirdLevelNodeViewBinder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.node_name_view);
    }

    public ThirdLevelNodeViewBinder(View itemView, View.OnClickListener onClickListener) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.node_name_view);
        textView.setOnClickListener(onClickListener);
    }

    @Override
    public int getCheckableViewId() {
        return R.id.checkBox;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_third_level;
    }

    @Override
    public void bindView(TreeNode treeNode) {
        textView.setText(treeNode.getValue().toString());
    }
}
