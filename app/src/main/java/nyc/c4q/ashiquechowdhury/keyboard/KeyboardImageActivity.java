package nyc.c4q.ashiquechowdhury.keyboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by ashiquechowdhury on 1/11/17.
 */
public class KeyboardImageActivity extends AppCompatActivity {
    private static final String BASE_URL = "http://jsjrobotics.nyc";
    ImageView keyboardImageView;
    boolean pressedBackOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboardimage);

        keyboardImageView = (ImageView) findViewById(R.id.keyBoardIView);
        Intent intent = getIntent();

        String ImageURL = intent.getStringExtra(KeyViewHolder.KEYBOARDIMAGEURL);
        Picasso.with(this).load(BASE_URL + ImageURL).fit().into(keyboardImageView);
    }

    @Override
    public void onBackPressed() {
        if(pressedBackOnce == false){
            Toast.makeText(this, "Press once more to see List", Toast.LENGTH_LONG).show();
            pressedBackOnce = true;
        }
        else
            super.onBackPressed();
    }
}
