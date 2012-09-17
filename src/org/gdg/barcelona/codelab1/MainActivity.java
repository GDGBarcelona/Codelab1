package org.gdg.barcelona.codelab1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Clase principal de la aplicacion
 * 
 * @author Adria Berge
 */
public class MainActivity extends Activity
{
    @Override
    public void onCreate(Bundle _savedInstanceState)
    {
        super.onCreate(_savedInstanceState);
        // Cargamos el dise–o de la pantalla descrito en /res/layout/activity_main.xml
        setContentView(R.layout.activity_main);
        
        // Recuperamos la instancia del boton
        Button button = (Button)findViewById(R.id.main_btton);
        // Y le anadimos un listener para reaccionar al evento de click
        button.setOnClickListener(new OnClickListener() 
        {	
			public void onClick(View _view) 
			{
				// Al clickar el boton, cambiamos a la actividad AndroidListDetailActivity
				startActivity(new Intent(getBaseContext(),AndroidListDetailActivity.class));
			}
		});
    }

}
