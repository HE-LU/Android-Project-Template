package cz.helu.rtl.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import cz.helu.rtl.R;
import cz.helu.rtl.adapter.DrawerAdapter;


public class MainActivity extends BaseActivity
{
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private ListView mDrawerListView;
	private CharSequence mTitle;
	private CharSequence mDrawerTitle;
	private String[] mTitles;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupActionBar();
		setupDrawer(savedInstanceState);
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

	@Override
	public boolean onPrepareOptionsMenu(Menu menu)
	{
		// action bar menu visibility
		if(menu!=null)
		{
			boolean drawerOpened = mDrawerLayout.isDrawerOpen(mDrawerListView);
		}
		return super.onPrepareOptionsMenu(menu);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// open or close the drawer if home button is pressed
		if(mDrawerToggle.onOptionsItemSelected(item))
		{
			return true;
		}

		// action bar menu behaviour
		switch(item.getItemId())
		{
			case android.R.id.home:
				// TODO
				return true;

			default:
				return super.onOptionsItemSelected(item);
		}
	}


	@Override
	protected void onPostCreate(Bundle savedInstanceState)
	{
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}


	@Override
	public void onConfigurationChanged(Configuration newConfiguration)
	{
		super.onConfigurationChanged(newConfiguration);
		mDrawerToggle.onConfigurationChanged(newConfiguration);
	}


	@Override
	public void onBackPressed()
	{
		if(mDrawerLayout.isDrawerOpen(Gravity.LEFT))
		{
			mDrawerLayout.closeDrawer(Gravity.LEFT);
		}
		else
		{
			super.onBackPressed();
		}
	}


	@Override
	public void setTitle(CharSequence title)
	{
		mTitle = title;
		getSupportActionBar().setTitle(mTitle);
	}


	private void setupDrawer(Bundle savedInstanceState)
	{
		mTitle = getTitle();
		mDrawerTitle = getTitle();

		mTitles = new String[4];
		mTitles[0] = getString(R.string.title_example);
		mTitles[1] = getString(R.string.title_example);
		mTitles[2] = getString(R.string.title_example);
		mTitles[3] = getString(R.string.title_example);

		Integer[] icons = new Integer[4];
		icons[0] = R.drawable.arrow;
		icons[1] = R.drawable.arrow;
		icons[2] = R.drawable.arrow;
		icons[3] = R.drawable.arrow;

		// reference
		mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_example_layout);
		mDrawerListView = (ListView) findViewById(R.id.activity_example_drawer);

		// set drawer
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		mDrawerListView.setAdapter(new DrawerAdapter(this, mTitles, icons));
		mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> adapterView, View clickedView, int position, long id)
			{
				selectDrawerItem(position);
			}
		});
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close)
		{
			@Override
			public void onDrawerClosed(View view)
			{
				getSupportActionBar().setTitle(mTitle);
				supportInvalidateOptionsMenu();
			}

			@Override
			public void onDrawerOpened(View drawerView)
			{
				getSupportActionBar().setTitle(mDrawerTitle);
				supportInvalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		// show initial fragment
		if(savedInstanceState == null)
		{
			selectDrawerItem(0);
		}
	}


	private void selectDrawerItem(int position)
	{
//		PercentFragmentRelative fragment;
//		if(position==0) fragment = PercentFragmentRelative.newInstance();
//		else if(position==1) fragment = PercentFragmentRelative.newInstance();
//		else if(position==2) fragment = PercentFragmentRelative.newInstance();
//		else if(position==3) fragment = PercentFragmentRelative.newInstance();
//		else fragment = PercentFragmentRelative.newInstance();

//		FragmentManager fragmentManager = getSupportFragmentManager();
//		fragmentManager.beginTransaction().replace(R.id.activity_example_container, fragment).commitAllowingStateLoss();

		mDrawerListView.setItemChecked(position, true);
		setTitle(mTitles[position]);
		mDrawerLayout.closeDrawer(mDrawerListView);
	}
}
