package com.my.app20160518;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.my.app20160518.view.XListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 在协查反馈Activity(InvestigationOfFeedbackActivity)案件显示的
 * 案件的Fragment
 * <p/>
 * Created by YJH on 2016/5/18.
 */
public class InvestigationCaseFragment extends Fragment implements AdapterView.OnItemClickListener, XListView.IXListViewListener {

    private XListView xListView_case_InvestigationCaseFragment;
    private CaseAdapter adapter;
    private InvestigationOfFeedbackActivity activity;
    private Handler mHandler;
    private List<String> data;

    public static InvestigationCaseFragment newInstance() {
        InvestigationCaseFragment fragment = new InvestigationCaseFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity= (InvestigationOfFeedbackActivity) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.investigation_case_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        initData();
    }

    private void initView() {
        xListView_case_InvestigationCaseFragment = (XListView) getActivity().findViewById(R.id.xListView_case_InvestigationCaseFragment);

        xListView_case_InvestigationCaseFragment.setPullLoadEnable(true);
        xListView_case_InvestigationCaseFragment.setXListViewListener(this);

        xListView_case_InvestigationCaseFragment.setOnItemClickListener(this);
    }

    private void initData() {
        mHandler = new Handler();
        data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add("X X X X X X X 案件");
        }

        adapter = new CaseAdapter(getActivity(), data);
        xListView_case_InvestigationCaseFragment.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int pos = position - 1;   //头布局占一个位置，所以-1
        if (pos >= 0) {           //判断是否pos为-1的情况下
            Toast.makeText(getContext(), "" + pos, Toast.LENGTH_SHORT).show();
            activity.initFragmentManager(InvestigationDetailsCaseFragment.newInstance());
        }
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshData();
            }
        }, 2000);
    }

    /**
     * 上拉加载
     */
    @Override
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadMoreData();
            }
        }, 2000);
    }

    /**
     * 下拉刷新数据(方法)
     */
    private void refreshData() {
        data.clear();
        for (int i = 0; i < 3; i++) {
            data.add("这是下拉加载数据(XXX案件)");
            data.add("这是下拉加载数据(XXX案件)");
            data.add("这是下拉加载数据(XXX案件)");
        }
        adapter.setDatas(data);
        adapter.notifyDataSetChanged();
        onLoad();
    }

    /**
     * 上拉加载数据(方法)
     */
    private void loadMoreData() {
        adapter.addData("这是上拉加载数据(XXX案件)");
        adapter.addData("这是上拉加载数据(XXX案件)");
        adapter.addData("这是上拉加载数据(XXX案件)");
        onLoad();
    }

    private void onLoad() {
        xListView_case_InvestigationCaseFragment.stopRefresh();
        xListView_case_InvestigationCaseFragment.stopLoadMore();
        xListView_case_InvestigationCaseFragment.setRefreshTime("");
    }

    /**
     * 这个fragment页面中的listview的适配器
     */
    private class CaseAdapter extends BaseAdapter {

        private Context context;
        private List<String> datas;

        public CaseAdapter(Context context, List<String> datas) {
            this.context = context;
            this.datas = datas;
        }

        public void setDatas(List<String> datas) {
            this.datas = datas;
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context)
                        .inflate(R.layout.investigation_case_fragment_item, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.tv_caseName_item_investigation_case_fragment =
                        (TextView) convertView.findViewById(R.id.tv_caseName_item_investigation_case_fragment);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            if (datas != null) {
                viewHolder.tv_caseName_item_investigation_case_fragment.setText(datas.get(position));
            }
            return convertView;
        }

        class ViewHolder {
            private TextView tv_caseName_item_investigation_case_fragment;
        }

        /**
         * 往适配器里面添加数据
         *
         * @param str
         */
        private void addData(String str) {
            datas.add(str);
            notifyDataSetChanged();
        }
    }
}
