package baidumapsdk.cunstonview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;


import qinshi.mylibrary.utils.ToastUtils;
import qinshi.mylibrary.view.listview.AutoLoadListView;
import qinshi.mylibrary.view.LoadingFooter;
import qinshi.mylibrary.view.listview.AutoAdapter;
import qinshi.mylibrary.view.listview.ViewHolder;
import qinshi.mylibrary.view.recyclerview.BaseAdapterHelper;
import qinshi.mylibrary.view.recyclerview.QuickAdapter;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mData = new ArrayList<>();
    private RecyclerView mListView;

    private QuickAdapter<String> mAutoAdapter;

    private Handler h = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {

                for (int i = 20; i <= 40; i++) {
                    mData.add(String.valueOf(i));

                }

                mAutoAdapter.notifyDataSetChanged();

                //  mListView.setState(LoadingFooter.State.TheEnd);

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (RecyclerView) findViewById(R.id.recyclerview);
        for (int i = 0; i <= 60; i++)
            mData.add(String.valueOf(i));

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        mAutoAdapter = new QuickAdapter<String>(this, R.layout.item, mData) {
            @Override
            protected void convert(BaseAdapterHelper helper, String item) {
                helper.getTextView(R.id.textView3).setText(item);
            }
        };
        mListView.setLayoutManager(mLinearLayoutManager);
        mListView.setAdapter(mAutoAdapter);


    }


}
