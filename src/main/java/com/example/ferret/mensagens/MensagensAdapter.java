package com.example.ferret.mensagens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ferret.R;

import java.util.List;

public class MensagensAdapter<Static> extends RecyclerView.Adapter<MensagensAdapter.MyViewHolder> {

    private List<MensagensList> messagesList = null;
    private final Context context;

    public MensagensAdapter(List<MensagensList> messagesListList, Context context) {
        this.messagesList = messagesList;
        this.context = context;
    }

    @NonNull
    @Override
    public MensagensAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mensagens_adapter,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MensagensAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }
    static class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView profilePic;
        private TextView name;
        private TextView lastMessage;
        private TextView unseeMessages;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            profilePic = itemView.findViewById(R.id.profilePic);
            name = itemView.findViewById(R.id.name);
            lastMessage = itemView.findViewById(R.id.lastMessage);
            unseeMessages = itemView.findViewById(R.id.unssenMessages);

        }
    }
}
