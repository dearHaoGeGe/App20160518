package com.my.app20160518.tab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.my.app20160518.activity.BusinessDetailsActivity;
import com.my.app20160518.bean.BusinessBean;
import com.my.app20160518.eventbus.EventBankBean;
import com.my.app20160518.eventbus.EventBusinessBean;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * 工商Fragment
 * <p/>
 * Created by YJH on 2016/5/19.
 */
public class BusinessCirclesFragment extends Fragment implements AdapterView.OnItemClickListener {

    private BusinessCirclesFragmentAdapter adapter;
    private ListView lv_BusinessCircles_Fragment;
    private List<BusinessBean> data;
    private static final String ACT_CREATE = "BusinessDetailsActivity已经创建";
    private int clickPosition;    //点击位置

    public static BusinessCirclesFragment newInstance() {
        BusinessCirclesFragment fragment = new BusinessCirclesFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //注册EventBus
        EventBus.getDefault().register(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.business_circles_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        initData();
    }

    private void initView() {
        lv_BusinessCircles_Fragment = (ListView) getActivity().findViewById(R.id.lv_BusinessCircles_Fragment);

        lv_BusinessCircles_Fragment.setOnItemClickListener(this);
    }

    private void initData() {
        data = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            data.add(addData(i));
        }

        adapter=new BusinessCirclesFragmentAdapter(getActivity(),data);
        lv_BusinessCircles_Fragment.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        clickPosition=position;
        Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getActivity(), BusinessDetailsActivity.class));
    }

    public void onEventMainThread(String s) {
        if (s.equals(ACT_CREATE)) {
            Log.d("------>", "BusinessCirclesFragment已经收到BusinessDetailsActivity成功创建的消息");
            EventBus.getDefault().post(new EventBusinessBean(data.get(clickPosition)));
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
    private class BusinessCirclesFragmentAdapter extends BaseAdapter {

        private Context context;
        private List<BusinessBean> datas;

        public BusinessCirclesFragmentAdapter(Context context, List<BusinessBean> datas) {
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
            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.business_circles_fragment_item, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.tv_CompanyName_BusinessCirclesFragment_item =
                        (TextView) convertView.findViewById(R.id.tv_CompanyName_BusinessCirclesFragment_item);
                viewHolder.tv_CompanyType_BusinessCirclesFragment_item =
                        (TextView) convertView.findViewById(R.id.tv_CompanyType_BusinessCirclesFragment_item);
                viewHolder.tv_Job_BusinessCirclesFragment_item =
                        (TextView) convertView.findViewById(R.id.tv_Job_BusinessCirclesFragment_item);
                viewHolder.tv_BusinessScope_BusinessCirclesFragment_item =
                        (TextView) convertView.findViewById(R.id.tv_BusinessScope_BusinessCirclesFragment_item);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            if (datas != null) {
                viewHolder.tv_CompanyName_BusinessCirclesFragment_item.setText("公司名称：" + datas.get(position).getCompanyName());
                viewHolder.tv_CompanyType_BusinessCirclesFragment_item.setText("公司类型：" + datas.get(position).getCompanyType());
                viewHolder.tv_Job_BusinessCirclesFragment_item.setText("检查对象承担职务：" + datas.get(position).getJob());
                viewHolder.tv_BusinessScope_BusinessCirclesFragment_item.setText("经营范围：" + datas.get(position).getBusinessScope());
            }
            return convertView;
        }

        class ViewHolder {
            private TextView tv_CompanyName_BusinessCirclesFragment_item, tv_CompanyType_BusinessCirclesFragment_item,
                    tv_Job_BusinessCirclesFragment_item, tv_BusinessScope_BusinessCirclesFragment_item;
        }
    }

    /**
     * 添加假数据
     * @param i
     * @return
     */
    private BusinessBean addData(int i){
        BusinessBean b=new BusinessBean();

        b.setCompanyName("中国移动");
        b.setFeedbackTime(20010330L);
        b.setHelpUnit("高院工商局");
        b.setBusiness_Registration_Number_Or_IDNumber(645979233131L);
        b.setCompanyType("上市");
        b.setRegistered_Money("2000万");
        b.setRegistered_Currency("人民币");
        b.setBusinessScope("经营范围");
        b.setCreate_Date(20010330L);
        b.setBusiness_Term("2001年3月至今");
        b.setJob("公司董事会主席");
        b.setLegal_Representative("高小才");
        b.setLegal_Representative_Gender("男");
        b.setLegal_Representative_ID("210283196512032653");
        b.setLegal_Representative_Phone("041182666688");
        b.setLegal_Representative_Address("北京市朝阳区");
        b.setCompany_Address("大连市河北街83号");
        b.setID_Type("身份证");
        b.setRemarks(null);

        return b;
    }

}
