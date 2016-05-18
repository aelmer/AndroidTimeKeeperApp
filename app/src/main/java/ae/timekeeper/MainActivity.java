package ae.timekeeper;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button analogButton, digitalButton;
    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Clock");
        //getActionBar().setTitle("Clock"); Works with Material theme not ApCompat
        myToolbar.setTitleTextColor(Color.WHITE);
        myToolbar.setSubtitle("tells the time");
        myToolbar.setSubtitleTextColor(Color.WHITE);
        myToolbar.setLogo(R.drawable.access_time_36dp);

        analogButton = (Button) findViewById(R.id.button_analog);
        analogButton.setOnClickListener(this);

        digitalButton = (Button) findViewById(R.id.button_digital);
        digitalButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Fragment fragment;
        if (v == analogButton){
            fragment =  new FragmentAnalog();
        }
        else {
            fragment = new FragmentDigital();
        }
        replaceFragment(fragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Fragment fragment;

        int id = item.getItemId();
        switch(id){
            case R.id.menu_date:
                startActivity(new Intent(Settings.ACTION_DATE_SETTINGS));
                break;
            case R.id.menu_location:
                startActivity(new Intent(Settings.ACTION_LOCALE_SETTINGS));
                break;
            case R.id.menu_sleep:
                startActivity(new Intent(Settings.ACTION_SOUND_SETTINGS));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void replaceFragment(Fragment fragment){

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
