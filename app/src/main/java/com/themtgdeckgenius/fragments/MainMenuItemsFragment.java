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
		TextView tv = (TextView) l.findViewById(R.id.title_text);
		tv.setText("Position = " + pos);
		
		LinearLayout root = (LinearLayout) l.findViewById(R.id.root);
		float scale = this.getArguments().getFloat("scale");

		return l;
	}
}
