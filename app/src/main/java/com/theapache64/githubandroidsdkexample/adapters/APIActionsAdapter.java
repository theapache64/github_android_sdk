package com.theapache64.githubandroidsdkexample.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.theapache64.githubandroidsdkexample.R;
import com.theapache64.githubandroidsdkexample.models.APIAction;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by theapache64 on 8/2/18.
 */

public class APIActionsAdapter extends RecyclerView.Adapter<APIActionsAdapter.ViewHolder> {

    private final List<APIAction> apiActions;
    private final LayoutInflater inflater;
    private final Callback callback;
    private Context context;

    public APIActionsAdapter(Context context, List<APIAction> apiActions, Callback callback) {
        this.context = context;
        this.apiActions = apiActions;
        this.inflater = LayoutInflater.from(context);
        this.callback = callback;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.api_actions_row, parent, false));
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvAPIActionTitle.setText(String.format("%d . %s", (position + 1), context.getString(apiActions.get(position).getTitle())));
    }

    @Override
    public int getItemCount() {
        return apiActions.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        //Generated with ButterLayout (http://github.com/theapache64/butterLayout): Thu Feb 08 12:47:32 IST 2018
        @BindView(R.id.tvAPIActionTitle)
        TextView tvAPIActionTitle;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.tvAPIActionTitle)
        public void onActionClicked() {
            callback.onItemClicked(getLayoutPosition());
        }

    }

    public interface Callback {
        void onItemClicked(int position);
    }
}
