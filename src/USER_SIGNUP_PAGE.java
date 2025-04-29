import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.protocol.Resultset;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import static java.lang.String.format;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static java.text.MessageFormat.format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class USER_SIGNUP_PAGE extends javax.swing.JFrame {
String crudImageName=" " ;
String crudImageAbsolutePath=" " ;
    public USER_SIGNUP_PAGE() {
        initComponents();
        SetIcon();
        int ID_no=getId();
        txt_id.setText(Integer.toString(ID_no));
    }
 private void SetIcon(){
setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
}
     int id=0;  
     public int getId(){
    ResultSet rs=null;
    try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginauth","root","Abhay@9899");
                String sql="Select max(ID) from user";
                Statement st=con.createStatement();
                rs=st.executeQuery(sql);
                while (rs.next()){
                   
                    id=rs.getInt(1);
                     id++;
                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
    return id;
    }
     public boolean validation(){
        
          if(txt_username.getText().equals("")  && txt_fullname.getText().equals("") && txt_email.getText().equals("")  &&txt_contactno.getText().equals("") 
                  &&Gender_radioButton.isSelected(null)&&  ComboBox_language.getSelectedItem().equals("---SELECT LANGUAGE---") && ComboBox_country.getSelectedItem().equals("---SELECT COUNTRY---")
                   &&ComboBox_SecurityQ.getSelectedItem().equals("---Select Security Question---")  && txt_dob.getDate()==null && profile_image.getIcon()==null
                  &&txt_answer.getText().equals("")&&txt_password.getText().equals("")
                  ){
                JOptionPane.showMessageDialog(null,"Please Fill the all Details");
           return false;
            }
            if(txt_username.getText().equals("")  ){
                JOptionPane.showMessageDialog(null,"Please Input a Username");
            return false;
            }
             if(txt_fullname.getText().equals("")  ){
                JOptionPane.showMessageDialog(null,"Please Input a FullName");
            return false;
            }
            
         if(txt_email.getText().equals("")  ){
            JOptionPane.showMessageDialog(null,"Please Input a Email Id");
        return false;
        }
         if(txt_contactno.getText().equals("") ){
         JOptionPane.showMessageDialog(null,"Please Input a Contact No");
        return false;
         }
         if(Gender_radioButton.isSelected(null)  ){
          JOptionPane.showMessageDialog(null,"Please Choosen a Gender");
          return false;
          }
           if( profile_image.getIcon()==null){
          JOptionPane.showMessageDialog(null,"Please Upload Your Image");
         return false;
          }
         if( ComboBox_language.getSelectedItem().equals("---SELECT LANGUAGE---") ){
            JOptionPane.showMessageDialog(null,"Please choosen  a Language");
        return false;
        }
         if( ComboBox_country.getSelectedItem().equals("---SELECT COUNTRY---") ){
            JOptionPane.showMessageDialog(null,"Please choosen  a Country name");
        return false;
        } 
         if( ComboBox_SecurityQ.getSelectedItem().equals("---Select Security Question---") ){
            JOptionPane.showMessageDialog(null,"Please choosen  a Security Question");
        return false;
        }
         if(txt_dob.getDate()==null){
          JOptionPane.showMessageDialog(null,"Please select Date of Birth");
          return false;
         }
         if(txt_answer.getText().equals("")  ){
            JOptionPane.showMessageDialog(null,"Please Input a Answer");
        return false;
        }
         if(txt_password.getText().equals("") ){
         JOptionPane.showMessageDialog(null,"Please Input a Password");
        return false;
         }
        
        
        return true;
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Gender_radioButton = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        profile_image = new javax.swing.JLabel();
        IMAGE_UPLOAD = new javax.swing.JButton();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        ComboBox_language = new javax.swing.JComboBox<>();
        ComboBox_country = new javax.swing.JComboBox<>();
        txt_dob = new com.toedter.calendar.JDateChooser();
        txt_username = new javax.swing.JTextField();
        txt_fullname = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        DATA_INSERTED = new javax.swing.JButton();
        DATA_CLEAR = new javax.swing.JButton();
        txt_id = new javax.swing.JLabel();
        jTextFieldIMAGName = new javax.swing.JLabel();
        jTextFieldIMAGPath = new javax.swing.JLabel();
        ComboBox_SecurityQ = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_contactno = new javax.swing.JTextField();
        txt_answer = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        show_password = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home2-32.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Register");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("ID");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("USERNAME");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("FULLNAME");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("EMAIL");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("GENDER");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("LANGUAGE");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("COUNTRY");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("IMAGE PATH");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("DOB");

        profile_image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        profile_image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profile_imageMouseClicked(evt);
            }
        });

        IMAGE_UPLOAD.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        IMAGE_UPLOAD.setText("Upload Image");
        IMAGE_UPLOAD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        IMAGE_UPLOAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IMAGE_UPLOADActionPerformed(evt);
            }
        });

        Gender_radioButton.add(male);
        male.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        male.setText("Male");

        Gender_radioButton.add(female);
        female.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });

        ComboBox_language.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ComboBox_language.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---SELECT LANGUAGE---", "English", "Assamese", "Bengali", "Gujarati", "Hindi", "Kannada", "Kashmiri", "Marathi", "Malayalam", "Oriya", "Punjabi", "Sanskrit", "Tamil", "Telugu", "Urdu", "Sindhi", "Konkani", "Nepali", "Manipuri", "Bodo", "Dogri", "Maithili", "Santhali" }));
        ComboBox_language.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ComboBox_language.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_languageActionPerformed(evt);
            }
        });

        ComboBox_country.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ComboBox_country.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---SELECT COUNTRY---", "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Rep", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Congo {Democratic Rep}", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland {Republic}", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar, {Burma}", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia", "Saint Vincent & the Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe" }));
        ComboBox_country.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ComboBox_country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_countryActionPerformed(evt);
            }
        });

        txt_dob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_dob.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txt_username.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txt_fullname.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_fullname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txt_email.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DATA_INSERTED.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        DATA_INSERTED.setText("SIGNUP");
        DATA_INSERTED.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        DATA_INSERTED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DATA_INSERTEDActionPerformed(evt);
            }
        });

        DATA_CLEAR.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        DATA_CLEAR.setText("CLEAR");
        DATA_CLEAR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        DATA_CLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DATA_CLEARActionPerformed(evt);
            }
        });

        txt_id.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jTextFieldIMAGName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jTextFieldIMAGPath.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextFieldIMAGPath.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ComboBox_SecurityQ.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ComboBox_SecurityQ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select Security Question---", "What is your First Elementary School ?", "What is your Favourite food ?", "What is your Child Nick name ?", "What is your Father's name ?", "What is your Favourite Fruit's ?" }));
        ComboBox_SecurityQ.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("SECURITYQ");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("CONTACTNO");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("ANSWER");

        txt_contactno.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_contactno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txt_answer.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_answer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("PASSWORD");

        txt_password.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        show_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_passwordActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/left-arrow.png"))); // NOI18N
        jLabel17.setToolTipText("");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_answer, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(DATA_INSERTED, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(DATA_CLEAR, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_password))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(show_password)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextFieldIMAGPath, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(IMAGE_UPLOAD, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(profile_image, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ComboBox_language, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ComboBox_SecurityQ, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ComboBox_country, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(male)
                                            .addGap(18, 18, 18)
                                            .addComponent(female))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(txt_contactno, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                            .addGap(17, 17, 17)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_fullname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(212, 212, 212)
                                        .addComponent(jTextFieldIMAGName, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(15, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(7, 7, 7)
                                .addComponent(txt_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(txt_contactno, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(IMAGE_UPLOAD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(profile_image, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldIMAGName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(male)
                                .addComponent(female)))))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIMAGPath, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ComboBox_language, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ComboBox_country, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ComboBox_SecurityQ, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_answer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(show_password))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DATA_CLEAR, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DATA_INSERTED, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(358, 358, 358)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        INDEX_PAGE ob = new INDEX_PAGE();
        ob.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void profile_imageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_imageMouseClicked
        // TODO add your handling code here:
        //        IMAGE_DISPLAY_JFRAME IPAGE=new IMAGE_DISPLAY_JFRAME();
        //         IPAGE.show();
        //         ImageGetInTable();

    }//GEN-LAST:event_profile_imageMouseClicked

    private void IMAGE_UPLOADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IMAGE_UPLOADActionPerformed
        // TODO add your handling code here:
        // String img=null;
        String currentDirectoryPath="";//C:\\Users\\Abhay mehta\\Documents\\NetBeansProjects\\CRUD_INSERT_IMAGE_WITH_FORM\\src\\USER_PROFILE_IMAGE
//        JFileChooser imageFileChooser=new JFileChooser(currentDirectoryPath);

  JFileChooser imageFileChooser=new JFileChooser();
        imageFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        imageFileChooser.setDialogTitle("CHOOSE IMAGE");
        FileNameExtensionFilter imageFNEF=new FileNameExtensionFilter("IMAGES","png","jpeg","jpg");
        imageFileChooser.setFileFilter(imageFNEF);        
int imageChooser=imageFileChooser.showOpenDialog(null);
        if(imageChooser==JFileChooser.APPROVE_OPTION){
            File  imageFile=imageFileChooser.getSelectedFile(); //import java.io.File;
            crudImageAbsolutePath=imageFile.getAbsolutePath();
            crudImageName=imageFile.getName();
            jTextFieldIMAGName.setText(crudImageName);
            jTextFieldIMAGPath.setText(crudImageAbsolutePath);
            ImageIcon imageicon=new ImageIcon(crudImageAbsolutePath);
            Image imageResize=imageicon.getImage().getScaledInstance(profile_image.getWidth(),profile_image.getHeight(),Image.SCALE_SMOOTH);//import java.awt.image;
            profile_image.setIcon(new ImageIcon(imageResize));
        }
    }//GEN-LAST:event_IMAGE_UPLOADActionPerformed

    private void ComboBox_languageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_languageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_languageActionPerformed

    private void DATA_INSERTEDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DATA_INSERTEDActionPerformed
        // TODO add your handling code here:

        if(validation()==true){

            try{
                String Username=txt_username.getText();
                String Fullname=txt_fullname.getText();
                String Email=txt_email.getText();
                 String Contactno=txt_contactno.getText();
                 String gender=" ";
                 InputStream imageIS=null;
                String ImageName=jTextFieldIMAGName.getText();
                String ImagePath=jTextFieldIMAGPath.getText();
                String Language=(String)ComboBox_language.getSelectedItem();
                String Country=(String)ComboBox_country.getSelectedItem();
                 String SecurityQ=(String)ComboBox_SecurityQ.getSelectedItem();
                Date date=txt_dob.getDate();
                SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
                String DOB=sdf.format(date);
                 String ANSWER=txt_answer.getText();
                 String PASSWORD=txt_password.getText();
              
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/loginauth","root","Abhay@9899");
                if(male.isSelected()  ){
                    gender="Male";
                }else if(female.isSelected()  ){
                    gender="Female";
                }
                imageIS=new FileInputStream(new File(crudImageAbsolutePath));
                PreparedStatement p =con.prepareStatement("Insert into user   values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                p.setInt(1,getId());
                p.setString(2,Username);
                p.setString(3,Fullname);
                p.setString(4,Email);
                p.setString(5,Contactno);
                p.setString(6,gender);
                p.setBlob(7,imageIS);
                p.setString(8,ImageName);
                p.setString(9,ImagePath);
                p.setString(10,Language);
                p.setString(11,Country);
                p.setString(12,SecurityQ);
                p.setString(13,ANSWER);
                p.setString(14,DOB);
                p.setString(15,PASSWORD);
                 Username=txt_username.getText();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select SECURITYQ from user  where USERNAME='"+txt_username+"'");
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"It's already Exist,Choosen new ");
            }
            else{
            p.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registration is Sucessfully");
                   txt_id.setText("");
                    txt_username.setText("");
                    txt_fullname.setText("");
                    txt_email.setText("");
                    txt_contactno.setText("");
                    Gender_radioButton.clearSelection();
                    profile_image.setIcon(null);
                    jTextFieldIMAGName.setText("");
                    jTextFieldIMAGPath.setText("");
                    ComboBox_language.setSelectedItem("---SELECT LANGUAGE---");
                    ComboBox_country.setSelectedItem("---SELECT COUNTRY---");
                    ComboBox_SecurityQ.setSelectedItem("---Select Security Question---");
                    txt_dob.setDate(null);
                    txt_answer.setText("");
                    txt_password.setText("");
                    setVisible(true);
            }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }

        }else{
        }

    }//GEN-LAST:event_DATA_INSERTEDActionPerformed

    private void DATA_CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DATA_CLEARActionPerformed
        // TODO add your handling code here:
                    txt_id.setText("");
                    txt_username.setText("");
                    txt_fullname.setText("");
                    txt_email.setText("");
                    txt_contactno.setText("");
                    Gender_radioButton.clearSelection();
                    profile_image.setIcon(null);
                    jTextFieldIMAGName.setText("");
                    jTextFieldIMAGPath.setText("");
                    ComboBox_language.setSelectedItem("---SELECT LANGUAGE---");
                    ComboBox_country.setSelectedItem("---SELECT COUNTRY---");
                    ComboBox_SecurityQ.setSelectedItem("---Select Security Question---");
                    txt_dob.setDate(null);
                    txt_answer.setText("");
                    txt_password.setText("");
                    setVisible(true);
                    int ID_no=getId();
                    txt_id.setText(Integer.toString(ID_no));
    }//GEN-LAST:event_DATA_CLEARActionPerformed

    private void ComboBox_countryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_countryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_countryActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
         String username=txt_username.getText();
        if(txt_username.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Input a Username");
        }
        else{
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/LoginAuth","root","Abhay@9899");
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select SECURITYQ from user  where USERNAME='"+username+"'");
                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"Username already Exist,Choosen new ");
                    txt_username.setText("");
                }

                else{
                    JOptionPane.showMessageDialog(null,"It's Unique");
                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        setVisible(false);
            USER_LOGIN_PAGE ob = new USER_LOGIN_PAGE();
        ob.setVisible(true);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void show_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_passwordActionPerformed
        // TODO add your handling code here:
        if(show_password.isSelected()){
            txt_password.setEchoChar((char)0);
        }
        else{
            txt_password.setEchoChar('*');
        }
    }//GEN-LAST:event_show_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(USER_SIGNUP_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(USER_SIGNUP_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(USER_SIGNUP_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(USER_SIGNUP_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new USER_SIGNUP_PAGE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox_SecurityQ;
    private javax.swing.JComboBox<String> ComboBox_country;
    private javax.swing.JComboBox<String> ComboBox_language;
    private javax.swing.JButton DATA_CLEAR;
    private javax.swing.JButton DATA_INSERTED;
    private javax.swing.ButtonGroup Gender_radioButton;
    private javax.swing.JButton IMAGE_UPLOAD;
    private javax.swing.JRadioButton female;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jTextFieldIMAGName;
    private javax.swing.JLabel jTextFieldIMAGPath;
    private javax.swing.JRadioButton male;
    private javax.swing.JLabel profile_image;
    private javax.swing.JCheckBox show_password;
    private javax.swing.JTextField txt_answer;
    private javax.swing.JTextField txt_contactno;
    private com.toedter.calendar.JDateChooser txt_dob;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_fullname;
    private javax.swing.JLabel txt_id;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
