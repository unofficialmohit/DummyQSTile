package com.mg.TileService;

import android.graphics.drawable.Icon;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

import com.mg.tileservice.R;

public class MyTileService extends TileService {
     @Override
    public void onTileAdded() {
        Tile tile = getQsTile();
        if (tile != null) {
            tile.setLabel("Location");
            if(getQsTile().getState()==Tile.STATE_ACTIVE) {
                tile.setSubtitle("On");
            }
            tile.setIcon(Icon.createWithResource(getApplicationContext(), R.drawable.location_on));
            tile.setState(Tile.STATE_ACTIVE);
            tile.updateTile();
        }
    }
    @Override
    public void onClick() {
        if(getQsTile().getState()==Tile.STATE_ACTIVE) {
            getQsTile().setState(Tile.STATE_INACTIVE);
            getQsTile().setIcon(Icon.createWithResource(getApplicationContext(), R.drawable.location_of));
            getQsTile().setSubtitle("Off");
         }
        else
        {
            getQsTile().setIcon(Icon.createWithResource(getApplicationContext(), R.drawable.location_on));
            getQsTile().setState(Tile.STATE_ACTIVE);
            getQsTile().setSubtitle("On");

        }
        getQsTile().updateTile();

}

}