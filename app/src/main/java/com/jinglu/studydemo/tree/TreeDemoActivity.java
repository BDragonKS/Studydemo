package com.jinglu.studydemo.tree;

import com.google.gson.Gson;

import com.chad.library.adapter.base.BaseViewHolder;
import com.jinglu.studydemo.R;
import com.longruan.appframe.base.BaseActivity;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import me.texy.treeview.TreeNode;
import me.texy.treeview.TreeView;
import me.texy.treeview.TreeViewAdapterNew;

public class TreeDemoActivity extends BaseActivity {

    private TreeNode root;
    private TreeNode root1;
    ConstraintLayout clTree;
    TreeView treeView;
    TreeView treeView1;
    RecyclerView rlNew;
    Button mButton;

    TreeViewAdapterNew adapterNew;
    MyNodeViewFactory mMyNodeViewFactory;
    private TreeViewAdapterNew adapterNew1;

    TreeNode treeNode;
    TreeNode treeNode1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolbar(R.layout.activity_tree_demo,getString(R.string.tree_title));
        intiView();
    }

    void intiView() {
        clTree = findViewById(R.id.cl_tree);
        rlNew = findViewById(R.id.rl_new);
        mButton = findViewById(R.id.button);

        //新版树形结构
        root = TreeNode.root();
        root1 = TreeNode.root();
        buildTree();
        mMyNodeViewFactory = new MyNodeViewFactory();
        mMyNodeViewFactory.setType(1);
        treeView = new TreeView(root, this, mMyNodeViewFactory);
        treeView1 = new TreeView(root1, this, mMyNodeViewFactory);
        treeView.setItemAnimator(rlNew);
        treeView1.setItemAnimator(rlNew);
        rlNew.setLayoutManager(new LinearLayoutManager(this));
        adapterNew = new TreeViewAdapterNew(this, root, treeView.getBaseNodeViewFactory()) {
            @Override
            public void convert(BaseViewHolder holder, final TreeNode node) {
                if (node.getLevel() == 3) {

                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(TreeDemoActivity.this, "Test+" + node.getValue(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    CheckBox checkBox = holder.getView(R.id.checkBox);
                    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                            Toast.makeText(TreeDemoActivity.this, "" + b, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        };
        adapterNew1 = new TreeViewAdapterNew(this, root1, treeView1.getBaseNodeViewFactory()) {
            @Override
            public void convert(BaseViewHolder holder, final TreeNode node) {
                if (node.getLevel() == 3) {

                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(TreeDemoActivity.this, "Test+" + node.getValue(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    CheckBox checkBox = holder.getView(R.id.checkBox);
                    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                            Toast.makeText(TreeDemoActivity.this, "" + b, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        };

        adapterNew.setTreeView(treeView);
        rlNew.setAdapter(adapterNew);
//        RecyclerView view = (RecyclerView) treeView.getView();
//        view.setLayoutParams(new ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        clTree.addView(view);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mMyNodeViewFactory.getType() == 1) {
                    root1.addChild(treeNode1);
                    mMyNodeViewFactory.setType(2);
                    rlNew.setAdapter(adapterNew1);
                    adapterNew1.refreshView();
                } else {
                    root.addChild(treeNode);
                    mMyNodeViewFactory.setType(1);
                    rlNew.setAdapter(adapterNew);
                    adapterNew.refreshView();
                }
            }
        });
    }

    private void buildTree() {
        String str = "  {\n" +
                "        \"iconCls\": \"fa fa-bookmark\",\n" +
                "        \"state\": \"open\",\n" +
                "        \"level\": 1,\n " +
                "        \"selected\": false,\n" +
                "        \"itemClickEnable\": true,\n" +
                "\t\"expanded\":true,\n" +
                "        \"attributes\": \"管理局\",\n" +
                "        \"id\": \"1\",\n" +
                "        \"value\": \"兵团煤矿安全监察局\",\n" +
                "        \"children\": [\n" +
                "            {\n" +
                "                \"iconCls\": \"fa fa-bookmark\",\n" +
                "                \"state\": \"open\",\n" +
                "        \"itemClickEnable\": true,\n" +
                "        \"level\": 2,\n " +
                "                \"selected\": false,\n" +
                "\"expanded\":true,\n" +
                "                \"attributes\": \"区县\",\n" +
                "                \"id\": \"11b894533ac14fb68bb3658013846dea\",\n" +
                "                \"value\": \"第一师\",\n" +
                "                \"children\": []\n" +
                "            },\n" +
                "            {\n" +
                "                \"iconCls\": \"fa fa-bookmark\",\n" +
                "                \"state\": \"open\",\n" +
//                "        \"itemClickEnable\": true,\n" +
                "        \"level\": 2,\n " +
//                "                \"selected\": false,\n" +
//                "\t\t\"expanded\":true,\n" +
                "                \"attributes\": \"区县\",\n" +
                "                \"id\": \"02b0f343bf194f57983374140a6419aa\",\n" +
                "                \"value\": \"第二师\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"itemClickEnable\": true,\n" +
                "        \"level\": 3,\n " +
                "                        \"selected\": true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"id\": \"391b77252c9a46fa8e41437d44cf3b5d\",\n" +
                "                        \"value\": \"金川矿业\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"itemClickEnable\": true,\n" +
                "                        \"selected\": true,\n" +
                "        \"level\": 3,\n " +
                "                        \"attributes\": \"矿井\",\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"id\": \"3d04c124d43149ceacc6e77020f832cb\",\n" +
                "                        \"value\": \"塔什店联合矿业\",\n" +
                "                        \"children\": []\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"iconCls\": \"fa fa-bookmark\",\n" +
                "                \"state\": \"open\",\n" +
                "                \"selected\": false,\n" +
                "        \"level\": 2,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                \"attributes\": \"区县\",\n" +
                "\t\t\"expanded\":true,\n" +
                "                \"id\": \"6ba60f42ccf648a9b8da12fb370bf3e5\",\n" +
                "                \"value\": \"第四师\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"level\": 3,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                        \"selected\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"c418ce478a1f4eada25f7be94d3d4b07\",\n" +
                "                        \"value\": \"三新煤业\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"itemClickEnable\": true,\n" +
                "        \"level\": 3,\n " +
                "                        \"selected\": true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"id\": \"314b4b5921b5406387c4f1efd5e34d2f\",\n" +
                "                        \"value\": \"喀赞其煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"itemClickEnable\": true,\n" +
                "        \"level\": 3,\n " +
                "                        \"selected\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"9aa542ffce28495b9a3b909366c4808c\",\n" +
                "                        \"value\": \"铁厂沟煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"iconCls\": \"fa fa-bookmark\",\n" +
                "                \"state\": \"open\",\n" +
                "                \"selected\": false,\n" +
                "\t\t\"expanded\":true,\n" +
                "                \"attributes\": \"区县\",\n" +
                "        \"level\": 2,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                \"id\": \"46d2099544a34add865dcc6d9829b6e9\",\n" +
                "                \"value\": \"第六师\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"level\": 3,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                        \"selected\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"f8f05f80b5f44e959efd5652c2fe753e\",\n" +
                "                        \"value\": \"豫新煤业一号井\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"itemClickEnable\": true,\n" +
                "                        \"selected\": true,\n" +
                "        \"level\": 3,\n " +
                "                        \"attributes\": \"矿井\",\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"id\": \"6b19fcbe7e8643d1a369dbf33b1c15c9\",\n" +
                "                        \"value\": \"梅斯布拉克煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"level\": 3,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                        \"selected\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"59a349dfed3f4a78b67a473f725b2801\",\n" +
                "                        \"value\": \"中煤能源106矿井\",\n" +
                "                        \"children\": []\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"iconCls\": \"fa fa-bookmark\",\n" +
                "                \"state\": \"open\",\n" +
                "        \"level\": 2,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                \"selected\": false,\n" +
                "\t\t\"expanded\":true,\n" +
                "                \"attributes\": \"区县\",\n" +
                "                \"id\": \"27b68973cddc4ea08d2bacadfcb6dce3\",\n" +
                "                \"value\": \"第七师\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "                        \"selected\": true,\n" +
                "        \"level\": 3,\n " +
                "        \"itemClickEnable\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"4b3ffeaa49a543418dcb8f6c0c348152\",\n" +
                "                        \"value\": \"准南煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "                        \"selected\": true,\n" +
                "        \"level\": 3,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"id\": \"400413d4ac964f68b92f9659968a1089\",\n" +
                "                        \"value\": \"准南东煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"level\": 3,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                        \"selected\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"3be127788c404a24b92f80cb8f1c6977\",\n" +
                "                        \"value\": \"一三七团煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"iconCls\": \"fa fa-bookmark\",\n" +
                "                \"state\": \"open\",\n" +
                "                \"selected\": false,\n" +
                "        \"level\": 2,\n " +
                "                \"attributes\": \"区县\",\n" +
                "\t\t\"expanded\":true,\n" +
                "        \"itemClickEnable\": true,\n" +
                "                \"id\": \"49fc51ba78164539b46e1d2cd3391ef2\",\n" +
                "                \"value\": \"第八师\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "                        \"selected\": true,\n" +
                "        \"level\": 3,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"id\": \"6b8d1c87412040329a6c750a910728e1\",\n" +
                "                        \"value\": \"南山煤矿小沟矿\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"level\": 3,\n " +
                "                        \"selected\": true,\n" +
                "        \"itemClickEnable\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"17a1c63466e04363b4821e8116f475d2\",\n" +
                "                        \"value\": \"塔西河煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"level\": 3,\n " +
                "                        \"selected\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "        \"itemClickEnable\": true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"987f14eb41544485af0c92eaac7c3a30\",\n" +
                "                        \"value\": \"东沟煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"iconCls\": \"fa fa-bookmark\",\n" +
                "                \"state\": \"open\",\n" +
                "        \"itemClickEnable\": true,\n" +
                "        \"level\": 2,\n " +
                "                \"selected\": false,\n" +
                "\t\t\"expanded\":true,\n" +
                "                \"attributes\": \"区县\",\n" +
                "                \"id\": \"715b009e13614d89ad5c78d0ed6423f2\",\n" +
                "                \"value\": \"第十师\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"itemClickEnable\": true,\n" +
                "                        \"selected\": true,\n" +
                "        \"level\": 3,\n " +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"56d5e5b3eb2246948b7ce15815917cc2\",\n" +
                "                        \"value\": \"屯南一分公司光明井\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "                        \"selected\": true,\n" +
                "        \"level\": 3,\n " +
                "\t\t\t\"expanded\":true,\n" +
                "        \"itemClickEnable\": true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"d5bf77ed9db1460593e9fa924a8be2a0\",\n" +
                "                        \"value\": \"一八七团煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "                        \"selected\": true,\n" +
                "        \"itemClickEnable\": true,\n" +
                "        \"level\": 3,\n " +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"5a0b1c4ad4084096b9828a91fe90ad91\",\n" +
                "                        \"value\": \"屯南煤业四分公司\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "                        \"selected\": true,\n" +
                "        \"level\": 3,\n " +
                "\t\t\t\"expanded\":true,\n" +
                "        \"itemClickEnable\": true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"2e2186a015bb4356be6bb2498c4dc8d3\",\n" +
                "                        \"value\": \"屯南煤业嘎顺乌散\",\n" +
                "                        \"children\": []\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"iconCls\": \"fa fa-bookmark\",\n" +
                "                \"state\": \"open\",\n" +
                "        \"level\": 2,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                \"selected\": false,\n" +
                "                \"attributes\": \"区县\",\n" +
                "\t\t\"expanded\":true,\n" +
                "                \"id\": \"b425c75757db4a8baf08ef218db9c309\",\n" +
                "                \"value\": \"第十二师\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"level\": 3,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                        \"selected\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"be696c9868ab4af3b6af999bb31e1431\",\n" +
                "                        \"value\": \"一零四团煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"level\": 3,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                        \"selected\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"87bc21ca84544bd29c8909425a8b7f79\",\n" +
                "                        \"value\": \"二二一团煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"level\": 3,\n " +
                "                        \"selected\": true,\n" +
                "        \"itemClickEnable\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"a809fe308e964db0a8d8f71c21951fc9\",\n" +
                "                        \"value\": \"白土窑煤业\",\n" +
                "                        \"children\": []\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"iconCls\": \"fa fa-bookmark\",\n" +
                "                \"state\": \"open\",\n" +
                "        \"level\": 2,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                \"selected\": false,\n" +
                "\t\t\"expanded\":true,\n" +
                "                \"attributes\": \"区县\",\n" +
                "                \"id\": \"6237d0be7fff4aebaac381327a23ab42\",\n" +
                "                \"value\": \"第十三师\",\n" +
                "                \"children\": []\n" +
                "            },\n" +
                "            {\n" +
                "                \"iconCls\": \"fa fa-bookmark\",\n" +
                "                \"state\": \"open\",\n" +
                "        \"level\": 2,\n " +
                "                \"selected\": false,\n" +
                "        \"itemClickEnable\": true,\n" +
                "\t\t\"expanded\":true,\n" +
                "                \"attributes\": \"区县\",\n" +
                "                \"id\": \"69df179c186f4876a1ef62704e8d3cd0\",\n" +
                "                \"value\": \"国资公司\",\n" +
                "                \"children\": []\n" +
                "            }\n" +
                "        ]\n" +
                "    }";

        String str1 = "  {\n" +
                "        \"iconCls\": \"fa fa-bookmark\",\n" +
                "        \"state\": \"open\",\n" +
                "        \"level\": 1,\n " +
                "        \"selected\": false,\n" +
                "        \"itemClickEnable\": true,\n" +
                "\t\"expanded\":true,\n" +
                "        \"attributes\": \"管理局\",\n" +
                "        \"id\": \"1\",\n" +
                "        \"value\": \"兵团煤矿安全监察局\",\n" +
                "        \"children\": [\n" +
                "            {\n" +
                "                \"iconCls\": \"fa fa-bookmark\",\n" +
                "                \"state\": \"open\",\n" +
                "        \"itemClickEnable\": true,\n" +
                "        \"level\": 2,\n " +
                "                \"selected\": false,\n" +
                "\"expanded\":true,\n" +
                "                \"attributes\": \"区县\",\n" +
                "                \"id\": \"11b894533ac14fb68bb3658013846dea\",\n" +
                "                \"value\": \"第一师\",\n" +
                "                \"children\": []\n" +
                "            },\n" +
                "            {\n" +
                "                \"iconCls\": \"fa fa-bookmark\",\n" +
                "                \"state\": \"open\",\n" +
                "        \"itemClickEnable\": true,\n" +
                "        \"level\": 2,\n " +
                "                \"selected\": false,\n" +
                "\t\t\"expanded\":true,\n" +
                "                \"attributes\": \"区县\",\n" +
                "                \"id\": \"02b0f343bf194f57983374140a6419aa\",\n" +
                "                \"value\": \"第二师\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"itemClickEnable\": true,\n" +
                "        \"level\": 3,\n " +
                "                        \"selected\": true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"id\": \"391b77252c9a46fa8e41437d44cf3b5d\",\n" +
                "                        \"value\": \"金川矿业\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"itemClickEnable\": true,\n" +
                "                        \"selected\": true,\n" +
                "        \"level\": 3,\n " +
                "                        \"attributes\": \"矿井\",\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"id\": \"3d04c124d43149ceacc6e77020f832cb\",\n" +
                "                        \"value\": \"塔什店联合矿业\",\n" +
                "                        \"children\": []\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"iconCls\": \"fa fa-bookmark\",\n" +
                "                \"state\": \"open\",\n" +
                "                \"selected\": false,\n" +
                "        \"level\": 2,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                \"attributes\": \"区县\",\n" +
                "\t\t\"expanded\":true,\n" +
                "                \"id\": \"6ba60f42ccf648a9b8da12fb370bf3e5\",\n" +
                "                \"value\": \"第四师\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"level\": 3,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                        \"selected\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"c418ce478a1f4eada25f7be94d3d4b07\",\n" +
                "                        \"value\": \"三新煤业\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"itemClickEnable\": true,\n" +
                "        \"level\": 3,\n " +
                "                        \"selected\": true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"id\": \"314b4b5921b5406387c4f1efd5e34d2f\",\n" +
                "                        \"value\": \"喀赞其煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"itemClickEnable\": true,\n" +
                "        \"level\": 3,\n " +
                "                        \"selected\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"9aa542ffce28495b9a3b909366c4808c\",\n" +
                "                        \"value\": \"铁厂沟煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"iconCls\": \"fa fa-bookmark\",\n" +
                "                \"state\": \"open\",\n" +
                "                \"selected\": false,\n" +
                "\t\t\"expanded\":true,\n" +
                "                \"attributes\": \"区县\",\n" +
                "        \"level\": 2,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                \"id\": \"46d2099544a34add865dcc6d9829b6e9\",\n" +
                "                \"value\": \"第六师\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"level\": 3,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                        \"selected\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"f8f05f80b5f44e959efd5652c2fe753e\",\n" +
                "                        \"value\": \"豫新煤业一号井\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"itemClickEnable\": true,\n" +
                "                        \"selected\": true,\n" +
                "        \"level\": 3,\n " +
                "                        \"attributes\": \"矿井\",\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"id\": \"6b19fcbe7e8643d1a369dbf33b1c15c9\",\n" +
                "                        \"value\": \"梅斯布拉克煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"level\": 3,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                        \"selected\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"59a349dfed3f4a78b67a473f725b2801\",\n" +
                "                        \"value\": \"中煤能源106矿井\",\n" +
                "                        \"children\": []\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"iconCls\": \"fa fa-bookmark\",\n" +
                "                \"state\": \"open\",\n" +
                "        \"level\": 2,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                \"selected\": false,\n" +
                "\t\t\"expanded\":true,\n" +
                "                \"attributes\": \"区县\",\n" +
                "                \"id\": \"27b68973cddc4ea08d2bacadfcb6dce3\",\n" +
                "                \"value\": \"第七师\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "                        \"selected\": true,\n" +
                "        \"level\": 3,\n " +
                "        \"itemClickEnable\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"4b3ffeaa49a543418dcb8f6c0c348152\",\n" +
                "                        \"value\": \"准南煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "                        \"selected\": true,\n" +
                "        \"level\": 3,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"id\": \"400413d4ac964f68b92f9659968a1089\",\n" +
                "                        \"value\": \"准南东煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"level\": 3,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                        \"selected\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"3be127788c404a24b92f80cb8f1c6977\",\n" +
                "                        \"value\": \"一三七团煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"iconCls\": \"fa fa-bookmark\",\n" +
                "                \"state\": \"open\",\n" +
                "                \"selected\": false,\n" +
                "        \"level\": 2,\n " +
                "                \"attributes\": \"区县\",\n" +
                "\t\t\"expanded\":true,\n" +
                "        \"itemClickEnable\": true,\n" +
                "                \"id\": \"49fc51ba78164539b46e1d2cd3391ef2\",\n" +
                "                \"value\": \"第八师\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "                        \"selected\": true,\n" +
                "        \"level\": 3,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"id\": \"6b8d1c87412040329a6c750a910728e1\",\n" +
                "                        \"value\": \"南山煤矿小沟矿\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"level\": 3,\n " +
                "                        \"selected\": true,\n" +
                "        \"itemClickEnable\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"17a1c63466e04363b4821e8116f475d2\",\n" +
                "                        \"value\": \"塔西河煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"level\": 3,\n " +
                "                        \"selected\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "        \"itemClickEnable\": true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"987f14eb41544485af0c92eaac7c3a30\",\n" +
                "                        \"value\": \"东沟煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"iconCls\": \"fa fa-bookmark\",\n" +
                "                \"state\": \"open\",\n" +
                "        \"itemClickEnable\": true,\n" +
                "        \"level\": 2,\n " +
                "                \"selected\": false,\n" +
                "\t\t\"expanded\":true,\n" +
                "                \"attributes\": \"区县\",\n" +
                "                \"id\": \"715b009e13614d89ad5c78d0ed6423f2\",\n" +
                "                \"value\": \"第十师\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"itemClickEnable\": true,\n" +
                "                        \"selected\": true,\n" +
                "        \"level\": 3,\n " +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"56d5e5b3eb2246948b7ce15815917cc2\",\n" +
                "                        \"value\": \"屯南一分公司光明井\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "                        \"selected\": true,\n" +
                "        \"level\": 3,\n " +
                "\t\t\t\"expanded\":true,\n" +
                "        \"itemClickEnable\": true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"d5bf77ed9db1460593e9fa924a8be2a0\",\n" +
                "                        \"value\": \"一八七团煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "                        \"selected\": true,\n" +
                "        \"itemClickEnable\": true,\n" +
                "        \"level\": 3,\n " +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"5a0b1c4ad4084096b9828a91fe90ad91\",\n" +
                "                        \"value\": \"屯南煤业四分公司\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "                        \"selected\": true,\n" +
                "        \"level\": 3,\n " +
                "\t\t\t\"expanded\":true,\n" +
                "        \"itemClickEnable\": true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"2e2186a015bb4356be6bb2498c4dc8d3\",\n" +
                "                        \"value\": \"屯南煤业嘎顺乌散\",\n" +
                "                        \"children\": []\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"iconCls\": \"fa fa-bookmark\",\n" +
                "                \"state\": \"open\",\n" +
                "        \"level\": 2,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                \"selected\": false,\n" +
                "                \"attributes\": \"区县\",\n" +
                "\t\t\"expanded\":true,\n" +
                "                \"id\": \"b425c75757db4a8baf08ef218db9c309\",\n" +
                "                \"value\": \"第十二师\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"level\": 3,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                        \"selected\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"be696c9868ab4af3b6af999bb31e1431\",\n" +
                "                        \"value\": \"一零四团煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"level\": 3,\n " +
                "        \"itemClickEnable\": true,\n" +
                "                        \"selected\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"87bc21ca84544bd29c8909425a8b7f79\",\n" +
                "                        \"value\": \"二二一团煤矿\",\n" +
                "                        \"children\": []\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"iconCls\": \"fa fa-bookmark\",\n" +
                "                        \"state\": \"open\",\n" +
                "        \"level\": 3,\n " +
                "                        \"selected\": true,\n" +
                "        \"itemClickEnable\": true,\n" +
                "\t\t\t\"expanded\":true,\n" +
                "                        \"attributes\": \"矿井\",\n" +
                "                        \"id\": \"a809fe308e964db0a8d8f71c21951fc9\",\n" +
                "                        \"value\": \"白土窑煤业\",\n" +
                "                        \"children\": []\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"iconCls\": \"fa fa-bookmark\",\n" +
                "                \"state\": \"open\",\n" +
                "        \"level\": 2,\n " +
                "                \"selected\": false,\n" +
                "        \"itemClickEnable\": true,\n" +
                "\t\t\"expanded\":true,\n" +
                "                \"attributes\": \"区县\",\n" +
                "                \"id\": \"69df179c186f4876a1ef62704e8d3cd0\",\n" +
                "                \"value\": \"国资公司\",\n" +
                "                \"children\": []\n" +
                "            }\n" +
                "        ]\n" +
                "    }";

        treeNode = new Gson().fromJson(str, TreeNode.class);
//        treeNode1 = new Gson().fromJson(str1, TreeNode.class);

    }
}
