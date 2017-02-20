package pub.kanzhibo.app.search;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.hwangjr.rxbus.RxBus;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxCompoundButton;
import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.OnClick;
import pub.kanzhibo.app.R;
import pub.kanzhibo.app.base.BaseActivity;
import pub.kanzhibo.app.model.PlatForm;
import pub.kanzhibo.app.model.event.SearchEvent;
import rx.functions.Action1;

public class SearchActivity extends BaseActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.et_search_key)
    EditText searchKeyEditText;
    @BindView(R.id.ib_search)
    ImageButton mIbSearch;
    String[] mPlatForms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mPlatForms = getResources().getStringArray(R.array.platform);
        viewPager.setAdapter(new SearchFragmentStatePagerAdapter(getSupportFragmentManager(), Arrays.asList(mPlatForms)));
        viewPager.setOffscreenPageLimit(5);
        tabLayout.setupWithViewPager(viewPager);
        //给editText内部的drawable添加点击事件
        searchKeyEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= searchKeyEditText.getRight() - searchKeyEditText.getTotalPaddingRight()) {
                        searchKeyEditText.setText("");
                        return true;
                    }
                }
                return false;
            }
        });
        RxView.clicks(mIbSearch).throttleFirst(1, TimeUnit.SECONDS).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                RxBus.get().post(new SearchEvent(searchKeyEditText.getText().toString().trim()));
            }
        });
    }

    @OnClick(R.id.ib_back)
    void back() {
        this.finish();
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
            SearchUserFragment searchUserFragment = new SearchUserFragment();
            Bundle bundle = new Bundle();
            switch (titles.get(position)) {
                case "熊猫":
                    bundle.putSerializable("platform", PlatForm.PANDA);
                    searchUserFragment.setArguments(bundle);
                    return searchUserFragment;
                case "虎牙":
                    bundle.putSerializable("platform", PlatForm.HUYA);
                    searchUserFragment.setArguments(bundle);
                    return searchUserFragment;
                case "战旗":
                    bundle.putSerializable("platform", PlatForm.ZHANQI);
                    searchUserFragment.setArguments(bundle);
                    return searchUserFragment;
                case "全民":
                    bundle.putSerializable("platform", PlatForm.QUANMIN);
                    searchUserFragment.setArguments(bundle);
                    return searchUserFragment;
                default:
                    bundle.putSerializable("platform", PlatForm.DOUYU);
                    searchUserFragment.setArguments(bundle);
                    return searchUserFragment;
            }

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
