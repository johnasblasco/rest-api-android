package busit.treefg1.myapi;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        // Get data from intent
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");
        int imageResource = getIntent().getIntExtra("image", 0);

        // Display item details
        TextView nameTextView = findViewById(R.id.item_name);
        TextView descriptionTextView = findViewById(R.id.item_description);
        ImageView imageView = findViewById(R.id.item_image);

        nameTextView.setText(name);
        descriptionTextView.setText(description);
        imageView.setImageResource(imageResource);
    }
}
