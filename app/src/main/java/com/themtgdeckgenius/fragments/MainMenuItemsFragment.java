package com.themtgdeckgenius.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.themtgdeckgenius.pocketbudget.MainMenuActivity;
import com.themtgdeckgenius.pocketbudget.R;
import com.themtgdeckgenius.widgets.MainMenuLinearLayout;

public class MainMenuItemsFragment extends Fragment {
	
	public static Fragment newInstance(MainMenuActivity context, int pos, 
			float scale)
	{
		Bundle b = new Bundle();
		b.putInt("pos", pos);
		b.putFloat("scale", scale);
		return Fragment.instantiate(context, MainMenuItemsFragment.class.getName(), b);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}
		
		LinearLayout l = (LinearLayout) 
				inflater.inflate(R.layout.fragment_main_menu, container, false);
		
		int pos = this.getArguments().getInt("pos");
		TextView tv = (TextView) l.findViewById(R.id.text);
		tv.setText("Position = " + pos);
		
		MainMenuLinearLayout root = (MainMenuLinearLayout) l.findViewById(R.id.root);
		float scale = this.getArguments().getFloat("scale");
		root.setScaleBoth(scale);
		
		return l;
	}
}
