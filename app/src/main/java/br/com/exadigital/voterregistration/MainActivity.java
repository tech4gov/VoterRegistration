package br.com.exadigital.voterregistration;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Gravity;
import android.widget.*;
import static android.widget.Toast.*;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {


    // Declaração de variaveis
    EditText editTextNumberofKits, editTextCostPerKit;
    EditText editTextPopulation, editTextRegistrationTime, editTextWorkingHours, editTextRegistrationCentres;
    TextView numberofkits,numberofdays,numberofregistrationcentreperkit,numberofregisteredpdaypkit,numberofdaysineachregistrationcentre, totalcostofkits, costperperson;
    TextView textViewPopulation,textViewNumberofkits,textViewRegistrationCentres,textViewCostperkit,textViewRegistrationTime, textViewWorkingHours;
    Double number1=0.0;
    Double number2=0.0;
    Double number3=0.0;
    Double number4= 0.0;
    Double number5=0.0;
    Double doubleditTextCostPerKit= 0.0;
    String stringnumberofdays;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    textViewPopulation                      = (TextView)findViewById(R.id.textViewPopulation);
                    textViewNumberofkits                    = (TextView)findViewById(R.id.textViewNumberofkits);
                    textViewRegistrationCentres             = (TextView)findViewById(R.id.textViewRegistrationCentres);
                    textViewCostperkit                      = (TextView)findViewById(R.id.textViewCostperkit);
                    textViewRegistrationTime                = (TextView)findViewById(R.id.textViewRegistrationTime);
                    textViewWorkingHours                    = (TextView)findViewById(R.id.textViewWorkingHours);

                    editTextPopulation                      = (EditText)findViewById(R.id.editTextPopulation);
                    editTextNumberofKits                    = (EditText)findViewById(R.id.editTextNumberofKits);
                    editTextRegistrationTime                = (EditText)findViewById(R.id.editTextRegistrationTime);
                    editTextWorkingHours                    = (EditText)findViewById(R.id.editTextWorkingHours);
                    editTextRegistrationCentres             = (EditText)findViewById(R.id.editTextRegistrationCentres);
                    editTextCostPerKit                      = (EditText)findViewById(R.id.editTextCostPerKit);

                    numberofkits                            = (TextView)findViewById(R.id.textViewRegistered);
                    numberofdays                            = (TextView)findViewById(R.id.textViewNumberofDays);
                    numberofregistrationcentreperkit        = (TextView)findViewById(R.id.textViewNumberofKitsPRegistration);
                    numberofregisteredpdaypkit              = (TextView)findViewById(R.id.textViewRegisterdPDayPKIT);
                    numberofdaysineachregistrationcentre    = (TextView)findViewById(R.id.textViewDaysinEachRegistrationCentre);
                    totalcostofkits                         = (TextView)findViewById(R.id.textViewTotalCost);
                    costperperson                           = (TextView)findViewById(R.id.textView12CostPPerson);

                   //Formata o campo edittext com virglas decimais
                        String num = editTextPopulation.getText().toString(); //number1.toString();
                        num = new StringBuilder(num).reverse().toString().replaceAll("(\\d{3})", "$1,");
                        num = new StringBuilder(num).reverse().toString().replaceAll("^,|,$", "");
                        textViewPopulation.setText("Population: " + num);

                        num = editTextNumberofKits.getText().toString(); //number1.toString();
                        num = new StringBuilder(num).reverse().toString().replaceAll("(\\d{3})", "$1,");
                        num = new StringBuilder(num).reverse().toString().replaceAll("^,|,$", "");
                        textViewNumberofkits.setText("Number of kits: " + num);

                        num = editTextRegistrationCentres.getText().toString(); //number1.toString();
                        num = new StringBuilder(num).reverse().toString().replaceAll("(\\d{3})", "$1,");
                        num = new StringBuilder(num).reverse().toString().replaceAll("^,|,$", "");
                        textViewRegistrationCentres.setText("Registration Centres: " + num);

                        num = editTextCostPerKit.getText().toString(); //number1.toString();
                        num = new StringBuilder(num).reverse().toString().replaceAll("(\\d{3})", "$1,");
                        num = new StringBuilder(num).reverse().toString().replaceAll("^,|,$", "");
                        textViewCostperkit.setText("Cost per kit: $ " + num);

                        num = editTextWorkingHours.getText().toString(); //number1.toString();
                        num = new StringBuilder(num).reverse().toString().replaceAll("(\\d{3})", "$1,");
                        num = new StringBuilder(num).reverse().toString().replaceAll("^,|,$", "");
                        textViewWorkingHours.setText("Working hours: " + num);

                        num = editTextRegistrationTime.getText().toString(); //number1.toString();
                        num = new StringBuilder(num).reverse().toString().replaceAll("(\\d{3})", "$1,");
                        num = new StringBuilder(num).reverse().toString().replaceAll("^,|,$", "");
                        textViewRegistrationTime.setText("Registration time (minutes): " + num);

                    try {
                        number1 = Double.parseDouble(editTextPopulation.getText().toString());
                    } catch (NumberFormatException e) {
                        number1 = 0.0;
                    }
                    try {
                        number2 = Double.parseDouble(editTextNumberofKits.getText().toString());
                    } catch (NumberFormatException e) {
                        number2 = 0.0;
                    }
                    try {
                        number3 = Double.parseDouble(editTextRegistrationTime.getText().toString());
                    } catch (NumberFormatException e) {
                        number3 = 0.0;
                    }
                    try {
                        number4 = Double.parseDouble(editTextWorkingHours.getText().toString());
                    } catch (NumberFormatException e) {
                        number4 = 0.0;
                    }
                    try {
                        number5 = Double.parseDouble(editTextRegistrationCentres.getText().toString());
                    } catch (NumberFormatException e) {
                        number5 = 0.0;
                    }
                    try {
                        doubleditTextCostPerKit = Double.parseDouble(editTextCostPerKit.getText().toString());
                    } catch (NumberFormatException e) {
                        doubleditTextCostPerKit = 0.0;
                    }

                    //===================
                    // 1 - Registered per kit
                    double registerdpkit = (number1/number2);


                    if (Double.isNaN(registerdpkit)){
                        numberofkits.setText("Registered per kit: 0");
                    } else {
                        String stringnumberofkits = String.format("%,.1f",registerdpkit);
                        numberofkits.setText("Registered per kit: " + stringnumberofkits);
                    }



                    //===================
                    // 2  - Number of days necessary
                    //  Calcula o mumero de total de minutos necessarios para o registro
                    //  pega-se o valor do numero de pessoas per kit e se multiplica pelo tempo necessário para cada registro
                    //Total time in minutes
                    double totalMinutos = registerdpkit * number3;
                    //Calculo de minutos por dia
                    double minutosDay = (60*number4); // 60 minutos vezes o numero de horas trabalhadas
                    double doublenumberofdays = totalMinutos/minutosDay;
                    if (Double.isNaN(doublenumberofdays)){
                        numberofdays.setText("# of working days: 0");
                    } else {
                        stringnumberofdays = String.format("%,.1f",doublenumberofdays);
                        numberofdays.setText("# of working days: "+ stringnumberofdays);
                    }





                    //=====
                    // 3 - total of registerd per day per kit
                    double registerdperdayperkit = registerdpkit/doublenumberofdays;


                    if (Double.isNaN(registerdperdayperkit)){
                        numberofregisteredpdaypkit.setText("Registered p/day p/kit: 0");
                    } else {
                        String stringregisterdpkit = String.format("%,.1f",registerdperdayperkit);
                        numberofregisteredpdaypkit.setText("Registered p/day p/kit: " + stringregisterdpkit);
                    }



                    //=====
                    // 4 - Number of Registration Centre per kit
                    double numberofregistrationcentrepkit;
                    if (number5 < number2) {
                        numberofregistrationcentrepkit = number2 / number5;


                        if (Double.isNaN(numberofregistrationcentrepkit)){
                            numberofregistrationcentreperkit.setText("# of kits p/Registration Centre: 0");
                        } else {
                            String stringnumberofregistrationcentreperkit = String.format("%,.1f", numberofregistrationcentrepkit);
                            numberofregistrationcentreperkit.setText("# of kits p/Registration Centre: " + stringnumberofregistrationcentreperkit);
                        }

                    } else {
                        numberofregistrationcentrepkit = number5 / number2;

                        if (Double.isNaN(numberofregistrationcentrepkit)){
                            numberofregistrationcentreperkit.setText("# of Registration Centres p/kit: 0");
                        } else {
                            String stringnumberofregistrationcentreperkit = String.format("%,.1f", numberofregistrationcentrepkit);
                            numberofregistrationcentreperkit.setText("# of Registration Centres p/kit: " + stringnumberofregistrationcentreperkit);
                        }
                    }

                    //=====
                    //5  - Number of days in each reagistrion centre
                    double daysineachregistrationcentre = doublenumberofdays/numberofregistrationcentrepkit;
                    if (number2 > number5){


                        if (Double.isNaN(daysineachregistrationcentre)){
                            numberofdaysineachregistrationcentre.setText("Kits - # of days p/ Registration Centre: 0");
                        } else {
                            numberofdaysineachregistrationcentre.setText("Kits - # of days p/ Registration Centre: " + stringnumberofdays);
                        }


                    } else{
                        daysineachregistrationcentre = doublenumberofdays/numberofregistrationcentrepkit;
                        if (Double.isNaN(daysineachregistrationcentre)){
                            numberofdaysineachregistrationcentre.setText("Kits - # of days p/ Registration Centre: 0");
                        } else {
                            String stringdaysineachregistrationcentre = String.format("%,.1f",daysineachregistrationcentre);
                            numberofdaysineachregistrationcentre.setText("Kits - # of days p/ Registration Centre: " + stringdaysineachregistrationcentre);
                        }
                    }


                    //=====
                    //6 - Total Cost of kits
                    double doublediCostPerKit = doubleditTextCostPerKit*number2;
                    String stringtotalcostperkit = String.format("$ %,.0f",doublediCostPerKit);
                    totalcostofkits.setText("Kits - Total Cost: " + stringtotalcostperkit);

                    //=====
                    //6 - Cost per person
                    double doublediCostPerPerson = doublediCostPerKit/number1;

                    if (Double.isNaN(doublediCostPerPerson)){
                        numberofdaysineachregistrationcentre.setText("Registration cost p/person: $ 0");
                    } else {
                        String stringcostperperson = String.format("$ %,.2f",doublediCostPerPerson);
                        costperperson.setText("Registration cost p/person: " + stringcostperperson);
                    }


                    Snackbar.make(view, "Processed!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, Help.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_help) {
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
            //showMsg("Deu certo");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
/*    private void showMsg(String msg) {
        Toast toast = makeText(MainActivity.this, msg, LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, toast.getXOffset() / 2, toast.getYOffset() / 2);
        toast.show();
    }*/
}
