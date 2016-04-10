package inteliment.h_sed.example.com.ilteliment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.item_English)
    ImageButton englishButton;
    @InjectView(R.id.item_French)
    ImageButton frenchButton;
    @InjectView(R.id.item_Chinese)
    ImageButton chineseButton;
    @InjectView(R.id.item_Espain)
    ImageButton spanishButton;
    @InjectView(R.id.item_German)
    ImageButton germanButton;
    @InjectView(R.id.clickable_viewpager)
    ClickableViewPager pager;
    @InjectView(R.id.fourthText)
    TextView fourthText;
    @InjectView(R.id.button_blue)
    Button blue_btn;
    @InjectView(R.id.button_red)
    Button red_btn;
    @InjectView(R.id.button_green)
    Button green_btn;
    @InjectView(R.id.back_layout)
    RelativeLayout myBackLayout;

    MyPageAdapter pageAdapter;

    @OnClick({R.id.item_English, R.id.item_Espain, R.id.item_Chinese, R.id.item_French, R.id.item_German})
    public void onNextClick(View v) {
        String tag = (String) v.getTag();
        fourthText.setText(tag);
    }

    public void onColorClick(View v) {
        String tag = (String) v.getTag();
        switch (Integer.parseInt(tag)) {
            case 1: {
                myBackLayout.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            }
            case 2: {
                myBackLayout.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
            }
            case 3: {
                myBackLayout.setBackgroundColor(getResources().getColor(R.color.green));
                break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        List<Fragment> fragments = getFragments();
        pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);

        pager.setAdapter(pageAdapter);
        pager.setOnItemClickListener(new ClickableViewPager.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Toast.makeText(MainActivity.this, "Fragment number :" + String.valueOf(position + 1),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<Fragment> getFragments() {
        List<Fragment> fList = new ArrayList<Fragment>();
        fList.add(MyFragment.newInstance("Fragment 1"));
        fList.add(MyFragment.newInstance("Fragment 2"));
        fList.add(MyFragment.newInstance("Fragment 3"));
        fList.add(MyFragment.newInstance("Fragment 4"));
        return fList;
    }


    private class MyPageAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;

        public MyPageAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }

}
