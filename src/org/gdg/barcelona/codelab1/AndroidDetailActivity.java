package org.gdg.barcelona.codelab1;

import org.gdg.barcelona.codelab1.fragments.AndroidImageFragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class AndroidDetailActivity extends FragmentActivity 
{
	@Override
	protected void onCreate(Bundle _savedInstanceState) 
	{
		super.onCreate(_savedInstanceState);
		
		// Si la orientaci—n pasa a ser landscape, cerramos la actividad y volvemos a la anterior,
		// dado que en landscape si que tenemos espacio para visualizar el fragment con la imagen
		if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE) 
		{
            finish();
            return;
        }
	
		if (_savedInstanceState == null) 
		{
			// A–adimos el fragment como raiz de la jerarquia de vistas
            AndroidImageFragment details = new AndroidImageFragment();
            details.setArguments(getIntent().getExtras());
            
            getSupportFragmentManager()
            	.beginTransaction()
            	.add(android.R.id.content, details)
            	.commit();
        }
	}
}
