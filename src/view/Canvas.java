/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import org.jdesktop.swingx.border.DropShadowBorder;

/**
 *
 * @author Riski Dwi
 */
public class Canvas {


    public Canvas(){
        DropShadowBorder shadow = new DropShadowBorder();
        shadow.setShadowColor(Color.BLACK);
        shadow.setShowLeftShadow(true);
        shadow.setShowRightShadow(true);
        shadow.setShowBottomShadow(true);
        shadow.setShowTopShadow(true);
        this.setGaris(shadow);
    }

    public DropShadowBorder setGaris(DropShadowBorder shadow) {
        return shadow;
    }


    
}
