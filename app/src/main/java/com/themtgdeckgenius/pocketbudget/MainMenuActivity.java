package com.themtgdeckgenius.pocketbudget;


import com.themtgdeckgenius.adapters.MainMenuPagerAdapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

public class MainMenuActivity extends FragmentActivity {
	
	public final static int PAGES = 5;
	// You can choose a bigger number for LOOPS, but you know, nobody will fling
	// more than 1000 times just in order to test your "infinite" ViewPager :D 
	public final static int LOOPS = 1000; 
	public final static int FIRST_PAGE = PAGES * LOOPS / 2;
	public final static float BIG_SCALE = 1.0f;
	public final static float SMALL_SCALE = 0.7f;
	public final static float DIFF_SCALE = BIG_SCALE - SMALL_SCALE;
	
	public MainMenuPagerAdapter adapter;
	public ViewPager pager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		
		pager = (ViewPager) findViewById(R.id.myviewpager);

		adapter = new MainMenuPagerAdapter(this, this.getSupportFragmentManager());
		pager.setAdapter(adapter);
		pager.setOnPageChangeListener(adapter);
		
		
		// Set current item to the middle page so we can fling to both
		// directions left and right
		pager.setCurrentItem(FIRST_PAGE);
		
		// Necessary or the pager will only have one extra page to show
		// make this at least however many pages you can see
		pager.setOffscreenPageLimit(3);
		
		// Set margin for pages as a negative number, so a part of next and 
		// previous pages will be showed
		pager.setPageMargin(-200);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
