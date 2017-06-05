package itesm.mx.m1_jbbm_labo_frutas;

import android.app.ListActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener{

    ImageView ivFruta;
    int[] frutasIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivFruta = (ImageView)findViewById(R.id.image_fruta);
        String[] stringFrutas = getResources().getStringArray(R.array.array_frutas);

        ArrayAdapter<String> adapterFrutas = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                stringFrutas);

        setListAdapter(adapterFrutas);

        getListView().setOnItemClickListener(this);

        frutasIds = new int[]{
                R.drawable.banana,
                R.drawable.pinapple,
                R.drawable.orange,
                R.drawable.watermelon
        };

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        int frutaId = frutasIds[position];

        Bitmap imagenFruta = BitmapFactory.decodeResource(getResources(), frutaId);
        ivFruta.setImageBitmap(imagenFruta);

        Toast.makeText(getApplicationContext(), "Seleccionaste: " +
                parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
    }
}
