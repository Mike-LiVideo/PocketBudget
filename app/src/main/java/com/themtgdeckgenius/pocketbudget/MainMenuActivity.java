package com.themtgdeckgenius.pocketbudget;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.themtgdeckgenius.adapters.MainMenuPagerAdapter;
import com.themtgdeckgenius.datacontrol.DatabaseAccessor;

public class MainMenuActivity
        extends FragmentActivity{

    public final static int PAGES = 5;
    public final static int LOOPS = 1000;
    public final static int FIRST_PAGE = PAGES * LOOPS / 2;
    protected static final String LOGTAG = MainMenuActivity.class.getSimpleName();
    public MainMenuPagerAdapter gMainMenuPagerAdapter;
    public ViewPager gViewPager;

    public static int getRealPosition(int pos){
        return pos % PAGES;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        gViewPager = (ViewPager) findViewById(R.id.myviewpager);
        gMainMenuPagerAdapter = new MainMenuPagerAdapter(this, this.getSupportFragmentManager());
        gViewPager.setAdapter(gMainMenuPagerAdapter);
        gViewPager.setOnPageChangeListener(gMainMenuPagerAdapter);
        gViewPager.setCurrentItem(FIRST_PAGE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int mId = item.getItemId();
        if(mId == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public Context getMainMenuContext(){
        return getApplicationContext();
    }

    public enum MAIN_MENU_FRAGMENTS{

        VIEW_BUDGET(R.string.title_view_budget, 0, R.drawable.view_symbol, false),
        ADD_INCOME(R.string.title_income_fragment, 1, R.drawable.plus_symbol, true),
        ADD_BILL(R.string.title_bill_fragment, 2, R.drawable.minus_symbol, true),
        ADD_EXPENSE(R.string.title_expense_fragment, 3, R.drawable.minus_symbol, true),
        REMOVE_FROM_BUDGET(R.string.title_remove_from_budget, 4, R.drawable.remove_symbol, false);

        private final int mTitleString;
        private final int mPosition;
        private final int mImageId;
        private final boolean mHasPopupl;

        MAIN_MENU_FRAGMENTS(final int fragmentTitle, final int position, int imageId, final boolean hasPopup){
            mTitleString = fragmentTitle;
            mPosition = position;
            mImageId = imageId;
            mHasPopupl = hasPopup;
        }

        public static MAIN_MENU_FRAGMENTS getFragmentFromPosition(int pos){

            switch(pos){
                case 0:
                    return VIEW_BUDGET;
                case 1:
                    return ADD_INCOME;
                case 2:
                    return ADD_BILL;
                case 3:
                    return ADD_EXPENSE;
                case 4:
                    return REMOVE_FROM_BUDGET;
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

        public boolean getHasPopup() { return mHasPopupl; }
    }
}
