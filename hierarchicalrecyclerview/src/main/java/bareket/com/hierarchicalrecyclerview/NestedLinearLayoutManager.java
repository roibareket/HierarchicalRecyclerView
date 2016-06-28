package bareket.com.hierarchicalrecyclerview;

import android.view.View;

/**
 * Created by roi.bareket.
 */
public interface NestedLinearLayoutManager {
    int findFirstVisibleItemPosition();

    int findLastVisibleItemPosition();

    View findViewByPosition(int i);
}
