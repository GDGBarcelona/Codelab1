package org.gdg.barcelona.codelab1.Fragments;

import org.gdg.barcelona.codelab1.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.app.ListFragment;

public class AndroidsListFragment extends ListFragment 
{
	private static String[] ANDROID_NAME_ARRAY = 
		{"Blanco", "Boda", "Jellybean", "Noogler","Worker", 
		 "R2D2", "Reactor", "Creature"};
	
	private static int[] ANDROID_ID_ARRAY = 
		{R.drawable.android_blanco, R.drawable.android_boda, 
		 R.drawable.android_jellybean, R.drawable.android_noogler,
		 R.drawable.android_office, R.drawable.android_r2d2, 
		 R.drawable.android_radiactiu, R.drawable.android_rojo};
	
	ClickedItem comunicacion;
	
	@Override	 
	public void onAttach(Activity activity) 
	{
		//evento asocia el fragment a la actividad
		 super.onAttach(activity);
		 
		 if (activity instanceof ClickedItem) 
		 {
			 comunicacion = (ClickedItem) activity;
		 }
	 }
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		ListView listView = getListView();
		//creamos un objeto de eventos de la list
		listView.setOnItemClickListener(new OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) 
			{
				comunicacion.ChangeImatge(ANDROID_ID_ARRAY[arg2]);
			}		
		});
		
		//modificamos la aparencia de la lista
		listView.setBackgroundDrawable(getResources().getDrawable(R.drawable.fondo_lista));
		
		ArrayAdapter<String> arrayAdapter = 
				new ArrayAdapter<String>(getActivity(), 
										android.R.layout.simple_list_item_1, 
										ANDROID_NAME_ARRAY);
		
		//le damos a los datos una representacion
		setListAdapter(arrayAdapter);

		super.onActivityCreated(savedInstanceState);
	}
	
	public interface ClickedItem 
	{
		public void ChangeImatge(int imatgeId);
	}
}
