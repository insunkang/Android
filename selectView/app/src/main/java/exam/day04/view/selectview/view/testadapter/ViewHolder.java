package exam.day04.view.selectview.view.testadapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

import exam.day04.view.selectview.R;

public class ViewHolder {
    ImageView actorImg;
    TextView actorName;
    TextView actorDate;
    TextView actorTxt;
    CheckBox actorCheck;

    public ViewHolder(View parentView){
        this.actorImg= parentView.findViewById(R.id.img);
        this.actorName= parentView.findViewById(R.id.name);
        this.actorDate= parentView.findViewById(R.id.date);
        this.actorTxt= parentView.findViewById(R.id.resultinfo);
        this.actorCheck= parentView.findViewById(R.id.exam_chk);
    }
}
