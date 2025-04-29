import com.mysql.cj.jdbc.Blob;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.lang.String;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Timer;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

public class ADMIN_HOMEPAGE extends javax.swing.JFrame {
String StudentName,UserName,DOB,EmaiLID,EmailId,ContactNo;
int StudentID;
public String userEmail;
DefaultTableModel model;
String path2=null;
String AdminUsername,AdminName, RegDate,PassWord;
String crudImageAbsolutePath=" " ;
   private ImageIcon format=null;  
    public ADMIN_HOMEPAGE() {
        initComponents();
        SetIcon();
        setStudentDetailsTable();
        setAdminDetailsTable();
        date();//dashboard date 
        time();//dashboard time
        SetHome_profile_image();
        setTotalUser();
        setTotalAdmin();
    }
    private void SetIcon(){
setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
}
    /*
     txt_admin_username.getText());
      txt_admin_fullname.getText());
      txt_admin_emailid.getText());
      txt_admin_contactno.getText());
      txt_admin_password.getText());
    */
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
      public void setTotalUser(){
      
         try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginauth","root","Abhay@9899");
                String sql = "SELECT count(ID) FROM user";
               PreparedStatement  prepare = con.prepareStatement(sql);
                ResultSet rs=prepare.executeQuery();
                  int countEnrolled = 0;
                  if (rs.next()) {
                countEnrolled = rs.getInt("count(ID)");
                 }
               USER.setText(String.valueOf(countEnrolled)  );
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"Error! in USER Count");
    }
     }
       public void setTotalAdmin(){
      
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
    public void DashBoardTime(){
Date thisdate=new Date();
SimpleDateFormat temp=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss a");   // a stands for Am
//sDashboard_Time.setText(temp.format(thisdate));
}
    
    public int AdminID_NO(){
int AdminID=1;
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginauth","root","Abhay@9899");
PreparedStatement pst=con.prepareStatement("Select max(ID) from table_admin");
ResultSet rs=pst.executeQuery();
if(rs.next()==true){
                   AdminID=rs.getInt(1);
                }
}catch(Exception e){
e.printStackTrace();

}
return AdminID+1;
}
    //Second Method to set details in Profile
//    public void setAdminDetailsProfile(){
//       try{
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginauth","root","Abhay@9899");
//                Statement st=con.createStatement();
//                String Username=name.getText();
//                ResultSet rs=st.executeQuery("Select * from table_admin where Admin_Username= '"+Username+"'");
//                while(rs.next()){
//                    txt_ADMIN_PROFILE_USERNAME.setText(rs.getString(2));
//                    txt_ADMIN_PROFILE_FULLNAME.setText(rs.getString(3));
//                    txt_ADMIN_PROFILE_EMAILID.setText(rs.getString(4));
//                    txt_ADMIN_PROFILE_CONTACTNO.setText(rs.getString(5));
//                    txt_ADMIN_PROFILE_REGDATE.setText(rs.getString(8));
//    
//                }
//                   
//    }catch(Exception e){
//        JOptionPane.showMessageDialog(null,e);
//    }
//    }
    public void SetHome_profile_image(){
     try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginauth","root","Abhay@9899");
           PreparedStatement pst=con.prepareStatement("Select Admin_Image from table_admin Where User_Type=1 " );
       ResultSet rs=pst.executeQuery();
        if(rs.next()){
                byte[] imagedata=rs.getBytes ("Admin_Image");
                format=new ImageIcon(imagedata);
                Image mm=format.getImage();
                Image img2=mm.getScaledInstance(Home_index_image.getWidth(),Home_index_image.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon image=new ImageIcon(img2); 
                Home_index_image.setIcon(image);
                
                 }else{
        }
        }catch(Exception e){
        }
    }
    public void setAdminDetailsTable(){
    try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginauth","root","Abhay@9899");
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("Select * from table_admin where User_Type= 0");
                while(rs.next()){
                String AdminUsername=rs.getString("Admin_Username");
                String AdminName=rs.getString("Admin_Name");
                String EmailId=rs.getString("EmailID");
                String ContactNo=rs.getString("ContactNo");
                String PassWord=rs.getString("Password");
                Object[] obj={AdminUsername,AdminName,EmailId,ContactNo,PassWord};
                 model = (DefaultTableModel)table_admin.getModel();
                model.addRow(obj);
                }
                   
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
    }
public void setStudentDetailsTable(){
    try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginauth","root","Abhay@9899");
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("Select * from user");
                while(rs.next()){
                String StudentID=rs.getString("ID");
                String StudentName=rs.getString("FULLNAME");
                String Course=rs.getString("USERNAME");
                 String Gender=rs.getString("GENDER");
                String DOB=rs.getString("DOB");
                String EmaiLID=rs.getString("EMAILID");
                String ContactNo=rs.getString("CONTACTNO");
                Object[] obj={StudentID,StudentName,Course,Gender,DOB,EmaiLID,ContactNo};
                 model = (DefaultTableModel)table_student.getModel();
                model.addRow(obj);
                }
                   
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
    }
 public void clearTabelStudent(){
DefaultTableModel model=(DefaultTableModel)table_student.getModel();
model.setRowCount(0);
}
 public void clearTabeladmin(){
DefaultTableModel model=(DefaultTableModel)table_admin.getModel();
model.setRowCount(0);
}
 public boolean updateadmin(){
    boolean isUpdated=false;
AdminUsername=txt_admin_username.getText();
AdminName=txt_admin_fullname.getText();
EmailId=txt_admin_emailid.getText();
ContactNo=txt_admin_contactno.getText();
PassWord=txt_admin_password.getText();
//String crudImageAbsolutePath=" " ;
InputStream imageIS=null;
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginauth","root","Abhay@9899");
//ImageIcon imageicon=new ImageIcon(crudImageAbsolutePath);
//imageIS=new FileInputStream(new File(crudImageAbsolutePath));
String sql="update table_admin set Admin_Name=?,EmailID=? ,ContactNo=?,Password=?  where Admin_Username=?" ;
PreparedStatement pst=con.prepareStatement(sql);
pst.setString(1,AdminName);
pst.setString(2,EmailId);
pst.setString(3,ContactNo);
pst.setString(4,PassWord);
//pst.setBlob(5,imageIS);
pst.setString(5,AdminUsername);
//pst.setInt(6,0);
int rowCount=pst.executeUpdate();

if(rowCount>0){
     isUpdated=true;
      
}else{
     isUpdated=false;
}
}catch(Exception e){
   JOptionPane.showMessageDialog(null,e);
    }

return isUpdated;
}
 public boolean deleteadmin(){
boolean isDeleted=false;
AdminUsername=txt_admin_username.getText();
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginauth","root","Abhay@9899");
String sql="delete from table_admin where Admin_Username=?" ;
PreparedStatement pst=con.prepareStatement(sql);
pst.setString(1,AdminUsername);
int rowCount=pst.executeUpdate();
if(rowCount>0){
     isDeleted=true;
}else{
     isDeleted=false;
}

}catch(Exception e){
JOptionPane.showMessageDialog(null,e);      
}

return isDeleted;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        Home_index_image = new javax.swing.JLabel();
        txt_Dashboard_Date = new javax.swing.JLabel();
        txt_Dashboard_Time = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        PANEL_HEADER = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        JTABBED_PANEL_BODY = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        USER = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        SUB_ADMIN = new javax.swing.JLabel();
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
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_student = new rojeru_san.complementos.RSTableMetro();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_admin_emailid = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txt_admin_contactno = new javax.swing.JTextField();
        txt_admin_password = new javax.swing.JPasswordField();
        show_pass1 = new javax.swing.JCheckBox();
        UpdateSubAdminDetails = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txt_admin_fullname = new javax.swing.JTextField();
        txt_admin_username = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_admin = new rojeru_san.complementos.RSTableMetro();
        jLabel35 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        manage_staff_image1 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        txt_subadminid = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txt_emailid = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txt_contactno = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        show_pass3 = new javax.swing.JCheckBox();
        jButton5 = new javax.swing.JButton();
        uploadButton = new javax.swing.JButton();
        txt_fullname = new javax.swing.JTextField();
        elab = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_ADMIN_PROFILE_EMAILID = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txt_ADMIN_PROFILE_CONTACTNO = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txt_ADMIN_PROFILE_FULLNAME = new javax.swing.JTextField();
        txt_ADMIN_PROFILE_REGDATE = new javax.swing.JLabel();
        txt_ADMIN_PROFILE_USERNAME = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_newpassword = new javax.swing.JPasswordField();
        txt_confirmpassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        txt_currentpassword = new javax.swing.JTextField();
        show_pass = new javax.swing.JCheckBox();
        jPanel13 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PANEL_MENU.setBackground(new java.awt.Color(0, 102, 102));
        PANEL_MENU.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PANEL_MENU.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homepanel.setBackground(new java.awt.Color(0, 102, 102));
        homepanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        homepanel.setPreferredSize(new java.awt.Dimension(157, 50));
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
                .addGap(20, 20, 20)
                .addComponent(HOME, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homepanelLayout.setVerticalGroup(
            homepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HOME, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        PANEL_MENU.add(homepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 243, 188, -1));

        datbase.setBackground(new java.awt.Color(0, 102, 102));
        datbase.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        datbase.setPreferredSize(new java.awt.Dimension(157, 50));
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
        Database.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/database1.png"))); // NOI18N
        Database.setText("Database");
        Database.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DatabaseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout datbaseLayout = new javax.swing.GroupLayout(datbase);
        datbase.setLayout(datbaseLayout);
        datbaseLayout.setHorizontalGroup(
            datbaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datbaseLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Database, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        datbaseLayout.setVerticalGroup(
            datbaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datbaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Database, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        PANEL_MENU.add(datbase, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 293, 188, -1));

        setting.setBackground(new java.awt.Color(0, 102, 102));
        setting.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setting.setPreferredSize(new java.awt.Dimension(157, 50));
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
            .addGroup(settingLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(SETTING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        settingLayout.setVerticalGroup(
            settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SETTING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        PANEL_MENU.add(setting, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 393, 188, -1));

        staff.setBackground(new java.awt.Color(0, 102, 102));
        staff.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        staff.setPreferredSize(new java.awt.Dimension(157, 50));
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
        STAFF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/setting.png"))); // NOI18N
        STAFF.setText("Sub-Admin");
        STAFF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                STAFFMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout staffLayout = new javax.swing.GroupLayout(staff);
        staff.setLayout(staffLayout);
        staffLayout.setHorizontalGroup(
            staffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(STAFF)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        staffLayout.setVerticalGroup(
            staffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(STAFF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        PANEL_MENU.add(staff, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 343, 188, -1));

        Home_index_image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PANEL_MENU.add(Home_index_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, 190));

        txt_Dashboard_Date.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_Dashboard_Date.setForeground(new java.awt.Color(255, 255, 255));
        PANEL_MENU.add(txt_Dashboard_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 140, 29));

        txt_Dashboard_Time.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_Dashboard_Time.setForeground(new java.awt.Color(255, 255, 255));
        PANEL_MENU.add(txt_Dashboard_Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 564, 180, 29));

        logout.setBackground(new java.awt.Color(0, 102, 102));
        logout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        logout.setPreferredSize(new java.awt.Dimension(157, 50));
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
            .addGroup(logoutLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logoutLayout.setVerticalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        PANEL_MENU.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 443, 188, -1));

        jPanel1.add(PANEL_MENU, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 44, 190, 600));

        PANEL_HEADER.setBackground(new java.awt.Color(0, 102, 102));
        PANEL_HEADER.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        name.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DASHBOARD");

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/two-factor-authentication (1).png"))); // NOI18N
        jLabel60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel60MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PANEL_HEADERLayout = new javax.swing.GroupLayout(PANEL_HEADER);
        PANEL_HEADER.setLayout(PANEL_HEADERLayout);
        PANEL_HEADERLayout.setHorizontalGroup(
            PANEL_HEADERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_HEADERLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        PANEL_HEADERLayout.setVerticalGroup(
            PANEL_HEADERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_HEADERLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PANEL_HEADERLayout.createSequentialGroup()
                .addGroup(PANEL_HEADERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel60))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(PANEL_HEADER, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, -1));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ADMIN/ HOME");

        jPanel8.setBackground(new java.awt.Color(0, 153, 153));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel8.setPreferredSize(new java.awt.Dimension(256, 187));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setText("TOTAL USER");

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/businessman.png"))); // NOI18N

        USER.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        USER.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(USER, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(USER, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jLabel41)))
                .addContainerGap())
        );

        jPanel19.setBackground(new java.awt.Color(0, 153, 153));
        jPanel19.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel19.setPreferredSize(new java.awt.Dimension(256, 187));

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/engineer (1).png"))); // NOI18N

        jLabel43.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel43.setText("TOTAL SUB-ADMIN");

        SUB_ADMIN.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        SUB_ADMIN.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SUB_ADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SUB_ADMIN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel20.setBackground(new java.awt.Color(0, 153, 153));
        jPanel20.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel20.setPreferredSize(new java.awt.Dimension(256, 187));

        jLabel45.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel45.setText("USER DATABASE");

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/database.png"))); // NOI18N
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
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addContainerGap())
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
        jLabel47.setText("ADMIN PROFILE");

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/administrator.png"))); // NOI18N
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
                .addContainerGap()
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jLabel49.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel49.setText("MANAGE SUB-ADMIN");

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/social-engineering.png"))); // NOI18N
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/web-development.png"))); // NOI18N
        jLabel51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel51MouseClicked(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel52.setText("ABOUT DEVELOPER");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addContainerGap())
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, 186, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, 186, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, 186, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel21, 190, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );

        JTABBED_PANEL_BODY.addTab("tab1", jPanel3);
        jPanel3.getAccessibleContext().setAccessibleParent(jPanel3);

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DATABASE / USER");

        table_student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " S_ID", "Username", "Fullname", "Gender", "DOB", "Email ID", "Contact No"
            }
        ));
        table_student.setRowHeight(30);
        table_student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_studentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_student);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clear (1).png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reload1.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        lb.setBackground(new java.awt.Color(0, 153, 153));
        lb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb.setPreferredSize(new java.awt.Dimension(134, 172));
        lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(6, 6, 6)
                            .addComponent(jLabel14))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(669, 669, 669)
                        .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        JTABBED_PANEL_BODY.addTab("tab2", jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("SUB-ADMIN/ MANAGE-STAFF");

        jPanel11.setBackground(new java.awt.Color(0, 153, 153));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel12.setBackground(new java.awt.Color(0, 123, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Fill the Info");

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel38MouseClicked(evt);
            }
        });

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/broom.png"))); // NOI18N
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Username");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setText("Full Name");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setText("Contact No");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setText("Email ID");

        txt_admin_emailid.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_admin_emailid.setToolTipText("");
        txt_admin_emailid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_admin_emailid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_admin_emailidActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel23.setText("Password");

        txt_admin_contactno.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_admin_contactno.setToolTipText("");
        txt_admin_contactno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_admin_contactno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_admin_contactnoActionPerformed(evt);
            }
        });

        txt_admin_password.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_admin_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_admin_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_admin_passwordActionPerformed(evt);
            }
        });

        show_pass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_pass1ActionPerformed(evt);
            }
        });

        UpdateSubAdminDetails.setBackground(new java.awt.Color(0, 123, 255));
        UpdateSubAdminDetails.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        UpdateSubAdminDetails.setForeground(new java.awt.Color(255, 255, 255));
        UpdateSubAdminDetails.setText("Update");
        UpdateSubAdminDetails.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        UpdateSubAdminDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateSubAdminDetailsActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 123, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txt_admin_fullname.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_admin_fullname.setToolTipText("");
        txt_admin_fullname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_admin_fullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_admin_fullnameActionPerformed(evt);
            }
        });

        txt_admin_username.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_admin_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(UpdateSubAdminDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(show_pass1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_admin_username, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_admin_contactno, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_admin_password, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_admin_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_admin_emailid, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_admin_username, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_admin_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_admin_emailid, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(txt_admin_contactno, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(txt_admin_password, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(show_pass1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateSubAdminDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        table_admin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        table_admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Fullname", "Email-ID", "ContactNo", "Password"
            }
        ));
        table_admin.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        table_admin.setFuenteHead(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        table_admin.setRowHeight(30);
        table_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_adminMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_admin);

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clear (1).png"))); // NOI18N
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
        });

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reload1.png"))); // NOI18N
        jLabel39.setToolTipText("");
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });

        manage_staff_image1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        manage_staff_image1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manage_staff_image1MouseClicked(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel40.setText("Update_Img");
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel39)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(523, 523, 523)
                                .addComponent(manage_staff_image1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel40)
                                .addGap(22, 22, 22)))))
                .addGap(14, 14, 14))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(manage_staff_image1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40))
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );

        JTABBED_PANEL_BODY.addTab("tab3", jPanel6);

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("SUB-ADMIN/ ADD-SUBADMIN");

        jPanel16.setBackground(new java.awt.Color(204, 204, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jPanel17.setBackground(new java.awt.Color(0, 123, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_subadminid.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_subadminid.setForeground(new java.awt.Color(255, 255, 255));
        txt_subadminid.setText("Fill the Info");
        jPanel17.add(txt_subadminid, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 6, -1, -1));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/left-arrow.png"))); // NOI18N
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });
        jPanel17.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 1, -1, 29));

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel30.setText("Username");

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel31.setText("Full Name");

        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel32.setText("Contact No");

        txt_username.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_username.setToolTipText("");
        txt_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_usernameKeyReleased(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel33.setText("Email ID");

        txt_emailid.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_emailid.setToolTipText("");
        txt_emailid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_emailid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailidActionPerformed(evt);
            }
        });
        txt_emailid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_emailidKeyReleased(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel34.setText("Password");

        txt_contactno.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_contactno.setToolTipText("");
        txt_contactno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_contactno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contactnoActionPerformed(evt);
            }
        });
        txt_contactno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_contactnoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_contactnoKeyReleased(evt);
            }
        });

        txt_password.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });

        show_pass3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_pass3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 123, 255));
        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Submit");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        uploadButton.setBackground(new java.awt.Color(0, 123, 255));
        uploadButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        uploadButton.setForeground(new java.awt.Color(255, 255, 255));
        uploadButton.setText("Upload Image");
        uploadButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        txt_fullname.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_fullname.setToolTipText("");
        txt_fullname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_fullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fullnameActionPerformed(evt);
            }
        });

        elab.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        elab.setForeground(new java.awt.Color(204, 0, 0));

        jLabel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(elab, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(txt_emailid, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_contactno, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(show_pass3))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(elab, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txt_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_emailid, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(uploadButton)))
                .addGap(6, 6, 6)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(txt_contactno, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(show_pass3)))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel29.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(0, 800, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTABBED_PANEL_BODY.addTab("tab4", jPanel7);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("SETTING/ PROFILE");

        jPanel14.setBackground(new java.awt.Color(204, 204, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel15.setBackground(new java.awt.Color(0, 123, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Update the Info");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel24.setText("Username");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel25.setText("Full Name");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel26.setText("Contact No");

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel27.setText("Email ID");

        txt_ADMIN_PROFILE_EMAILID.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_ADMIN_PROFILE_EMAILID.setForeground(new java.awt.Color(255, 51, 51));
        txt_ADMIN_PROFILE_EMAILID.setToolTipText("");
        txt_ADMIN_PROFILE_EMAILID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_ADMIN_PROFILE_EMAILID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ADMIN_PROFILE_EMAILIDActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel28.setText("Registration Date");

        txt_ADMIN_PROFILE_CONTACTNO.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_ADMIN_PROFILE_CONTACTNO.setForeground(new java.awt.Color(255, 51, 51));
        txt_ADMIN_PROFILE_CONTACTNO.setToolTipText("");
        txt_ADMIN_PROFILE_CONTACTNO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_ADMIN_PROFILE_CONTACTNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ADMIN_PROFILE_CONTACTNOActionPerformed(evt);
            }
        });
        txt_ADMIN_PROFILE_CONTACTNO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ADMIN_PROFILE_CONTACTNOKeyReleased(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 123, 255));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Submit");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("Change password ?");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        txt_ADMIN_PROFILE_FULLNAME.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_ADMIN_PROFILE_FULLNAME.setForeground(new java.awt.Color(255, 51, 51));
        txt_ADMIN_PROFILE_FULLNAME.setToolTipText("");
        txt_ADMIN_PROFILE_FULLNAME.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_ADMIN_PROFILE_FULLNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ADMIN_PROFILE_FULLNAMEActionPerformed(evt);
            }
        });

        txt_ADMIN_PROFILE_REGDATE.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_ADMIN_PROFILE_REGDATE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_ADMIN_PROFILE_REGDATE.setPreferredSize(new java.awt.Dimension(64, 31));

        txt_ADMIN_PROFILE_USERNAME.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_ADMIN_PROFILE_USERNAME.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_ADMIN_PROFILE_USERNAME.setPreferredSize(new java.awt.Dimension(64, 31));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_ADMIN_PROFILE_FULLNAME, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txt_ADMIN_PROFILE_EMAILID, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_ADMIN_PROFILE_CONTACTNO, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(25, 25, 25)))
                    .addComponent(txt_ADMIN_PROFILE_REGDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_ADMIN_PROFILE_USERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_ADMIN_PROFILE_USERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ADMIN_PROFILE_FULLNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ADMIN_PROFILE_EMAILID, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ADMIN_PROFILE_CONTACTNO, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ADMIN_PROFILE_REGDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        JTABBED_PANEL_BODY.addTab("tab5", jPanel2);

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("SETTING/ UPDATE PASSWORD");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel10.setBackground(new java.awt.Color(0, 123, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("CHANGE YOUR PASSWORD");

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/left-arrow.png"))); // NOI18N
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel36MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel36)
                .addGap(58, 58, 58)
                .addComponent(jLabel15)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel36)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Current Password");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("New Password");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Confirm Password");

        txt_newpassword.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_newpassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txt_confirmpassword.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_confirmpassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_confirmpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_confirmpasswordKeyReleased(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 123, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Change");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_currentpassword.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_currentpassword.setToolTipText("");
        txt_currentpassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_currentpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_currentpasswordActionPerformed(evt);
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
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_newpassword)
                    .addComponent(txt_confirmpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addComponent(txt_currentpassword))
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
                .addComponent(txt_currentpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txt_newpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_confirmpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(show_pass))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(255, 255, 255))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        JTABBED_PANEL_BODY.addTab("tab6", jPanel4);

        jPanel13.setBackground(new java.awt.Color(0, 153, 153));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("ABOUT DEVELOPER");
        jPanel13.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 181, 29));

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/left-arrow.png"))); // NOI18N
        jLabel54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel54MouseClicked(evt);
            }
        });
        jPanel13.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 41, -1, -1));

        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/image__2.png"))); // NOI18N
        jPanel13.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, -1, 499));

        jLabel56.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel56.setText("Version -1.01");
        jPanel13.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, -1, -1));

        jLabel57.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel57.setText("Contact Details :-abhaymehta9**@gmail.com");
        jPanel13.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 470, -1));

        jLabel58.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel58.setText("Copyright @2024");
        jPanel13.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 220, -1));

        jLabel59.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel59.setText("Login Authentication System");
        jPanel13.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, -1));

        JTABBED_PANEL_BODY.addTab("tab7", jPanel13);

        jPanel1.add(JTABBED_PANEL_BODY, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 1050, 630));
        JTABBED_PANEL_BODY.getAccessibleContext().setAccessibleName("tab1");

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
        JTABBED_PANEL_BODY.setSelectedIndex(4);
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

    private void table_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_studentMouseClicked
        // TODO add your handling code here:
        int selectedRow=table_student.getSelectedRow();
        DefaultTableModel model=(DefaultTableModel)table_student.getModel();
        int i=table_student.getSelectedRow();
        String click1=(table_student.getModel().getValueAt(i,0).toString());
         String sql="Select IMAGE from user Where ID='"+click1+ "'  ";
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginauth","root","Abhay@9899");
           PreparedStatement pst=con.prepareStatement(sql);
           ResultSet rs=pst.executeQuery();
           if(rs.next()){
                byte[] imagedata=rs.getBytes ("IMAGE");
                format=new ImageIcon(imagedata);
                Image mm=format.getImage();
                Image img2=mm.getScaledInstance(lb.getWidth(),lb.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon image=new ImageIcon(img2); 
                lb.setIcon(image);
                
                 }else{
        }
        }catch(Exception e){
        }
    }//GEN-LAST:event_table_studentMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        clearTabelStudent();
       lb.setIcon(null);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        clearTabelStudent();
        setStudentDetailsTable();
        lb.setIcon(null);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String Username=name.getText();
        String CurrentPassword=txt_currentpassword.getText();
        String NewPassword=txt_newpassword.getText();
        String ConfirmPassword=txt_confirmpassword.getText();
        if(txt_currentpassword.getText().equals("")  && txt_newpassword.getText().equals("") &&txt_confirmpassword.getText().equals("") )
        {
            JOptionPane.showMessageDialog(null,"Please Input a All the Details");

        }else if(txt_currentpassword.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Input a Current Password");

        }
        else if(txt_newpassword.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Input New Password");

        }

        else if(txt_confirmpassword.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Input a Confirm Password");

        }
        else{
            if(!(new String(txt_newpassword.getPassword()).equals(new String(txt_confirmpassword.getPassword()))))
            {
             JOptionPane.showMessageDialog(this,"Your Confirm Password Does Not Match!");
            }else{     
                try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/LoginAuth","root","Abhay@9899");
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select Admin_Username from table_admin  where  PASSWORD='"+CurrentPassword+"'");
                if(rs.next()){
                    st.executeUpdate("update table_admin set PASSWORD='"+ConfirmPassword+ "' where Admin_Username='"+Username+"' ");
                    JOptionPane.showMessageDialog(null,"Admin Password Updated Successfully");
                     txt_currentpassword.setText("");
                    txt_newpassword.setText("");
                    txt_confirmpassword.setText("");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please Write correct Current Password");
                     }
             }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
                }
            }
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_currentpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_currentpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_currentpasswordActionPerformed

    private void show_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_passActionPerformed
        // TODO add your handling code here:
        if(show_pass.isSelected()){
            txt_newpassword.setEchoChar((char)0);
            txt_confirmpassword.setEchoChar((char)0);
        }
        else{
            txt_newpassword.setEchoChar('*');
            txt_confirmpassword.setEchoChar('*');
        }
    }//GEN-LAST:event_show_passActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        JTABBED_PANEL_BODY.setSelectedIndex(5);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void txt_ADMIN_PROFILE_EMAILIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ADMIN_PROFILE_EMAILIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ADMIN_PROFILE_EMAILIDActionPerformed

    private void txt_ADMIN_PROFILE_CONTACTNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ADMIN_PROFILE_CONTACTNOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ADMIN_PROFILE_CONTACTNOActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String Admin=txt_ADMIN_PROFILE_USERNAME.getText();
       String Full=txt_ADMIN_PROFILE_FULLNAME.getText();
        String Email=txt_ADMIN_PROFILE_EMAILID.getText();
        String Contact=txt_ADMIN_PROFILE_CONTACTNO.getText();
        String RegDATE=txt_ADMIN_PROFILE_REGDATE.getText();
         if(txt_ADMIN_PROFILE_FULLNAME.getText().equals("")  && txt_ADMIN_PROFILE_EMAILID.getText().equals("") &&txt_ADMIN_PROFILE_CONTACTNO.getText().equals("") )
        {
            JOptionPane.showMessageDialog(null,"Please Input a All the Details");

        }else if(txt_ADMIN_PROFILE_FULLNAME.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Input a FullName");

        }
        else if(txt_ADMIN_PROFILE_EMAILID.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Input a Email Id");

        }

        else if(txt_ADMIN_PROFILE_CONTACTNO.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Input a Contact No");

        }else{
         try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginauth","root","Abhay@9899");
String sql="update table_admin set Admin_Name=?,EMAILID=? ,ContactNo=?,Admin_RegDate=? where Admin_Username=?" ;
PreparedStatement pst=con.prepareStatement(sql);
pst.setString(1,Full);
pst.setString(2,Email);
pst.setString(3,Contact);
pst.setString(4,RegDATE);
pst.setString(5,Admin); 
int rowCount=pst.executeUpdate();
if(rowCount>0){
      JOptionPane.showMessageDialog(null,"Admin Profile  Updated");
}else{
     JOptionPane.showMessageDialog(null,"Admin Profile Updated Failed");
}
}catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
}      
        }
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txt_admin_emailidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_admin_emailidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_admin_emailidActionPerformed

    private void txt_admin_contactnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_admin_contactnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_admin_contactnoActionPerformed

    private void txt_admin_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_admin_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_admin_passwordActionPerformed

    private void show_pass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_pass1ActionPerformed
        // TODO add your handling code here:
        if(show_pass1.isSelected()){
            txt_admin_password.setEchoChar((char)0);
        }
        else{
            txt_admin_password.setEchoChar('*');
        }
    }//GEN-LAST:event_show_pass1ActionPerformed

    private void UpdateSubAdminDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateSubAdminDetailsActionPerformed
DefaultTableModel tblmodel=(DefaultTableModel)table_admin.getModel();
if(table_admin.getSelectedRowCount()==0){
  JOptionPane.showMessageDialog(null,"Details is Empty");
  JOptionPane.showMessageDialog(null,"Please Select a Single Row in Table for Updation");
}else{
     int opt=JOptionPane.showConfirmDialog(null,"Are You want Update ","Update",JOptionPane.YES_NO_OPTION);
      tblmodel.removeRow(table_admin.getSelectedRow());
     if(opt==0){
         if(updateadmin()==true){
            JOptionPane.showMessageDialog(null,"Sub-Admin  Updated");
           txt_admin_username.setText("");
           txt_admin_fullname.setText("");
           txt_admin_emailid.setText("");
           txt_admin_contactno.setText("");
           txt_admin_password.setText("");
           manage_staff_image1.setIcon(null);
           clearTabeladmin();
          setAdminDetailsTable();
        }else{
            JOptionPane.showMessageDialog(null,"Sub-Admin Updated Failed");
           clearTabeladmin();
          setAdminDetailsTable();
        }
     }else{}
}
          txt_admin_username.setText("");
           txt_admin_fullname.setText("");
           txt_admin_emailid.setText("");
           txt_admin_contactno.setText("");
           txt_admin_password.setText("");
           manage_staff_image1.setIcon(null);
          clearTabeladmin();
          setAdminDetailsTable();
    }//GEN-LAST:event_UpdateSubAdminDetailsActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 DefaultTableModel tblmodel=(DefaultTableModel)table_admin.getModel();
if(table_admin.getSelectedRowCount()==0){
  JOptionPane.showMessageDialog(null,"Details is Empty");
  JOptionPane.showMessageDialog(null,"Please Select a Single Row in Table for Deletion");
}else{
     int opt=JOptionPane.showConfirmDialog(null,"Are You want Delete ","Delete",JOptionPane.YES_NO_OPTION);
      tblmodel.removeRow(table_admin.getSelectedRow());
     if(opt==0){
         if(deleteadmin()==true){
            JOptionPane.showMessageDialog(null,"Sub-Admin  Deleted");
           txt_admin_username.setText("");
           txt_admin_fullname.setText("");
           txt_admin_emailid.setText("");
           txt_admin_contactno.setText("");
           txt_admin_password.setText("");
           manage_staff_image1.setIcon(null);
           clearTabeladmin();
          setAdminDetailsTable();
        }else{
            JOptionPane.showMessageDialog(null,"Sub-Admin Deleted Failed");
           clearTabeladmin();
          setAdminDetailsTable();
        }
     }else{}
}
           txt_admin_username.setText("");
           txt_admin_fullname.setText("");
           txt_admin_emailid.setText("");
           txt_admin_contactno.setText("");
           txt_admin_password.setText("");
           manage_staff_image1.setIcon(null);
          clearTabeladmin();
          setAdminDetailsTable();
    }//GEN-LAST:event_jButton3ActionPerformed
/*

    */
    private void table_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_adminMouseClicked
        // TODO add your handling code here:
        int i=table_admin.getSelectedRow();
        TableModel model=table_admin.getModel();
        //DefaultTableModel model=(DefaultTableModel)table_admin.getModel();
         txt_admin_username.setText(model.getValueAt(i,0).toString());
        txt_admin_fullname.setText(model.getValueAt(i,1).toString());
       txt_admin_emailid.setText(model.getValueAt(i,2).toString());
        txt_admin_contactno.setText(model.getValueAt(i,3).toString());
        txt_admin_password.setText(model.getValueAt(i,4).toString()); 
        String click1=(table_admin.getModel().getValueAt(i,0).toString());
         String sql="Select Admin_Image from table_admin Where Admin_Username='"+click1+ "'  ";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginauth","root","Abhay@9899");
           PreparedStatement pst=con.prepareStatement(sql);
       ResultSet rs=pst.executeQuery();
        if(rs.next()){
                byte[] imagedata=rs.getBytes ("Admin_Image");
                format=new ImageIcon(imagedata);
                Image mm=format.getImage();
                Image img2=mm.getScaledInstance(manage_staff_image1.getWidth(),manage_staff_image1.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon image=new ImageIcon(img2); 
                manage_staff_image1.setIcon(image);
                
                 }else{
        }
        }catch(Exception e){
        }
         

    }//GEN-LAST:event_table_adminMouseClicked

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_emailidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailidActionPerformed

    private void txt_contactnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contactnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactnoActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void show_pass3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_pass3ActionPerformed
        // TODO add your handling code here:
        if(show_pass3.isSelected()){
            txt_password.setEchoChar((char)0);
        }
        else{
            txt_password.setEchoChar('*');
        }
    }//GEN-LAST:event_show_pass3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
          // TODO add your handling code here:
       
        String Username=txt_username.getText();
        String FullName=txt_fullname.getText();
        String EmailID=txt_emailid.getText();
        String ContactNo=txt_contactno.getText();
        String Password=txt_password.getText();
        Date thisdate=new Date();
        SimpleDateFormat RegDate=new SimpleDateFormat("YYYY-MM-dd hh:mm:ss ");
        String RDate=RegDate.format(new Date());
          InputStream imageIS=null;
         if(txt_username.getText().equals("")  && txt_fullname.getText().equals("") &&txt_emailid.getText().equals("") 
                && txt_contactno.getText().equals("") &&txt_password.getText().equals("") &&jLabel29.getIcon()==null)
        {
            JOptionPane.showMessageDialog(null,"Please Input a All the Details");

        } 
       else if(txt_username.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Input a Username");

        }
        else if(txt_fullname.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Input FullName");

        }

        else if(txt_emailid.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Input a EmailId");

        }
        else if(txt_contactno.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Input a Contact No.");

        }
        else if(txt_password.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Input Password");

        }

        else if(jLabel29.getIcon()==null)
        {
            JOptionPane.showMessageDialog(null,"Please Upload Image");

        }
        else{
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/LoginAuth","root","Abhay@9899");
             imageIS=new FileInputStream(new File(crudImageAbsolutePath));
                PreparedStatement p =con.prepareStatement("Insert into table_admin   values(?,?,?,?,?,?,?,?,?)");
                p.setInt(1,AdminID_NO());
                p.setString(2,Username);
                p.setString(3,FullName);
                p.setString(4,EmailID);
                p.setString(5,ContactNo);
                p.setString(6,Password);
                p.setBlob(7,imageIS);
                p.setString(8,RDate);
                p.setInt(9,0);
                p.executeUpdate();
                JOptionPane.showMessageDialog(null,"Registration is Sucessfully");
                txt_username.setText("");
                txt_fullname.setText("");
                txt_emailid.setText("");
                txt_contactno.setText("");
                txt_password.setText("");
                jLabel29.setIcon(null);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }

        }
          
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
         String currentDirectoryPath="";//C:\\Users\\Abhay mehta\\Documents\\NetBeansProjects\\CRUD_INSERT_IMAGE_WITH_FORM\\src\\USER_PROFILE_IMAGE
        JFileChooser imageFileChooser=new JFileChooser(currentDirectoryPath);
        imageFileChooser.setDialogTitle("CHOOSE IMAGE");
        FileNameExtensionFilter imageFNEF=new FileNameExtensionFilter("IMAGES","png","jpeg","jpg");
        imageFileChooser.setFileFilter(imageFNEF);
        int imageChooser=imageFileChooser.showOpenDialog(null);
        File  imageFile=imageFileChooser.getSelectedFile();
       crudImageAbsolutePath=imageFile.getAbsolutePath();
             ImageIcon imageicon=new ImageIcon(crudImageAbsolutePath);
            Image imageResize=imageicon.getImage().getScaledInstance(jLabel29.getWidth(),jLabel29.getHeight(),Image.SCALE_SMOOTH);//import java.awt.image;
             jLabel29.setIcon(new ImageIcon(imageResize));
            
        
    }//GEN-LAST:event_uploadButtonActionPerformed

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
        // TODO add your handling code here:
         JTABBED_PANEL_BODY.setSelectedIndex(4);
    }//GEN-LAST:event_jLabel36MouseClicked

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        // TODO add your handling code here:
         JTABBED_PANEL_BODY.setSelectedIndex(2);
          clearTabeladmin();
        setAdminDetailsTable();
         txt_username.setText("");
                txt_fullname.setText("");
                txt_emailid.setText("");
                txt_contactno.setText("");
                txt_password.setText("");
                jLabel29.setIcon(null);
        elab.setText(null);
    }//GEN-LAST:event_jLabel37MouseClicked

    private void jLabel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseClicked
        // TODO add your handling code here:
         JTABBED_PANEL_BODY.setSelectedIndex(3);
         txt_admin_username.setText("");
        txt_admin_fullname.setText("");
       txt_admin_emailid.setText("");
        txt_admin_contactno.setText("");
        txt_admin_password.setText("");
    }//GEN-LAST:event_jLabel38MouseClicked

    private void txt_fullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fullnameActionPerformed

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        // TODO add your handling code here:
         clearTabeladmin();
        txt_admin_username.setText("");
        txt_admin_fullname.setText("");
       txt_admin_emailid.setText("");
        txt_admin_contactno.setText("");
        txt_admin_password.setText("");
        manage_staff_image1.setIcon(null);
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        // TODO add your handling code here:
         clearTabeladmin();
           txt_admin_username.setText("");
        txt_admin_fullname.setText("");
       txt_admin_emailid.setText("");
        txt_admin_contactno.setText("");
        txt_admin_password.setText("");
        manage_staff_image1.setIcon(null);
        setAdminDetailsTable();
    }//GEN-LAST:event_jLabel39MouseClicked

    private void txt_admin_fullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_admin_fullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_admin_fullnameActionPerformed

    private void txt_ADMIN_PROFILE_FULLNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ADMIN_PROFILE_FULLNAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ADMIN_PROFILE_FULLNAMEActionPerformed

    private void txt_confirmpasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_confirmpasswordKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_confirmpasswordKeyReleased

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

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        int opt=JOptionPane.showConfirmDialog(null,"Are You want Logout","Logout",JOptionPane.YES_NO_OPTION);
       if(opt==0){ 
           setVisible(false);
        ADMIN_LOGIN_PAGE ob = new ADMIN_LOGIN_PAGE();
        ob.setVisible(true);
       //System.exit(0);
       }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void txt_emailidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailidKeyReleased
        // TODO add your handling code here:
        String PATTERN="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
         Pattern patt=Pattern.compile (PATTERN);
        Matcher match=patt.matcher(txt_emailid.getText());
        if(!match.matches()){
       elab.setText("Please Input valid Email Id");
       txt_contactno.setEditable(false);
       txt_password.setEditable(false);
        }else{
        elab.setText(null);
       txt_contactno.setEditable(true);
       txt_password.setEditable(true);
        }
    }//GEN-LAST:event_txt_emailidKeyReleased

    private void txt_contactnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactnoKeyReleased
        // TODO add your handling code here:
       Pattern p = Pattern.compile("(0|91)?[6-9][0-9]{9}");
          Matcher match=p.matcher(txt_contactno.getText());
          if(!match.matches()){
           elab.setText("Incorrect Contact no");
           txt_password.setEditable(false);
          }else{
          elab.setText(null);
          txt_password.setEditable(true);
        }
    }//GEN-LAST:event_txt_contactnoKeyReleased

    private void txt_contactnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactnoKeyPressed
        // TODO add your handling code here:
          
    }//GEN-LAST:event_txt_contactnoKeyPressed

    private void txt_usernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyReleased
        // TODO add your handling code here:
       String PATTERN="^[A-Za-z][A-Za-z0-9_]{5,20}$";
        Pattern patt=Pattern.compile (PATTERN);
        Matcher match=patt.matcher(txt_username.getText());
        if(!match.matches()){
       elab.setText("Please Input valid Username");
       txt_fullname.setEditable(false);
       txt_emailid.setEditable(false);
       txt_contactno.setEditable(false);
       txt_password.setEditable(false);
        }else{
        elab.setText(null);
         txt_fullname.setEditable(true);
          txt_emailid.setEditable(true);
       txt_contactno.setEditable(true);
       txt_password.setEditable(true);
        }
    }//GEN-LAST:event_txt_usernameKeyReleased

    private void txt_ADMIN_PROFILE_CONTACTNOKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ADMIN_PROFILE_CONTACTNOKeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txt_ADMIN_PROFILE_CONTACTNOKeyReleased

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
        // TODO add your handling code here:
        txt_admin_username.setText("");
        txt_admin_fullname.setText("");
       txt_admin_emailid.setText("");
        txt_admin_contactno.setText("");
        txt_admin_password.setText("");
        manage_staff_image1.setIcon(null);
    }//GEN-LAST:event_jLabel42MouseClicked

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        // TODO add your handling code here:
          JTABBED_PANEL_BODY.setSelectedIndex(1);
    }//GEN-LAST:event_jLabel46MouseClicked

    private void jLabel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseClicked
        // TODO add your handling code here:
          JTABBED_PANEL_BODY.setSelectedIndex(4);
    }//GEN-LAST:event_jLabel48MouseClicked

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
        // TODO add your handling code here:
         JTABBED_PANEL_BODY.setSelectedIndex(2);
    }//GEN-LAST:event_jLabel50MouseClicked

    private void jLabel54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel54MouseClicked
        // TODO add your handling code here:
          JTABBED_PANEL_BODY.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel54MouseClicked

    private void jLabel51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseClicked
        // TODO add your handling code here:
          JTABBED_PANEL_BODY.setSelectedIndex(6);
    }//GEN-LAST:event_jLabel51MouseClicked
String imgPath=null;
public ImageIcon ResizeImage(String imgPath1){
        ImageIcon MyImage = new ImageIcon(imgPath1);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(lb.getWidth(), lb.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
    private void lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMouseClicked
//         JFileChooser imageFileChooser=new JFileChooser();
//        imageFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
//        imageFileChooser.setDialogTitle("CHOOSE IMAGE");
//        FileNameExtensionFilter imageFNEF=new FileNameExtensionFilter("IMAGES","png","jpeg","jpg");
//        imageFileChooser.setFileFilter(imageFNEF);
//        int result=imageFileChooser.showSaveDialog(null);
//         if(result == JFileChooser.APPROVE_OPTION){
//             File selectedFile = imageFileChooser.getSelectedFile();
//             String path = selectedFile.getAbsolutePath();
//             lb.setIcon(ResizeImage(path));
//             imgPath = path;
//              }
//         else if(result == JFileChooser.CANCEL_OPTION){
//             System.out.println("No Data");
//         }
    }//GEN-LAST:event_lbMouseClicked

    private void manage_staff_image1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manage_staff_image1MouseClicked
         JFileChooser imageFileChooser=new JFileChooser();
        imageFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        imageFileChooser.setDialogTitle("CHOOSE IMAGE");
        FileNameExtensionFilter imageFNEF=new FileNameExtensionFilter("IMAGES","png","jpeg","jpg");
        imageFileChooser.setFileFilter(imageFNEF);
        int result=imageFileChooser.showSaveDialog(null);
         if(result == JFileChooser.APPROVE_OPTION){
             File selectedFile = imageFileChooser.getSelectedFile();
             String path = selectedFile.getAbsolutePath();
             manage_staff_image1.setIcon(ResizeImage(path));
             imgPath = path;
              }
         else if(result == JFileChooser.CANCEL_OPTION){
             System.out.println("No Data");
         }
    }//GEN-LAST:event_manage_staff_image1MouseClicked

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        if(imgPath!=null ){
            String Staff_Username = txt_admin_username.getText();
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginauth","root","Abhay@9899");
                String sql="Update  table_admin set Admin_Image=? where Admin_Username=?";
                InputStream img=new FileInputStream(new File(imgPath));
                PreparedStatement pst=con.prepareStatement(sql);
                pst.setBlob(1,img);
                pst.setString(2,Staff_Username);
                if(pst.executeUpdate()==1){
                    JOptionPane.showMessageDialog(null,"Image Updated");
                    manage_staff_image1.setIcon(null);
                }else{
                    JOptionPane.showMessageDialog(null,"No Image Exist With this ID");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }else{
            JOptionPane.showMessageDialog(null,"No Image Selected");
        }
        imgPath=null;
    }//GEN-LAST:event_jLabel40MouseClicked

    private void jLabel60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel60MouseClicked
        JTABBED_PANEL_BODY.setSelectedIndex(6);
    }//GEN-LAST:event_jLabel60MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ADMIN_HOMEPAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADMIN_HOMEPAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADMIN_HOMEPAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADMIN_HOMEPAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADMIN_HOMEPAGE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Database;
    private javax.swing.JLabel HOME;
    private javax.swing.JLabel Home_index_image;
    private javax.swing.JTabbedPane JTABBED_PANEL_BODY;
    private javax.swing.JPanel PANEL_HEADER;
    private javax.swing.JPanel PANEL_MENU;
    private javax.swing.JLabel SETTING;
    private javax.swing.JLabel STAFF;
    private javax.swing.JLabel SUB_ADMIN;
    private javax.swing.JLabel USER;
    private javax.swing.JButton UpdateSubAdminDetails;
    private javax.swing.JPanel datbase;
    private javax.swing.JLabel elab;
    private javax.swing.JPanel homepanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb;
    private javax.swing.JPanel logout;
    private javax.swing.JLabel manage_staff_image1;
    public javax.swing.JLabel name;
    private javax.swing.JPanel setting;
    private javax.swing.JCheckBox show_pass;
    private javax.swing.JCheckBox show_pass1;
    private javax.swing.JCheckBox show_pass3;
    private javax.swing.JPanel staff;
    private rojeru_san.complementos.RSTableMetro table_admin;
    private rojeru_san.complementos.RSTableMetro table_student;
    public javax.swing.JTextField txt_ADMIN_PROFILE_CONTACTNO;
    public javax.swing.JTextField txt_ADMIN_PROFILE_EMAILID;
    public javax.swing.JTextField txt_ADMIN_PROFILE_FULLNAME;
    public javax.swing.JLabel txt_ADMIN_PROFILE_REGDATE;
    public javax.swing.JLabel txt_ADMIN_PROFILE_USERNAME;
    private javax.swing.JLabel txt_Dashboard_Date;
    private javax.swing.JLabel txt_Dashboard_Time;
    private javax.swing.JTextField txt_admin_contactno;
    private javax.swing.JTextField txt_admin_emailid;
    private javax.swing.JTextField txt_admin_fullname;
    private javax.swing.JPasswordField txt_admin_password;
    private javax.swing.JLabel txt_admin_username;
    private javax.swing.JPasswordField txt_confirmpassword;
    private javax.swing.JTextField txt_contactno;
    private javax.swing.JTextField txt_currentpassword;
    private javax.swing.JTextField txt_emailid;
    private javax.swing.JTextField txt_fullname;
    private javax.swing.JPasswordField txt_newpassword;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JLabel txt_subadminid;
    private javax.swing.JTextField txt_username;
    private javax.swing.JButton uploadButton;
    // End of variables declaration//GEN-END:variables
}
