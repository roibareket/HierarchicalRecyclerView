package bareket.com.hierarchicalrecyclerview;

import android.content.Context;
import android.util.Log;
import android.view.View;

import java.util.HashMap;
import java.util.List;

/**
 * Created by roi.bareket.
 */
public class NestedScrollHelper {
    private final int FOCUS_VIEW_SLIDE_END;
    private final int FOCUS_VIEW_SLIDE_START;
    private final int NESTING_GAP;
    private final int MAX_VISIBLE_NESTING;


    private List<? extends NestedItem> commentDataList;
    private NestedLinearLayoutManager layoutManager;
    private HashMap<Object, Integer> nestingMap = new HashMap<>();

    public NestedScrollHelper(Context context, NestedLinearLayoutManager layoutManager, List<? extends NestedItem> commentDataList) {
        FOCUS_VIEW_SLIDE_START = context.getResources().getDimensionPixelSize(R.dimen.nesting_scroll_focus_view_slide_start);
        FOCUS_VIEW_SLIDE_END = context.getResources().getDimensionPixelSize(R.dimen.nesting_scroll_focus_view_slide_end);
        NESTING_GAP = context.getResources().getDimensionPixelSize(R.dimen.nesting_scroll_gap_size);
        MAX_VISIBLE_NESTING = 3 * NESTING_GAP;

        this.layoutManager = layoutManager;
        onDataSetChange(commentDataList);
    }

    public void onDataSetChange(List<? extends NestedItem> commentDataList) {
        this.commentDataList = commentDataList;
        invalidateNestingMap();
    }

    private void invalidateNestingMap() {
        nestingMap.clear();
        for (NestedItem data : commentDataList) {
            Integer parentNesting = nestingMap.get(data.getNestedItemParentId());
            int childNesting = parentNesting == null ? 0 : parentNesting + 1;
            nestingMap.put(data.getNestedItemId(), childNesting);
        }
    }

    public void onScrolled() {
        int firstPosition = layoutManager.findFirstVisibleItemPosition();
        int lastPosition = layoutManager.findLastVisibleItemPosition();

        int focusedViewNesting = 0;
        int focusedViewShifting = 0;
        boolean showParentHint = false;

        // get focused view
        if (firstPosition != lastPosition) {
            View focusedView = null;
            int focusedViewPosition = 0;
            for (int i = firstPosition; i <= lastPosition; i++) {
                View focusedViewCandidate = layoutManager.findViewByPosition(i);
                if (focusedViewCandidate.getTop() < FOCUS_VIEW_SLIDE_START) {
                    focusedView = focusedViewCandidate;
                    focusedViewPosition = i;
                } else {
                    break;
                }
            }

            focusedViewNesting = nestingMap.get(commentDataList.get(focusedViewPosition).getNestedItemId());

            // calc view shifting
            if (focusedView.getTop() > FOCUS_VIEW_SLIDE_END) {
                Integer nesting = nestingMap.get(commentDataList.get(focusedViewPosition - 1).getNestedItemId());
                int aboveViewNesting =  nesting - focusedViewNesting;
                float shiftingPercentage = ((float) (focusedView.getTop() - FOCUS_VIEW_SLIDE_END)) / (FOCUS_VIEW_SLIDE_START - FOCUS_VIEW_SLIDE_END);
                focusedViewShifting = (int) -(shiftingPercentage * aboveViewNesting * NESTING_GAP);
            }

            // calc parent hint
            int firstFocusNesting = nestingMap.get(commentDataList.get(firstPosition).getNestedItemId());
            showParentHint = focusedViewNesting < firstFocusNesting;
        }

        // adjust views translationX
        for (int i = firstPosition; i <= lastPosition; i++) {
            View view = layoutManager.findViewByPosition(i);
            Integer nesting = nestingMap.get(commentDataList.get(i).getNestedItemId());
            Integer viewNesting =  nesting - focusedViewNesting;
            int absoluteTranslationX = NESTING_GAP * viewNesting + focusedViewShifting;
            int relativeTranslationX = Math.max(Math.min(absoluteTranslationX, MAX_VISIBLE_NESTING), -MAX_VISIBLE_NESTING);
            view.setTranslationX(relativeTranslationX);
        }


    }
}