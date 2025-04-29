import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.String.format;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
public class USER_HOME_PAGE extends javax.swing.JFrame {
String crudImageName=" " ;
String crudImageAbsolutePath=" " ;
 private ImageIcon format=null;  
 String Username;
 String filename=null;
    public USER_HOME_PAGE() {
        initComponents();
        SetIcon();
        date();//dashboard date 
        time();//dashboard time
        setTotalAdmin();
        setTotalSubAdmin();
    }
    private void SetIcon(){
setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
}
    public void date(){
    Date d=new Date();      //     import java.util.Date;
    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy EEEE");            //     import java.text.SimpleDateFormat;
    String dd=sdf.format(d);
    txt_Dashboard_Time.setText(dd);
     }
 Timer t ;
 SimpleDateFormat st ;
    
public void time(){
  t = new Timer(0, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         Date dt  =new Date();
        st = new SimpleDateFormat("hh:mm:ss a");
         String tt = st.format(dt);
        txt_Dashboard_Date.setText(tt);}
    });
    t.start();
}
public ImageIcon ResizeImage(String crudImageAbsolutePath){
        ImageIcon MyImage = new ImageIcon(crudImageAbsolutePath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(Update_user_image.getWidth(), Update_user_image.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
  public void setTotalSubAdmin(){
      
         try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginauth","root","Abhay@9899");
                String sql = "SELECT count(ID) FROM table_admin where User_Type=0";
               PreparedStatement  prepare = con.prepareStatement(sql);
                ResultSet rs=prepare.executeQuery();
                  int countEnrolled = 0;
                  if (rs.next()) {
                countEnrolled = rs.getInt("count(ID)");
                 }
               SUB_ADMIN.setText(String.valueOf(countEnrolled)  );
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"Error! in Sub-Admin Count");
    }
     }
       public void setTotalAdmin(){
      
         try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginauth","root","Abhay@9899");
                String sql = "SELECT count(ID) FROM table_admin where User_Type=1";
               PreparedStatement  prepare = con.prepareStatement(sql);
                ResultSet rs=prepare.executeQuery();
                  int countEnrolled = 0;
                  if (rs.next()) {
                countEnrolled = rs.getInt("count(ID)");
                 }
               Admin.setText(String.valueOf(countEnrolled)  );
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"Error! in Sub-Admin Count");
    }
     }
  public void RefreshUserDetails(){
  try{
           int ID=Integer.parseInt(txt_id1.getText());
           Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/LoginAuth","root","Abhay@9899");
            Statement stm=con.createStatement();
            String sql="Select * from user where ID='"+ID+"' ";
            ResultSet rs=stm.executeQuery(sql);
            if(rs.next()){
                  txt_id1.setText(rs.getString(1));
                  txt_username1.setText(rs.getString(2));
                  txt_fullname1.setText(rs.getString(3));
                  txt_email1.setText(rs.getString(4));
                  txt_contactno1.setText(rs.getString(5));
                   String gender=rs.getString(6);
                     if (gender.equals("Male")) {
                  male.setSelected(true);
                     } else {
                  female.setSelected(true);
                     } 
                jTextFieldIMAGName1.setText(rs.getString(8));
                jTextFieldIMAGPath1.setText(rs.getString(9));
                jTextFieldIMAGName2.setText(rs.getString(8));
                jTextFieldIMAGPath2.setText(rs.getString(9));
                ComboBox_language1.setSelectedItem(rs.getString(10));
                ComboBox_country1.setSelectedItem(rs.getString(11));
                ComboBox_SecurityQ1.setSelectedItem(rs.getString(12));
                txt_answer1.setText(rs.getString(13));
                java.util.Date date = rs.getDate(14); // Retrieve the date from ResultSet
                txt_dob1.setDate(date);
                byte[] imagedata=rs.getBytes ("IMAGE");
                format=new ImageIcon(imagedata);
                Image mm=format.getImage();
                Image img2=mm.getScaledInstance(164,208,Image.SCALE_SMOOTH);
                Image img3=mm.getScaledInstance(341,379,Image.SCALE_SMOOTH);
                ImageIcon image=new ImageIcon(img2); 
                ImageIcon image1=new ImageIcon(img3); 
                profile_image.setIcon(image);
                Home_index_imageUser.setIcon(image);
                Update_user_image.setIcon(image1);
                txt_password1.setText(rs.getString(15));
            }else{
                JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Gender_radioButton1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        PANEL_MENU = new javax.swing.JPanel();
        homepanel = new javax.swing.JPanel();
        HOME = new javax.swing.JLabel();
        datbase = new javax.swing.JPanel();
        Database = new javax.swing.JLabel();
        setting = new javax.swing.JPanel();
        SETTING = new javax.swing.JLabel();
        staff = new javax.swing.JPanel();
        STAFF = new javax.swing.JLabel();
        Home_index_imageUser = new javax.swing.JLabel();
        txt_Dashboard_Date = new javax.swing.JLabel();
        txt_Dashboard_Time = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        PANEL_HEADER = new javax.swing.JPanel();
        name1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        JTABBED_PANEL_BODY = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        Admin = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        SUB_ADMIN = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        profile_image = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        ComboBox_language1 = new javax.swing.JComboBox<>();
        ComboBox_country1 = new javax.swing.JComboBox<>();
        txt_email1 = new javax.swing.JTextField();
        DATA_UPDATED_INSERTED = new javax.swing.JButton();
        txt_id = new javax.swing.JLabel();
        jTextFieldIMAGName1 = new javax.swing.JLabel();
        jTextFieldIMAGPath1 = new javax.swing.JLabel();
        ComboBox_SecurityQ1 = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_contactno1 = new javax.swing.JTextField();
        txt_answer1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txt_username1 = new javax.swing.JLabel();
        txt_password1 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txt_id1 = new javax.swing.JLabel();
        txt_fullname1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txt_dob1 = new com.toedter.calendar.JDateChooser();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        Update_user_image = new javax.swing.JLabel();
        UPDATED_IMAGE = new javax.swing.JButton();
        txt_id2 = new javax.swing.JLabel();
        jTextFieldIMAGName2 = new javax.swing.JLabel();
        jTextFieldIMAGPath2 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txt_id3 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        CHANGE_IMAGE = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        updatepasswordback = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_newpassword1 = new javax.swing.JPasswordField();
        txt_confirmpassword1 = new javax.swing.JPasswordField();
        Change_OldPassword = new javax.swing.JButton();
        txt_currentpassword1 = new javax.swing.JTextField();
        show_pass = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PANEL_MENU.setBackground(new java.awt.Color(0, 102, 102));
        PANEL_MENU.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PANEL_MENU.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homepanel.setBackground(new java.awt.Color(0, 102, 102));
        homepanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        homepanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homepanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homepanelMouseExited(evt);
            }
        });

        HOME.setBackground(new java.awt.Color(0, 102, 102));
        HOME.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        HOME.setForeground(new java.awt.Color(255, 255, 255));
        HOME.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home1.png"))); // NOI18N
        HOME.setText("Home");
        HOME.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HOMEMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout homepanelLayout = new javax.swing.GroupLayout(homepanel);
        homepanel.setLayout(homepanelLayout);
        homepanelLayout.setHorizontalGroup(
            homepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(HOME, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addContainerGap())
        );
        homepanelLayout.setVerticalGroup(
            homepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HOME, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        PANEL_MENU.add(homepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 243, 188, -1));

        datbase.setBackground(new java.awt.Color(0, 102, 102));
        datbase.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        datbase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                datbaseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                datbaseMouseExited(evt);
            }
        });

        Database.setBackground(new java.awt.Color(0, 102, 102));
        Database.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Database.setForeground(new java.awt.Color(255, 255, 255));
        Database.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/resume.png"))); // NOI18N
        Database.setText("Edit Details");
        Database.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DatabaseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout datbaseLayout = new javax.swing.GroupLayout(datbase);
        datbase.setLayout(datbaseLayout);
        datbaseLayout.setHorizontalGroup(
            datbaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datbaseLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(Database, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        datbaseLayout.setVerticalGroup(
            datbaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datbaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Database, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        PANEL_MENU.add(datbase, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 293, 188, -1));

        setting.setBackground(new java.awt.Color(0, 102, 102));
        setting.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingMouseExited(evt);
            }
        });

        SETTING.setBackground(new java.awt.Color(0, 102, 102));
        SETTING.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        SETTING.setForeground(new java.awt.Color(255, 255, 255));
        SETTING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings (1).png"))); // NOI18N
        SETTING.setText("Setting");
        SETTING.setPreferredSize(new java.awt.Dimension(86, 29));
        SETTING.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SETTINGMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout settingLayout = new javax.swing.GroupLayout(setting);
        setting.setLayout(settingLayout);
        settingLayout.setHorizontalGroup(
            settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(SETTING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        settingLayout.setVerticalGroup(
            settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SETTING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        PANEL_MENU.add(setting, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 393, 188, -1));

        staff.setBackground(new java.awt.Color(0, 102, 102));
        staff.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        staff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                staffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                staffMouseExited(evt);
            }
        });

        STAFF.setBackground(new java.awt.Color(0, 102, 102));
        STAFF.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        STAFF.setForeground(new java.awt.Color(255, 255, 255));
        STAFF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/photo.png"))); // NOI18N
        STAFF.setText("Update Image");
        STAFF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                STAFFMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout staffLayout = new javax.swing.GroupLayout(staff);
        staff.setLayout(staffLayout);
        staffLayout.setHorizontalGroup(
            staffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(STAFF)
                .addContainerGap())
        );
        staffLayout.setVerticalGroup(
            staffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(STAFF, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        PANEL_MENU.add(staff, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 343, -1, -1));

        Home_index_imageUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PANEL_MENU.add(Home_index_imageUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 164, 208));

        txt_Dashboard_Date.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_Dashboard_Date.setForeground(new java.awt.Color(255, 255, 255));
        PANEL_MENU.add(txt_Dashboard_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 140, 29));

        txt_Dashboard_Time.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_Dashboard_Time.setForeground(new java.awt.Color(255, 255, 255));
        PANEL_MENU.add(txt_Dashboard_Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 564, 180, 29));

        logout.setBackground(new java.awt.Color(0, 102, 102));
        logout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        logout.setPreferredSize(new java.awt.Dimension(154, 49));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 102, 102));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout1.png"))); // NOI18N
        jLabel7.setText("Logout");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout logoutLayout = new javax.swing.GroupLayout(logout);
        logout.setLayout(logoutLayout);
        logoutLayout.setHorizontalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoutLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        logoutLayout.setVerticalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        PANEL_MENU.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 442, 188, 50));

        jPanel1.add(PANEL_MENU, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 190, 590));

        PANEL_HEADER.setBackground(new java.awt.Color(0, 102, 102));
        PANEL_HEADER.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        name1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        name1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("USER DASHBOARD");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/two-factor-authentication (1).png"))); // NOI18N

        javax.swing.GroupLayout PANEL_HEADERLayout = new javax.swing.GroupLayout(PANEL_HEADER);
        PANEL_HEADER.setLayout(PANEL_HEADERLayout);
        PANEL_HEADERLayout.setHorizontalGroup(
            PANEL_HEADERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_HEADERLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 847, Short.MAX_VALUE)
                .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        PANEL_HEADERLayout.setVerticalGroup(
            PANEL_HEADERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_HEADERLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_HEADERLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PANEL_HEADERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        jPanel1.add(PANEL_HEADER, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 50));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("USER/ HOME");

        jPanel12.setBackground(new java.awt.Color(0, 153, 153));
        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel12.setPreferredSize(new java.awt.Dimension(256, 187));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setText("ADMINISTRATION");

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/businessman.png"))); // NOI18N

        Admin.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        Admin.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(17, 17, 17))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Admin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel20.setBackground(new java.awt.Color(0, 153, 153));
        jPanel20.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel20.setPreferredSize(new java.awt.Dimension(256, 187));

        jLabel45.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel45.setText("NO.SUB-ADMIN");

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/engineer (1).png"))); // NOI18N
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel45))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel46)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 19, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel21.setBackground(new java.awt.Color(0, 153, 153));
        jPanel21.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel21.setPreferredSize(new java.awt.Dimension(256, 187));

        jLabel47.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel47.setText("UPDATE DETAILS");

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/personal-profile.png"))); // NOI18N
        jLabel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel48MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel47))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel48)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        jPanel22.setBackground(new java.awt.Color(0, 153, 153));
        jPanel22.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel22.setPreferredSize(new java.awt.Dimension(256, 187));
        jPanel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel22MouseClicked(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel49.setText("CHANGE IMAGE");

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/generative-image.png"))); // NOI18N
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel50))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel23.setBackground(new java.awt.Color(0, 153, 153));
        jPanel23.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel23.setPreferredSize(new java.awt.Dimension(256, 187));
        jPanel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel23MouseClicked(evt);
            }
        });

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/password-manager.png"))); // NOI18N
        jLabel51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel51MouseClicked(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel52.setText("UPDATE PASSWORD");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel51)
                .addGap(69, 69, 69))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel51)
                .addContainerGap())
        );

        SUB_ADMIN.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        SUB_ADMIN.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addContainerGap(941, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247)
                .addComponent(SUB_ADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(91, 91, 91)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(50, 50, 50)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(50, 50, 50)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(89, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(SUB_ADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jPanel12, 186, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(75, 75, 75)
                    .addComponent(jPanel20, 186, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(80, 80, 80)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel21, 190, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(73, Short.MAX_VALUE)))
        );

        JTABBED_PANEL_BODY.addTab("tab1", jPanel3);

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("USER / UPDATE DETAILS");

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("USERNAME");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("FULLNAME");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("EMAIL");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("GENDER");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("LANGUAGE");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setText("COUNTRY");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setText("IMAGE PATH");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setText("DOB");

        profile_image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        profile_image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profile_imageMouseClicked(evt);
            }
        });

        Gender_radioButton1.add(male);
        male.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        male.setText("Male");

        Gender_radioButton1.add(female);
        female.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });

        ComboBox_language1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ComboBox_language1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---SELECT LANGUAGE---", "English", "Assamese", "Bengali", "Gujarati", "Hindi", "Kannada", "Kashmiri", "Marathi", "Malayalam", "Oriya", "Punjabi", "Sanskrit", "Tamil", "Telugu", "Urdu", "Sindhi", "Konkani", "Nepali", "Manipuri", "Bodo", "Dogri", "Maithili", "Santhali" }));
        ComboBox_language1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ComboBox_language1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_language1ActionPerformed(evt);
            }
        });

        ComboBox_country1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ComboBox_country1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---SELECT COUNTRY---", "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Rep", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Congo {Democratic Rep}", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland {Republic}", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar, {Burma}", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia", "Saint Vincent & the Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe" }));
        ComboBox_country1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ComboBox_country1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_country1ActionPerformed(evt);
            }
        });

        txt_email1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_email1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DATA_UPDATED_INSERTED.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        DATA_UPDATED_INSERTED.setText("UPDATE");
        DATA_UPDATED_INSERTED.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        DATA_UPDATED_INSERTED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DATA_UPDATED_INSERTEDActionPerformed(evt);
            }
        });

        txt_id.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jTextFieldIMAGName1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jTextFieldIMAGPath1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextFieldIMAGPath1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ComboBox_SecurityQ1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ComboBox_SecurityQ1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select Security Question---", "What is your First Elementary School ?", "What is your Favourite food ?", "What is your Child Nick name ?", "What is your Father's name ?", "What is your Favourite Fruit's ?" }));
        ComboBox_SecurityQ1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setText("SECURITYQ");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel22.setText("CONTACTNO");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel23.setText("ANSWER");

        txt_contactno1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_contactno1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txt_answer1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_answer1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel24.setText("PASSWORD");

        txt_username1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_username1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txt_password1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_password1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel25.setText("ID");

        txt_id1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_id1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txt_fullname1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_fullname1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/left-arrow.png"))); // NOI18N
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });

        txt_dob1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_dob1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(221, 221, 221)
                                .addComponent(DATA_UPDATED_INSERTED, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(368, 368, 368))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_password1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_answer1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextFieldIMAGPath1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                            .addComponent(txt_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(190, 190, 190)
                                            .addComponent(profile_image, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ComboBox_language1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ComboBox_SecurityQ1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_dob1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel18)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ComboBox_country1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(620, 620, 620)
                                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_email1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(male)
                                                .addGap(18, 18, 18)
                                                .addComponent(female))
                                            .addComponent(txt_contactno1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_username1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_fullname1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldIMAGName1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(15, 15, 15))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_username1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_fullname1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_email1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_contactno1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(male)
                                    .addComponent(female)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(profile_image, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldIMAGName1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIMAGPath1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ComboBox_language1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ComboBox_country1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ComboBox_SecurityQ1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dob1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_answer1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(txt_password1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addComponent(DATA_UPDATED_INSERTED, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addContainerGap(837, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JTABBED_PANEL_BODY.addTab("tab2", jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("USER / UPDATE IMAGE");

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel31.setText("IMAGE PATH");

        Update_user_image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Update_user_image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Update_user_imageMouseClicked(evt);
            }
        });

        UPDATED_IMAGE.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        UPDATED_IMAGE.setText("UPDATE IMAGE");
        UPDATED_IMAGE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        UPDATED_IMAGE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATED_IMAGEActionPerformed(evt);
            }
        });

        txt_id2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jTextFieldIMAGName2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextFieldIMAGName2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextFieldIMAGPath2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextFieldIMAGPath2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel37.setText("ID  :-");

        txt_id3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel32.setText("IMAGE NAME");

        CHANGE_IMAGE.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        CHANGE_IMAGE.setText("CHANGE IMAGE");
        CHANGE_IMAGE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CHANGE_IMAGE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHANGE_IMAGEActionPerformed(evt);
            }
        });

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/left-arrow.png"))); // NOI18N
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel37)
                        .addGap(620, 620, 620)
                        .addComponent(txt_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(UPDATED_IMAGE, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(301, 301, 301))))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel27))
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_id3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldIMAGName2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CHANGE_IMAGE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Update_user_image, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldIMAGPath2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Update_user_image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_id3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(253, 253, 253)
                                .addComponent(CHANGE_IMAGE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIMAGName2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIMAGPath2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(UPDATED_IMAGE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 126, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        JTABBED_PANEL_BODY.addTab("tab3", jPanel6);

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("SETTING/ UPDATE PASSWORD");

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel10.setBackground(new java.awt.Color(0, 123, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("CHANGE YOUR PASSWORD");

        updatepasswordback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/left-arrow.png"))); // NOI18N
        updatepasswordback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatepasswordbackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel15)
                .addContainerGap(146, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(updatepasswordback)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(updatepasswordback, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Current Password");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("New Password");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Confirm Password");

        txt_newpassword1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_newpassword1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txt_confirmpassword1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_confirmpassword1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_confirmpassword1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_confirmpassword1KeyReleased(evt);
            }
        });

        Change_OldPassword.setBackground(new java.awt.Color(0, 123, 255));
        Change_OldPassword.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Change_OldPassword.setForeground(new java.awt.Color(255, 255, 255));
        Change_OldPassword.setText("Change");
        Change_OldPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        Change_OldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Change_OldPasswordActionPerformed(evt);
            }
        });

        txt_currentpassword1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_currentpassword1.setToolTipText("");
        txt_currentpassword1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_currentpassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_currentpassword1ActionPerformed(evt);
            }
        });

        show_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_passActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Change_OldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_newpassword1)
                    .addComponent(txt_confirmpassword1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addComponent(txt_currentpassword1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(show_pass)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txt_currentpassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txt_newpassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_confirmpassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(show_pass))
                .addGap(18, 18, 18)
                .addComponent(Change_OldPassword)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(277, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(255, 255, 255))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        JTABBED_PANEL_BODY.addTab("tab6", jPanel4);

        jPanel1.add(JTABBED_PANEL_BODY, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 1050, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1260, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void HOMEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HOMEMouseClicked
        // TODO add your handling code here:
        JTABBED_PANEL_BODY.setSelectedIndex(0);
        RefreshUserDetails();
    }//GEN-LAST:event_HOMEMouseClicked

    private void homepanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homepanelMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(0,153,153);
        homepanel.setBackground(clr);
    }//GEN-LAST:event_homepanelMouseEntered

    private void homepanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homepanelMouseExited
        // TODO add your handling code here:
        Color clr=new Color(0,102,102);
        homepanel.setBackground(clr);
    }//GEN-LAST:event_homepanelMouseExited

    private void DatabaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DatabaseMouseClicked
        // TODO add your handling code here:
        JTABBED_PANEL_BODY.setSelectedIndex(1);
        RefreshUserDetails();
    }//GEN-LAST:event_DatabaseMouseClicked

    private void datbaseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datbaseMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(0,153,153);
        datbase.setBackground(clr);
    }//GEN-LAST:event_datbaseMouseEntered

    private void datbaseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datbaseMouseExited
        // TODO add your handling code here:
        Color clr=new Color(0,102,102);
        datbase.setBackground(clr);
    }//GEN-LAST:event_datbaseMouseExited

    private void SETTINGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SETTINGMouseClicked
        // TODO add your handling code here:
        JTABBED_PANEL_BODY.setSelectedIndex(3);
        RefreshUserDetails();
    }//GEN-LAST:event_SETTINGMouseClicked

    private void settingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(0,153,153);
        setting.setBackground(clr);
    }//GEN-LAST:event_settingMouseEntered

    private void settingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMouseExited
        // TODO add your handling code here:
        Color clr=new Color(0,102,102);
        setting.setBackground(clr);
    }//GEN-LAST:event_settingMouseExited

    private void STAFFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_STAFFMouseClicked
        // TODO add your handling code here:
   JTABBED_PANEL_BODY.setSelectedIndex(2);
   RefreshUserDetails();
    }//GEN-LAST:event_STAFFMouseClicked

    private void staffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(0,153,153);
        staff.setBackground(clr);
    }//GEN-LAST:event_staffMouseEntered

    private void staffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffMouseExited
        // TODO add your handling code here:
        Color clr=new Color(0,102,102);
        staff.setBackground(clr);
    }//GEN-LAST:event_staffMouseExited

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        int opt=JOptionPane.showConfirmDialog(null,"Are You want Logout","Logout",JOptionPane.YES_NO_OPTION);
        if(opt==0){
            setVisible(false);
            USER_LOGIN_PAGE ob = new USER_LOGIN_PAGE();
            ob.setVisible(true);
            //System.exit(0);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(0,153,153);
        logout.setBackground(clr);
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        // TODO add your handling code here:
        Color clr=new Color(0,102,102);
        logout.setBackground(clr);
    }//GEN-LAST:event_logoutMouseExited

    private void show_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_passActionPerformed
        // TODO add your handling code here:
        if(show_pass.isSelected()){
            txt_newpassword1.setEchoChar((char)0);
            txt_confirmpassword1.setEchoChar((char)0);
        }
        else{
            txt_newpassword1.setEchoChar('*');
            txt_confirmpassword1.setEchoChar('*');
        }
    }//GEN-LAST:event_show_passActionPerformed

    private void txt_currentpassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_currentpassword1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_currentpassword1ActionPerformed

    private void Change_OldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Change_OldPasswordActionPerformed
        String Username=name1.getText();
        String CurrentPassword=txt_currentpassword1.getText();
        String NewPassword=txt_newpassword1.getText();
        String ConfirmPassword=txt_confirmpassword1.getText();
        if(txt_currentpassword1.getText().equals("")  && txt_newpassword1.getText().equals("") &&txt_confirmpassword1.getText().equals("") )
        {
            JOptionPane.showMessageDialog(null,"Please Input a All the Details");

        }else if(txt_currentpassword1.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Input a Current Password");

        }
        else if(txt_newpassword1.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Input New Password");

        }

        else if(txt_confirmpassword1.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Input a Confirm Password");

        }
        else{
            if(!(new String(txt_newpassword1.getPassword()).equals(new String(txt_confirmpassword1.getPassword()))))
            {
                JOptionPane.showMessageDialog(this,"Your Confirm Password Does Not Match!");
            }else{
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginauth","root","Abhay@9899");
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery("select USERNAME from user  where  PASSWORD='"+CurrentPassword+"'");
                    if(rs.next()){
                        st.executeUpdate("update user set PASSWORD='"+ConfirmPassword+ "' where USERNAME='"+Username+"' ");
                        JOptionPane.showMessageDialog(null,"User Password Updated Successfully");
                        txt_currentpassword1.setText("");
                        txt_newpassword1.setText("");
                        txt_confirmpassword1.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Please Write correct Current Password");
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
            }
        }
    }//GEN-LAST:event_Change_OldPasswordActionPerformed

    private void txt_confirmpassword1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_confirmpassword1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_confirmpassword1KeyReleased

    private void DATA_UPDATED_INSERTEDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DATA_UPDATED_INSERTEDActionPerformed
       if(txt_id1.getText().equals("")  && txt_username1.getText().equals("") &&txt_fullname1.getText().equals("")  && txt_email1.getText().equals("") 
           &&txt_contactno1.getText().equals("")  && profile_image.getIcon()==null &&Gender_radioButton1.isSelected(null) && jTextFieldIMAGName1.getText().equals("")   
               && jTextFieldIMAGPath1.getText().equals("")&&ComboBox_language1.getSelectedItem().equals("---SELECT LANGUAGE---")  &&ComboBox_country1.getSelectedItem().equals("---SELECT COUNTRY---") 
               && ComboBox_SecurityQ1.getSelectedItem().equals("---Select Security Question---")&&txt_dob1.getDate()==null&&txt_answer1.getText().equals("")  && txt_password1.getText().equals("")){
       JOptionPane.showMessageDialog(null,"Please Input All Details");
       }else{
           try{
              int opt=JOptionPane.showConfirmDialog(null,"Are You want Update ","Update",JOptionPane.YES_NO_OPTION);
            String Username=txt_username1.getText();
            String Fullname=txt_fullname1.getText();
            String Email=txt_email1.getText();
            String Contactno=txt_contactno1.getText();
            String gender=" ";
            String Language=(String)ComboBox_language1.getSelectedItem();
            String Country=(String)ComboBox_country1.getSelectedItem();
            String SecurityQ=(String)ComboBox_SecurityQ1.getSelectedItem();
            Date date=txt_dob1.getDate();
            SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
            String DOB=sdf.format(date);
            String ANSWER=txt_answer1.getText();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/loginauth","root","Abhay@9899");
            if(male.isSelected()  ){
                gender="Male";
            }else if(female.isSelected()  ){
                gender="Female";
            }
            String sql="update user set FullNAME=?,EMAILID=? ,CONTACTNO=?,GENDER=?,LANGUAGE=?,COUNTRY=?,SECURITYQ=?,ANSWER=?,DOB=? where USERNAME=?" ;
            PreparedStatement p=con.prepareStatement(sql);
            p.setString(1,Fullname);
            p.setString(2,Email);
            p.setString(3,Contactno);
            p.setString(4,gender);
            p.setString(5,Language);
            p.setString(6,Country);
            p.setString(7,SecurityQ);
            p.setString(8,ANSWER);
            p.setString(9,DOB);
            //p.setInt(10,User_id);
            p.setString(10,Username);
            int rowCount=p.executeUpdate();
            if(opt==0){
            if(rowCount>0){
                JOptionPane.showMessageDialog(null,"User Details Updated");
                RefreshUserDetails();
            }else{
                JOptionPane.showMessageDialog(null,"User Details Updated Failed");
                RefreshUserDetails();
            }
            }else{
            
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
       }
        
    }//GEN-LAST:event_DATA_UPDATED_INSERTEDActionPerformed

    private void ComboBox_country1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_country1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_country1ActionPerformed

    private void ComboBox_language1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_language1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_language1ActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleActionPerformed

    private void profile_imageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_imageMouseClicked
        // TODO add your handling code here:
        //        IMAGE_DISPLAY_JFRAME IPAGE=new IMAGE_DISPLAY_JFRAME();
        //         IPAGE.show();
        //         ImageGetInTable();
    }//GEN-LAST:event_profile_imageMouseClicked

    private void Update_user_imageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Update_user_imageMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Update_user_imageMouseClicked

    private void UPDATED_IMAGEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATED_IMAGEActionPerformed
        // TODO add your handling code here:
        if(filename!=null ){
try{
    int User_id=Integer.parseInt(txt_id3.getText());
    String ImageName=jTextFieldIMAGName2.getText();
    String ImagePath=jTextFieldIMAGPath2.getText();
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginauth","root","Abhay@9899");
InputStream img=new FileInputStream(new File(filename));
String sql="Update  user set IMAGE=?,IMAGE_NAME=?,IMAGE_PATH=? where ID='"+User_id+"'";
PreparedStatement pst=con.prepareStatement(sql);
pst.setBlob(1,img);
 pst.setString(2,ImageName);
 pst.setString(3,ImagePath);
 //pst.setInt(4,User_id);
if(pst.executeUpdate()==1){
     JOptionPane.showMessageDialog(null,"Image Updated");
    RefereshImage_HomePage_Details();
}else{
JOptionPane.showMessageDialog(null,"No Image Exist With this ID");
}
  }catch(Exception e){
              JOptionPane.showMessageDialog(null,e);
              }
        }else{
        JOptionPane.showMessageDialog(null,"No Image Selected");
    }
          filename=null;    
    }//GEN-LAST:event_UPDATED_IMAGEActionPerformed
public void RefereshImage_HomePage_Details(){

    try{
        int User_id=Integer.parseInt(txt_id3.getText());
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginauth","root","Abhay@9899");
        InputStream img=new FileInputStream(new File(filename));
         Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("Select * from user where ID= '"+User_id+"' ");
            if(rs.next()){
                jTextFieldIMAGName1.setText(rs.getString(8));
                jTextFieldIMAGPath1.setText(rs.getString(9));
                byte[] imagedata=rs.getBytes ("IMAGE");
                format=new ImageIcon(imagedata);
                Image mm=format.getImage();
                Image img2=mm.getScaledInstance(164,208,Image.SCALE_SMOOTH);
                ImageIcon image=new ImageIcon(img2); 
                profile_image.setIcon(image);
                Home_index_imageUser.setIcon(image);
                
            }
    
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }

}
    private void CHANGE_IMAGEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHANGE_IMAGEActionPerformed
        // TODO add your handling code here:
        JFileChooser imageFileChooser=new JFileChooser();
           imageFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
           imageFileChooser.setDialogTitle("CHOOSE IMAGE");
           FileNameExtensionFilter imageFNEF=new FileNameExtensionFilter("IMAGES","png","jpeg","jpg");
           imageFileChooser.setFileFilter(imageFNEF);
           int imageChooser=imageFileChooser.showSaveDialog(null);
           if(imageChooser==JFileChooser.APPROVE_OPTION){
           File  imageFile=imageFileChooser.getSelectedFile(); //import java.io.File;
           crudImageAbsolutePath=imageFile.getAbsolutePath();
           crudImageName=imageFile.getName();
           jTextFieldIMAGName2.setText(crudImageName);
           jTextFieldIMAGPath2.setText(crudImageAbsolutePath);
           String path=imageFile.getAbsolutePath();
          Update_user_image.setIcon(ResizeImage(path));
          filename = path;
            }else if(imageChooser==JFileChooser.CANCEL_OPTION){
        System.out.println("No file Selected");
            }   
    }//GEN-LAST:event_CHANGE_IMAGEActionPerformed

    private void jLabel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseClicked
        // TODO add your handling code here:
        JTABBED_PANEL_BODY.setSelectedIndex(1);
    }//GEN-LAST:event_jLabel48MouseClicked

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
        // TODO add your handling code here:
        JTABBED_PANEL_BODY.setSelectedIndex(2);
    }//GEN-LAST:event_jLabel50MouseClicked

    private void jLabel51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseClicked
        // TODO add your handling code here:
        JTABBED_PANEL_BODY.setSelectedIndex(3);
    }//GEN-LAST:event_jLabel51MouseClicked

    private void jPanel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MouseClicked
        // TODO add your handling code here:
         JTABBED_PANEL_BODY.setSelectedIndex(3);
    }//GEN-LAST:event_jPanel23MouseClicked

    private void jPanel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseClicked
        // TODO add your handling code here:
          JTABBED_PANEL_BODY.setSelectedIndex(2);
    }//GEN-LAST:event_jPanel22MouseClicked

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel46MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:
          JTABBED_PANEL_BODY.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel27MouseClicked

    private void updatepasswordbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatepasswordbackMouseClicked
        // TODO add your handling code here:
         JTABBED_PANEL_BODY.setSelectedIndex(0);
    }//GEN-LAST:event_updatepasswordbackMouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // TODO add your handling code here:
        JTABBED_PANEL_BODY.setSelectedIndex(0);
        RefreshUserDetails();
    }//GEN-LAST:event_jLabel28MouseClicked

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(USER_HOME_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(USER_HOME_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(USER_HOME_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(USER_HOME_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new USER_HOME_PAGE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Admin;
    private javax.swing.JButton CHANGE_IMAGE;
    private javax.swing.JButton Change_OldPassword;
    public javax.swing.JComboBox<String> ComboBox_SecurityQ1;
    public javax.swing.JComboBox<String> ComboBox_country1;
    public javax.swing.JComboBox<String> ComboBox_language1;
    private javax.swing.JButton DATA_UPDATED_INSERTED;
    private javax.swing.JLabel Database;
    private javax.swing.ButtonGroup Gender_radioButton1;
    private javax.swing.JLabel HOME;
    public javax.swing.JLabel Home_index_imageUser;
    private javax.swing.JTabbedPane JTABBED_PANEL_BODY;
    private javax.swing.JPanel PANEL_HEADER;
    private javax.swing.JPanel PANEL_MENU;
    private javax.swing.JLabel SETTING;
    private javax.swing.JLabel STAFF;
    private javax.swing.JLabel SUB_ADMIN;
    private javax.swing.JButton UPDATED_IMAGE;
    public javax.swing.JLabel Update_user_image;
    private javax.swing.JPanel datbase;
    public javax.swing.JRadioButton female;
    private javax.swing.JPanel homepanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JLabel jTextFieldIMAGName1;
    public javax.swing.JLabel jTextFieldIMAGName2;
    public javax.swing.JLabel jTextFieldIMAGPath1;
    public javax.swing.JLabel jTextFieldIMAGPath2;
    private javax.swing.JPanel logout;
    public javax.swing.JRadioButton male;
    public javax.swing.JLabel name1;
    public javax.swing.JLabel profile_image;
    private javax.swing.JPanel setting;
    private javax.swing.JCheckBox show_pass;
    private javax.swing.JPanel staff;
    private javax.swing.JLabel txt_Dashboard_Date;
    private javax.swing.JLabel txt_Dashboard_Time;
    public javax.swing.JTextField txt_answer1;
    private javax.swing.JPasswordField txt_confirmpassword1;
    public javax.swing.JTextField txt_contactno1;
    private javax.swing.JTextField txt_currentpassword1;
    public com.toedter.calendar.JDateChooser txt_dob1;
    public javax.swing.JTextField txt_email1;
    public javax.swing.JTextField txt_fullname1;
    private javax.swing.JLabel txt_id;
    public javax.swing.JLabel txt_id1;
    private javax.swing.JLabel txt_id2;
    public javax.swing.JLabel txt_id3;
    private javax.swing.JPasswordField txt_newpassword1;
    public javax.swing.JLabel txt_password1;
    public javax.swing.JLabel txt_username1;
    private javax.swing.JLabel updatepasswordback;
    // End of variables declaration//GEN-END:variables
}
