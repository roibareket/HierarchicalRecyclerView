package bareket.com.hierarchicalrecyclerviewsample;


import bareket.com.hierarchicalrecyclerview.NestedItem;

/**
 * Created by roi.bareket.
 */
public class CommentData implements NestedItem {
    public Integer parentId;
    public Integer id;
    public int avatar;
    public String name;
    public String comment;

    public CommentData(Integer id, Integer parentId, int avatar, String name, String comment){
        this.id = id;
        this.parentId = parentId;
        this.avatar = avatar;
        this.name = name;
        this.comment = comment;
    }

    @Override
    public Integer getNestedItemId() {
        return id;
    }

    @Override
    public Integer getNestedItemParentId() {
        return parentId;
    }
}
