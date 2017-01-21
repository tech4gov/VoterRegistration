package br.com.exadigital.voterregistration;

/**
 * Created by paulo siqueira on 9/6/16.
 */


import java.util.ArrayList;
import java.util.Arrays;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;
import android.os.Bundle;

public class About extends Activity {

    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        // Find the ListView resource.
        mainListView = (ListView) findViewById( R.id.listView );

        // Create and populate a List of Definitions.
        String[] definition = new String[] {
                //"About\n" +
                        "Technology for Governance - a free apps project.\n" +
                        "\n" +
                        "This app has been developed with the support of Paulo Siqueira, an experienced international electoral specialist, with strong background in ICT and voter registration. \n" +
                        "Through this app Paulo aims to give an extra tool to professionals working for Governments and Electoral Management Bodies during the planning of a registration exercise.\n" +
                        "Paulo seeks to transfer to the app some basic knowledge related with the planning of registration activities. It’s a free tool to all practitioners and professionals of civil and voter registration.\n" +
                        "Please, contact Paulo and provide suggestions for improvements, comments, clarifications, bugs, and corrections using the email: technologyforgovernance@gmail.com\n" +
                        "\n"
        };
        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll( Arrays.asList(definition) );

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);

        // Add more Definitions. If you passed a String[] instead of a List<String>
        // into the ArrayAdapter constructor, you must not add more items.
        // Otherwise an exception will occur.
       /* listAdapter.add( "Number of working days\n" +
                "This number displays the minimum number of days that each kit need to be placed in the RC.\n" );
*/
        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter( listAdapter );
    }


}
