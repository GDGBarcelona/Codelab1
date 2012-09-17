package org.gdg.barcelona.codelab1;

import org.gdg.barcelona.codelab1.fragments.AndroidsListFragment;
import org.gdg.barcelona.codelab1.fragments.AndroidImageFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;

public class AndroidListDetailActivity extends FragmentActivity implements AndroidsListFragment.ClickedItem
{
	private static final String FRAGMENT_TAG = "FRAGMENT_TAG";
	
	View frameLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_android_list);
		
		frameLayout = findViewById(R.id.android_list_activity_detail_framelayout);
		
		FragmentManager fragmentManager = getSupportFragmentManager();
		
		if (frameLayout != null)
		{
			Fragment imageFragment = (Fragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);

			if (imageFragment == null)
			{
				fragmentManager
					.beginTransaction()
					.replace(R.id.android_list_activity_detail_framelayout, new AndroidImageFragment(), FRAGMENT_TAG)
					.commit();
			}	
		}
		else
		{
			fragmentManager
				.beginTransaction()
				.replace(R.id.android_list_activity_framelayout, new AndroidsListFragment(), FRAGMENT_TAG)
				.commit();
		}
	}

	public void ChangeImatge(int _imageID) 
	{
		Bundle bundle = new Bundle();
		bundle.putInt("id", _imageID);
		
		Fragment fragment = new AndroidImageFragment();
		fragment.setArguments(bundle);
		
		if (frameLayout == null)
		{
			getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.android_list_activity_framelayout, fragment, FRAGMENT_TAG)
				.addToBackStack(null)
				.commit();
		}
		else
		{
			getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.android_list_activity_detail_framelayout, fragment, FRAGMENT_TAG)
				.commit();
		}
	}

}
