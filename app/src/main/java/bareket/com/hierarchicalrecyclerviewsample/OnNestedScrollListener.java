package bareket.com.hierarchicalrecyclerviewsample;

import android.support.v7.widget.RecyclerView;

import bareket.com.hierarchicalrecyclerview.NestedScrollHelper;

/**
 * Created by roi.bareket.
 */
public class OnNestedScrollListener extends RecyclerView.OnScrollListener {


    private final NestedScrollHelper nestedScrollHelper;

    public OnNestedScrollListener(NestedScrollHelper nestedScrollHelper) {
        this.nestedScrollHelper = nestedScrollHelper;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        nestedScrollHelper.onScrolled();
    }
}
