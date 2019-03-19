package com.gargpiyush.android.githubrepository.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gargpiyush.android.githubrepository.R;
import com.gargpiyush.android.githubrepository.adapter.RecyclerViewAdapter;
import com.gargpiyush.android.githubrepository.model.OrgRepos;
import com.gargpiyush.android.githubrepository.viewModel.GitHubRepoViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Piyush Garg on 3/17/2019 at 21:57.
 */
public class MainFragment extends Fragment {

    @BindView(R.id.MainFragmentButton)
    Button button;

    @BindView(R.id.MainFragmentEditText)
    EditText editText;

    @BindViews({R.id.EmptyString,R.id.OrgUnavailable})
    List<TextView> textViews;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private Context context;


    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;

    private GitHubRepoViewModel gitHubRepoViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container,false);
        ButterKnife.bind(this,view);

        context = getContext();

        gitHubRepoViewModel = new GitHubRepoViewModel(getActivity().getApplication());
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerViewAdapter = new RecyclerViewAdapter(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @OnClick(R.id.MainFragmentButton)
    public void search(){
        textViews.get(0).setVisibility(View.INVISIBLE);
        textViews.get(1).setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
        if (!editText.getText().toString().isEmpty()) {
            gitHubRepoViewModel = ViewModelProviders.of(this).get(GitHubRepoViewModel.class);
            gitHubRepoViewModel.getGitHubOrgRepo(editText.getText().toString())
                    .observe(this, new Observer<OrgRepos>() {
                        @Override
                        public void onChanged(@Nullable OrgRepos orgRepos) {
                            if (orgRepos != null) {
                                recyclerView.setVisibility(View.VISIBLE);
                                recyclerViewAdapter.setItemList(orgRepos);
                                recyclerViewAdapter.notifyDataSetChanged();
                            }
                            else{
                                textViews.get(1).setVisibility(View.VISIBLE);
                                recyclerView.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
        }
        else
        {
            textViews.get(0).setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
        }
    }
}
