package id.makers.app.imageslide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import id.makers.app.imageslide.Slider.FragmentSlider;
import id.makers.app.imageslide.Slider.SliderIndicator;
import id.makers.app.imageslide.Slider.SliderPagerAdapter;
import id.makers.app.imageslide.Slider.SliderView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView toolbarTitle;
    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;
    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderView = (SliderView) findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) findViewById(R.id.pagesContainer);
        setupSlider();
        //bind view
        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbarTitle = (ImageView) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        if (toolbar != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }


    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragmentx = new ArrayList<>();
        fragmentx.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/zYFQM9G5j9cRsMNMuZAX64nmUMf.jpg"));
        fragmentx.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/rXBB8F6XpHAwci2dihBCcixIHrK.jpg"));
        fragmentx.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/biN2sqExViEh8IYSJrXlNKjpjxx.jpg"));
        fragmentx.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg"));

        mAdapter = new SliderPagerAdapter(getSupportFragmentManager(), fragmentx);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(this, mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragmentx.size());
        mIndicator.show();
    }
}
