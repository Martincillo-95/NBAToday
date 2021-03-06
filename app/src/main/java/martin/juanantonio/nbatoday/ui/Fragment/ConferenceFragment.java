package martin.juanantonio.nbatoday.ui.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.Locale;

import martin.juanantonio.nbatoday.R;
import martin.juanantonio.nbatoday.ui.Tabs.TabConferenceEast;
import martin.juanantonio.nbatoday.ui.Tabs.TabConferenceWest;

public class ConferenceFragment extends Fragment {

    private AppBarLayout appBarLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_conferences, container, false);

        View contenedor = (View) container.getParent();
        appBarLayout = contenedor.findViewById(R.id.appBarLayout);
        tabLayout = new TabLayout(getActivity());
        tabLayout.setTabTextColors(Color.parseColor("#9c9c9c"), Color.parseColor("#FFFFFF"));
        appBarLayout.addView(tabLayout);

        viewPager = root.findViewById(R.id.pagerConference);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        appBarLayout.removeView(tabLayout);
    }

    public class ViewPagerAdapter extends FragmentStatePagerAdapter{
        public ViewPagerAdapter(FragmentManager fragmentManager){
            super(fragmentManager);

        }

        String titles[] = {"Conferencia Este", "Conferencia Oeste"};
        String[] titlesEnglish = {"West Conference", "East Conference"};

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new TabConferenceEast();
                case 1: return new TabConferenceWest();
            }

            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            if(Locale.getDefault().getLanguage().equals("en")){
                return titlesEnglish[position];
            }else if(Locale.getDefault().getLanguage().equals("es")){
                return titles[position];
            }

            return null;
        }
    }
}