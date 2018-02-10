package com.theapache64.githubandroidsdkexample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.theapache64.githubandroidsdkexample.R;
import com.theapache64.githubandroidsdkexample.adapters.APIActionsAdapter;
import com.theapache64.githubandroidsdkexample.models.APIAction;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements APIActionsAdapter.Callback {

    private static List<APIAction> apiActions = new ArrayList<>();

    static {
        apiActions.add(new APIAction(R.id.actionCreateIssue, R.string.Create_Issue));
        apiActions.add(new APIAction(R.id.actionCreateComment, R.string.Create_Comment));
    }


    @BindView(R.id.rvAPIActions)
    RecyclerView rvAPIActions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        APIActionsAdapter apiActionsAdapter = new APIActionsAdapter(this, apiActions, this);
        rvAPIActions.setLayoutManager(new LinearLayoutManager(this));
        rvAPIActions.setAdapter(apiActionsAdapter);
    }


    @Override
    public void onItemClicked(int position) {

        switch (apiActions.get(position).getId()) {
            case R.id.actionCreateIssue:
                CreateIssueActivity.start(this, CreateIssueActivity.class);
                break;

            case R.id.actionCreateComment:
                CreateCommentActivity.start(this, CreateCommentActivity.class);
                break;
        }

    }
}
