package br.com.exadigital.voterregistration;

/**
 * Created by paulosiqueira on 9/6/16.
 */

import java.util.ArrayList;
import java.util.Arrays;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;
import android.os.Bundle;

public class Help extends Activity {

    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);



        // Find the ListView resource.
        mainListView = (ListView) findViewById( R.id.listView );

        // Create and populate a List of Definitions.
        String[] definition = new String[] {
                "Population\n" +
                        "Population is a set of similar items or events. In this app is the estimated number of registrants.\n",
                "Number of kits\n" +
                        "Kit is a set of instruments required to conduct a registration process; each kit should include the material necessary for the enrolment. The registration could be manual (e.g. using pens, forms, paper, envelopes) or electronic, (e.g. biometric registration devices, laptops, tablets, and other gadgets). It’s possible also to have a mixed process with manual and electronic materials.\n",
                "Registered per kit\n" +
                        "Is the average number related with the amount of records each kit has to register.\n",
                "Cost per kit\n" +
                        "Cost per kit is the estimated price necessary to cover the resources for each kit. Include, if necessary, the human resources necessary to support the activity (e.g. two persons per kit).\n",
                "Total cost – kits\n" +
                        "The total cost of kits is the value of each kit multiplied by the number of kits.\n",
                "Cost per person\n" +
                        "Cost per person is the value of the cost of the kits divided by the population.\n",
                "Registration time\n" +
                        "Registration time is the estimated time (expressed in minutes) necessary to register one person.\n",
                "Working hours\n" +
                        "Working hours is the estimated time (expressed in hours) that each registration team will be working per day during the registration process.\n"
        };
        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll( Arrays.asList(definition) );

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);

        // Add more Definitions. If you passed a String[] instead of a List<String>
        // into the ArrayAdapter constructor, you must not add more items.
        // Otherwise an exception will occur.
        listAdapter.add( "Number of working days\n" +
                "Number of working days is the total time necessary to register the whole population based on the informed parameters (time and number of kits).\n" );
        listAdapter.add( "Registration Centres\n" +
                "Registration Centres are the places where the population needs to be allocated in order to register during the registration process.\n " );
        listAdapter.add( "Registered per day per kit\n" +
                "This information is the estimated number of registrants that each kit should register per day.\n" );
        listAdapter.add( "# of Registration Centre per kit\n" +
                "This information shows the number of Registration Centres (RCs) that each kit will need to go in order to cover all RCs. \n" +
                "If the number of kits is superior to the number of RCs, the number of kits that need to be allocated to each RC will be shown.\n" );
        listAdapter.add( "Days in each Registration Centre\n" +
                "This number displays the minimum number of days that each kit need to be placed in the RC.\n" );

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter( listAdapter );



    }
}
