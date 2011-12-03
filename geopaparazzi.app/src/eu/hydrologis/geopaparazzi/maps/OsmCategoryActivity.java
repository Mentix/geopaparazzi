/*
 * Geopaparazzi - Digital field mapping on Android based devices
 * Copyright (C) 2010  HydroloGIS (www.hydrologis.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package eu.hydrologis.geopaparazzi.maps;

import java.sql.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;
import eu.hydrologis.geopaparazzi.R;
import eu.hydrologis.geopaparazzi.database.DaoNotes;
import eu.hydrologis.geopaparazzi.maps.TagsManager.TagObject;
import eu.hydrologis.geopaparazzi.osm.OsmTagsManager;
import eu.hydrologis.geopaparazzi.util.Constants;
import eu.hydrologis.geopaparazzi.util.debug.Logger;

/**
 * Osm category activity showing the available tags.
 * 
 * @author Andrea Antonello (www.hydrologis.com)
 */
public class OsmCategoryActivity extends Activity {

    public void onCreate( Bundle icicle ) {
        super.onCreate(icicle);
        setContentView(R.layout.osmcategorytags);

        Bundle extras = getIntent().getExtras();
        String category = extras.getString(Constants.OSM_CATEGORY_KEY);

        final String[] itemsForCategory = OsmTagsManager.getInstance().getItemsForCategory(this, category);

        GridView buttonGridView = (GridView) findViewById(R.id.osmtagsgridview);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.gpslog_row, itemsForCategory){
            public View getView( final int position, View cView, ViewGroup parent ) {

                Button osmButton = new Button(OsmCategoryActivity.this);
                osmButton.setText(itemsForCategory[position]);
                // osmButton.setImageResource(R.drawable.gps);
                osmButton.setOnClickListener(new Button.OnClickListener(){
                    public void onClick( View v ) {
                    }
                });

                return osmButton;
            }
        };

        // setListAdapter(arrayAdapter);
        buttonGridView.setAdapter(arrayAdapter);
    }
}
