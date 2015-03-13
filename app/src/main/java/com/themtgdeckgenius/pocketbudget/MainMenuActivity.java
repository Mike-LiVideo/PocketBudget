package com.themtgdeckgenius.pocketbudget;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.themtgdeckgenius.adapters.MainMenuPagerAdapter;

public class MainMenuActivity
        extends FragmentActivity{

    public final static int PAGES = 5;
    public final static int LOOPS = 1000;
    public final static int FIRST_PAGE = PAGES * LOOPS / 2;
    public final static float BIG_SCALE = 1.0f;
    public final static float SMALL_SCALE = 0.7f;
    protected static final String LOGTAG = MainMenuActivity.class.getSimpleName();
    public MainMenuPagerAdapter adapter;
    public ViewPager pager;

    public static int getRealPosition(int pos){
        return pos % PAGES;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        pager = (ViewPager) findViewById(R.id.myviewpager);

        adapter = new MainMenuPagerAdapter(this, this.getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(adapter);

        pager.setCurrentItem(FIRST_PAGE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public Context getMainMenuContext(){
        return getApplicationContext();
    }

    public enum MAIN_MENU_FRAGMENTS{

        ADD_INCOME(R.string.title_income_fragment, 0, R.drawable.plus_symbol),
        ADD_BILL(R.string.title_bill_fragment, 1, R.drawable.minus_symbol),
        ADD_EXPENSE(R.string.title_expense_fragment, 2, R.drawable.minus_symbol),
        VIEW_BUDGET(R.string.title_view_budget, 3, R.drawable.view_symbol),
        REMOVE_FROM_BUDGET(R.string.title_remove_from_budget, 4, R.drawable.remove_symbol);

        private final int mTitleString;
        private final int mPosition;
        private final int mImageId;

        MAIN_MENU_FRAGMENTS(final int fragmentTitle, final int position, int imageId){
            mTitleString = fragmentTitle;
            mPosition = position;
            mImageId = imageId;
        }

        public static MAIN_MENU_FRAGMENTS getFragmentFromPosition(int pos){

            switch(pos){
                case 0:
                    return ADD_INCOME;
                case 1:
                    return ADD_BILL;
                case 2:
                    return ADD_EXPENSE;
                case 3:
                    return VIEW_BUDGET;
                default:
                    Log.e(LOGTAG, "Invalid Position");
                    return null;

            }

        }

        public int getTitleId(){
            return mTitleString;
        }

        public int getPosition(){
            return mPosition;
        }

        public int getImageId(){
            return mImageId;
        }
    }
}
