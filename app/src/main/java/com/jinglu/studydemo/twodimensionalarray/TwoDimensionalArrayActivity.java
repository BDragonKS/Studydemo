package com.jinglu.studydemo.twodimensionalarray;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.jinglu.studydemo.R;
import com.longruan.appframe.base.BaseActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;

public class TwoDimensionalArrayActivity extends BaseActivity {

    @BindView(R.id.tv_json)
    TextView mTvJson;
    @BindView(R.id.tv_json_result)
    TextView mTvJsonResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolbar(R.layout.activity_two_dimensional_array, getString(R.string.two_dimensional_array_title));
        json2Obj();
    }

    private void json2Obj() {

        Gson gson = new Gson();
        List<List<String>> mLists = gson.fromJson(mTvJson.getText().toString(), new TypeToken<List<List<String>>>() {
        }.getType());

        if (mLists != null) {
            mTvJsonResult.setText(mLists.toString());
        }
    }
/*
    private class TwoDimensionalArray {
        private List<List<String>> mLists;
    }*/
}
