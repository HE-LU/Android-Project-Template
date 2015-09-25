package cz.helu.rtl.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import cz.helu.rtl.R;
import cz.helu.rtl.layout.PercentLinearLayout;
import cz.helu.rtl.utils.RTLHelper;


public class RTLFragment extends Fragment
{
	private View mRootView;


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
		final PercentLinearLayout layout = ((PercentLinearLayout) mRootView.findViewById(R.id.layout_percent_linear_horizontal_1));
		final PercentLinearLayout layout2 = ((PercentLinearLayout) mRootView.findViewById(R.id.layout_percent_linear_horizontal_2));

		if(RTLHelper.isRTL())
		{
			layout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
			layout2.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
		}

		mRootView.findViewById(R.id.top_right_button_ltr).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				layout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
				layout2.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
			}
		});
		mRootView.findViewById(R.id.top_right_button_rtl).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				layout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
				layout2.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
			}
		});
	}
}
