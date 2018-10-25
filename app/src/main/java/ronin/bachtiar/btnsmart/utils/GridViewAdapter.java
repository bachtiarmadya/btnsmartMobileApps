package ronin.bachtiar.btnsmart.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import ronin.bachtiar.btnsmart.R;
public class GridViewAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater inflter;
    private final String[] gridViewString;
    private final int[] ImageId;

    public GridViewAdapter(Context context, String[] gridViewString, int[] ImageId) {
        mContext = context;
        this.ImageId = ImageId;
        this.gridViewString = gridViewString;
        inflter = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return gridViewString.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.grid_taskdashboard, null);
        ImageView gridViewImageId = (ImageView) view.findViewById(R.id.gridview_image);
        TextView gridViewImageString = (TextView) view.findViewById(R.id.gridview_text);
        gridViewImageString.setText(gridViewString[i]);
        gridViewImageId.setImageResource(ImageId[i]);
        return view;
    }
}

