package com.example.santurtzi;

import android.view.KeyEvent;
import android.view.View;

public class A1_OnKeyListener implements View.OnKeyListener
{

    private A1_Cancion parent;

    public A1_OnKeyListener(A1_Cancion parent)
    {
        this.parent=parent;
    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent event)
    {
        // If the event is a key-down event on the "enter" button
        if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                (keyCode == KeyEvent.KEYCODE_ENTER)) {
            // Perform action on key press
            parent.comprobarRespuestas();
            return true;
        }
        return false;
    }

}
