package habiba.h.coffeeordersystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Timer;
import java.util.TimerTask;

public class SplashFragment extends Fragment
{

    private View mainView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        mainView=inflater.inflate(R.layout.fragment_splash,null);
        return mainView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        timer();
    }
    private void timer()
    {
        Timer timer=new Timer();

        TimerTask timerTask=new TimerTask()
        {
            @Override
            public void run()
            {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.Fragment_container,new menuFragment()).disallowAddToBackStack().commit();
            }
        };

        timer.schedule(timerTask,3000);
    }
}
