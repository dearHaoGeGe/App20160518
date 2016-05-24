package com.my.app20160518.tab;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.my.app20160518.R;
import com.my.app20160518.bean.BankBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 银行Fragment
 * <p/>
 * Created by YJH on 2016/5/19.
 */
public class BankFragment extends Fragment {

    private ListView lv_Bank_Fragment;
    private BankFragmentAdapter adapter;
    private List<BankBean> data;

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
    }

    private void initData(){
        data=new ArrayList<>();
        data.add(new BankBean("马云","中国建设银行","610023597222032056",19980101L,20000L,true));
        data.add(new BankBean("雷军","中国招商银行","610028977222032056",20100101L,13000L,true));
        data.add(new BankBean("丁磊","中国银行","369741597222032056",20020101L,89000L,true));
        data.add(new BankBean("董明珠","中国格力银行","610230140222032056",19900101L,20000L,true));
        data.add(new BankBean("周宏伟","中国工商银行","610023597222032056",19980101L,20000L,true));
        data.add(new BankBean("罗永浩","中国招商银行","610023597222032056",19980101L,20000L,true));
        data.add(new BankBean("王自如","中国建设银行","610023597222032056",19980101L,20000L,false));
        data.add(new BankBean("马化腾","中国QQ银行","610023597222032056",19980101L,20000L,true));

        adapter=new BankFragmentAdapter(data,getActivity());
        lv_Bank_Fragment.setAdapter(adapter);
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

            if (datas!=null){
                viewHolder.tv_name_BankFragment_item.setText("姓名："+datas.get(position).getName());
                viewHolder.tv_Bank_Account_BankFragment_item.setText("开户银行："+datas.get(position).getBank_Account());
                viewHolder.tv_Account_Opening_BankFragment_item.setText("开户账号："+datas.get(position).getAccount_Opening()+"");
                viewHolder.tv_Opening_Time_BankFragment_item.setText("开户时间："+datas.get(position).getOpening_Time()+"");
                viewHolder.tv_Account_Balance_BankFragment_item.setText("账户余额:"+datas.get(position).getAccount_Balance()+"");
                if (datas.get(position).isAccount_Status()){
                    viewHolder.tv_Account_Status_BankFragment_item.setText("开户状态：正常");
                }else {
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
}
