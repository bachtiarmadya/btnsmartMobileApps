package ronin.bachtiar.btnsmart.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import ronin.bachtiar.btnsmart.R;
import ronin.bachtiar.btnsmart.smarttask.Smart_DialyAgenda;
import ronin.bachtiar.btnsmart.utils.GridViewAdapter;

public class ServiceHome extends Fragment {
    View view;
    GridView androidGridView;

    Activity context;

    public static String[] gridViewStrings = {
            "Lead Generation",
            "Lead Qualification",
            "Lead Activity Management",
            "Material Tools",
            "Fitur 1",
            "Fitur 2",
            "Fitur 3"

    };
    public static int[] gridViewImages = {
            R.drawable.taskicon,
            R.drawable.taskicon,
            R.drawable.taskicon,
            R.drawable.taskicon,
            R.drawable.taskicon,
            R.drawable.taskicon,
            R.drawable.taskicon
    };

    public ServiceHome() {
        // Required empty public constructor
    }

    public static ServiceHome newInstance(String param1, String param2) {
        ServiceHome fragment = new ServiceHome();
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
        context=getActivity();
        view = inflater.inflate(R.layout.layout_home, container, false);
        return view;
    }
    public void onStart(){
        super.onStart();
        GridViewAdapter AdapterViewAndroid = new GridViewAdapter(getActivity(), gridViewStrings, gridViewImages);
        androidGridView=(GridView) view.findViewById(R.id.grid);
        androidGridView.setAdapter(AdapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {


                if( gridViewImages[+i] == R.drawable.taskicon)
                {
                    Intent intent = new Intent(getActivity(), Smart_DialyAgenda.class);
                    startActivity(intent);
                }
                else if(gridViewImages[+i] == R.drawable.taskicon)
                {
                    Intent intent = new Intent(getActivity(), Smart_DialyAgenda.class);
                    startActivity(intent);
                }

                else if(gridViewImages[+i] == R.drawable.taskicon)
                {
                    Intent intent = new Intent(getActivity(), Smart_DialyAgenda.class);
                    startActivity(intent);
                }
                else if(gridViewImages[+i] == R.drawable.taskicon)
                {
                    Intent intent = new Intent(getActivity(), Smart_DialyAgenda.class);
                    startActivity(intent);
                }
                else if(gridViewImages[+i] == R.drawable.taskicon)
                {
                    Intent intent = new Intent(getActivity(), Smart_DialyAgenda.class);
                    startActivity(intent);
                }
                else if(gridViewImages[+i] == R.drawable.taskicon)
                {
                    Intent intent = new Intent(getActivity(), Smart_DialyAgenda.class);
                    startActivity(intent);
                }
                else if(gridViewImages[+i] == R.drawable.taskicon)
                {
                    Intent intent = new Intent(getActivity(), Smart_DialyAgenda.class);
                    startActivity(intent);
                }
            }
        });
    }
}
