package nyc.c4q.ashiquechowdhury.keyboard;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.ashiquechowdhury.keyboard.model.Keys;

/**
 * Created by ashiquechowdhury on 1/11/17.
 */
public class KeyViewHolder extends RecyclerView.ViewHolder{
    private TextView keyBoardTView;
    public static final String KEYBOARDIMAGEURL = "nyc.c4q.ashiquechowdhury.URL";

    public KeyViewHolder(View itemView) {
        super(itemView);
        keyBoardTView = (TextView) itemView.findViewById(R.id.keyboardTview);
    }

    public void bind(final Keys keys) {
        keyBoardTView.setText(keys.getName());
        int color = Color.parseColor(keys.getTextColor());
        keyBoardTView.setTextColor(color);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), KeyboardImageActivity.class);
                intent.putExtra(KEYBOARDIMAGEURL, keys.getUrl());
                itemView.getContext().startActivity(intent);
            }
        });
    }
}
