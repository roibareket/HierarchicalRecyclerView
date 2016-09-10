package bareket.com.hierarchicalrecyclerviewsample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import bareket.com.hierarchicalrecyclerview.NestedItem;
import bareket.com.hierarchicalrecyclerview.NestedScrollHelper;

/**
 * Created by roi.bareket.
 */
public class OnNestedScrollListener extends RecyclerView.OnScrollListener {

    private final NestedScrollHelper nestedScrollHelper;

    public OnNestedScrollListener(Context context, NestedLinearLayoutManager layoutManager, List<NestedItem> commentDataList) {
        nestedScrollHelper = new NestedScrollHelper(context, layoutManager, commentDataList);
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        nestedScrollHelper.onScrolled();
    }
}
