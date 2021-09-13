package habiba.h.coffeeordersystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startFragment(new SplashFragment());
    }
    public void startFragment(Fragment fragment)
    {
        getSupportFragmentManager().beginTransaction().add(R.id.Fragment_container ,fragment)
                .disallowAddToBackStack().commit();
    }



}
