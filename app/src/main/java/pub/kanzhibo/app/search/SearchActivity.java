package pub.kanzhibo.app.search;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.hwangjr.rxbus.RxBus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import pub.kanzhibo.app.R;
import pub.kanzhibo.app.base.BaseActivity;
import pub.kanzhibo.app.model.event.SearchEvent;

public class SearchActivity extends BaseActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
//    @BindView(R.id.ib_back)
//    ImageButton backButton;
//    @BindView(R.id.ib_search)
//    ImageButton searchButton;
    @BindView(R.id.et_search_key)
    EditText searchKeyEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        viewPager.setAdapter(new SearchFragmentStatePagerAdapter(getSupportFragmentManager(), Arrays.asList(getResources().getStringArray(R.array.platform))));
        tabLayout.setupWithViewPager(viewPager);
    }

    @OnClick(R.id.ib_back)
    void back() {
        this.finish();
    }

    @OnClick(R.id.ib_search)
    void search() {
        RxBus.get().post(new SearchEvent( searchKeyEditText.getText().toString().trim()));
    }
    //todo fragment的缓存
    class SearchFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

        List<String> titles;

        public SearchFragmentStatePagerAdapter(FragmentManager fm, List<String> titles) {
            super(fm);
            this.titles = titles;
        }

        @Override
        public Fragment getItem(int position) {
            return new SearchUserFragment();
        }

        @Override
        public int getCount() {
            return titles.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
