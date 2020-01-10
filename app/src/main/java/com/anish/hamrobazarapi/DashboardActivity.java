package com.anish.hamrobazarapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;


import com.anish.hamrobazarapi.API.ProductAPI;
import com.anish.hamrobazarapi.API.UsersAPI;
import com.anish.hamrobazarapi.adapter.ProductAdapter;
import com.anish.hamrobazarapi.model.Product;
import com.anish.hamrobazarapi.model.User;
import com.anish.hamrobazarapi.url.Url;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {

    private Button btnSignUp;
    ImageView icon;
    Dialog myDialog;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    ViewFlipper vflipper;
    private RecyclerView recyclerView, recyclerViewSecond;

   /* @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.img:

        }
        return true;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        icon = findViewById(R.id.icon);
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadCurrentUser();
                Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        int images[] = {R.drawable.yamaha, R.drawable.car, R.drawable.bike, R.drawable.house, R.drawable.furnitures, R.drawable.music};

        vflipper = findViewById(R.id.vflipper);


        for (int image : images) {
            flipperimages(image);
        }

        //recycleview first
        recyclerView = findViewById(R.id.recyclerView);
        recyclerViewSecond=findViewById(R.id.recyclerViewSecond);

        ProductAPI productAPI = Url.getInstance().create(ProductAPI.class);
        Call<List<Product>> listCall = productAPI.getPopularProduct();
        listCall.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(DashboardActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Product> product = response.body();

                ProductAdapter productAdapter = new ProductAdapter(DashboardActivity.this, product);
                recyclerView.setAdapter(productAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(DashboardActivity.this, LinearLayoutManager.HORIZONTAL, false));
            }



            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(DashboardActivity.this, "failed" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        Call<List<Product>> recentcall = productAPI.getRecentProduct();
        recentcall.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(DashboardActivity.this, "", Toast.LENGTH_SHORT).show();
                    return;
                }
                List<Product> product = response.body();

                ProductAdapter productAdapter = new ProductAdapter(DashboardActivity.this, product);
                recyclerViewSecond.setAdapter(productAdapter);
                recyclerViewSecond.setLayoutManager(new LinearLayoutManager(DashboardActivity.this, LinearLayoutManager.HORIZONTAL, false));


            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(DashboardActivity.this, "failed" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void loadCurrentUser() {

        UsersAPI usersAPI = Url.getInstance().create(UsersAPI.class);
        Call<User> userCall = usersAPI.getUserDetails(Url.token);

        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(DashboardActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                String imgPath = Url.imagePath + response.body().getImage();

                Picasso.get().load(imgPath).into(icon);

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(DashboardActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }

        });
    }

    public void flipperimages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        vflipper.addView(imageView);
        vflipper.setFlipInterval(4000);
        vflipper.setAutoStart(true);

        //animation
        vflipper.setInAnimation(this, android.R.anim.slide_in_left);
        vflipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}