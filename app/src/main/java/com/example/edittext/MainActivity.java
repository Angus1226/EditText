package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button btn1,btn2;
EditText et1,et2,et3;
TextView tv1;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        et1=(EditText)findViewById(R.id.editText1);
        et2=(EditText)findViewById(R.id.editText2);
        et3=(EditText)findViewById(R.id.editText3);
        tv1=(TextView)findViewById(R.id.textView4);

        View.OnClickListener OCL=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=((Button)v).getId();
                switch(id){
                    case R.id.button1:
                        String s1=et1.getText().toString(); //抓取物件轉成字串
                        int n1=Integer.parseInt(s1);       //將s1轉成數字
                        String s2=et2.getText().toString();
                        int n2=Integer.parseInt(s2);
                        String s3=et3.getText().toString();
                        double n3=Double.parseDouble(s3);   //可輸入小數點數值
                        double  sum=n1+n2+n3;
                        double avg=(n1+n2+n3)/3;
                        /*tv1.setText("總分:"+sum+"分,平均:"+avg+"分"); setText只接受文字跟整數(realsource ID 字串檔內代號)
                           所以只給常數會錯誤,而setＴext只會顯示一行如果多行會被覆蓋*/

                        tv1.append("\n國文"+s1+ "\n英文"+s2+ "\n數學"+s3+"\n總分:"+sum+"分,\n平均:"+avg+"分");
                        //使用append可以復加但不會自動換行
                        tv1.append((avg>60)?"恭喜及格！":"抱歉不及格！！");
                        switch((int)(avg/10)){
                            case 10:
                            case 9:
                                tv1.append("A\n");
                                break;
                            case 8:
                                tv1.append("B\n");
                                break;
                            case 7:
                                tv1.append("C\n");
                                break;
                            case 6:
                                tv1.append("D\n");
                                break;
                                default:
                                    tv1.append("E\n");
                        }
                    break;
                    case R.id.button2:
                        et1.setText(" ");
                        et2.setText(" ");
                        et3.setText(" ");
                        tv1.setText(" ");
                        break;

                }
            }
        };
        btn1.setOnClickListener(OCL);
        btn2.setOnClickListener(OCL);
    }
}
