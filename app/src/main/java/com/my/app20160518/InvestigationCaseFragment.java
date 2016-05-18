package com.my.app20160518;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.my.app20160518.view.XListView;

import java.util.List;

/**
 * 在协查反馈Activity(InvestigationOfFeedbackActivity)案件显示的
 * 案件的Fragment
 * <p/>
 * Created by YJH on 2016/5/18.
 */
public class InvestigationCaseFragment extends Fragment implements AdapterView.OnItemClickListener {

    private XListView xListView_case_InvestigationCaseFragment;

    public static InvestigationCaseFragment newInstance() {
        InvestigationCaseFragment fragment = new InvestigationCaseFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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
        xListView_case_InvestigationCaseFragment.setOnItemClickListener(this);
    }

    private void initData() {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    /**
     * 这个fragment页面中的listview的适配器
     */
    private class CaseAdapter extends BaseAdapter{

        private Context context;
        private List<String> datas;

        public CaseAdapter(Context context, List<String> datas) {
            this.context = context;
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
            ViewHolder viewHolder=null;
            if (convertView==null){
                convertView=LayoutInflater.from(context)
                        .inflate(R.layout.investigation_case_fragment_item,parent,false);

            }
            return null;
        }

        class ViewHolder{
            private TextView tv_caseName_item_investigation_case_fragment;
        }
    }
}
