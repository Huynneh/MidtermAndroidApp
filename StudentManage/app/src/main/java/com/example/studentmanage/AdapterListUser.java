package com.example.studentmanage;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AdapterListUser extends ArrayAdapter<UserInfo> {

    private ArrayList<UserInfo> listUser;
    private Context context;
    public AdapterListUser(@NonNull Context context, int resource, @NonNull List<UserInfo> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_user, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.name);
            viewHolder.tvPos = convertView.findViewById(R.id.tvPos);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        UserInfo user = listUser.get(position);
        viewHolder.name.setText(user.getName());
        viewHolder.tvPos.setText(user.getPosition());

        return convertView;
    }

    static class ViewHolder {
        TextView name;
        TextView tvPos;
    }
}