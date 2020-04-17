package multi.android.material_design_pro2.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;

public class CircleImageRecyclerTest extends AppCompatActivity {
    RecyclerView imagelist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_image_recycler_test);
        imagelist = findViewById(R.id.imagelist);
        List<CircleItem> recycler_circle_item = new ArrayList<CircleItem>();

        CircleItem gong = new CircleItem(R.drawable.gong);
        CircleItem jang = new CircleItem(R.drawable.jang);
        CircleItem jung = new CircleItem(R.drawable.jung);
        CircleItem lee = new CircleItem(R.drawable.lee);
        CircleItem so = new CircleItem(R.drawable.so);
        recycler_circle_item.add(gong);
        recycler_circle_item.add(jang);
        recycler_circle_item.add(jung);
        recycler_circle_item.add(lee);
        recycler_circle_item.add(so);

        RecyclerCircleAdapter adapter =
                new RecyclerCircleAdapter(this,R.layout.circle_item,recycler_circle_item);
//        GridLayoutManager manager =
//                new GridLayoutManager(getApplicationContext(),3);
        LinearLayoutManager manager =
                new LinearLayoutManager(getApplicationContext());//this로 해도 가능
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        imagelist.setHasFixedSize(true);
        imagelist.setLayoutManager(manager);
        imagelist.setAdapter(adapter);

    }
}
