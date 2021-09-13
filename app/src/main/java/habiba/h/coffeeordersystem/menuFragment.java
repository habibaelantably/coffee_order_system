package habiba.h.coffeeordersystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class menuFragment extends Fragment
{

    private EditText Namefield;
    private RadioGroup radiogroup;
    private CheckBox chocolatechCB,hazelnutsCB,freshvanillaCB,cinamonCB;
    private TextView cupscounter;
    private Button add,minus,ordernow;
    private RadioButton radioButton;

    private String name;

    private int price=0;
    private String cat;

    private  int adds;
    private int cupsCount=1;

    private int total;



    private View mainView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        mainView=inflater.inflate(R.layout.fragment_menu,null);
        return mainView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        initViews();

    }

    private void initViews()
    {
        Namefield=mainView.findViewById(R.id.name_field);
        chocolatechCB=mainView.findViewById(R.id.chocolate);
        hazelnutsCB=mainView.findViewById(R.id.hazelnuts);
        freshvanillaCB=mainView.findViewById(R.id.frenshvanilla);
        cinamonCB=mainView.findViewById(R.id.cinamon);
        cupscounter=mainView.findViewById(R.id.counter);
        add=mainView.findViewById(R.id.more);
        minus=mainView.findViewById(R.id.less);
        ordernow=mainView.findViewById(R.id.order);
        RadioGroup rg =(RadioGroup) mainView.findViewById(R.id.radio_gp);


           add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        if (cupsCount == 10)
                        {
                            Toast.makeText(requireContext(),"can`t order more than 10 cups",Toast.LENGTH_SHORT).show();
                            return;
                        }else
                            {
                            cupsCount += 1;
                            cupscounter.setText(String.valueOf(cupsCount));
                        }
            }
        });

          minus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        if (cupsCount <= 0)
                        {
                            Toast.makeText(requireContext(),"not valid number of cups",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else {
                            cupsCount -= 1;
                            cupscounter.setText(String.valueOf(cupsCount));
                        }
            }
        });

          ordernow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        OrderNow();

                    }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup radiogroup, int checkedId) {
                switch(checkedId){
                    case R.id.espresso:
                        price=40;
                        cat="espresso";
                        break;
                    case R.id.icedcoffee:
                        price=45;
                        cat="iced coffee";
                        break;
                    case R.id.amricano:
                        price=40;
                        cat="amricano";
                        break;
                    case R.id.flatwhite:
                        price=50;
                        cat="flat white";
                        break;

                }
            }
        });
    }

    private void OrderNow()
    {
        name=Namefield.getText().toString();


        if (name.isEmpty())
        {
          Toast.makeText(requireContext(),"please enter your name",Toast.LENGTH_SHORT).show();
          return;
        }

        if (price==0)
        {
            Toast.makeText(requireContext(),"please order a cup of coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        if (chocolatechCB.isChecked())
        {
           adds=adds+7;
        }
        if (hazelnutsCB.isChecked())
        {
           adds+=10;
        }
        if (freshvanillaCB.isChecked())
        {
           adds+=15;
        }
        if (cinamonCB.isChecked())
        {
           adds+=12;
        }

        total=(price+adds)*cupsCount;

        //datamodel model=new datamodel(name,String.valueOf(total),cat) ;

      /*  Bundle x = new Bundle();
        order_fragment orderFragment = new order_fragment();
        x.putString("username", name);
        x.putString("orderprice",String.valueOf(total));
        x.putString("typeofcoffee",cat);
        orderFragment.setArguments(x);*/

        startFragment(menuFragment.this,new order_fragment(name,String.valueOf(total),cat));


}

    public void startFragment(Fragment from,Fragment to)
    {
        from.requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.Fragment_container,to).addToBackStack(null).commit();



    }

}






      /*  switch (view.getId())
        {
            case R.id.more:
                cupsCount+=1;
                cupscounter.setText(String.valueOf(cupsCount));
                break;
            case R.id.less:
                cupsCount-=1;
                cupscounter.setText(String.valueOf(cupsCount));
                break;

            case R.id.order:

                break;
 }
    }*/



