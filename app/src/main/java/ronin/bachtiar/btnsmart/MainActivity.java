package ronin.bachtiar.btnsmart;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import ronin.bachtiar.btnsmart.activity.ServiceHome;
import ronin.bachtiar.btnsmart.activity.ServiceNotification;
import ronin.bachtiar.btnsmart.activity.ServiceProfileAccount;
import ronin.bachtiar.btnsmart.activity.ServiceProgress;
import ronin.bachtiar.btnsmart.activity.ServiceTask;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.app.ActionBar toolbar;
    BottomNavigationView navigation;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationView);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        toolbar.setTitle("Home");
        loadFragment(new ServiceHome());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle("Beranda");
                    fragment = new ServiceHome();
                    loadFragment(fragment);
                    return true;

                case R.id.navigation_task:
                    toolbar.setTitle("Tugas");
                    fragment = new ServiceTask();
                    loadFragment(fragment);
                    return true;

                case R.id.navigation_notif:
                    toolbar.setTitle("Notifikasi");
                    fragment = new ServiceNotification();
                    loadFragment(fragment);
                    return true;

                case R.id.navigation_progress:
                    toolbar.setTitle("Progress");
                    fragment = new ServiceProgress();
                    loadFragment(fragment);
                    return true;

                case R.id.navigation_account:
                    toolbar.setTitle("Akun saya");
                    fragment = new ServiceProfileAccount();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}