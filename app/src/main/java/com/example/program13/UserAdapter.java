package com.example.program13;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private ArrayList<UserModal> userModalArrayList;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView userName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.usertext);
        }
    }

    public UserAdapter(ArrayList<UserModal> userModalArrayList, Context context)
    {
        this.userModalArrayList = userModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserModal modal = userModalArrayList.get(position);
        holder.userName.setText(modal.getUserName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, UpdateActivity.class);
                i.putExtra("name", modal.getUserName());
                i.putExtra("email", modal.getEmail());
                i.putExtra("phone", modal.getPhone());
                i.putExtra("password", modal.getPassword());
                i.putExtra("cpassowrd", modal.getConfrmPassword());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userModalArrayList.size();
    }
}

