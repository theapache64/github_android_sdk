package com.theapache64.githubandroidsdkexample.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

import com.afollestad.materialdialogs.MaterialDialog;
import com.theapache64.github_android_sdk.GitHubAPI;
import com.theapache64.github_android_sdk.responses.CreateIssueResponse;
import com.theapache64.githubandroidsdkexample.R;
import com.theapache64.githubandroidsdkexample.utils.DialogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateIssueActivity extends BaseAppCompatActivity {


    //Generated with ButterLayout (http://github.com/theapache64/butterLayout): Thu Feb 08 13:22:22 IST 2018
    @BindView(R.id.etAuthorization)
    EditText etAuthorization;

    @BindView(R.id.etOwner)
    EditText etOwner;

    @BindView(R.id.etRepo)
    EditText etRepo;

    @BindView(R.id.etTitle)
    EditText etTitle;

    @BindView(R.id.etBody)
    EditText etBody;

    @BindView(R.id.bCreateIssue)
    Button bCreateIssue;


    private DialogUtils dialogUtils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_issue);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        dialogUtils = new DialogUtils(this);

        etAuthorization.setText(GitHubAPI.getAccessToken());

        etOwner.setText("theapache64");
        etRepo.setText("lab");
        etTitle.setText("Sample title");
        etBody.setText("Sample body");

        enableBackNavigation();

    }

    @OnClick(R.id.bCreateIssue)
    public void onCreateIssueClicked() {

        final MaterialDialog progressDialog = dialogUtils.getProgressDialog(R.string.Creating_issue);
        progressDialog.show();

        GitHubAPI.createIssue(
                etOwner.getText().toString(),
                etRepo.getText().toString(),
                etTitle.getText().toString(),
                etBody.getText().toString(), new GitHubAPI.Callback<CreateIssueResponse>() {
                    @Override
                    public void onSuccess(CreateIssueResponse createIssueResponse) {
                        progressDialog.dismiss();
                        dialogUtils.showSimpleDialog(R.string.Success, R.string.Issue_created);
                    }

                    @Override
                    public void onError(Throwable t) {
                        progressDialog.dismiss();
                        dialogUtils.showErrorDialog(t.getMessage());
                    }
                });

    }


}
