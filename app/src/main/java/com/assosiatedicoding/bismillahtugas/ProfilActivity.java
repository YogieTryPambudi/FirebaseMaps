package com.assosiatedicoding.bismillahtugas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfilActivity extends AppCompatActivity implements View.OnClickListener{
    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private Button buttonLogout;
    private ImageButton buttonAddTower;
    private ImageButton buttonLihatTower;
    private TextView tambahTower;
    private TextView lihatTower;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonAddTower = (ImageButton) findViewById(R.id.buttonAddTower);
        buttonLihatTower = (ImageButton) findViewById(R.id.buttonLihat);
        tambahTower = (TextView)findViewById(R.id.tambah_tower);
        lihatTower = (TextView)findViewById(R.id.lihat_tower);

        //adding listener to button
        buttonLogout.setOnClickListener(this);
        buttonAddTower.setOnClickListener(this);
        buttonLihatTower.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == buttonLogout){
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
        switch (view.getId()){
            case R.id.buttonAddTower:
                Intent moveIntent = new Intent(ProfilActivity.this,FirebaseTambah.class);
                startActivity(moveIntent);
                break;
        }
        switch (view.getId()){
            case R.id.buttonLihat:
                openImagesActivity();
        }
    }
    private void openImagesActivity(){
        Intent intent = new Intent(this,ImagesActivity.class);
        startActivity(intent);
    }
}
