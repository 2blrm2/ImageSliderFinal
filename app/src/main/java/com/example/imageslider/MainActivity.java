package com.example.imageslider;

import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private  City selectedCity;

    TextView cityName;
    TabLayout tabLayout;
    ViewPager citiesViewpager;
    RadioGroup rgCities;

    private ArrayList<City> cities;


    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        cities =new ArrayList<>();
        initializeCities();

        selectedCity= cities.get(0);// As we have checked london city radio button in defining xml file
                                    // so we are making selectedcity=London
        changePhotoAndCityName();

        rgCities.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                cityChanged(checkedId);
            }
        });

    }

    private void initView() {
        cityName =(TextView)findViewById(R.id.txCityName);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        citiesViewpager = (ViewPager) findViewById(R.id.citiesViewpager);
        rgCities= (RadioGroup) findViewById(R.id.rgCities);

    }

    private void cityChanged(int rbId) {
        Log.d(TAG, "cityChanged: started");

        switch (rbId)
        {
            case R.id.rbLondon :
                selectedCity=getCityByName("London");
                break;
            case R.id.rbNewyork :
                selectedCity=getCityByName("Newyork");

                break;
            case R.id.rbTokyo :
                selectedCity=getCityByName("Tokyo");

                break;
            case R.id.rbZurish :
                selectedCity=getCityByName("Zurish");

                break;
                default:
                    break;
        }
        changePhotoAndCityName();

    }

    public void changePhotoAndCityName() {

            cityName.setText(selectedCity.getName());

            adapter = new ViewPagerAdapter(getSupportFragmentManager(), selectedCity);
            citiesViewpager.setAdapter(adapter);
            tabLayout.setupWithViewPager(citiesViewpager);
    }

    private City getCityByName(String name){
        Log.d(TAG, "getCityByName: started");
        for(City city : cities)
        {
            if (city.getName().equals(name)) {return city;
        }
        }
        return null;
    }
    private void initializeCities()
    {
        City london = new City();
        london.setName("London");
        ArrayList<String> londonUrls = new ArrayList<>();
        londonUrls.add("https://cdn.pixabay.com/photo/2015/12/08/00/32/london-1081820__340.jpg");
        londonUrls.add("https://images.pexels.com/photos/1796715/pexels-photo-1796715.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
        londonUrls.add("https://www.fodors.com/wp-content/uploads/2019/01/shutterstock_1255481941.jpg");
        londonUrls.add("https://business.okstate.edu/site-files/images/cagle/london-top.jpg");


        london.setImageUrls(londonUrls);

        City tokyo = new City();
        tokyo.setName("Tokyo");
        ArrayList<String> tokyoUrls = new ArrayList<>();
        tokyoUrls.add("https://static.independent.co.uk/s3fs-public/thumbnails/image/2018/04/10/13/tokyo-main.jpg?w968h681");
        tokyoUrls.add("https://media.timeout.com/images/105282442/630/472/image.jpg");
      //  tokyoUrls.add("https://i0.wp.com/www.director.co.uk/wp-content/uploads/Tokyo-city-landscape.jpg?fit=1000%2C500&ssl=1");
        tokyoUrls.add("https://images.unsplash.com/photo-1547981609-ad4e1dde4d41?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=600&q=60");



        tokyo.setImageUrls(tokyoUrls);

        City newyork = new City();
        newyork.setName("Newyork");
        ArrayList<String> newyorkUrls = new ArrayList<>();
        newyorkUrls.add("https://cdn.pixabay.com/photo/2014/05/02/23/46/new-york-city-336475_1280.jpg");
        newyorkUrls.add("https://image.shutterstock.com/image-photo/new-york-city-skyline-urban-260nw-147954134.jpg");
        newyorkUrls.add("https://cdn.pixabay.com/photo/2016/10/28/13/09/usa-1777986__480.jpg");
        newyorkUrls.add("data:image/jpeg;base64,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");

        newyork.setImageUrls(newyorkUrls);

        City zoron = new City();
        zoron.setName("Zurish");
        ArrayList<String> zoronUrls = new ArrayList<>();
        zoronUrls.add("https://lonelyplanetwp.imgix.net/2018/01/shutterstock_Nataliya_Hora-zurich_mini-c8f7c1539f2e.jpg?crop=entropy&fit=crop&h=421&sharp=10&vib=20&w=748");
        zoronUrls.add("https://cdn.zuerich.com/sites/default/files/styles/fullwidth_320x180/public/teaserimage/web_zurich_webcam_1280x960_0.jpg?itok=FT14_WoT&timestamp=1461682611");
        zoronUrls.add("https://www.oebb.at/thumbnails/www.nightjet.com/.imaging/default/dam/nightjet/bildergalerie/laender-2560x1600/schweiz/Z%EF%BF%BDrich-517851983-TomasSereda-iStock-Thinkstock.jpg/jcr:content.jpg?t=1506944152919&scale=1.0");
        zoronUrls.add("https://www.oebb.at/thumbnails/www.nightjet.com/.imaging/default/dam/nightjet/bildergalerie/laender-2560x1600/schweiz/Z%EF%BF%BDrich-518594550-bluejayphoto-iStock-Thinkstock.jpg/jcr:content.jpg?t=1506944248424&scale=1.0");

        zoron.setImageUrls(zoronUrls);

        cities.add(london);
        cities.add(tokyo);
        cities.add(newyork);
        cities.add(zoron);
        Log.d(TAG, "initializeCities: donne");

    }
}
