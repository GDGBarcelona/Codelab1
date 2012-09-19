package org.gdg.barcelona.codelab1;

import org.gdg.barcelona.codelab1.fragments.AndroidImageFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class AndroidListDetailActivity extends FragmentActivity
{
	private static final String FRAGMENT_TAG = "FRAGMENT_TAG";
	private View mFrameLayout;
	private static int mID = 0;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) 
	{
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.activity_android_list);
		
		// Comprobamos si la pantalla incluye un framelayout para el fragment de detalle
		mFrameLayout = findViewById(R.id.android_list_activity_detail_framelayout);
		
		// Si lo incluye, a–adimos el fragment
		if (mFrameLayout != null)
		{
			// Reemplazamos el fragment con el œltimo ID v‡lido
			replaceImageFragment(mID);
		}
	}

	/**
	 * Metodo para cambiar la imagen del fragment de detalle, o, en caso de que no 
	 * haya espacio en la pantalla para dicho fragment, lanza una nueva actividad para 
	 * cambiarlo. El cambio se provoca a partir de la seleccion realizada en el fragment 
	 * con la lista
	 * 
	 * @param _imageID Identificador del recurso a subsituir, o 0 en caso de que no haya 
	 * 		  ninguno seleccionado
	 */
	public void ChangeImatge(int _imageID) 
	{	
		// Nos guardamos el ID por si vamos a cambiar de actividad
		mID = _imageID;
		
		if (mFrameLayout != null)
		{
			// Si existe el framelayout para colocar el fragment, lo reemplazamos
			replaceImageFragment(_imageID);
		}
		else
		{
			// En caso contrario, creamos una nueva actividad para que albergue el 
			// fragment, y le pasamos el identificador
			Intent intent = new Intent(this, AndroidDetailActivity.class);
			intent.putExtra(AndroidImageFragment.IMAGE_ID_KEY, _imageID);
			startActivity(intent);
		}
	}
	
	/**
	 * Metodo para reemplazar el fragment con la imagen del android 
	 * seleccionada
	 * 
	 * @param _id Identificador del recurso a subsituir, o 0 en caso de que no haya 
	 * 		  ninguno seleccionado
	 */
	private void replaceImageFragment(int _id)
	{
		Bundle bundle = new Bundle();
		bundle.putInt(AndroidImageFragment.IMAGE_ID_KEY, _id);
		
		Fragment fragment = new AndroidImageFragment();
		fragment.setArguments(bundle);
		
		getSupportFragmentManager()
			.beginTransaction()
			.replace(R.id.android_list_activity_detail_framelayout, fragment, FRAGMENT_TAG)
			.commit();
	}

}
