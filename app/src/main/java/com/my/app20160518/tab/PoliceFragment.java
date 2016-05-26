package com.my.app20160518.tab;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.my.app20160518.R;
import com.my.app20160518.bean.BankBean;
import com.my.app20160518.bean.PoliceBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 公安Fragment
 * <p>
 * Created by Administrator on 2016/5/19.
 */
public class PoliceFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView lv_Police_Fragment;
    private List<PoliceBean> data;
    private int clickPosition;    //点击位置

    public static PoliceFragment newInstance() {
        PoliceFragment fragment = new PoliceFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.police_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void initView() {
        lv_Police_Fragment = (ListView) getActivity().findViewById(R.id.lv_Police_Fragment);

        lv_Police_Fragment.setOnItemClickListener(this);
    }

    private void initData() {
        data = new ArrayList<>();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    /**
     * 适配器
     */
    private class PoliceFragmentAdapter extends BaseAdapter{

        private List<BankBean> datas;
        private Context context;

        public PoliceFragmentAdapter(List<BankBean> datas, Context context) {
            this.datas = datas;
            this.context = context;
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
                convertView=LayoutInflater.from(context).inflate(R.layout.police_fragment_item,parent,false);
                viewHolder=new ViewHolder();
                viewHolder.tv_name_PoliceFragment_item= (TextView) convertView.findViewById(R.id.tv_name_PoliceFragment_item);
                viewHolder.tv_Place_Birth_PoliceFragment_item= (TextView) convertView.findViewById(R.id.tv_Place_Birth_PoliceFragment_item);
                viewHolder.tv_work_PoliceFragment_item= (TextView) convertView.findViewById(R.id.tv_work_PoliceFragment_item);
                viewHolder.tv_Date_Birth_PoliceFragment_item= (TextView) convertView.findViewById(R.id.tv_Date_Birth_PoliceFragment_item);
                viewHolder.tv_IDNumber_PoliceFragment_item= (TextView) convertView.findViewById(R.id.tv_IDNumber_PoliceFragment_item);

                convertView.setTag(viewHolder);
            }else {
                viewHolder= (ViewHolder) convertView.getTag();
            }

            if (datas!=null){

            }
            return convertView;
        }

        class ViewHolder{
            private TextView tv_name_PoliceFragment_item,tv_Place_Birth_PoliceFragment_item,
                    tv_work_PoliceFragment_item,tv_Date_Birth_PoliceFragment_item,
                    tv_IDNumber_PoliceFragment_item;
        }
    }
}
