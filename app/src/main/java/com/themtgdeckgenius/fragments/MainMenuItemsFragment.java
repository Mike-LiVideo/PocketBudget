package com.themtgdeckgenius.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.themtgdeckgenius.pocketbudget.MainMenuActivity;
import com.themtgdeckgenius.pocketbudget.R;

public class MainMenuItemsFragment extends Fragment {

    public static Fragment newInstance(MainMenuActivity context, String act, MainMenuActivity.MAIN_MENU_FRAGMENTS fragmentEnum) {
        Bundle b = new Bundle();
        b.putString("action", act);
        b.putSerializable("fragment", fragmentEnum);
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

        String act = this.getArguments().getString("action");
        MainMenuActivity.MAIN_MENU_FRAGMENTS fragmentEnum = (MainMenuActivity.MAIN_MENU_FRAGMENTS) this.getArguments().getSerializable("fragment");
        TextView tv = (TextView) l.findViewById(R.id.title_text);
        tv.setText(act);

        ImageButton ib = (ImageButton) l.findViewById(R.id.content);
        int imageRes = fragmentEnum.getImageId();
        ib.setImageResource(imageRes);

        return l;
    }
}
