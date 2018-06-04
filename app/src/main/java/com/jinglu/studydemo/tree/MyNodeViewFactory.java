package com.jinglu.studydemo.tree;

import android.view.View;

import me.texy.treeview.base.BaseNodeViewBinder;
import me.texy.treeview.base.BaseNodeViewFactory;


/**
 * Created by zxy on 17/4/23.
 */

public class MyNodeViewFactory extends BaseNodeViewFactory {

    private int type ;


    @Override
    public BaseNodeViewBinder getNodeViewBinder(View view, int level) {
        
        
        /*switch (level) {
            case 1:
                return new FirstLevelNodeViewBinder(view);
            case 2:
                return new SecondLevelNodeViewBinder(view);
            case 3:
                return new ThirdLevelNodeViewBinder(view);
            default:
                return null;
        }*/
        
        switch(type){
            case 1:
                return new FirstLevelNodeViewBinder(view);
            case 2:
                return new SecondLevelNodeViewBinder(view);
            default:
                return null;
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
