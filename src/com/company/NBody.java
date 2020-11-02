package com.company;
import javax.swing.*;       // for JPanel
import java.awt.*;          // for Graphics
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

/**
 * Generates a moving Celestial Body model
 * @param <E>
 */
public class NBody<E> extends JPanel implements ActionListener {

    List<CelestialBody> planets = null;

    /**
     * Reads the text file, determines if it's a LinkedList or Array List
     * @throws IOException
     */
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

    /**
     * Paints the planets on the JPanel
     * @param g
     */
    public void paintComponent(Graphics g) {
        Timer timer = new Timer(900, this);
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

    /**
     * Animates the planets with gravitational force
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        int xCoord, yCoord;     // cb
        int xCoord1, yCoord1;   // cb1
        double xVelocity, yVelocity;    // cb
        double xVelocity1, yVelocity1;  // cb1
        double mass1;
        double mass2;
        double gravity = 6.674 * Math.pow(10, -11);
        double distance;
        double force;

        for (int i=0; i<planets.size(); i++) {
            CelestialBody cb = planets.get(i);
            mass1 = cb.getMass();

            int j=0;
            CelestialBody cb1 = planets.get(j);
            for (j=1; j<planets.size() && i != j; j++) {
                cb1 = planets.get(j);
                mass2 = cb1.getMass();
                distance = Math.sqrt(Math.pow((cb1.getyCoord() - cb.getyCoord()), 2) + Math.pow((cb1.getxCoord() - cb.getxCoord()), 2));
                force = gravity*(mass1*mass2)/distance;

                if (cb.getxCoord() > cb1.getxCoord()) {        //whether the other x is < > to cb
                    cb.setxVelocity(cb.getxVelocity() + force);
                } else if (cb.getxCoord() < cb1.getxCoord()) {
                    cb.setxVelocity(cb.getxVelocity() - force);
                }

                if (cb.getyCoord() > cb1.getyCoord()) {
                    cb.setyVelocity(cb.getyVelocity() + force);
                } else if (cb.getyCoord() < cb1.getyCoord()) {
                    cb.setyVelocity(cb.getyVelocity() - force);
                }

                xCoord1 = cb1.getxCoord();
                xVelocity1 = cb1.getxVelocity();
                cb1.setxCoord((int) (xCoord1 + xVelocity1));

                yCoord1 = cb1.getyCoord();
                yVelocity1 = cb1.getyVelocity();
                cb.setyCoord((int) (yCoord1 + yVelocity1));

                if (xCoord1 < 0 || xCoord1 > 740) {
                    cb.setxCoord((int) (xCoord1 - xVelocity1));
                    cb.setyCoord((int) (yCoord1 - yVelocity1));
                }

                repaint();
            }

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

    /**
     * Calls the above methods
     * @param args
     * @throws IOException
     */
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
