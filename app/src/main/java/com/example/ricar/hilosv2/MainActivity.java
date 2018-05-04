package com.example.ricar.hilosv2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    Button button2;


    ProgressBar progressBar1;
    ProgressBar progressBar2;


    EditText editText;
    EditText editText2;


    AsyncTask hiloConectar;

    int leer1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);




        progressBar1 = (ProgressBar) findViewById(R.id.progressBar);
        progressBar1.setMax(20);
        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        progressBar2.setMax(20);


        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);




        button1.setOnClickListener(this);
        button2.setOnClickListener(this);


    }

    private void UnSegundo() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    public void hilos() {

        new Thread(new Runnable() {
            @Override
            public void run() {

               // String a = editText.getText().toString();
               // int ax = new Integer(a).intValue();

                for (int i = 1; i <= Integer.parseInt(editText.getText().toString()) ; i++) {
                    UnSegundo();
                    progressBar1.setMax(20);
                    progressBar1.setProgress(i);

                }

               // Toast.makeText(getBaseContext(), "Segundos: "+ editText.getText().toString() , Toast.LENGTH_LONG).show();
            }
        }).start();
    }


    public void hilos2() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= Integer.parseInt(editText2.getText().toString()); i++) {
                    UnSegundo();
                    progressBar2.setMax(20);
                    progressBar2.setProgress(i);
                }



}
        }).start();
                }



@Override
    public void onClick(View v) {

        int i;
        switch (v.getId()) {

           case R.id.button:
                hilos();
                break;
            case R.id.button2:
                hilos2();
                break;

            default:
                break;
        }


    }

    public  class AsyncTask_load extends AsyncTask<Void,Integer, Boolean> {
        int numero;
        ProgressBar progressBar;
       // String lol ="";

        public AsyncTask_load(ProgressBar progressBar,int numero) {
            this.numero = numero;
            this.progressBar = progressBar;
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            for (int i=1; i<=numero; i++){
                UnSegundo();
                publishProgress(i);
                if (isCancelled()){
                    break;
                }
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0].intValue());
          //  txtRes.append(values[0].intValue()+" * "+values[2].intValue()+" = "+values[1].intValue()+"\n");
        }
    }


}
