package space.mark.simulatorbomzha.Places;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import space.mark.simulatorbomzha.General.Person;
import space.mark.simulatorbomzha.MainActivity;
import space.mark.simulatorbomzha.R;

public class bolvanka extends AppCompatActivity{
    Person man;
    TextView fenergy,fmoney;
    TextView fgolod,fdosug,fobchenie;
    Button homebtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        //Объявление всех элементов на экране
        fenergy=(TextView)findViewById(R.id.fenergy);
        fmoney=(TextView)findViewById(R.id.fmoney);
        homebtn=(Button)findViewById(R.id.homebtn);

        man = (Person) getIntent().getSerializableExtra("person");




        //////Нажатие кнопок
        //////Переход домой
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bolvanka.this,Home.class);
                intent.putExtra("person",man);
                startActivity(intent);finish();
            }
        });



        update();
    }


    //Стандартные методы
    public void update(){
        fmoney.setText(String.valueOf(man.money));
        fenergy.setText(String.valueOf(man.energy));

    }

    @Override
    public void onBackPressed(){
        try{
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);finish();
            man=null;
        }catch (Exception e){}

    }

}