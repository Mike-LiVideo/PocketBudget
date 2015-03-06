package com.themtgdeckgenius.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.themtgdeckgenius.fragments.MainMenuItemsFragment;
import com.themtgdeckgenius.pocketbudget.MainMenuActivity;

public class MainMenuPagerAdapter extends FragmentPagerAdapter implements
		ViewPager.OnPageChangeListener {

	private LinearLayout cur = null;
	private LinearLayout next = null;
	private MainMenuActivity context;
	private FragmentManager fm;
	private float scale;

	public MainMenuPagerAdapter(MainMenuActivity context, FragmentManager fm) {
		super(fm);
		this.fm = fm;
		this.context = context;
	}

	@Override
	public Fragment getItem(int position) 
	{
        // make the first pager bigger than others
        if (position == MainMenuActivity.FIRST_PAGE)
        	scale = MainMenuActivity.BIG_SCALE;     	
        else
        	scale = MainMenuActivity.SMALL_SCALE;
        
        position = position % MainMenuActivity.PAGES;
        return MainMenuItemsFragment.newInstance(context, position, scale);
	}

	@Override
	public int getCount()
	{		
		return MainMenuActivity.PAGES * MainMenuActivity.LOOPS;
	}

	@Override
	public void onPageScrolled(int position, float positionOffset,
			int positionOffsetPixels) 
	{
	}

	@Override
	public void onPageSelected(int position) {}
	
	@Override
	public void onPageScrollStateChanged(int state) {}
	
	private String getFragmentTag(int position)
	{
	    return "android:switcher:" + context.pager.getId() + ":" + position;
	}
}
