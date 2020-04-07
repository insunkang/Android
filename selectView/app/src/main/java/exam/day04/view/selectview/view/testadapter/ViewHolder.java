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
        this.actorImg= parentView.findViewById(R.id.actorImg);
        this.actorName= parentView.findViewById(R.id.actorName);
        this.actorDate= parentView.findViewById(R.id.actorDate);
        this.actorTxt= parentView.findViewById(R.id.actorTxt);
        this.actorCheck= parentView.findViewById(R.id.actorCheck);
    }
}
