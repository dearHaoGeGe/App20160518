package com.my.app20160518.tab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.my.app20160518.R;
import com.my.app20160518.activity.PoliceDetailsActivity;
import com.my.app20160518.bean.PoliceBean;
import com.my.app20160518.eventbus.EventBankBean;
import com.my.app20160518.eventbus.EventPoliceBean;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * 公安Fragment
 * <p/>
 * Created by YJH on 2016/5/19.
 */
public class PoliceFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView lv_Police_Fragment;
    private List<PoliceBean> data;
    private PoliceFragmentAdapter adapter;
    private static final String ACT_CREATE = "PoliceDetailsActivity已经创建";
    private int clickPosition;    //点击位置

    public static PoliceFragment newInstance() {
        PoliceFragment fragment = new PoliceFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        //注册EventBus
        EventBus.getDefault().register(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.police_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        initData();
    }

    private void initView() {
        lv_Police_Fragment = (ListView) getActivity().findViewById(R.id.lv_Police_Fragment);

        lv_Police_Fragment.setOnItemClickListener(this);
    }

    private void initData() {
        data = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            data.add(addData(i));
        }

        adapter = new PoliceFragmentAdapter(data, getActivity());
        lv_Police_Fragment.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        clickPosition=position;
        Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getActivity(), PoliceDetailsActivity.class));
    }

    public void onEventMainThread(String s) {
        if (s.equals(ACT_CREATE)) {
            Log.d("------>", "BankFragment已经收到BankDetailsActivity成功创建的消息");
            EventBus.getDefault().post(new EventPoliceBean(data.get(clickPosition)));
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消注册EventBus
        EventBus.getDefault().unregister(this);
    }

    /**
     * 适配器
     */
    private class PoliceFragmentAdapter extends BaseAdapter {

        private List<PoliceBean> datas;
        private Context context;

        public PoliceFragmentAdapter(List<PoliceBean> datas, Context context) {
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
            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.police_fragment_item, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.tv_name_PoliceFragment_item = (TextView) convertView.findViewById(R.id.tv_name_PoliceFragment_item);
                viewHolder.tv_Place_Birth_PoliceFragment_item = (TextView) convertView.findViewById(R.id.tv_Place_Birth_PoliceFragment_item);
                viewHolder.tv_work_PoliceFragment_item = (TextView) convertView.findViewById(R.id.tv_work_PoliceFragment_item);
                viewHolder.tv_Date_Birth_PoliceFragment_item = (TextView) convertView.findViewById(R.id.tv_Date_Birth_PoliceFragment_item);
                viewHolder.tv_IDNumber_PoliceFragment_item = (TextView) convertView.findViewById(R.id.tv_IDNumber_PoliceFragment_item);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            if (datas != null) {
                viewHolder.tv_name_PoliceFragment_item.setText("姓名：" + datas.get(position).getName());
                viewHolder.tv_Place_Birth_PoliceFragment_item.setText("出生地：" + datas.get(position).getPlace_Of_Birth());
                viewHolder.tv_work_PoliceFragment_item.setText("职业：" + datas.get(position).getJob());
                viewHolder.tv_Date_Birth_PoliceFragment_item.setText("出生日期：" + datas.get(position).getBirthday() + "");
                viewHolder.tv_IDNumber_PoliceFragment_item.setText("证件号码：" + datas.get(position).getIDNumber());
            }
            return convertView;
        }

        class ViewHolder {
            private TextView tv_name_PoliceFragment_item, tv_Place_Birth_PoliceFragment_item,
                    tv_work_PoliceFragment_item, tv_Date_Birth_PoliceFragment_item,
                    tv_IDNumber_PoliceFragment_item;
        }
    }

    private PoliceBean addData(int i) {
        PoliceBean b = new PoliceBean();

        b.setName("王二虎" + i);
        b.setBefore_Name("叶良辰" + i);
        b.setIDNumber("230265195606231256");
        b.setHouse_Number("DLHJ0001");
        b.setAnd_Host_Relationship("户主");
        b.setNode_Type("非农");
        b.setMarry("已婚");
        b.setEducation("博士");
        b.setNation("回族");
        b.setJob("博士生导师");
        b.setGender("女");
        b.setHeight("175cm");
        b.setBirthday(19560623L);
        b.setPlace_Of_Birth("黑龙江省哈尔滨市");
        b.setDomicile_Address_City(null);
        b.setDomicile_Address(null);
        b.setPolice_Station_Name("动力路99号");
        b.setPublic_Security_Name(null);
        b.setOther_Address_City(null);
        b.setOther_Address(null);
        b.setEmployer(null);
        b.setChange_Date(null);
        b.setWhere_Move(null);

        return b;
    }
}
