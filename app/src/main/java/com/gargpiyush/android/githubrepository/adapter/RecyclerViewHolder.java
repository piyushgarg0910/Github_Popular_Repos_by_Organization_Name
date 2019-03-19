package com.gargpiyush.android.githubrepository.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gargpiyush.android.githubrepository.R;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by Piyush Garg on 3/18/2019 at 20:31.
 */
class RecyclerViewHolder extends RecyclerView.ViewHolder {

    @BindViews({R.id.title_text,R.id.num,R.id.description})
    List<TextView> textViews;

    @BindView(R.id.image_view)
    ImageView imageView;

    @BindView(R.id.link)
    Button button;

    RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
