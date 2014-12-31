package org.arenatest.bits.arena_test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventManagersFragment extends Fragment {
    private final String[] EventTitles = {"Football", "Badminton", "Cricket", "Hockey", "Basketball", "Carrom","Chess", "Lawn Tennis","Table Tennis","Power Lifting","Volleyball"};
    private final int position;


    public EventManagersFragment(int position) {
        // Required empty public constructor
        this.position = position;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_eventmanagers,container,false);
        TextView m1= (TextView) v.findViewById(R.id.manager1);
        TextView m2= (TextView) v.findViewById(R.id.manager2);
        TextView m3= (TextView) v.findViewById(R.id.manager3);
        TextView pm1= (TextView) v.findViewById(R.id.phmanager1);
        TextView pm2= (TextView) v.findViewById(R.id.phmanager2);
        TextView pm3= (TextView) v.findViewById(R.id.phmanager3);
        switch (position){
            case 0:
                m1.setText("Shantanu Bhardwaj");
                pm1.setText("+91-9912608166");
                m2.setText("");
                pm2.setText("");
                m3.setText("");
                pm3.setText("");
                break;
            case 1:
                m1.setText("Balu Sai");
                pm1.setText("9010526852");
                m2.setText("K.Chandrasekhar");
                pm2.setText("9603246400");
                m3.setText("");
                pm3.setText("");
                break;
            case 2:
                m1.setText("Chaitanya Kakarla");
                pm1.setText("9951979639");
                m2.setText("Harsh");
                pm2.setText("+91-9951014855");
                m3.setText("");
                pm3.setText("");
                break;
            case 3:
                m1.setText("Likith Mudunuri");
                pm1.setText("9705223489");
                m2.setText("");
                pm2.setText("");
                m3.setText("");
                pm3.setText("");
                break;
            case 4:
                m1.setText("Rishab Kapur");
                pm1.setText("+91-8465047480");
                m2.setText("Meha Sadasivam");
                pm2.setText("+91-9912651622");
                m3.setText("");
                pm3.setText("");
                break;
            case 5:
                m1.setText("Pathi Abhinav Patil");
                pm1.setText("9010172575");
                m2.setText("");
                pm2.setText("");
                m3.setText("");
                pm3.setText("");
                break;
            case 6:
                m1.setText("N Bharat Krishna");
                pm1.setText("8096222369");
                m2.setText("Phanikumar Satrasala");
                pm2.setText("8497943416");
                m3.setText("");
                pm3.setText("");
                break;
            case 7:
                m1.setText("Vishal Athreya");
                pm1.setText("9542592406");
                m2.setText("");
                pm2.setText("");
                m3.setText("");
                pm3.setText("");
                break;
            case 8:
                m1.setText("Kanishk Upreti");
                pm1.setText("7730905235");
                m2.setText("Sriya Ganesh");
                pm2.setText("7661079298");
                m3.setText("");
                pm3.setText("");
                break;
            case 9:
                m1.setText("SIDDHARTH LENKA");
                pm1.setText("9705633550");
                m2.setText("");
                pm2.setText("");
                m3.setText("");
                pm3.setText("");
                break;
            case 10:
                m1.setText("Swayam Pattnaik");
                pm1.setText("8498085517");
                m2.setText("Chaitanya Podilapu");
                pm2.setText("8096134765");
                m3.setText("Sumiran Shubhi");
                pm3.setText("9542874711");
                break;

        }
        return v;
    }


}
