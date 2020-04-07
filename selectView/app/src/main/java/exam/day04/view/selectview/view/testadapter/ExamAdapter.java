package exam.day04.view.selectview.view.testadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import exam.day04.view.selectview.R;
import exam.day04.view.selectview.view.adapter.SaveUserState;

public class ExamAdapter extends ArrayAdapter {
    private Context context;
    private int resId;
    private ArrayList<ActorItem> datalist;
    HashMap<Integer,SaveUserStateC> saveData= new HashMap<Integer, SaveUserStateC>();
    public ExamAdapter(Context context , int resId,  ArrayList<ActorItem> datalist) {
        super(context, resId, datalist );
        this.context = context;
        this.resId = resId;
        this.datalist = datalist;
    }

    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public Object getItem(int position) {
        return datalist.get(position);
    }


    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView==null){
            LayoutInflater inflater =
                    (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ActorItem actorItem = datalist.get(position);


        if (actorItem!=null){
            ImageView imageView = viewHolder.actorImg;
            TextView nameView = viewHolder.actorName;
            TextView dateView = viewHolder.actorDate;
            TextView textView = viewHolder.actorTxt;

            final CheckBox checkView = viewHolder.actorCheck;

            imageView.setImageResource(actorItem.actorImg);
            nameView.setText(actorItem.actorName);
            dateView.setText(actorItem.actorDate);
            textView.setText(actorItem.actorTxt);
            SaveUserStateC stateC = saveData.get(position);

            if (stateC.equals(false)) {
                checkView.setChecked(false);
            }else{
                checkView.setChecked(true);
            }



        }




        return convertView;
    }
}
