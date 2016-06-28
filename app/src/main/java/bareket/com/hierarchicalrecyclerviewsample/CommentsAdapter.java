package bareket.com.hierarchicalrecyclerviewsample;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder>{

    private final List<CommentData> commentData;

    public CommentsAdapter(List<CommentData> commentData){
        this.commentData = commentData;
    }

    @Override
    public CommentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommentsAdapter.ViewHolder(new Comment(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(CommentsAdapter.ViewHolder holder, int position) {
        holder.onBind(commentData.get(position));
    }

    @Override
    public int getItemCount() {
        return commentData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final Comment comment;

        public ViewHolder(Comment comment) {
            super(comment);
            this.comment = comment;
        }

        public void onBind(CommentData commentData){
            comment.setAvatar(commentData.avatar);
            comment.setName(commentData.name);
            comment.setComment(commentData.comment);
        }
    }
}
