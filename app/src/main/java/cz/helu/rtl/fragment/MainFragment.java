package cz.helu.rtl.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cz.helu.rtl.R;
import cz.helu.rtl.RTLApplication;
import cz.helu.rtl.activity.PercentActivity;
import cz.helu.rtl.activity.RTLActivity;


public class MainFragment extends Fragment
{
	private View mRootView;


	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setHasOptionsMenu(true);
		setRetainInstance(false);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		mRootView = inflater.inflate(R.layout.fragment_main, container, false);
		return mRootView;
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		renderView();
	}


	private void renderView()
	{
		final Button percentLinearButton = (Button) mRootView.findViewById(R.id.activity_main_button_percent_linear);
		final Button percentRelativeButton = (Button) mRootView.findViewById(R.id.activity_main_button_percent_relative);
		final Button percentFrameButton = (Button) mRootView.findViewById(R.id.activity_main_button_percent_frame);
		final Button rtlExampleButton = (Button) mRootView.findViewById(R.id.activity_main_button_rtl_example);

		percentLinearButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = PercentActivity.newIntent(RTLApplication.getContext(), PercentActivity.LayoutTypeEnum.LINEAR);
				startActivity(intent);
			}
		});

		percentRelativeButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = PercentActivity.newIntent(RTLApplication.getContext(), PercentActivity.LayoutTypeEnum.RELATIVE);
				startActivity(intent);
			}
		});

		percentFrameButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = PercentActivity.newIntent(RTLApplication.getContext(), PercentActivity.LayoutTypeEnum.FRAME);
				startActivity(intent);
			}
		});

		rtlExampleButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = RTLActivity.newIntent(RTLApplication.getContext());
				startActivity(intent);
			}
		});
	}
}
