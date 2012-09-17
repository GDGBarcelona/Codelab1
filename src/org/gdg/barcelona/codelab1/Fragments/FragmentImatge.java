package org.gdg.barcelona.codelab1.Fragments;

import org.gdg.barcelona.codelab1.AndroidListDetailActivity;
import org.gdg.barcelona.codelab1.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentImatge extends Fragment
{
	public ImageView imatge = null;
	
	@Override
	public View onCreateView(LayoutInflater _inflater, ViewGroup _container, Bundle _savedInstanceState)
	{
		View v = _inflater.inflate(R.layout.fragment_imatge, _container, false);
		return v;
	}
	
	@Override
	public void onActivityCreated(Bundle _savedInstanceState)
	{
		super.onActivityCreated(_savedInstanceState);
		imatge = (ImageView)getActivity().findViewById(R.id.fragment_imatgeview);
		AndroidListDetailActivity panel = (AndroidListDetailActivity)getActivity();
		
		if(panel.imagenselected == null){
			imatge.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));
		}else{
			imatge.setImageDrawable(panel.imagenselected);			
		}
		
	}
}
