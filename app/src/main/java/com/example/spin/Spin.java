package com.example.spin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Spin extends AppCompatActivity {
    LuckyWheel luckyWheel;
    List<WheelItem> wheelItemList=new ArrayList<>();
    String points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin);
        luckyWheel=findViewById(R.id.luckywheel);

        WheelItem wheelItem= new WheelItem(ResourcesCompat.getColor(getResources(),R.color.ten,null), BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_action_name),"10");
        wheelItemList.add(wheelItem);
        WheelItem wheelItem1= new WheelItem(ResourcesCompat.getColor(getResources(),R.color.fifteen,null), BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_action_name),"15");
        wheelItemList.add(wheelItem1);
        WheelItem wheelItem2= new WheelItem(ResourcesCompat.getColor(getResources(),R.color.twenty,null), BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_action_name),"20");
        wheelItemList.add(wheelItem2);
        WheelItem wheelItem3= new WheelItem(ResourcesCompat.getColor(getResources(),R.color.ten,null), BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_action_name),"10");
        wheelItemList.add(wheelItem3);
        WheelItem wheelItem4= new WheelItem(ResourcesCompat.getColor(getResources(),R.color.fifteen,null), BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_action_name),"15");
        wheelItemList.add(wheelItem4);
        WheelItem wheelItem5= new WheelItem(ResourcesCompat.getColor(getResources(),R.color.twenty,null), BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_action_name),"20");
        wheelItemList.add(wheelItem5);

        luckyWheel.addWheelItems(wheelItemList);

        luckyWheel.setLuckyWheelReachTheTarget(new OnLuckyWheelReachTheTarget() {
            @Override
            public void onReachTarget() {
                WheelItem itemSelected= wheelItemList.get(Integer.parseInt(points)-1);
                String points_amount = itemSelected.text;

                TextView number = findViewById(R.id.number);
                number.setText(points_amount);
            }
        });

    }

    public void btnClick(View v)
    {
        Random random = new Random();
        points = String.valueOf(random.nextInt(6));
        if(points.equals("0")){
            points=String.valueOf(1);
        }
        luckyWheel.rotateWheelTo(Integer.parseInt(points));
    }
}