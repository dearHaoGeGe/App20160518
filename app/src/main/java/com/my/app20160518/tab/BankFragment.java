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
import com.my.app20160518.activity.BankDetailsActivity;
import com.my.app20160518.bean.BankBean;
import com.my.app20160518.eventbus.EventBankBean;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * 银行Fragment
 * <p/>
 * Created by YJH on 2016/5/19.
 */
public class BankFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView lv_Bank_Fragment;
    private BankFragmentAdapter adapter;
    private List<BankBean> data;
    private static final String ACT_CREATE = "BankDetailsActivity已经创建";
    private int clickPosition;    //点击位置

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
        View view = inflater.inflate(R.layout.bank_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        initData();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public static BankFragment newInstance() {
        BankFragment fragment = new BankFragment();
        return fragment;
    }

    private void initView() {
        lv_Bank_Fragment = (ListView) getActivity().findViewById(R.id.lv_Bank_Fragment);

        lv_Bank_Fragment.setOnItemClickListener(this);
    }

    private void initData() {
        data = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            data.add(addData(i));
        }

        adapter = new BankFragmentAdapter(data, getActivity());
        lv_Bank_Fragment.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        clickPosition = position;
        Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getActivity(), BankDetailsActivity.class));
    }

    public void onEventMainThread(String s) {
        if (s.equals(ACT_CREATE)) {
            Log.d("------>", "BankFragment已经收到BankDetailsActivity成功创建的消息");
            EventBus.getDefault().post(new EventBankBean(data.get(clickPosition)));
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
    private class BankFragmentAdapter extends BaseAdapter {

        private List<BankBean> datas;
        private Context context;

        public BankFragmentAdapter(List<BankBean> datas, Context context) {
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
                convertView = LayoutInflater.from(context).inflate(R.layout.bank_fragment_item, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.tv_name_BankFragment_item = (TextView) convertView.findViewById(R.id.tv_name_BankFragment_item);
                viewHolder.tv_Bank_Account_BankFragment_item = (TextView) convertView.findViewById(R.id.tv_Bank_Account_BankFragment_item);
                viewHolder.tv_Account_Opening_BankFragment_item = (TextView) convertView.findViewById(R.id.tv_Account_Opening_BankFragment_item);
                viewHolder.tv_Opening_Time_BankFragment_item = (TextView) convertView.findViewById(R.id.tv_Opening_Time_BankFragment_item);
                viewHolder.tv_Account_Balance_BankFragment_item = (TextView) convertView.findViewById(R.id.tv_Account_Balance_BankFragment_item);
                viewHolder.tv_Account_Status_BankFragment_item = (TextView) convertView.findViewById(R.id.tv_Account_Status_BankFragment_item);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            if (datas != null) {
                viewHolder.tv_name_BankFragment_item.setText("姓名：" + datas.get(position).getName());
                viewHolder.tv_Bank_Account_BankFragment_item.setText("开户银行：" + datas.get(position).getBank_Account());
                viewHolder.tv_Account_Opening_BankFragment_item.setText("开户账号：" + datas.get(position).getAccount_Number() + "");
                viewHolder.tv_Opening_Time_BankFragment_item.setText("开户时间：" + datas.get(position).getOpening_Time() + "");
                viewHolder.tv_Account_Balance_BankFragment_item.setText("可用资产数额:" + datas.get(position).getAccount_Balance() + "");
                if (datas.get(position).isAccount_Status()) {
                    viewHolder.tv_Account_Status_BankFragment_item.setText("开户状态：正常");
                } else {
                    viewHolder.tv_Account_Status_BankFragment_item.setText("开户状态：冻结");
                }
            }
            return convertView;
        }

        class ViewHolder {
            private TextView tv_name_BankFragment_item, tv_Bank_Account_BankFragment_item,
                    tv_Account_Opening_BankFragment_item, tv_Opening_Time_BankFragment_item,
                    tv_Account_Balance_BankFragment_item, tv_Account_Status_BankFragment_item;
        }
    }

    /**
     * 添加假数据
     */
    private BankBean addData(int i) {
        BankBean b1 = new BankBean();

        b1.setName("马云" + i);
        b1.setBank_Account("中国建设银行");
        b1.setAccount_Number("610023597222032056");
        b1.setOpening_Time(19980101L);
        b1.setAmount_Of_Assets("93000");
        b1.setAccount_Status(true);
        b1.setHelpUnit("高院商业银行");
        b1.setNew_AccountCode("hz4142");
        b1.setAmount_Of_Assets("23000");
        b1.setAccount_Type("信用卡");
        b1.setCurrency("人民币");
        b1.setPostCode("060100");
        b1.setAccount_Balance(236510L);
        b1.setNotesOnTheNotes("本币");
        b1.setNewAccountBankAddress("大连甘井区支行");
        b1.setRelatedCapitalAccount("");
        b1.setAddress("大连甘井区生态科技城");
        b1.setFeedbackTime(20160521L);
        b1.setDataStopTime(20150525L);
        b1.setPhone("13800001234");
        b1.setLogoutAccountDate(2L);
        b1.setRemarks("");

        return b1;
    }


}
