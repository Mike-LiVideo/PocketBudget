package com.themtgdeckgenius.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.themtgdeckgenius.pocketbudget.MainMenuActivity;
import com.themtgdeckgenius.pocketbudget.R;
import com.themtgdeckgenius.widgets.DialogBaseActivity;

public class MainMenuItemsFragment
        extends Fragment{

    public static Fragment newInstance(MainMenuActivity context, String act, MainMenuActivity.MAIN_MENU_FRAGMENTS fragmentEnum){
        Bundle mBundle = new Bundle();
        mBundle.putString("action", act);
        mBundle.putSerializable("fragment", fragmentEnum);
        return Fragment.instantiate(context, MainMenuItemsFragment.class.getName(), mBundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        if(container == null){
            return null;
        }

        LinearLayout mLinearLayout = (LinearLayout)
                inflater.inflate(R.layout.fragment_main_menu, container, false);

        final String mAction = this.getArguments().getString("action");
        final MainMenuActivity.MAIN_MENU_FRAGMENTS mFragmentEnum = (MainMenuActivity.MAIN_MENU_FRAGMENTS) this.getArguments().getSerializable("fragment");
        TextView mMTextView = (TextView) mLinearLayout.findViewById(R.id.title_text);
        mMTextView.setText(mAction);

        ImageButton mImageButton = (ImageButton) mLinearLayout.findViewById(R.id.content);
        int mImageRes = mFragmentEnum.getImageId();
        mImageButton.setImageResource(mImageRes);
        mImageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mFragmentEnum.getHasPopup()){
                    DialogBaseActivity mDialogPopup = new DialogBaseActivity(getActivity()){
                        @Override
                        protected DIALOG_TYPE getDialogType(){
                            switch(mFragmentEnum){
                                case ADD_INCOME:
                                    return DIALOG_TYPE.ADD_INCOME;
                                case ADD_BILL:
                                    return DIALOG_TYPE.ADD_BILL;
                                case ADD_EXPENSE:
                                    return DIALOG_TYPE.ADD_EXPENSE;
                                default:
                                    return null;
                            }
                        }

                        @Override
                        protected int getTitleID(){
                            return mFragmentEnum.getTitleId();
                        }

                        @Override
                        protected int getHintID(){
                            switch(mFragmentEnum){
                                case ADD_INCOME:
                                    return R.string.hint_income;
                                case ADD_BILL:
                                    return R.string.hint_name_bill;
                                case ADD_EXPENSE:
                                    return R.string.hint_name_expense;
                                default:
                                    return 0;
                            }
                        }
                    };
                    mDialogPopup.show();
                }
                else {
                    Toast.makeText(getActivity(), "Not Implemented Yet", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return mLinearLayout;
    }
}
