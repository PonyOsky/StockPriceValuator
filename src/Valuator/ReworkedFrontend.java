/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Valuator;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author ondre
 * 
 * Colors set up:
 * rgb(0, 255, 246)
 * rgb(0, 231, 255)
 * rgb(0, 158, 255)
 * rgb(0, 20, 255)
 * 
 */
public class ReworkedFrontend extends javax.swing.JFrame {

    /**
     * Creates new form ReworkedFrontend
     */
    
    private final Color lightColor;
    private final Color lightDarkColor;
    private final Color darkLightColor;
    private final Color darkColor;
    private ArrayList<String> activeChoices;
    private boolean hiddenInputs = true;
    private boolean hiddenOutputs = true;
    private JPanel hideChosen;
    
    public ReworkedFrontend() {
        initComponents();
        setIconImage(new ImageIcon(this.getClass().getResource("/Icons/icon.png")).getImage());
        setTitle("Stock price valuator");
        HidingMenuInputs.setVisible(false);
        CalcBut.setName("ShowHideButton");
        ResultBut.setName("CorpChoiceButton");
        SettingBut.setName("CorpDibChoiceButton");
        HelpBut.setName("BankChoiceButton");
        InModel.setName("InputsModel");
        InRatio.setName("InputsRatio");
        OutSummary.setName("OutputSummary");
        OutRatio.setName("OutputRatios");
        OutDCF.setName("OutputDCF");
        OutDDM.setName("OutputDDM");
        OutGraham.setName("OutputGraham");
        activeChoices = new ArrayList();
        lightColor = new Color(0, 255, 246);
        lightDarkColor = new Color(0, 231, 255);
        darkLightColor = new Color(0, 20, 255);
        darkColor = new Color(0, 20, 255);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Calculation = new javax.swing.JPanel();
        UseDCF = new javax.swing.JCheckBox();
        UseRatios = new javax.swing.JCheckBox();
        BorderOne = new javax.swing.JPanel();
        UseDDM = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        UseGraham = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        BorderTwo = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        MenuColumn = new javax.swing.JPanel();
        CalcBut = new javax.swing.JPanel();
        calcLabel = new javax.swing.JLabel();
        ResultBut = new javax.swing.JPanel();
        resultLabel = new javax.swing.JLabel();
        SettingBut = new javax.swing.JPanel();
        setttingLabel = new javax.swing.JLabel();
        HelpBut = new javax.swing.JPanel();
        helpLabel = new javax.swing.JLabel();
        HidingMenuInputs = new javax.swing.JPanel();
        InModel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        InRatio = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        OutSummary = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        OutRatio = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        OutDCF = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        OutDDM = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        OutGraham = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        WelcomePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 600));

        Calculation.setBackground(new java.awt.Color(0, 20, 255));
        Calculation.setForeground(new java.awt.Color(0, 102, 255));
        Calculation.setLayout(new java.awt.GridLayout(3, 4));

        UseDCF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        UseDCF.setForeground(new java.awt.Color(255, 255, 255));
        UseDCF.setText("DCF");
        UseDCF.setToolTipText("Enable / Disable Discounted Cash Flow Model");
        UseDCF.setPreferredSize(new java.awt.Dimension(56, 21));
        Calculation.add(UseDCF);

        UseRatios.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        UseRatios.setForeground(new java.awt.Color(255, 255, 255));
        UseRatios.setText("Ratios");
        UseRatios.setToolTipText("Enable / Disable Ratios");
        Calculation.add(UseRatios);

        BorderOne.setBackground(new java.awt.Color(0, 20, 255));

        javax.swing.GroupLayout BorderOneLayout = new javax.swing.GroupLayout(BorderOne);
        BorderOne.setLayout(BorderOneLayout);
        BorderOneLayout.setHorizontalGroup(
            BorderOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
        );
        BorderOneLayout.setVerticalGroup(
            BorderOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        Calculation.add(BorderOne);

        UseDDM.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        UseDDM.setForeground(new java.awt.Color(255, 255, 255));
        UseDDM.setText("DDM");
        UseDDM.setToolTipText("Enable / Disable Dividend Discount Model");
        Calculation.add(UseDDM);

        jCheckBox5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jCheckBox5.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setText("Feature 1");
        Calculation.add(jCheckBox5);

        UseGraham.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        UseGraham.setForeground(new java.awt.Color(255, 255, 255));
        UseGraham.setText("Grahams formulas");
        UseGraham.setToolTipText("Enable / Disable Grahams formulas");
        Calculation.add(UseGraham);

        jCheckBox6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jCheckBox6.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setText("Feature 2");
        Calculation.add(jCheckBox6);

        BorderTwo.setBackground(new java.awt.Color(0, 20, 255));

        javax.swing.GroupLayout BorderTwoLayout = new javax.swing.GroupLayout(BorderTwo);
        BorderTwo.setLayout(BorderTwoLayout);
        BorderTwoLayout.setHorizontalGroup(
            BorderTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
        );
        BorderTwoLayout.setVerticalGroup(
            BorderTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        Calculation.add(BorderTwo);

        getContentPane().add(Calculation, java.awt.BorderLayout.PAGE_END);

        Menu.setBackground(new java.awt.Color(102, 204, 255));
        Menu.setLayout(new java.awt.BorderLayout());

        MenuColumn.setBackground(new java.awt.Color(0, 255, 246));
        MenuColumn.setLayout(new java.awt.GridLayout(6, 1));

        CalcBut.setBackground(new java.awt.Color(0, 255, 246));
        CalcBut.setPreferredSize(new java.awt.Dimension(50, 50));
        CalcBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CalcButMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CalcButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CalcButMouseExited(evt);
            }
        });

        calcLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        calcLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/calc.png"))); // NOI18N
        calcLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        calcLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout CalcButLayout = new javax.swing.GroupLayout(CalcBut);
        CalcBut.setLayout(CalcButLayout);
        CalcButLayout.setHorizontalGroup(
            CalcButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(calcLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        CalcButLayout.setVerticalGroup(
            CalcButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(calcLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );

        MenuColumn.add(CalcBut);

        ResultBut.setBackground(new java.awt.Color(0, 255, 246));
        ResultBut.setPreferredSize(new java.awt.Dimension(50, 50));
        ResultBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultButMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ResultButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ResultButMouseExited(evt);
            }
        });

        resultLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/result.png"))); // NOI18N
        resultLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ResultButLayout = new javax.swing.GroupLayout(ResultBut);
        ResultBut.setLayout(ResultButLayout);
        ResultButLayout.setHorizontalGroup(
            ResultButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resultLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        ResultButLayout.setVerticalGroup(
            ResultButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );

        MenuColumn.add(ResultBut);

        SettingBut.setBackground(new java.awt.Color(0, 255, 246));
        SettingBut.setPreferredSize(new java.awt.Dimension(50, 50));
        SettingBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SettingButMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SettingButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SettingButMouseExited(evt);
            }
        });

        setttingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setttingLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/set.png"))); // NOI18N
        setttingLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout SettingButLayout = new javax.swing.GroupLayout(SettingBut);
        SettingBut.setLayout(SettingButLayout);
        SettingButLayout.setHorizontalGroup(
            SettingButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(setttingLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        SettingButLayout.setVerticalGroup(
            SettingButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(setttingLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );

        MenuColumn.add(SettingBut);

        HelpBut.setBackground(new java.awt.Color(0, 255, 246));
        HelpBut.setPreferredSize(new java.awt.Dimension(50, 50));
        HelpBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HelpButMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HelpButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HelpButMouseExited(evt);
            }
        });

        helpLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        helpLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/info.png"))); // NOI18N
        helpLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        helpLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout HelpButLayout = new javax.swing.GroupLayout(HelpBut);
        HelpBut.setLayout(HelpButLayout);
        HelpButLayout.setHorizontalGroup(
            HelpButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(helpLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        HelpButLayout.setVerticalGroup(
            HelpButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(helpLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );

        MenuColumn.add(HelpBut);

        Menu.add(MenuColumn, java.awt.BorderLayout.LINE_START);

        HidingMenuInputs.setBackground(new java.awt.Color(0, 231, 255));
        HidingMenuInputs.setLayout(new java.awt.GridLayout(7, 1));

        InModel.setBackground(new java.awt.Color(0, 231, 255));
        InModel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InModelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InModelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InModelMouseExited(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Models Inputs");

        javax.swing.GroupLayout InModelLayout = new javax.swing.GroupLayout(InModel);
        InModel.setLayout(InModelLayout);
        InModelLayout.setHorizontalGroup(
            InModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
        );
        InModelLayout.setVerticalGroup(
            InModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );

        HidingMenuInputs.add(InModel);

        InRatio.setBackground(new java.awt.Color(0, 231, 255));
        InRatio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InRatioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InRatioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InRatioMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Ratios Inputs");

        javax.swing.GroupLayout InRatioLayout = new javax.swing.GroupLayout(InRatio);
        InRatio.setLayout(InRatioLayout);
        InRatioLayout.setHorizontalGroup(
            InRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
        );
        InRatioLayout.setVerticalGroup(
            InRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );

        HidingMenuInputs.add(InRatio);

        OutSummary.setBackground(new java.awt.Color(0, 231, 255));
        OutSummary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OutSummaryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OutSummaryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OutSummaryMouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Summary");

        javax.swing.GroupLayout OutSummaryLayout = new javax.swing.GroupLayout(OutSummary);
        OutSummary.setLayout(OutSummaryLayout);
        OutSummaryLayout.setHorizontalGroup(
            OutSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
        );
        OutSummaryLayout.setVerticalGroup(
            OutSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );

        HidingMenuInputs.add(OutSummary);

        OutRatio.setBackground(new java.awt.Color(0, 231, 255));
        OutRatio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OutRatioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OutRatioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OutRatioMouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Ratios");

        javax.swing.GroupLayout OutRatioLayout = new javax.swing.GroupLayout(OutRatio);
        OutRatio.setLayout(OutRatioLayout);
        OutRatioLayout.setHorizontalGroup(
            OutRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
        );
        OutRatioLayout.setVerticalGroup(
            OutRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );

        HidingMenuInputs.add(OutRatio);

        OutDCF.setBackground(new java.awt.Color(0, 231, 255));
        OutDCF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OutDCFMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OutDCFMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OutDCFMouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("DCF");

        javax.swing.GroupLayout OutDCFLayout = new javax.swing.GroupLayout(OutDCF);
        OutDCF.setLayout(OutDCFLayout);
        OutDCFLayout.setHorizontalGroup(
            OutDCFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
        );
        OutDCFLayout.setVerticalGroup(
            OutDCFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );

        HidingMenuInputs.add(OutDCF);

        OutDDM.setBackground(new java.awt.Color(0, 231, 255));
        OutDDM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OutDDMMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OutDDMMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OutDDMMouseExited(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("DDM");

        javax.swing.GroupLayout OutDDMLayout = new javax.swing.GroupLayout(OutDDM);
        OutDDM.setLayout(OutDDMLayout);
        OutDDMLayout.setHorizontalGroup(
            OutDDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
        );
        OutDDMLayout.setVerticalGroup(
            OutDDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );

        HidingMenuInputs.add(OutDDM);

        OutGraham.setBackground(new java.awt.Color(0, 231, 255));
        OutGraham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OutGrahamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OutGrahamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OutGrahamMouseExited(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Graham's formula");

        javax.swing.GroupLayout OutGrahamLayout = new javax.swing.GroupLayout(OutGraham);
        OutGraham.setLayout(OutGrahamLayout);
        OutGrahamLayout.setHorizontalGroup(
            OutGrahamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        OutGrahamLayout.setVerticalGroup(
            OutGrahamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );

        HidingMenuInputs.add(OutGraham);

        Menu.add(HidingMenuInputs, java.awt.BorderLayout.CENTER);

        getContentPane().add(Menu, java.awt.BorderLayout.LINE_START);

        WelcomePanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome into Stock Price Valuator version 2.0");

        javax.swing.GroupLayout WelcomePanelLayout = new javax.swing.GroupLayout(WelcomePanel);
        WelcomePanel.setLayout(WelcomePanelLayout);
        WelcomePanelLayout.setHorizontalGroup(
            WelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WelcomePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(1107, 1107, 1107))
        );
        WelcomePanelLayout.setVerticalGroup(
            WelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomePanelLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2844, Short.MAX_VALUE))
        );

        getContentPane().add(WelcomePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param hover
     * @param rand
     */
    public void changeColor(JPanel hover, Color rand){
        if(hover != null) {
            hover.setBackground(rand);
        }
    }
    
    /**
     *
     * @param showingMenu
     * @param hid
     */
    public void showHideMenu(JPanel showingMenu, boolean hid){
        if(!hid){
            showingMenu.setPreferredSize(new Dimension(0, MenuColumn.getHeight()));
            changeIcon(calcLabel, "/Icons/calc.png");
        }else{
            showingMenu.setPreferredSize(new Dimension(280, MenuColumn.getHeight()));
            changeIcon(calcLabel, "/Icons/close-edit.png");
        }
        hiddenInputs = !hid;
    }
    
    /**
     *
     * @param target
     * @param resourceRoute
     */
    public void changeIcon(JLabel target, String resourceRoute){
        ImageIcon icon = new ImageIcon(getClass().getResource(resourceRoute));
        target.setIcon(icon);
        target.setSize(50, 50);
        target.setVerticalAlignment(SwingConstants.CENTER);
        target.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    /**
     *
     * @param target
     */
    public void clickUnclick(JPanel target){
        if(target != null){
            if(!activeChoices.contains(target.getName())){
                target.setBackground(lightDarkColor);
                activeChoices.add(target.getName());
            }else{
                target.setBackground(lightColor);
                activeChoices.remove(target.getName());
            }
        }
    }
    
    /**
     *
     * @param target
     */
    public void exiting(JPanel target){
        if(target != null){
            if(!activeChoices.contains(target.getName())){
                target.setBackground(lightColor);
            }
        }
    }
    
    /**
     *
     * @param target
     */
    public void hidemenuClick(JPanel target){
        if(target != null){
            if(target == hideChosen){
                changeColor(target, lightDarkColor);
                hideChosen = null;
            }else{
                changeColor(target, darkLightColor);
                changeColor(hideChosen, lightDarkColor);
                hideChosen = target;
            }
        }
    }
    
    /**
     *
     * @param target
     */
    public void hidemenuExiting(JPanel target){
        if(target != null){
            if(target != hideChosen){
                changeColor(target, lightDarkColor);
            }
        }
    }
    
    private void CalcButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcButMouseEntered
        changeColor(CalcBut, lightDarkColor);
    }//GEN-LAST:event_CalcButMouseEntered

    private void CalcButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcButMouseExited
        exiting(CalcBut);
    }//GEN-LAST:event_CalcButMouseExited

    private void CalcButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcButMouseClicked
        HidingMenuInputs.setVisible(true);
        clickUnclick(CalcBut);
        if(hiddenInputs) {
            showHideMenu(HidingMenuInputs, hiddenInputs);
        }else{
            showHideMenu(HidingMenuInputs, hiddenInputs);
        }
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_CalcButMouseClicked

    private void ResultButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultButMouseEntered
        changeColor(ResultBut, lightDarkColor);
    }//GEN-LAST:event_ResultButMouseEntered

    private void ResultButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultButMouseExited
        exiting(ResultBut);
    }//GEN-LAST:event_ResultButMouseExited

    private void ResultButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultButMouseClicked
        HidingMenuInputs.setVisible(true);
        clickUnclick(CalcBut);
        if(hiddenOutputs) {
            showHideMenu(HidingMenuInputs, hiddenOutputs);
        }else{
            showHideMenu(HidingMenuInputs, hiddenOutputs);
        }
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_ResultButMouseClicked

    private void SettingButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SettingButMouseEntered
        changeColor(SettingBut, lightDarkColor);
    }//GEN-LAST:event_SettingButMouseEntered

    private void SettingButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SettingButMouseExited
        exiting(SettingBut);
    }//GEN-LAST:event_SettingButMouseExited

    private void SettingButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SettingButMouseClicked
        clickUnclick(SettingBut);
    }//GEN-LAST:event_SettingButMouseClicked

    private void HelpButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HelpButMouseEntered
        changeColor(HelpBut, lightDarkColor);
    }//GEN-LAST:event_HelpButMouseEntered

    private void HelpButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HelpButMouseExited
        exiting(HelpBut);
    }//GEN-LAST:event_HelpButMouseExited

    private void HelpButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HelpButMouseClicked
        clickUnclick(HelpBut);
    }//GEN-LAST:event_HelpButMouseClicked

    private void OutSummaryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutSummaryMouseEntered
        changeColor(OutSummary, darkLightColor);
    }//GEN-LAST:event_OutSummaryMouseEntered

    private void InModelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InModelMouseEntered
        changeColor(InModel, darkLightColor);
    }//GEN-LAST:event_InModelMouseEntered

    private void InModelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InModelMouseExited
        hidemenuExiting(InModel);
    }//GEN-LAST:event_InModelMouseExited

    private void InModelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InModelMouseClicked
        hidemenuClick(InModel);
    }//GEN-LAST:event_InModelMouseClicked

    private void InRatioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InRatioMouseEntered
        changeColor(InRatio, darkLightColor);
    }//GEN-LAST:event_InRatioMouseEntered

    private void InRatioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InRatioMouseExited
        hidemenuExiting(InRatio);
    }//GEN-LAST:event_InRatioMouseExited

    private void InRatioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InRatioMouseClicked
        hidemenuClick(InRatio);
    }//GEN-LAST:event_InRatioMouseClicked

    private void OutSummaryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutSummaryMouseExited
        hidemenuExiting(OutSummary);
    }//GEN-LAST:event_OutSummaryMouseExited

    private void OutSummaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutSummaryMouseClicked
        hidemenuClick(OutSummary);
    }//GEN-LAST:event_OutSummaryMouseClicked

    private void OutRatioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutRatioMouseEntered
        changeColor(OutRatio, darkLightColor);
    }//GEN-LAST:event_OutRatioMouseEntered

    private void OutRatioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutRatioMouseExited
        hidemenuExiting(OutRatio);
    }//GEN-LAST:event_OutRatioMouseExited

    private void OutRatioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutRatioMouseClicked
        hidemenuClick(OutRatio);
    }//GEN-LAST:event_OutRatioMouseClicked

    private void OutDCFMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutDCFMouseEntered
        changeColor(OutDCF, darkLightColor);
    }//GEN-LAST:event_OutDCFMouseEntered

    private void OutDCFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutDCFMouseExited
        hidemenuExiting(OutDCF);
    }//GEN-LAST:event_OutDCFMouseExited

    private void OutDCFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutDCFMouseClicked
        hidemenuClick(OutDCF);
    }//GEN-LAST:event_OutDCFMouseClicked

    private void OutDDMMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutDDMMouseEntered
        changeColor(OutDDM, darkLightColor);
    }//GEN-LAST:event_OutDDMMouseEntered

    private void OutDDMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutDDMMouseExited
        hidemenuExiting(OutDDM);
    }//GEN-LAST:event_OutDDMMouseExited

    private void OutDDMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutDDMMouseClicked
        hidemenuClick(OutDDM);
    }//GEN-LAST:event_OutDDMMouseClicked

    private void OutGrahamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutGrahamMouseEntered
        changeColor(OutGraham, darkLightColor);
    }//GEN-LAST:event_OutGrahamMouseEntered

    private void OutGrahamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutGrahamMouseExited
        hidemenuExiting(OutGraham);
    }//GEN-LAST:event_OutGrahamMouseExited

    private void OutGrahamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutGrahamMouseClicked
        hidemenuClick(OutGraham);
    }//GEN-LAST:event_OutGrahamMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //řeší problém se škálováním ikon
        System.setProperty("sun.java2d.uiScale", "1");
        
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
            java.util.logging.Logger.getLogger(ReworkedFrontend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReworkedFrontend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReworkedFrontend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReworkedFrontend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ReworkedFrontend().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BorderOne;
    private javax.swing.JPanel BorderTwo;
    private javax.swing.JPanel CalcBut;
    private javax.swing.JPanel Calculation;
    private javax.swing.JPanel HelpBut;
    private javax.swing.JPanel HidingMenuInputs;
    private javax.swing.JPanel InModel;
    private javax.swing.JPanel InRatio;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel MenuColumn;
    private javax.swing.JPanel OutDCF;
    private javax.swing.JPanel OutDDM;
    private javax.swing.JPanel OutGraham;
    private javax.swing.JPanel OutRatio;
    private javax.swing.JPanel OutSummary;
    private javax.swing.JPanel ResultBut;
    private javax.swing.JPanel SettingBut;
    private javax.swing.JCheckBox UseDCF;
    private javax.swing.JCheckBox UseDDM;
    private javax.swing.JCheckBox UseGraham;
    private javax.swing.JCheckBox UseRatios;
    private javax.swing.JPanel WelcomePanel;
    private javax.swing.JLabel calcLabel;
    private javax.swing.JLabel helpLabel;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JLabel setttingLabel;
    // End of variables declaration//GEN-END:variables

    private void setIconImage(String iconsaccountingico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
