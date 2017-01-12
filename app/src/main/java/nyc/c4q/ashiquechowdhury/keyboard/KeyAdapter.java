package nyc.c4q.ashiquechowdhury.keyboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.ashiquechowdhury.keyboard.model.Keys;

/**
 * Created by ashiquechowdhury on 1/11/17.
 */
public class KeyAdapter extends RecyclerView.Adapter<KeyViewHolder> {
    private List<Keys> myKeys;

    public KeyAdapter(List<Keys> myKeys) {
        this.myKeys = myKeys;
    }

    @Override
    public KeyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View childView = inflater.inflate(R.layout.key_row, parent, false);
        return new KeyViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(KeyViewHolder holder, int position) {
        holder.bind(myKeys.get(position));
    }

    @Override
    public int getItemCount() {
        return myKeys.size();
    }
}
