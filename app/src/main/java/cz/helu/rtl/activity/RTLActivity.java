package cz.helu.rtl.activity;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import cz.helu.rtl.R;
import cz.helu.rtl.fragment.RTLCustomFragment;
import cz.helu.rtl.fragment.RTLFragment;


public class RTLActivity extends BaseActivity
{
	public static final String ARGUMENT_TYPE = "argument_type";


	public enum LayoutTypeEnum
	{
		NORMAL, CUSTOM
	}


	public static Intent newIntent(Context context, LayoutTypeEnum type)
	{
		Intent intent = new Intent(context, RTLActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.putExtra(ARGUMENT_TYPE, type);
		return intent;
	}


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rtl);
		setupActionBar();

		LayoutTypeEnum type = (LayoutTypeEnum) getIntent().getExtras().getSerializable(ARGUMENT_TYPE);
		ActionBar bar = getSupportActionBar();
		if(type != null && bar != null)
		{
			switch(type)
			{
				case NORMAL:
					bar.setTitle(getString(R.string.ab_title_rtl_normal));
					FragmentTransaction transaction = getFragmentManager().beginTransaction();
					transaction.replace(R.id.activity_rtl_container, RTLFragment.newInstance(), RTLFragment.TAG);
					transaction.commitAllowingStateLoss();
					break;
				case CUSTOM:
					bar.setTitle(getString(R.string.ab_title_rtl_custom));
					transaction = getFragmentManager().beginTransaction();
					transaction.replace(R.id.activity_rtl_container, RTLCustomFragment.newInstance(), RTLCustomFragment.TAG);
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
