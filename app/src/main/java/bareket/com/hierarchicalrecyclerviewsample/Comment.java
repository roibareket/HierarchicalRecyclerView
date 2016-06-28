package bareket.com.hierarchicalrecyclerviewsample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by roi.bareket.
 */
public class Comment extends LinearLayout{

    private ImageView avatar;
    private TextView comment;
    private TextView name;

    public Comment(Context context) {
        super(context);
        init();
    }

    public Comment(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Comment(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.comment_view, this);

        avatar = (ImageView) rootView.findViewById(R.id.avatar);
        name = (TextView) rootView.findViewById(R.id.name);
        comment = (TextView) rootView.findViewById(R.id.comment);
    }

    public void setAvatar(int val){
        avatar.setImageResource(val);
    }

    public void setName(String val){
        name.setText(val);
    }

    public void setComment(String val){
        comment.setText(val);
    }
}
