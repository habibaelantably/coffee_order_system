package habiba.h.coffeeordersystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class order_fragment extends Fragment
{
    private View mainView;

    private TextView namebox;
    private TextView price;
    private TextView category;

    String name;
    String total;
    String coffeecat;


    public order_fragment(String name, String total, String coffeecat)
    {
        this.name=name;
        this.total=total;
        this.coffeecat=coffeecat;

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        mainView=inflater.inflate(R.layout.fragment_order,null);
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

        namebox=mainView.findViewById(R.id.name_box);
        price=mainView.findViewById(R.id.price_box);
        category=mainView.findViewById(R.id.category_box);

        namebox.setText(name);
        price.setText(total);
        category.setText(coffeecat);
        /*Bundle y = this.getArguments();
        if (y != null) {

           String name1 = y.getString("username");
            String total = y.getString("orderprice");
            String type = y.getString("typeofcoffee");

            namebox.setText(name1);
            price.setText(total);
            category.setText(type);

        }else
            {
                Toast.makeText(requireActivity(),"no data ",Toast.LENGTH_SHORT).show();
        }*/


    }
}
