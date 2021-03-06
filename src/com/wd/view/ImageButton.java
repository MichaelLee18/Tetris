package com.wd.view;

import javax.swing.*;
import java.awt.*;

public abstract class ImageButton extends JButton {
    public ImageButton(String icon) {
        setContentAreaFilled(false);
        ImageIcon imageIcon = new ImageIcon(icon);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(90,70, Image.SCALE_DEFAULT));
       setIcon(imageIcon);
       setBorder(null);
       addActionListener((e)->{
           onclick();
       });
    }

    public abstract void onclick();


}
