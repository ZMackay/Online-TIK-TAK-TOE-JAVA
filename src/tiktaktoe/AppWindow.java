package tiktaktoe;

import Conn.DBConnection;
import Controllers.BoardController;
import Controllers.ChatController;
import Controllers.GameControll;
import Controllers.PlayerController;
import Runnables.BoardCheck;
import Runnables.openGameCheck;

/**
 *
 * @author zachm
 */
public class AppWindow extends javax.swing.JFrame {

    public AppWindow() {
        
        Conn.DBConnection.startInstance();
        INIT_OPENGAMESEARCH();
        initComponents();
        
        //init code based formatting
        this.jTabbedPane1.setEnabledAt(1, false);
        GameControll.openGamesArea = this.openGameArea;
        board.INIT_BOARD_SEGS(topLeft,topMid,topRight,midLeft,midLabel,midRight,botLeft,botMid,botRight);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        MenuTab = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        openGameArea = new javax.swing.JTextArea();
        openGamesTitle = new javax.swing.JLabel();
        usrNametxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        joinGameButton = new javax.swing.JButton();
        createNewGameButton = new javax.swing.JButton();
        joinGameInfo = new javax.swing.JLabel();
        gameIDtxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        boardTab = new javax.swing.JPanel();
        InfoArea = new javax.swing.JScrollPane();
        chatDisplay = new javax.swing.JTextArea();
        GameArea = new javax.swing.JPanel();
        leftTop = new javax.swing.JPanel();
        topLeft = new javax.swing.JLabel();
        midTop = new javax.swing.JPanel();
        topMid = new javax.swing.JLabel();
        rightTop = new javax.swing.JPanel();
        topRight = new javax.swing.JLabel();
        leftMid = new javax.swing.JPanel();
        midLeft = new javax.swing.JLabel();
        midMid = new javax.swing.JPanel();
        midLabel = new javax.swing.JLabel();
        rightMid = new javax.swing.JPanel();
        midRight = new javax.swing.JLabel();
        leftBot = new javax.swing.JPanel();
        botLeft = new javax.swing.JLabel();
        midBot = new javax.swing.JPanel();
        botMid = new javax.swing.JLabel();
        rightBot = new javax.swing.JPanel();
        botRight = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatToSendBox = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Title.setFont(new java.awt.Font("Wide Latin", 1, 36)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Online Tik Tak Toe : JAVA edition");

        openGameArea.setEditable(false);
        openGameArea.setColumns(20);
        openGameArea.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        openGameArea.setRows(5);
        jScrollPane2.setViewportView(openGameArea);

        openGamesTitle.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        openGamesTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        openGamesTitle.setText("Open Games");

        usrNametxt.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        usrNametxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("USER NAME:");

        joinGameButton.setBackground(new java.awt.Color(0, 102, 255));
        joinGameButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        joinGameButton.setText("Join Game");
        joinGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinGameButtonActionPerformed(evt);
            }
        });

        createNewGameButton.setBackground(new java.awt.Color(51, 255, 51));
        createNewGameButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        createNewGameButton.setText("Create New Game");
        createNewGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createNewGameButtonMouseClicked(evt);
            }
        });

        joinGameInfo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        joinGameInfo.setText("To join a game you must already know the GAME ID or type in an ID from the Open Games from the left ");

        gameIDtxt.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        gameIDtxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gameIDtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameIDtxtActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("GAME ID:");

        javax.swing.GroupLayout MenuTabLayout = new javax.swing.GroupLayout(MenuTab);
        MenuTab.setLayout(MenuTabLayout);
        MenuTabLayout.setHorizontalGroup(
            MenuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MenuTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(openGamesTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
                .addGroup(MenuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(MenuTabLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(MenuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(createNewGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MenuTabLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usrNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(joinGameInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(MenuTabLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(gameIDtxt)
                        .addGap(32, 32, 32)
                        .addComponent(joinGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        MenuTabLayout.setVerticalGroup(
            MenuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(MenuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuTabLayout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(jLabel3))
                    .addGroup(MenuTabLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(MenuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usrNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createNewGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(joinGameInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MenuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(gameIDtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(joinGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(MenuTabLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openGamesTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Menu", MenuTab);

        chatDisplay.setEditable(false);
        chatDisplay.setColumns(20);
        chatDisplay.setRows(5);
        InfoArea.setViewportView(chatDisplay);

        GameArea.setLayout(new java.awt.GridLayout(3, 3));

        leftTop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        leftTop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leftTopMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout leftTopLayout = new javax.swing.GroupLayout(leftTop);
        leftTop.setLayout(leftTopLayout);
        leftTopLayout.setHorizontalGroup(
            leftTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
        );
        leftTopLayout.setVerticalGroup(
            leftTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        );

        GameArea.add(leftTop);

        midTop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        midTop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                midTopMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout midTopLayout = new javax.swing.GroupLayout(midTop);
        midTop.setLayout(midTopLayout);
        midTopLayout.setHorizontalGroup(
            midTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topMid, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
        );
        midTopLayout.setVerticalGroup(
            midTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topMid, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        );

        GameArea.add(midTop);

        rightTop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rightTop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rightTopMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout rightTopLayout = new javax.swing.GroupLayout(rightTop);
        rightTop.setLayout(rightTopLayout);
        rightTopLayout.setHorizontalGroup(
            rightTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topRight, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
        );
        rightTopLayout.setVerticalGroup(
            rightTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topRight, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        );

        GameArea.add(rightTop);

        leftMid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        leftMid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leftMidMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout leftMidLayout = new javax.swing.GroupLayout(leftMid);
        leftMid.setLayout(leftMidLayout);
        leftMidLayout.setHorizontalGroup(
            leftMidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(midLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
        );
        leftMidLayout.setVerticalGroup(
            leftMidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(midLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        );

        GameArea.add(leftMid);

        midMid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        midMid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                midMidMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout midMidLayout = new javax.swing.GroupLayout(midMid);
        midMid.setLayout(midMidLayout);
        midMidLayout.setHorizontalGroup(
            midMidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(midLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
        );
        midMidLayout.setVerticalGroup(
            midMidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(midLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        );

        GameArea.add(midMid);

        rightMid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rightMid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rightMidMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout rightMidLayout = new javax.swing.GroupLayout(rightMid);
        rightMid.setLayout(rightMidLayout);
        rightMidLayout.setHorizontalGroup(
            rightMidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(midRight, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
        );
        rightMidLayout.setVerticalGroup(
            rightMidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(midRight, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        );

        GameArea.add(rightMid);

        leftBot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        leftBot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leftBotMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout leftBotLayout = new javax.swing.GroupLayout(leftBot);
        leftBot.setLayout(leftBotLayout);
        leftBotLayout.setHorizontalGroup(
            leftBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
        );
        leftBotLayout.setVerticalGroup(
            leftBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        );

        GameArea.add(leftBot);

        midBot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        midBot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                midBotMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout midBotLayout = new javax.swing.GroupLayout(midBot);
        midBot.setLayout(midBotLayout);
        midBotLayout.setHorizontalGroup(
            midBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botMid, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
        );
        midBotLayout.setVerticalGroup(
            midBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botMid, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        );

        GameArea.add(midBot);

        rightBot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rightBot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rightBotMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout rightBotLayout = new javax.swing.GroupLayout(rightBot);
        rightBot.setLayout(rightBotLayout);
        rightBotLayout.setHorizontalGroup(
            rightBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botRight, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
        );
        rightBotLayout.setVerticalGroup(
            rightBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botRight, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        );

        GameArea.add(rightBot);

        chatToSendBox.setColumns(20);
        chatToSendBox.setRows(5);
        jScrollPane1.setViewportView(chatToSendBox);

        sendButton.setBackground(new java.awt.Color(51, 255, 0));
        sendButton.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        sendButton.setText("SEND");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SimSun-ExtB", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chat");

        javax.swing.GroupLayout boardTabLayout = new javax.swing.GroupLayout(boardTab);
        boardTab.setLayout(boardTabLayout);
        boardTabLayout.setHorizontalGroup(
            boardTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boardTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendButton)
                .addContainerGap(1189, Short.MAX_VALUE))
            .addGroup(boardTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(boardTabLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(boardTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(InfoArea, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GameArea, javax.swing.GroupLayout.PREFERRED_SIZE, 1048, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        boardTabLayout.setVerticalGroup(
            boardTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boardTabLayout.createSequentialGroup()
                .addContainerGap(747, Short.MAX_VALUE)
                .addGroup(boardTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
            .addGroup(boardTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(boardTabLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(boardTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(GameArea, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(InfoArea, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(95, 95, 95)))
        );

        jTabbedPane1.addTab("Game", boardTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1630, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 869, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 869, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void leftTopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftTopMouseClicked
        // TODO add your handling code here:
        board.PlayerMoveUpdateBoardVal("topLeft");
    }//GEN-LAST:event_leftTopMouseClicked

    private void gameIDtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameIDtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gameIDtxtActionPerformed

    private void createNewGameButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createNewGameButtonMouseClicked
        // TODO add your handling code here:
        INIT_NEWGAME();
    }//GEN-LAST:event_createNewGameButtonMouseClicked

    private void joinGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinGameButtonActionPerformed
        // TODO add your handling code here:
        INIT_JOIN();
    }//GEN-LAST:event_joinGameButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        // TODO add your handling code here:
        if (!this.chatToSendBox.getText().isBlank()) {
            System.out.println("SENDING CHAT");
            chat.insert(this.chatToSendBox.getText());
            this.chatToSendBox.setText("");
        }

    }//GEN-LAST:event_sendButtonActionPerformed

    private void midTopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_midTopMouseClicked
        // TODO add your handling code here:
        board.PlayerMoveUpdateBoardVal("topMid");
    }//GEN-LAST:event_midTopMouseClicked

    private void rightTopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightTopMouseClicked
        // TODO add your handling code here:
        board.PlayerMoveUpdateBoardVal("topRight");
    }//GEN-LAST:event_rightTopMouseClicked

    private void leftMidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftMidMouseClicked
        // TODO add your handling code here:
        board.PlayerMoveUpdateBoardVal("midLeft");
    }//GEN-LAST:event_leftMidMouseClicked

    private void midMidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_midMidMouseClicked
        // TODO add your handling code here:
        board.PlayerMoveUpdateBoardVal("midMid");
    }//GEN-LAST:event_midMidMouseClicked

    private void rightMidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightMidMouseClicked
        // TODO add your handling code here:
        board.PlayerMoveUpdateBoardVal("midRight");
    }//GEN-LAST:event_rightMidMouseClicked

    private void leftBotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftBotMouseClicked
        // TODO add your handling code here:
        board.PlayerMoveUpdateBoardVal("botLeft");
    }//GEN-LAST:event_leftBotMouseClicked

    private void midBotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_midBotMouseClicked
        // TODO add your handling code here:
        board.PlayerMoveUpdateBoardVal("botMid");
    }//GEN-LAST:event_midBotMouseClicked

    private void rightBotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightBotMouseClicked
        // TODO add your handling code here:
        board.PlayerMoveUpdateBoardVal("botRight");
    }//GEN-LAST:event_rightBotMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppWindow().setVisible(true);
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                ChatController.insert("DISCONNECTED");
                if(GameControll.instanceGameID != 0){
                  GameControll.setGameOverTrue();  
                }
                
                DBConnection.stopInstance();

            }
        });
    }

    public void INIT_NEWGAME() {
        if (!this.usrNametxt.getText().isBlank() && !this.usrNametxt.getText().equals("You Must Enter A Username")) {
            player.player1 = true;
            PlayerController.turn = false;
            board.resetBoard();
            System.out.println("THIS INSTANCE IS SET TO A PLAYER 1");
            //CREATE GAME SHELL
            this.game.createShell();
            System.out.println("GAME SHELL CREATED");

            //CREATE PLAYER 1 ENTREE
            this.player.insert(this.usrNametxt.getText(), this.game.getMostRecentGAMEID());

            //CREATE BOARD ENTREE
            board.insert(game.getMostRecentGAMEID());
            //UPDATE GAME TABLE TO INCLUDE PLAYER 1 AND NEW BOARD ID
            game.update(PlayerController.playerID);

            //CHECK POINT
            DBConnection.dbCheckPoint();
            chat.startChat(this.chatDisplay);
            ChatController.insert("JOINED AS PLAYER1");
            ChatController.insert("THIS GAME'S ID IS: "+GameControll.instanceGameID);

            /*
            commits all so far
            after checkpoint start new thread db checks for actions
            auto commit on
             */
            this.jTabbedPane1.setEnabledAt(1, true);
            this.jTabbedPane1.setSelectedIndex(1);

        } else if (this.usrNametxt.getText().equals("You Must Enter A Username")) {

            this.usrNametxt.setText("You Must Enter A Username");

        } else {
            this.usrNametxt.setText("You Must Enter A Username");
        }
    }

    public void INIT_JOIN() {
        if (!this.gameIDtxt.getText().isBlank()) {
            //set player type
            PlayerController.player2 = true;
            PlayerController.player1 = false;
            board.resetBoard();
            //check game id for existance and availability
            if (game.checkForPlayer2(Integer.parseInt(this.gameIDtxt.getText()))) {
                //create player 2 entree
                player.insert(this.usrNametxt.getText(), Integer.parseInt(this.gameIDtxt.getText()));
                //set to passed gameid
                GameControll.instanceGameID = Integer.parseInt(this.gameIDtxt.getText());
                //update game table to include player 2
                game.update(PlayerController.playerID);
                
                //checkpoint
                DBConnection.dbCheckPoint();
                chat.startChat(this.chatDisplay);
                ChatController.insert("JOINED AS PLAYER2");

                //player 2 gets first turn
                PlayerController.turn = true;
                

                this.jTabbedPane1.setEnabledAt(1, true);
                this.jTabbedPane1.setSelectedIndex(1);
            } else {
                System.out.println("UNABLE TO CONNECT TO THIS GAME");
            }

        } else {
            this.gameIDtxt.setText("ENTER A GAME ID TO JOIN");
        }
    }
    Thread openGame;
    public void INIT_OPENGAMESEARCH(){
        
        if(openGame == null){
         openGame = new Thread(new openGameCheck());   
        }
        
        if(!openGame.isAlive()){
         openGame.start();   
        }
        
    }

    private Controllers.BoardController board = new Controllers.BoardController();
    private Controllers.GameControll game = new Controllers.GameControll();
    private Controllers.PlayerController player = new Controllers.PlayerController();
    private Controllers.ChatController chat = new Controllers.ChatController();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GameArea;
    private javax.swing.JScrollPane InfoArea;
    private javax.swing.JPanel MenuTab;
    private javax.swing.JLabel Title;
    private javax.swing.JPanel boardTab;
    private javax.swing.JLabel botLeft;
    private javax.swing.JLabel botMid;
    private javax.swing.JLabel botRight;
    private javax.swing.JTextArea chatDisplay;
    private javax.swing.JTextArea chatToSendBox;
    private javax.swing.JButton createNewGameButton;
    private javax.swing.JTextField gameIDtxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton joinGameButton;
    private javax.swing.JLabel joinGameInfo;
    private javax.swing.JPanel leftBot;
    private javax.swing.JPanel leftMid;
    private javax.swing.JPanel leftTop;
    private javax.swing.JPanel midBot;
    private javax.swing.JLabel midLabel;
    private javax.swing.JLabel midLeft;
    private javax.swing.JPanel midMid;
    private javax.swing.JLabel midRight;
    private javax.swing.JPanel midTop;
    private javax.swing.JTextArea openGameArea;
    private javax.swing.JLabel openGamesTitle;
    private javax.swing.JPanel rightBot;
    private javax.swing.JPanel rightMid;
    private javax.swing.JPanel rightTop;
    private javax.swing.JButton sendButton;
    private javax.swing.JLabel topLeft;
    private javax.swing.JLabel topMid;
    private javax.swing.JLabel topRight;
    private javax.swing.JTextField usrNametxt;
    // End of variables declaration//GEN-END:variables
}
