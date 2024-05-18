package busit.treefg1.myapi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener {

//    my List
    List<Item> items = new ArrayList<>();

//    my API
    String recipes = "https://dummyjson.com/recipes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);


//      Create Request
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,recipes,null,
                response -> {

                    try {
                        JSONArray x = response.getJSONArray("recipes");

                        for (int i = 0; i < x.length(); i++) {
                            JSONObject userObject = x.getJSONObject(i);
                            items.add(new Item(userObject.getString("name"), "the book is not for sale", R.drawable.medusa));
                        }
                        //        ilagay sa recyclerview
                        MyAdapter adapter = new MyAdapter(getApplicationContext(), items, this);
                        recyclerView.setLayoutManager(new LinearLayoutManager(this));
                        recyclerView.setAdapter(adapter);

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                },
                error -> {

                }
                );
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(req);

    }

    @Override
    public void onItemClick(int position) {
        // Handle item click here, for example, navigate to another activity with item details
        Item clickedItem = items.get(position);
        Intent intent = new Intent(this, ItemDetailsActivity.class);
        intent.putExtra("name", clickedItem.getName());
        intent.putExtra("description", clickedItem.getDiscription());
        intent.putExtra("image", clickedItem.getImage());
        startActivity(intent);
    }
}
