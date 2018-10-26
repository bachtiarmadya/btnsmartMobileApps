package ronin.bachtiar.btnsmart.smarttask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ronin.bachtiar.btnsmart.R;

public class Smart_InputNewProspek extends AppCompatActivity {

    private android.support.v7.app.ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_inputnewprospek);

        toolbar = getSupportActionBar();
        toolbar.setTitle("Input prospek baru");
    }
}
