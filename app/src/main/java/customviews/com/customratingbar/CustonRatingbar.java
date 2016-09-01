package customviews.com.customratingbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by zhen on 2016/8/30.
 */
public class CustonRatingbar extends LinearLayout {

    private final LinearLayout mRootView;
    private Context context;

    private int mTotalCount;
    private int mLikeCount;
    private int resId;
    private int likeResid;
    private int mSize;

    public CustonRatingbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mRootView = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.custom_ratingbar_layout, this);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.context = context;
        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomRatingbar, 0, 0);

        mTotalCount = array.getInt(R.styleable.CustomRatingbar_cr_total_count, 5);
        mLikeCount = array.getInt(R.styleable.CustomRatingbar_cr_like_count, 0);

        resId = array.getResourceId(R.styleable.CustomRatingbar_cr_src, R.drawable.heart);
        likeResid = array.getResourceId(R.styleable.CustomRatingbar_cr_like_src, R.drawable.heart_like);

        mSize = array.getResourceId(R.styleable.CustomRatingbar_cr_size, R.dimen.cr_size);

    }

    public void setmLikeCount(int totolCount, int num) {
        mTotalCount = totolCount;
        mLikeCount = num;
        addView();
    }

    private void addView() {
        mRootView.removeAllViews();
        for (int i = 0; i < mLikeCount; i++) {
            ImageView iv = new ImageView(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) context.getResources().getDimension(mSize), (int) context.getResources().getDimension(mSize));
            params.setMargins(0, 5, 5, 0);
            iv.setLayoutParams(params);
            iv.setImageResource(likeResid);
            mRootView.addView(iv);
        }

        for (int i = 0; i < mTotalCount - mLikeCount; i++) {
            ImageView iv = new ImageView(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) context.getResources().getDimension(mSize), (int) context.getResources().getDimension(mSize));
            params.setMargins(0, 5, 5, 0);
            iv.setLayoutParams(params);
            iv.setImageResource(resId);
            mRootView.addView(iv);
        }
    }
}
