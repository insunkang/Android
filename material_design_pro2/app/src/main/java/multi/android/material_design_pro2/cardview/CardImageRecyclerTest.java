package multi.android.material_design_pro2.cardview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;

public class CardImageRecyclerTest extends AppCompatActivity {
    RecyclerView imagelist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_image_recycler_test);
        imagelist = findViewById(R.id.imagelist);
        List<CardItem> recycler_circle_item = new ArrayList<CardItem>();

        CardItem gong = new CardItem(R.drawable.gong,"공유의 도깨비");
        CardItem jang = new CardItem(R.drawable.jang,"검색어를 입력하세요");
        CardItem jung = new CardItem(R.drawable.jung,"정우성의 비트");
        CardItem lee = new CardItem(R.drawable.lee,"이민호의 신의");
        CardItem so = new CardItem(R.drawable.so,"미안하다 사랑한다");
        recycler_circle_item.add(gong);
        recycler_circle_item.add(jang);
        recycler_circle_item.add(jung);
        recycler_circle_item.add(lee);
        recycler_circle_item.add(so);

        RecyclerCardAdapter adapter =
                new RecyclerCardAdapter(this,R.layout.card_item,recycler_circle_item);
        GridLayoutManager manager =
                new GridLayoutManager(getApplicationContext(),1);
//        LinearLayoutManager manager =
//                new LinearLayoutManager(getApplicationContext());//this로 해도 가능
//        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        imagelist.setHasFixedSize(true);
        imagelist.setLayoutManager(manager);
        imagelist.setAdapter(adapter);

    }
}
