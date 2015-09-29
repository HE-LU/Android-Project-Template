package cz.helu.rtl.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import cz.helu.rtl.R;
import cz.helu.rtl.utility.RTLHelper;


public class RTLCustomFragment extends Fragment
{
	public static final String TAG = RTLCustomFragment.class.getSimpleName();

	private View mRootView;


	public static RTLCustomFragment newInstance()
	{
		return new RTLCustomFragment();
	}


	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setHasOptionsMenu(true);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		mRootView = inflater.inflate(R.layout.fragment_rtl, container, false);
		return mRootView;
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		renderView();
	}


	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
	{
		// action bar menu
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.menu_main, menu);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// action bar menu behaviour
		switch(item.getItemId())
		{
			case android.R.id.home:
				getActivity().finish();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}


	private void renderView()
	{
		ImageView rtlImageViewArrow = (ImageView) mRootView.findViewById(R.id.fragment_rtl_imageview_arrow);
		TextView rtlOrientationTextView = (TextView) mRootView.findViewById(R.id.fragment_rtl_textview_orientation);
		TextView rtlForcedFirstTextView = (TextView) mRootView.findViewById(R.id.fragment_rtl_textview_forced_first);
		EditText rtlForcedFirstEditText = (EditText) mRootView.findViewById(R.id.fragment_rtl_edittext_forced_first);
		TextView rtlForcedSecondTextView = (TextView) mRootView.findViewById(R.id.fragment_rtl_textview_forced_second);
		EditText rtlForcedSecondEditText = (EditText) mRootView.findViewById(R.id.fragment_rtl_edittext_forced_second);
		CheckBox rtlForcedCheckBox = (CheckBox) mRootView.findViewById(R.id.fragment_rtl_checkbox_forced);
		Switch rtlForcedSwitch = (Switch) mRootView.findViewById(R.id.fragment_rtl_switch_forced);

		if(RTLHelper.isDefaultLocaleRTL())
			rtlOrientationTextView.setText("RTL");
		else
			rtlOrientationTextView.setText("LTR");

		rtlImageViewArrow.setImageDrawable(ContextCompat.getDrawable(mRootView.getContext(), R.drawable.arrow));
		RTLHelper.setDirectionToView(rtlForcedFirstTextView);
		RTLHelper.setDirectionToView(rtlForcedFirstEditText);
		RTLHelper.setDirectionToView(rtlForcedSecondTextView);
		RTLHelper.setDirectionToView(rtlForcedSecondEditText);
		RTLHelper.setDirectionToView(rtlForcedCheckBox);
		RTLHelper.setDirectionToView(rtlForcedSwitch);
	}
}
