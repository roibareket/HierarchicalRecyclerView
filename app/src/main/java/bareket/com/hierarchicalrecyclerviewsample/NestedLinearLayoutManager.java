package bareket.com.hierarchicalrecyclerviewsample;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

/**
 * Created by roi.bareket.
 */
public class NestedLinearLayoutManager extends LinearLayoutManager implements bareket.com.hierarchicalrecyclerview.NestedLinearLayoutManager {
    public NestedLinearLayoutManager(Context context) {
        super(context);
    }

    public NestedLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public NestedLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
