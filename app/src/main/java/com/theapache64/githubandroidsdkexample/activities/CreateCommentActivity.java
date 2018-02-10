package com.theapache64.githubandroidsdkexample.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import com.afollestad.materialdialogs.MaterialDialog;
import com.theapache64.github_android_sdk.GitHubAPI;
import com.theapache64.github_android_sdk.responses.CreateCommentResponse;
import com.theapache64.githubandroidsdkexample.R;
import com.theapache64.githubandroidsdkexample.utils.DialogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateCommentActivity extends BaseAppCompatActivity {

    //Generated with ButterLayout (http://github.com/theapache64/butterLayout): Thu Feb 08 18:17:12 IST 2018
    @BindView(R.id.etAuthorization)
    EditText etAuthorization;

    @BindView(R.id.etOwner)
    EditText etOwner;

    @BindView(R.id.etRepo)
    EditText etRepo;

    @BindView(R.id.etIssueNumber)
    EditText etIssueNumber;

    @BindView(R.id.etBody)
    EditText etBody;

    private DialogUtils dialogUtils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_comment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        dialogUtils = new DialogUtils(this);

        etAuthorization.setText(GitHubAPI.getAccessToken());
        etOwner.setText("theapache64");
        etRepo.setText("lab");
        etIssueNumber.setText("1");
        etBody.setText("Sample comment");

        enableBackNavigation();
    }

    @OnClick(R.id.bCreateComment)
    public void onCreateCommentClicked() {

        final MaterialDialog progressDialog = dialogUtils.getProgressDialog(R.string.Creating_comment);
        progressDialog.show();

        GitHubAPI.createComment(
                etOwner.getText().toString(),
                etRepo.getText().toString(),
                Integer.parseInt(etIssueNumber.getText().toString()),
                etBody.getText().toString(),
                new GitHubAPI.Callback<CreateCommentResponse>() {

                    @Override
                    public void onSuccess(CreateCommentResponse createCommentResponse) {
                        progressDialog.dismiss();
                        dialogUtils.showSimpleDialog(R.string.Success, R.string.Comment_created);
                    }

                    @Override
                    public void onError(Throwable t) {
                        progressDialog.dismiss();
                        dialogUtils.showErrorDialog(t.getMessage());
                    }

                });

    }

}
