package com.whyalwaysmea.bigboom.module.moviedetail.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.bean.MovieDetail;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;
import com.whyalwaysmea.bigboom.utils.DensityUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/10/17.
 */

public class CastAdapter extends BaseAdapter<MovieDetail.CastsBean> {


    public CastAdapter(Context context, List<MovieDetail.CastsBean> data) {
        super(context, data);
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_cast, parent, false);
        return new CastHolder(view);
    }


    class CastHolder extends BaseViewHolder {

        @BindView(R.id.cast_item_avatar)
        ImageView mCastItemAvatar;
        @BindView(R.id.cast_item_name)
        TextView mCastItemName;
        @BindView(R.id.director)
        TextView mDirector;


        public CastHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(int position) {
            if(position == 0) {
                itemView.setPadding(DensityUtils.dp2px(mContext, 24), DensityUtils.dp2px(mContext, 5), DensityUtils.dp2px(mContext, 5), DensityUtils.dp2px(mContext, 5));
                mDirector.setVisibility(View.VISIBLE);
            } else {
                mDirector.setVisibility(View.GONE);
            }
            ImageUtils.getInstance().display(mCastItemAvatar, mData.get(position).getAvatars().getMedium());
            mCastItemName.setText(mData.get(position).getName());
        }
    }
}
