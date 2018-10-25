package ronin.bachtiar.btnsmart.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ronin.bachtiar.btnsmart.R;
import ronin.bachtiar.btnsmart.utils.SessionManager;

public class ServiceProfileAccount extends Fragment {

    Button btnLogout;
    SessionManager session;


    public ServiceProfileAccount() {
        // Required empty public constructor
    }

    public static ServiceProfileAccount newInstance(String param1, String param2) {
        ServiceProfileAccount fragment = new ServiceProfileAccount();
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

        View view = inflater.inflate(R.layout.layout_profile, container, false);

        session = new SessionManager(getContext());
        btnLogout = (Button) view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(myAction);

        // Inflate the layout for this fragment
        return view;

    }
    View.OnClickListener myAction = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            session = new SessionManager(getActivity());
            session.logoutUser();
        }
    };
}
