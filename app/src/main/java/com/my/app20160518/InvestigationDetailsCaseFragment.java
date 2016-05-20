package com.my.app20160518;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
 * 案件详情Fragment     (上拉加载下拉刷新暂时没有加)
 * <p/>
 * Created by Administrator on 2016/5/19.
 */
public class InvestigationDetailsCaseFragment extends Fragment implements XListView.IXListViewListener, AdapterView.OnItemClickListener {

    private XListView xListView_InvestigationDetailsCaseFragment;
    private InvestigationOfFeedbackActivity activity;
    private InvestigationDetailsCaseAdapter adapter;
    private List<String> data;

    public static InvestigationDetailsCaseFragment newInstance() {
        InvestigationDetailsCaseFragment fragment = new InvestigationDetailsCaseFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity= (InvestigationOfFeedbackActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.investigation_details_case_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        initData();
    }

    private void initView() {
        xListView_InvestigationDetailsCaseFragment = (XListView) getActivity().findViewById(R.id.xListView_InvestigationDetailsCaseFragment);

        xListView_InvestigationDetailsCaseFragment.setPullLoadEnable(true);
        xListView_InvestigationDetailsCaseFragment.setXListViewListener(this);

        View view=LayoutInflater.from(getActivity()).inflate(R.layout.investigation_etails_case_fragment_header,null);
        TextView tv= (TextView) view.findViewById(R.id.tv_header_item_investigation_case_fragment);
        tv.setText("案件相关人员");
        tv.setTextSize(30);
        xListView_InvestigationDetailsCaseFragment.addHeaderView(view);

        xListView_InvestigationDetailsCaseFragment.setOnItemClickListener(this);
    }

    private void initData() {
        data=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add("人 员 姓 名");
        }

        adapter = new InvestigationDetailsCaseAdapter(data,getActivity());
        xListView_InvestigationDetailsCaseFragment.setAdapter(adapter);
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {

    }

    /**
     * 上拉加载
     */
    @Override
    public void onLoadMore() {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int pos=position-2;     //头布局-2
        if (pos>=0){
            Toast.makeText(getActivity(), ""+pos, Toast.LENGTH_SHORT).show();
            activity.initFragmentManager(StaffDetailsFragment.newInstance());
        }
    }

    /**
     * 适配器
     */
    private class InvestigationDetailsCaseAdapter extends BaseAdapter {

        private List<String> datas;
        private Context context;

        public InvestigationDetailsCaseAdapter(List<String> datas, Context context) {
            this.datas = datas;
            this.context = context;
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
                convertView = LayoutInflater.from(context).inflate(R.layout.investigation_etails_case_fragment_header, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.tv_caseName_item_investigation_case_fragment =
                        (TextView) convertView.findViewById(R.id.tv_header_item_investigation_case_fragment);

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
