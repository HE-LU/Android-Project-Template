package cz.helu.rtl.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.percent.PercentRelativeLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import cz.helu.rtl.R;


public class PercentFragmentRelative extends Fragment
{
	public static final String TAG = PercentFragmentRelative.class.getSimpleName();

	private View mRootView;


	public static PercentFragmentRelative newInstance()
	{
		return new PercentFragmentRelative();
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
		mRootView = inflater.inflate(R.layout.fragment_percent_relative, container, false);
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
		mRootView.findViewById(R.id.top_right_button_ltr).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				PercentRelativeLayout layout = ((PercentRelativeLayout) mRootView.findViewById(R.id.layout_percent_relative));
				layout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
			}
		});
		mRootView.findViewById(R.id.top_right_button_rtl).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				PercentRelativeLayout layout = ((PercentRelativeLayout) mRootView.findViewById(R.id.layout_percent_relative));
				layout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
			}
		});
	}
}
