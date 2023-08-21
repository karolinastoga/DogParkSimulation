package simulation.GUI;

import agents.AgentsGenerator;
import agents.dogs.Dachshund;
import agents.dogs.Dog;
import agents.dogs.GoldenRetriever;
import agents.dogs.Rottweiler;
import agents.humans.DogCatcher;
import agents.humans.Human;
import agents.humans.Walker;
import park.Board;
import park.Simulation;

import javax.swing.*;

import static park.GeneratePark.*;

public class CreatedAgents extends javax.swing.JFrame {

    private String parkName;
    private AgentsGenerator agentsGenerator;
    private Board board;

    public CreatedAgents() {
        setVal();
        initComponents();
    }

    public void setVal(){
        parkName = getParkName();
        agentsGenerator = getAgents();
        board = getPark();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">

    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        jTabbedPane1 = new javax.swing.JTabbedPane();

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();

        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Start Simulation");
        jButton1.addActionListener(e ->
        {
                SimulationDisplay simulationDisplay= new SimulationDisplay();
                simulationDisplay.display();
        });

        jTable1 = createDachshundTable();

        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Dachshunds", jPanel1);

        jTable2 = createGoldenRetrieverTable();

        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Golden Retrievers", jPanel2);

        jTable3 = createRottweilerTable();
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Rottweilers", jPanel3);

        jTable4 = createDogCatcherTable();
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Dog Catchers", jPanel4);

        jTable5 = createWalkerTable();
        jScrollPane5.setViewportView(jTable5);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Walkers", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTabbedPane1)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTabbedPane1)
                                .addContainerGap())
        );

        pack();
    }

    private JTable createDachshundTable() {

        Dachshund[] dachshunds = agentsGenerator.getDachshunds().toArray(new Dachshund[0]);
        int dachshundL = dachshunds.length;

        String[] columnNames = {"No.", "Name", "Age", "Colour", "Length"};
        String[][] dachshundData = createTable(dachshundL, columnNames.length, dachshunds);

        for (int i = 0; i < dachshundL; i++) {
            dachshundData[i][4] = String.valueOf(dachshunds[i].getLength());
        }

        return new JTable(dachshundData, columnNames);
    }

    private JTable createGoldenRetrieverTable() {

        GoldenRetriever[] goldenRetrievers = agentsGenerator.getGoldenRetrievers().toArray(new GoldenRetriever[0]);
        int goldenL = goldenRetrievers.length;

        String[] columnNames = {"No.", "Name", "Age", "Colour", "Cuteness Level"};
        String[][] goldenRetrieverData = createTable(goldenL, columnNames.length, goldenRetrievers);

        for (int i = 0; i < goldenL; i++) {
            goldenRetrieverData[i][4] = String.valueOf(goldenRetrievers[i].getCutenessLevel());
        }

        return new JTable(goldenRetrieverData, columnNames);
    }

    private JTable createRottweilerTable() {

        Rottweiler[] rottweilers = agentsGenerator.getRottweilers().toArray(new Rottweiler[0]);
        int rottweilerL = rottweilers.length;

        String[] columnNames = {"No.", "Name", "Age", "Colour", "Aggression Level"};
        String[][] rottweilerData = createTable(rottweilerL, columnNames.length, rottweilers);

        for (int i = 0; i < rottweilerL; i++) {
            rottweilerData[i][4] = String.valueOf(rottweilers[i].getAggressionLevel());
        }

        return new JTable(rottweilerData, columnNames);
    }

    private JTable createDogCatcherTable() {

        DogCatcher[] dogCatchers = agentsGenerator.getDogCatchers().toArray(new DogCatcher[0]);
        int dogCatcherL = dogCatchers.length;

        String[] columnNames = {"No.", "Name", "Surname", "Age", "Experience Level"};
        String[][] dogCatcherData = createTable(dogCatcherL, columnNames.length, dogCatchers);

        for (int i = 0; i < dogCatcherL; i++) {
            dogCatcherData[i][4] = String.valueOf(dogCatchers[i].getExperienceLevel());
        }

        return new JTable(dogCatcherData, columnNames);
    }

    private JTable createWalkerTable() {

        Walker[] walkers = agentsGenerator.getWalkers().toArray(new Walker[0]);
        int walkerL = walkers.length;

        String[] columnNames = {"No.", "Name", "Surname", "Age", "Minimum Cuteness Level"};
        String[][] walkerData = createTable(walkerL, columnNames.length, walkers);

        for (int i = 0; i < walkerL; i++) {
            walkerData[i][4] = String.valueOf(walkers[i].getMinimumCutenessLevel());
        }

        return new JTable(walkerData, columnNames);
    }

    private String[][] createTable(int rows, int columns, Dog[] list) {

        String[][] data = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            data[i][0] = String.valueOf((i + 1));
            data[i][1] = list[i].getName();
            data[i][2] = String.valueOf(list[i].getAge());
            data[i][3] = list[i].getColour();
        }

        return data;
    }

    /**
     *
     * @param rows
     * @param columns
     * @param list
     * @return
     */

    private String[][] createTable(int rows, int columns, Human[] list) {

        String[][] data = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            data[i][0] = String.valueOf((i + 1));
            data[i][1] = list[i].getName();
            data[i][2] = list[i].getSurname();
            data[i][3] = String.valueOf(list[i].getAge());
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
            java.util.logging.Logger.getLogger(CreatedAgents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreatedAgents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreatedAgents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreatedAgents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreatedAgents().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    // End of variables declaration
}

