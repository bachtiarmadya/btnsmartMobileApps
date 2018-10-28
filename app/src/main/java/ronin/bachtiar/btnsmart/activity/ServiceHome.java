package ronin.bachtiar.btnsmart.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import ronin.bachtiar.btnsmart.R;
import ronin.bachtiar.btnsmart.smarttask.Smart_DialyAgenda;
import ronin.bachtiar.btnsmart.smarttask.Smart_InputNewProspek;
import ronin.bachtiar.btnsmart.utils.GridViewAdapter;

public class ServiceHome extends Fragment implements OnChartValueSelectedListener {
    View view;
    GridView androidGridView;

    Activity context;


    public static String[] gridViewStrings = {
            "Input prospek baru",
            "Input referral",
            "View lead"

    };
    public static int[] gridViewImages = {
            R.drawable.add_user,
            R.drawable.add_referral,
            R.drawable.view_lead
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
        context = getActivity();
        view = inflater.inflate(R.layout.layout_home, container, false);




        return view;
    }

    public void onStart() {
        super.onStart();


        PieChart pieChart = (PieChart) view.findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);

        // IMPORTANT: In a PieChart, no values (Entry) should have the same
        // xIndex (even if from different DataSets), since no values can be
        // drawn above each other.
        ArrayList<Entry> yvalues = new ArrayList<Entry>();
        yvalues.add(new Entry(8f, 0));
        yvalues.add(new Entry(15f, 1));
        yvalues.add(new Entry(12f, 2));
        yvalues.add(new Entry(25f, 3));
        yvalues.add(new Entry(23f, 4));
        yvalues.add(new Entry(17f, 5));

        PieDataSet dataSet = new PieDataSet(yvalues, "Election Results");

        ArrayList<String> xVals = new ArrayList<String>();

        xVals.add("January");
        xVals.add("February");
        xVals.add("March");
        xVals.add("April");
        xVals.add("May");
        xVals.add("June");

        PieData data = new PieData(xVals, dataSet);
        // In Percentage term
        data.setValueFormatter(new PercentFormatter());
        // Default value
        //data.setValueFormatter(new DefaultValueFormatter(0));
        pieChart.setData(data);
        pieChart.setDescription("This is Pie Chart");

        pieChart.setDrawHoleEnabled(true);
        pieChart.setTransparentCircleRadius(25f);
        pieChart.setHoleRadius(25f);

        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        data.setValueTextSize(13f);
        data.setValueTextColor(Color.DKGRAY);
        pieChart.setOnChartValueSelectedListener(this);

        pieChart.animateXY(1400, 1400);


        GridViewAdapter AdapterViewAndroid = new GridViewAdapter(getActivity(), gridViewStrings, gridViewImages);
        androidGridView = (GridView) view.findViewById(R.id.grid);
        androidGridView.setAdapter(AdapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {


                if (gridViewImages[+i] == R.drawable.add_user) {
                    Intent intent = new Intent(getActivity(), Smart_InputNewProspek.class);
                    startActivity(intent);
                } else if (gridViewImages[+i] == R.drawable.add_referral) {
                    Intent intent = new Intent(getActivity(), Smart_DialyAgenda.class);
                    startActivity(intent);
                } else if (gridViewImages[+i] == R.drawable.view_lead) {
                    Intent intent = new Intent(getActivity(), Smart_DialyAgenda.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {

        if (e == null)
            return;
        Log.i("VAL SELECTED",
                "Value: " + e.getVal() + ", xIndex: " + e.getXIndex()
                        + ", DataSet index: " + dataSetIndex);
    }

    @Override
    public void onNothingSelected() {
        Log.i("PieChart", "nothing selected");
    }
}
