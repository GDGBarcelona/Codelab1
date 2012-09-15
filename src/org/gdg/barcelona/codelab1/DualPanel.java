package org.gdg.barcelona.codelab1;

import org.gdg.barcelona.codelab1.Fragments.FragmentImatge;
import org.gdg.barcelona.codelab1.Fragments.ListFragment;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

public class DualPanel extends FragmentActivity implements ListFragment.ClickedItem{
	Fragment listas =  new ListFragment();
	FragmentImatge imatges =  new FragmentImatge();
	public Drawable imagenselected;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//Montamos el arbol de vistas
		setContentView(R.layout.activity_dual_panel_landscape);
		
		//cargamos los fragments en cada uno de los frames
		getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.FrameLayout_List,listas)
				.commit();
			
		getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.FrameLayout_Imatge, imatges)
				.commit();
		
	}

	public void ChangeImatge(int ImatgeId) {
		//obtenemos la imagen de nuestros recursos
		imagenselected = getResources().getDrawable(ImatgeId);
		//casteamos la imatgeview i le ponemos la imagen
		ImageView imatge = (ImageView)findViewById(R.id.fragment_imatgeview);
		imatge.setImageDrawable(imagenselected);
		
	}

}
