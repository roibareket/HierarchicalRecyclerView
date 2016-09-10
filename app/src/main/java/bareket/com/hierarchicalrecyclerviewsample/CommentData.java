package bareket.com.hierarchicalrecyclerviewsample;


import bareket.com.hierarchicalrecyclerview.NestedItem;

/**
 * Created by roi.bareket.
 */
public class CommentData implements NestedItem {
    public String parentId;
    public String id;
    public int avatar;
    public String name;
    public String comment;

    public CommentData(String id, String parentId, int avatar, String name, String comment){
        this.id = id;
        this.parentId = parentId;
        this.avatar = avatar;
        this.name = name;
        this.comment = comment;
    }

    @Override
    public Object getNestedItemId() {
        return id;
    }

    @Override
    public Object getNestedItemParentId() {
        return parentId;
    }
}
