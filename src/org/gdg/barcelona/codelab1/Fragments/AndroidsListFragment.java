package org.gdg.barcelona.codelab1.fragments;

import org.gdg.barcelona.codelab1.AndroidListDetailActivity;
import org.gdg.barcelona.codelab1.R;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.app.ListFragment;

public class AndroidsListFragment extends ListFragment 
{
	// Array con los nombres de los androids
	private static final String[] ANDROID_NAME_ARRAY = 
		{"Blanco", "Boda", "Jellybean", "Noogler","Worker", 
		 "R2D2", "Reactor", "Creature"};
	
	// Array con los recursos que representan las imagenes de los androids
	private static final int[] ANDROID_ID_ARRAY = 
		{R.drawable.android_blanco, R.drawable.android_boda, 
		 R.drawable.android_jellybean, R.drawable.android_noogler,
		 R.drawable.android_office, R.drawable.android_r2d2, 
		 R.drawable.android_radiactiu, R.drawable.android_rojo};
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
		// Recuperamos la lista y anadimos un evento de click
		ListView listView = getListView();
		listView.setOnItemClickListener(new OnItemClickListener()
		{
			// Al clickar, cambiaremos la imagen del fragment de detalle
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) 
			{
				// Mejor desacoplar la actividad del fragment utilizando una interfice, pero para
				// no "complicar" el ejemplo, lo haremos de la siguiente manera
				((AndroidListDetailActivity)getActivity()).ChangeImatge(ANDROID_ID_ARRAY[arg2]);
			}		
		});
		
		// modificamos la aparencia de la lista
		listView.setBackgroundDrawable(getResources().getDrawable(R.drawable.fondo_lista));
		
		// Creamos el adapter para rellenar la lista a partir del array de nombres de Androids
		ArrayAdapter<String> arrayAdapter = 
				new ArrayAdapter<String>(getActivity(), 
										android.R.layout.simple_list_item_1, 
										ANDROID_NAME_ARRAY);
		
		// Pasamos el adapter a la lista para genera los items
		setListAdapter(arrayAdapter);
	}
}
