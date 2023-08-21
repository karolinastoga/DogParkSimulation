package simulation.GUI;

import agents.dogs.Dachshund;
import agents.dogs.Dog;
import agents.dogs.GoldenRetriever;
import agents.dogs.Rottweiler;
import agents.humans.DogCatcher;
import agents.humans.Human;
import agents.humans.Walker;
import park.Field;
import park.Simulation;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static park.GeneratePark.getAgents;
import static park.GeneratePark.getPark;
import static simulation.Configuration.config;

public class SimulationDisplay extends javax.swing.JFrame {

    private Simulation simulation;

    public SimulationDisplay() {
        initComponents();
        simulation = new Simulation(getPark());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        map = new javax.swing.JButton[getPark().getX()][getPark().getY()];

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Copperplate", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("Statistics");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        createStatistics();

        jLabel4.setText("Value");
        jLabel5.setText("Qty");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane6)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap(18, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                        .addComponent(jScrollPane6))
                                .addContainerGap())
        );

        jButton1.setText("Next turn");
        jButton1.addActionListener(evt -> {
                    simulation.performSimulation();
                    createTables();
                    createStatistics();
                    placeAgents();
                }
        );

        jButton2.setText("Finish");
//        jButton2.addActionListener(evt -> );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Copperplate", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));
        jLabel3.setText("Park Map");

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 405, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 336, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Copperplate", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setText("Agents");

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        createTables();
        createMap();
        placeAgents();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(39, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50))
        );

        pack();
    }

    public void createMap(){
        for (int i = 0; i < getPark().getX(); i++)
        {
            for (int j = 0; j < getPark().getY(); j++)
            {
                Image img = new ImageIcon("src/main/resources/GUI/icons/grass.jpeg").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                Icon icon = new ImageIcon(img);
                Dimension size = new Dimension(25,25);

                map[i][j] = new JButton(icon);
                map[i][j].setMargin(new Insets(0, 0, 0, 0));
                map[i][j].setPreferredSize(size);
                map[i][j].setMaximumSize(size);
                map[i][j].setMinimumSize(size);
                map[i][j].setBackground(Color.green);
                map[i][j].setForeground(Color.black);
                map[i][j].setSize(size);
                map[i][j].setLocation(i*26,j*26);
                jPanel5.add(map[i][j]);
            }
        }
    }

    public void placeAgents(){
        for(var fields: getPark().getBoard()){

            Image img;
            Icon icon;

            for(var field: fields){
                if(field.isAssigned()){
                    int c = field.getDachshundArrayList().size() +
                            field.getGoldenRetrieverArrayList().size() +
                            field.getRottweilerArrayList().size() +
                            field.getDogCatcherArrayList().size() +
                            ((field.isHasBone())? 1 : 0) +
                            ((field.isHasPoison())? 1 : 0);

                    if(c > 1) img = new ImageIcon("src/main/resources/GUI/icons/interaction.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                    else {
                        if(field.getDachshundArrayList().size() > 0) img = new ImageIcon("src/main/resources/GUI/icons/dogs/DachshundIcon.jpeg").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                        else if(field.getGoldenRetrieverArrayList().size() > 0) img = new ImageIcon("src/main/resources/GUI/icons/dogs/GoldenRetrieverIcon.jpeg").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                        else if(field.getRottweilerArrayList().size() > 0) img = new ImageIcon("src/main/resources/GUI/icons/dogs/rottweilerIcon.jpeg").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                        else if(field.getDogCatcherArrayList().size() > 0) img = new ImageIcon("src/main/resources/GUI/icons/dogCatcher.jpeg").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                        else if(field.getWalkerArrayList().size() > 0) img = new ImageIcon("src/main/resources/GUI/icons/walker.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                        else if(field.isHasBone()) img = new ImageIcon("src/main/resources/GUI/icons/bone.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                        else img = new ImageIcon("src/main/resources/GUI/icons/poison.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                    }

                }
                else img = new ImageIcon("src/main/resources/GUI/icons/grass.jpeg").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);

                icon = new ImageIcon(img);
                map[field.getPositionX()][field.getPositionY()].setIcon(icon);
            }
        }
    }

    public void createStatistics() {
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {
                    config.agents.dog_breeds.DACHSHUNDS,
                    config.agents.dog_breeds.GOLDEN_RETRIEVERS,
                    "GoldenRetrieversKilled",
                    "GoldenRetrieversAdopted",
                    config.agents.dog_breeds.ROTTWEILERS,
                    "RottweilersKilled",
                    "RottweilersCaught",
            };

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane6.setViewportView(jList1);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {

            String[] strings = {
                    String.valueOf(getAgents().getDachshunds().size()),
                    String.valueOf(getAgents().getGoldenRetrievers().size()),
                    String.valueOf(getPark().getKilledDogs().size()),
                    String.valueOf(getPark().getAdoptedDogs().size()),
                    String.valueOf(getAgents().getRottweilers().size()),
                    String.valueOf(getPark().getKilledRottweilers().size()),
                    String.valueOf(getPark().getCaughtRottweilers().size()),
            };

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane7.setViewportView(jList2);
    }

    private void createTables() {
        jTable1 = createDachshundTable();
        jScrollPane1.setViewportView(jTable1);
        jTabbedPane1.addTab("Dachshunds", jScrollPane1);

        jTable2 = createGoldenRetrieverTable();
        jScrollPane2.setViewportView(jTable2);
        jTabbedPane1.addTab("Golden Retrievers", jScrollPane2);

        jTable3 = createRottweilerTable();
        jScrollPane3.setViewportView(jTable3);
        jTabbedPane1.addTab("Rottweiler", jScrollPane3);

        jTable4 = createDogCatcherTable();
        jScrollPane4.setViewportView(jTable4);
        jTabbedPane1.addTab("Dog Catchers", jScrollPane4);

        jTable5 = createWalkerTable();
        jScrollPane5.setViewportView(jTable5);
        jTabbedPane1.addTab("Walkers", jScrollPane5);
    }

    private JTable createDachshundTable() {

        Dachshund[] dachshunds = getAgents().getDachshunds().toArray(new Dachshund[0]);
        int dachshundL = dachshunds.length;

        String[] columnNames = {"No.", "Name", "Is Alive", "Bones", "Poison", "Length"};
        String[][] dachshundData = createTable(dachshundL, columnNames.length, dachshunds);

        for (int i = 0; i < dachshundL; i++) {
            int j = 3;
            dachshundData[i][j] = String.valueOf(dachshunds[i].getBonesCount());
            dachshundData[i][j + 1] = String.valueOf(dachshunds[i].getPoisonCount());
            dachshundData[i][j + 2] = String.valueOf(dachshunds[i].getLength());
        }

        return new JTable(dachshundData, columnNames);
    }

    private JTable createGoldenRetrieverTable() {

        GoldenRetriever[] goldenRetrievers = getAgents().getGoldenRetrievers().toArray(new GoldenRetriever[0]);
        int goldenL = goldenRetrievers.length;

        String[] columnNames = {"No.", "Name", "Alive", "Adopted", "Cuteness Lvl", "Strokes", "Plays"};
        String[][] goldenRetrieverData = createTable(goldenL, columnNames.length, goldenRetrievers);

        for (int i = 0; i < goldenL; i++) {
            int j = 3;
            goldenRetrieverData[i][j] = String.valueOf(goldenRetrievers[i].isAdopted());
            goldenRetrieverData[i][j + 1] = String.valueOf(goldenRetrievers[i].getCutenessLevel());
            goldenRetrieverData[i][j + 2] = String.valueOf(goldenRetrievers[i].getStrokeCount());
            goldenRetrieverData[i][j + 3] = String.valueOf(goldenRetrievers[i].getPlayCount());
        }

        return new JTable(goldenRetrieverData, columnNames);
    }

    private JTable createRottweilerTable() {

        Rottweiler[] rottweilers = getAgents().getRottweilers().toArray(new Rottweiler[0]);
        int rottweilerL = rottweilers.length;

        String[] columnNames = {"No.", "Name", "Alive", "Caught", "Aggression Level", "Defeated Dogs"};
        String[][] rottweilerData = createTable(rottweilerL, columnNames.length, rottweilers);

        for (int i = 0; i < rottweilerL; i++) {
            int j = 3;
            rottweilerData[i][j] = String.valueOf(rottweilers[i].isCaught());
            rottweilerData[i][j + 1] = String.valueOf(rottweilers[i].getAggressionLevel());
            rottweilerData[i][j + 2] = String.valueOf(rottweilers[i].getDefeatedDogsCount());
        }

        return new JTable(rottweilerData, columnNames);
    }

    private JTable createDogCatcherTable() {

        DogCatcher[] dogCatchers = getAgents().getDogCatchers().toArray(new DogCatcher[0]);
        int dogCatcherL = dogCatchers.length;

        String[] columnNames = {"No.", "Name", "Surname", "Experience Level", "Caught Dogs", "Bites"};
        String[][] dogCatcherData = createTable(dogCatcherL, columnNames.length, dogCatchers);

        for (int i = 0; i < dogCatcherL; i++) {
            int j = 3;
            dogCatcherData[i][j] = String.valueOf(dogCatchers[i].getExperienceLevel());
            dogCatcherData[i][j + 1] = String.valueOf(dogCatchers[i].getCaughtDogsCount());
            dogCatcherData[i][j + 2] = String.valueOf(dogCatchers[i].getBitesCount());
        }

        return new JTable(dogCatcherData, columnNames);
    }

    private JTable createWalkerTable() {

        Walker[] walkers = getAgents().getWalkers().toArray(new Walker[0]);
        int walkerL = walkers.length;

        String[] columnNames = {"No.", "Name", "Surname", "Minimum Cuteness Level", "Stroked Dogs", "Adopted Dog"};
        String[][] walkerData = createTable(walkerL, columnNames.length, walkers);

        for (int i = 0; i < walkerL; i++) {
            int j = 3;
            walkerData[i][j] = String.valueOf(walkers[i].getMinimumCutenessLevel());
            walkerData[i][j + 1] = String.valueOf(walkers[i].getStrokedDogsCount());
            if (walkers[i].isHasAdoptedDog())
                walkerData[i][j + 2] = String.valueOf(walkers[i].getAdoptedDog().getName());
            else walkerData[i][j + 2] = String.valueOf(walkers[i].isHasAdoptedDog());
        }

        return new JTable(walkerData, columnNames);
    }

    private String[][] createTable(int rows, int columns, Dog[] list) {

        String[][] data = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            data[i][0] = String.valueOf((i + 1));
            data[i][1] = list[i].getName();
            data[i][2] = String.valueOf(list[i].isAlive());
        }

        return data;
    }

    private String[][] createTable(int rows, int columns, Human[] list) {

        String[][] data = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            data[i][0] = String.valueOf((i + 1));
            data[i][1] = list[i].getName();
            data[i][2] = list[i].getSurname();
        }

        return data;
    }

    public void display() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SimulationDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimulationDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimulationDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimulationDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimulationDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JButton[][] map;
    // End of variables declaration
}