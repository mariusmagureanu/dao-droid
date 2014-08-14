package com.svs.manager.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.svs.manager.R;
import com.svs.manager.entities.User;

import java.util.HashMap;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public class UserListAdapter extends BaseAdapter {

    private HashMap<Integer, User> users;
    private LayoutInflater inflater;

    public UserListAdapter(final HashMap<Integer, User> users) {
        this.users = users;
    }

    @Override
    public int getCount() {
        return this.users.size();
    }

    @Override
    public Object getItem(int i) {
        return this.users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (this.inflater == null) {
            this.inflater = LayoutInflater.from(viewGroup.getContext());

        }
        if (view == null) {
            view = this.inflater.inflate(R.layout.user_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.firstNameTextView = (TextView) view.findViewById(R.id.firstNameTextView);
            viewHolder.lastNameTextView = (TextView) view.findViewById(R.id.lastNameTextView);
            viewHolder.userNameTextView = (TextView) view.findViewById(R.id.usernameTextView);
            viewHolder.passwordTextView = (TextView) view.findViewById(R.id.passwordTextView);
            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        final User currentUser = this.users.get(i);

        viewHolder.firstNameTextView.setText(currentUser.getFirstName());
        viewHolder.lastNameTextView.setText(currentUser.getLastName());
        viewHolder.userNameTextView.setText(currentUser.getUserName());
        viewHolder.passwordTextView.setText(currentUser.getPassword());

        return view;
    }

    static class ViewHolder {
        public TextView firstNameTextView;
        public TextView lastNameTextView;
        public TextView userNameTextView;
        public TextView passwordTextView;
    }
}
