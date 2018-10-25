package ronin.bachtiar.btnsmart.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ronin.bachtiar.btnsmart.R;
import ronin.bachtiar.btnsmart.model.Model_Customer;

public class Adapter_SmartTask extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Model_Customer> customerData;

    public Adapter_SmartTask(Activity activity, List<Model_Customer> customerData) {
        this.activity = activity;
        this.customerData = customerData;
    }

    @Override
    public int getCount() {
        return customerData.size();
    }

    @Override
    public Object getItem(int location) {
        return customerData.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView = inflater.inflate(R.layout.task_dialyagenda, null);
        }

        TextView txtTaskNamaNasabah = (TextView) convertView.findViewById(R.id.txtTaskNamaNasabah);
        TextView txtTaskNoTlp = (TextView) convertView.findViewById(R.id.txtTaskNoTlp);
        TextView txtTaskProgress = (TextView) convertView.findViewById(R.id.txtTaskProgress);

        Model_Customer custData = new Model_Customer();
        txtTaskNamaNasabah.setText(custData.getCustName());
        txtTaskNoTlp.setText(custData.getCustPhone());


        return convertView;
    }
}

