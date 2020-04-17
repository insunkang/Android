package multi.android.material_design_pro2.cardview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import multi.android.material_design_pro2.R;

public class RecyclerCardAdapter extends RecyclerView.Adapter<RecyclerCardAdapter.ViewHolder> {
    Context context;
    int row_id;
    List<CardItem> data ;

    public RecyclerCardAdapter(Context context, int row_id, List<CardItem> data) {
        this.context = context;
        this.row_id = row_id;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(row_id,null  );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageView row_image_view = holder.imageView;
        TextView row_text_view = holder.txt;
        row_image_view.setImageResource(data.get(position).getImg());
        row_text_view.setText(data.get(position).getTxt());
        row_image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"데이터연결완료",Toast.LENGTH_LONG).show();
            }
        });
    }



    @Override
    public int getItemCount() {
        return data.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView txt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            txt = itemView.findViewById(R.id.textView);
        }
    }
}
