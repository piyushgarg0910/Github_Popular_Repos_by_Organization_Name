package com.gargpiyush.android.githubrepository.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gargpiyush.android.githubrepository.R;
import com.gargpiyush.android.githubrepository.model.OrgRepos;
import com.squareup.picasso.Picasso;

/**
 * Created by Piyush Garg on 3/18/2019 at 22:47.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private OrgRepos orgRepos;

    private Context context;

    public RecyclerViewAdapter(Context context){
        this.context = context;
    }

    public void setItemList(OrgRepos orgRepos){
        this.orgRepos = orgRepos;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        String title = context.getString(R.string.Title) + ": " + orgRepos.getItems()
                .get(viewHolder.getAdapterPosition()).getName();
        String description = context.getString(R.string.Description) + ": "
                + orgRepos.getItems().get(viewHolder.getAdapterPosition()).getDescription();
        String ratings = orgRepos.getItems()
                .get(viewHolder.getAdapterPosition()).getStargazers_count().toString();
        String imageUrl = orgRepos.getItems().get(viewHolder.getAdapterPosition()).getRepoOwner().getAvatar_url();
        ((RecyclerViewHolder)viewHolder).textViews.get(0).setText(title);
        ((RecyclerViewHolder)viewHolder).textViews.get(1).setText(ratings);
        ((RecyclerViewHolder)viewHolder).textViews.get(2).setText(description);
        Picasso.with(context).load(imageUrl).into(((RecyclerViewHolder)viewHolder).imageView);
        ((RecyclerViewHolder)viewHolder).button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = orgRepos.getItems().get(viewHolder.getAdapterPosition()).getHtml_url();
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
                builder.addDefaultShareMenuItem();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(context, Uri.parse(url));
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_layout,
                viewGroup, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public int getItemCount() {
        if (orgRepos == null)
            return 0;
        else
            return orgRepos.getItems().size();
    }
}
