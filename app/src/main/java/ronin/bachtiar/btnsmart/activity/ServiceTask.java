package ronin.bachtiar.btnsmart.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import ronin.bachtiar.btnsmart.R;

public class ServiceTask extends Fragment {

    public ServiceTask() {
        // Required empty public constructor
    }

    public static ServiceTask newInstance(String param1, String param2) {
        ServiceTask fragment = new ServiceTask();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.layout_task, container, false);
    }
}
