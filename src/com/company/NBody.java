package com.company;
import javax.swing.*;       // for JPanel
import java.awt.*;          // for Graphics
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;



//TODO:
// Read the file in a method (throws exception in that method instead of main) - done
// draw (done)
// check if it draws with add method (done)
// animation (done)
// gravity
// From scratch: LinkedList, ArrayList (code for LinkedList is lab 5, array list is in lecture) (done)

public class NBody<E> extends JPanel implements ActionListener {

    List<CelestialBody> planets = null;

    public void readingLines() throws IOException {
        File textFile = new File("/Users/nickihashemi/IdeaProjects/NBody/src/com/company/NBody.txt");
        BufferedReader fileScanner = new BufferedReader(new FileReader(textFile));

        String listType = fileScanner.readLine();                   // reads first line
        if (listType.equals("LinkedList")) {
            planets = new LinkedList<CelestialBody>();
        } else if (listType.equals("ArrayList")) {
            planets = new ArrayList<CelestialBody>();
        }

        double scale = Double.valueOf(fileScanner.readLine());      // reads second line

        String lines;
        while ((lines = fileScanner.readLine()) != null) {
            String[] temp = lines.split(",");
            System.out.println(Arrays.toString(temp));
            planets.add(new CelestialBody(temp[0], Double.parseDouble(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), scale * Double.parseDouble(temp[4]), scale * Double.parseDouble(temp[5]), Integer.parseInt(temp[6])));
        }
        System.out.println(planets.toString());

    }


    public void paintComponent(Graphics g) {
        Timer timer = new Timer(300, this);
        super.paintComponent(g);        // type super because we're getting it from the JPanel

        for (int i=0; i<planets.size(); i++) {
            g.setColor(Color.RED);

            if (i == 1) {
                g.setColor(Color.BLUE);
            } else if (i == 2){
                g.setColor(Color.GREEN);
            } else if (i == 3){
                g.setColor(Color.BLACK);
            } else if (i >= 4) {
                g.setColor(Color.MAGENTA);
            }

            CelestialBody cb = planets.get(i);
            g.fillOval(cb.getxCoord(), cb.getyCoord(), cb.getRadius(), cb.getRadius());
        }

        timer.start();
    }


    public void actionPerformed(ActionEvent e) {
        int xCoord, yCoord;
        double xVelocity, yVelocity;

        for (int i=0; i<planets.size(); i++) {
            CelestialBody cb = planets.get(i);
            xCoord = cb.getxCoord();
            xVelocity = cb.getxVelocity();
            cb.setxCoord((int) (xCoord + xVelocity));

            yCoord = cb.getyCoord();
            yVelocity = cb.getyVelocity();
            cb.setyCoord((int) (yCoord + yVelocity));


            if (xCoord < 0 || xCoord > 740) {
                cb.setxCoord((int) (xCoord - xVelocity));
                cb.setyCoord((int) (yCoord - yVelocity));
            }

            repaint();

        }
    }

    public static void main(String[] args) throws IOException {

        // JFrame
        NBody nBody = new NBody();
        nBody.readingLines();

        JFrame jFrame = new JFrame();
        jFrame.setTitle("NBody");
        jFrame.setSize(768, 768);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(nBody);
        jFrame.validate();

    }
}
