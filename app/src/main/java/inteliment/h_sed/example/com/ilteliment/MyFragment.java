package inteliment.h_sed.example.com.ilteliment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by hsedghinezhad on 8/04/2016.
 */
public class MyFragment extends Fragment {
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    public static final MyFragment newInstance(String message) {
        MyFragment f = new MyFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String message = getArguments().getString(EXTRA_MESSAGE);
        View v = inflater.inflate(R.layout.myfragment_layout, container, false);
        TextView messageTextView = (TextView) v.findViewById(R.id.textView);
        RelativeLayout relativeLayout = (RelativeLayout) v.findViewById(R.id.relativeView);

        Random rnd = new Random();
        int color = Color.argb(44, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        relativeLayout.setBackgroundColor(color);

        messageTextView.setText(message);

        return v;
    }

}
