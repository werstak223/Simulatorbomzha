package space.mark.simulatorbomzha.Places;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import space.mark.simulatorbomzha.General.Person;
import space.mark.simulatorbomzha.MainActivity;
import space.mark.simulatorbomzha.R;

public class Home extends AppCompatActivity{
    Person man;
    TextView fenergy,fmoney;
    TextView fgolod,fdosug,fobchenie;
    Button sleepbtn,eatbtn,playbtn,obcheniebtn,shopbtn,apartmentbtn,zarabotokbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        //Объявление всех элементов на экране
        fenergy=(TextView)findViewById(R.id.fenergy);
        fmoney=(TextView)findViewById(R.id.fmoney);
        fgolod=(TextView)findViewById(R.id.fgolod);
        fdosug=(TextView)findViewById(R.id.fdosug);
        fobchenie=(TextView)findViewById(R.id.fobchenie);
        sleepbtn=(Button)findViewById(R.id.sleepbtn);
        eatbtn=(Button)findViewById(R.id.eatbtn);
        playbtn=(Button)findViewById(R.id.playbtn);
        obcheniebtn=(Button)findViewById(R.id.communicatebtn);
        shopbtn=(Button)findViewById(R.id.shopbtn);
        apartmentbtn=(Button)findViewById(R.id.apartmentbtn);
        zarabotokbtn=(Button)findViewById(R.id.zarabotokbtn);



        man = (Person) getIntent().getSerializableExtra("person");




        //////Нажатие кнопок
        sleepbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(man.energy<100){
                    man.energy=100;
                }else {
                    Toast toast;
                    toast=Toast.makeText(getBaseContext(),"Вы уже выспались!",Toast.LENGTH_SHORT);
                    toast.show();
                }
                update();
            }
        });
        ///////
        eatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                man.energy+=5;
                man.money-=5;
                update();
            }
        });
        ///////
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                man.energy-=10;
                man.dosug+=5;
                update();
            }
        });
        //////////
        obcheniebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                man.energy-=7;
                man.obchenie+=3;
                update();
            }
        });
        ///// Переход в магазин
        shopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,Shop.class);
                intent.putExtra("person",man);
                startActivity(intent);finish();
            }
        });
        ///////////////////////
        ///// Переход в недвижимость
        apartmentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,Nedvizhimost.class);
                intent.putExtra("person",man);
                startActivity(intent);finish();
            }
        });
        ///////////////////////
        ///// Переход в заработок
        zarabotokbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,Zarabotok.class);
                intent.putExtra("person",man);
                startActivity(intent);finish();
            }
        });
        ///////////////////////




        update();
    }


    //Стандартные методы
    public void update(){
        fmoney.setText(String.valueOf(man.money));
        fenergy.setText(String.valueOf(man.energy));
        fgolod.setText(String.valueOf(man.golod));
        fdosug.setText(String.valueOf(man.dosug));
        fobchenie.setText(String.valueOf(man.obchenie));

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