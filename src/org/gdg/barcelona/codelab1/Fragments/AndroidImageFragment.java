package org.gdg.barcelona.codelab1.fragments;

import org.gdg.barcelona.codelab1.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class AndroidImageFragment extends Fragment
{
	public static final String IMAGE_ID_KEY = "IMAGE_ID_KEY";
	
	@Override
	public View onCreateView(LayoutInflater _inflater, ViewGroup _container, Bundle _savedInstanceState)
	{
		return _inflater.inflate(R.layout.fragment_image, _container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle _savedInstanceState)
	{
		super.onActivityCreated(_savedInstanceState);
		
		ImageView imageView = (ImageView)getActivity().findViewById(R.id.fragment_imatgeview);
		
		if (imageView != null)
		{	
			// Recuperamos el identificador de la imagen
			int id = getArguments().getInt(IMAGE_ID_KEY,0);
			
			// En base a el, mostramos la imagen correspondiente
			if (id == 0)
			{
				imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));
			}
			else
			{
				imageView.setImageDrawable(getResources().getDrawable(id));			
			}
		}
	}
}
