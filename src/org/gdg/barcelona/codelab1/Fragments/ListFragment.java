package org.gdg.barcelona.codelab1.Fragments;

import org.gdg.barcelona.codelab1.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListFragment extends android.support.v4.app.ListFragment {
	private ClickedItem comunicacion;
	
	Object[][] dades = new Object[][]{
			{"android blanco",R.drawable.android_blanco},
			{"android boda",R.drawable.android_boda},
			{"android jellbean",R.drawable.android_jellybean},
			{"android noogler",R.drawable.android_noogler},
			{"android oficina",R.drawable.android_office},
			{"android r2d2",R.drawable.android_r2d2},
			{"android radioactiu",R.drawable.android_radiactiu},
			{"android vermell",R.drawable.android_rojo},
	};
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		//obtenemos la vista
		ListView list = getListView();
		//creamos un objeto de eventos de la list
		OnClickListenerListView listener = new OnClickListenerListView();
		list.setOnItemClickListener(listener);
		list.setOnItemLongClickListener(listener);
		//le damos a los datos una representacion
		setListAdapter(new AdaptadorDoubleArray(dades));
		//modificamos la aparencia de la lista
		list.setBackgroundDrawable(getResources().getDrawable(R.drawable.fondo_lista));
		
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override	 
	public void onAttach(Activity activity) {//evento asocia el fragment a la actividad
		 super.onAttach(activity);
		 if (activity instanceof ClickedItem) {
			 comunicacion = (ClickedItem) activity;
		 }
	 }
	
	private class OnClickListenerListView implements OnItemClickListener,OnItemLongClickListener{

		public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
				int arg2, long arg3) {
			
			return false;
		}

		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			int id = Integer.parseInt(dades[arg2][1].toString());
			comunicacion.ChangeImatge(id);
		}		
		
	}
	
	private class AdaptadorDoubleArray extends BaseAdapter{
		Object[][] objects;
		public AdaptadorDoubleArray(Object[][] d){
			objects = d;
		}
		
		public int getCount() {
			// TODO Auto-generated method stub
			return objects.length;
		}

		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return objects[arg0];
		}

		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		public View getView(int arg0, View arg1, ViewGroup arg2) {
			LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);      
		    View lay = inflater.inflate(R.layout.item_fragment_list, arg2, false);
			
			TextView text = (TextView)lay.findViewById(R.id.textView1);
			
			Object[] name = (Object[])getItem(arg0);
			
			text.setText(name[0].toString());
			
			return lay;
		}
		
	}
	
	public interface ClickedItem{
		void ChangeImatge(int ImatgeId);
	}
}
