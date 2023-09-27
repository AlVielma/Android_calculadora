package com.example.practica_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double firstNum; // Almacena el primer número en operaciones matemáticas.
    String operation; // Almacena el tipo de operación seleccionada (+, -, *, /).

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialización de botones y pantalla.
        Button num0 =findViewById(R.id.num0);
        Button num1 =findViewById(R.id.num1);
        Button num2 =findViewById(R.id.num2);
        Button num3 =findViewById(R.id.num3);
        Button num4 =findViewById(R.id.num4);
        Button num5 =findViewById(R.id.num5);
        Button num6 =findViewById(R.id.num6);
        Button num7 =findViewById(R.id.num7);
        Button num8 =findViewById(R.id.num8);
        Button num9 =findViewById(R.id.num9);

        Button on = findViewById(R.id.on);
        Button off = findViewById(R.id.off);
        Button ac = findViewById(R.id.ac);
        Button del = findViewById(R.id.del);
        Button div = findViewById(R.id.div);
        Button times = findViewById(R.id.times);
        Button min = findViewById(R.id.min);
        Button equal = findViewById(R.id.equal);
        Button plus = findViewById(R.id.plus);
        Button point = findViewById(R.id.point);

        TextView screen = findViewById(R.id.screen);

        // Manejo del botón "AC" (Clear All).
        ac.setOnClickListener(view -> {
            firstNum =0;
            screen.setText("0");
        });

        // Manejo del botón "Off" para ocultar la pantalla.
        off.setOnClickListener(view -> screen.setVisibility(View.GONE));

        // Manejo del botón "On" para mostrar la pantalla y restablecerla a "0".
        on.setOnClickListener(view -> {
            screen.setVisibility(View.VISIBLE);
            screen.setText("0");
        });

        ArrayList<Button> nums = new ArrayList<>();
        nums.add(num0);
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        nums.add(num4);
        nums.add(num5);
        nums.add(num6);
        nums.add(num7);
        nums.add(num8);
        nums.add(num9);

        // Inicialización de botones numéricos.
        for (Button b : nums){
            b.setOnClickListener(view -> {
                if (!screen.getText().toString().equals("0")){
                    screen.setText(screen.getText().toString() + b.getText().toString());
                } else {
                    screen.setText(b.getText().toString());
                }
            });
        }

        // Inicialización de botones de operaciones (+, -, *, /).
        ArrayList<Button> opers = new ArrayList<>();
        opers.add(div);
        opers.add(times);
        opers.add(plus);
        opers.add(min);
        // Configurar la acción cuando se pulsa un botón de operación.
        for (Button b : opers){
            b.setOnClickListener(view -> {
                firstNum = Double.parseDouble(screen.getText().toString());
                operation = b.getText().toString();
                screen.setText("0");
            });
        }

        // Manejo del botón "Del" (Eliminar último dígito o borrar todo).
        del.setOnClickListener(view -> {
            String num = screen.getText().toString();
            if (num.length()>1){
                screen.setText(num.substring(0,num.length()-1));
            } else if (num.length()==1 && !num.equals("0")) {
                screen.setText("0");
            }
        });

        // Manejo del botón "Point" (Punto decimal).
        point.setOnClickListener(view -> {
            if (!screen.getText().toString().contains(".")){
                screen.setText(screen.getText().toString() + ".");
            }
        });

        // Manejo del botón "Equal" (Igual, realizar cálculo y mostrar resultado).
        equal.setOnClickListener(view -> {
            double seconNum = Double.parseDouble(screen.getText().toString());
            double result;
            switch (operation){
                case"/":
                    result = firstNum/seconNum;
                    break;
                case"X":
                    result = firstNum*seconNum;
                    break;
                case"+":
                    result = firstNum+seconNum;
                    break;
                case"-":
                    result = firstNum-seconNum;
                    break;
                default:result = firstNum+seconNum;
            }
            screen.setText(String.valueOf(result));
            firstNum = result;
        });
    }
}