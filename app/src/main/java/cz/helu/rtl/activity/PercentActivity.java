package cz.helu.rtl.activity;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import cz.helu.rtl.R;
import cz.helu.rtl.fragment.PercentFragmentFrame;
import cz.helu.rtl.fragment.PercentFragmentLinear;
import cz.helu.rtl.fragment.PercentFragmentRelative;


public class PercentActivity extends BaseActivity
{
	public static final String ARGUMENT_TYPE = "argument_type";


	public enum LayoutTypeEnum
	{
		LINEAR, RELATIVE, FRAME
	}


	public static Intent newIntent(Context context, LayoutTypeEnum type)
	{
		Intent intent = new Intent(context, PercentActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.putExtra(ARGUMENT_TYPE, type);
		return intent;
	}


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_percent);
		setupActionBar();

		LayoutTypeEnum type = (LayoutTypeEnum) getIntent().getExtras().getSerializable(ARGUMENT_TYPE);
		ActionBar bar = getSupportActionBar();
		if(type != null && bar != null)
		{
			switch(type)
			{
				case RELATIVE:
					bar.setTitle(getString(R.string.ab_title_percent_relative));
					FragmentTransaction transaction = getFragmentManager().beginTransaction();
					transaction.replace(R.id.activity_percent_container, PercentFragmentRelative.newInstance(), PercentFragmentRelative.TAG);
					transaction.commitAllowingStateLoss();
					break;
				case LINEAR:
					bar.setTitle(getString(R.string.ab_title_percent_linear));
					transaction = getFragmentManager().beginTransaction();
					transaction.replace(R.id.activity_percent_container, PercentFragmentLinear.newInstance(), PercentFragmentLinear.TAG);
					transaction.commitAllowingStateLoss();
					break;
				case FRAME:
					bar.setTitle(getString(R.string.ab_title_percent_frame));
					transaction = getFragmentManager().beginTransaction();
					transaction.replace(R.id.activity_percent_container, PercentFragmentFrame.newInstance(), PercentFragmentFrame.TAG);
					transaction.commitAllowingStateLoss();
					break;
			}
		}
	}


	private void setupActionBar()
	{
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		ActionBar bar = getSupportActionBar();
		if(bar == null) return;
		bar.setDisplayUseLogoEnabled(false);
		bar.setDisplayShowTitleEnabled(true);
		bar.setDisplayShowHomeEnabled(true);
		bar.setDisplayHomeAsUpEnabled(true);
		bar.setHomeButtonEnabled(true);
	}
}
