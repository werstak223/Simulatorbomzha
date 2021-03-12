package space.mark.simulatorbomzha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import space.mark.simulatorbomzha.General.*;
import space.mark.simulatorbomzha.Places.*;

public class MainActivity extends AppCompatActivity {
    private long backpressedTime;
    private Toast backToast;
    public Person man;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        man=new Person();

        Button start=(Button)findViewById(R.id.startbtn);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    try {
                        Intent intent = new Intent(MainActivity.this, Home.class);
                        intent.putExtra("person",man);
                        startActivity(intent);
                        finish();
                    }catch (Exception e){}
            }
        });


    }

    @Override
    public void onBackPressed(){

        if(backpressedTime>System.currentTimeMillis()-2000){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
            backToast=Toast.makeText(getBaseContext(),"Нажмите еще раз, чтобы выйти.", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backpressedTime=System.currentTimeMillis();
    }
}