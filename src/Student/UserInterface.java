package Student;

import javax.swing.*;
import javax.swing.SpringLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class UserInterface {
    public static final String filepath = "/Users/admin/W4/src/Student/student.txt";

    private static ArrayList<Student> studentContainer = new ArrayList<Student>();

    public static void main(String[] args) {

        ArrayList<String> courses = new ArrayList<>();
        JFrame frame = new JFrame("Student Console");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(new Dimension(500, 250));
        frame.getContentPane().setBackground(Color.darkGray);
        JButton addStudent = new JButton("Add Student");
        JButton openStudent = new JButton("Open Saved Student");

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(addStudent, BorderLayout.WEST);
        frame.getContentPane().add(openStudent, BorderLayout.CENTER);
        openStudent.addActionListener((ActionEvent e) -> {

            ReadObject readObject = new ReadObject();

            ArrayList<Student> temp = new ArrayList<Student>();
            temp = (ArrayList<Student>) readObject.ReadObjectFromFile();

              JFrame newFrame = new JFrame("Saved Students");
              newFrame.setLayout(new GridLayout());
              newFrame.setSize(500,500);
              JTextArea  studentView = new JTextArea();
              studentView.setText(temp.toString());
              newFrame.add(studentView);
              newFrame.setVisible(true);



        });
        Container main = frame.getContentPane();

        addStudent.addActionListener((ActionEvent e) ->
        {


            frame.getContentPane().removeAll();

            frame.setSize(1000, 350);
            JPanel p = new JPanel(new FlowLayout());
            JLabel studentID = new JLabel("Student ID: ", JLabel.TRAILING);
            JTextField textFieldID = new JTextField(12);
            studentID.setLabelFor(textFieldID);
            textFieldID.setSize(new Dimension(100, 100));
            p.add(studentID);
            p.add(textFieldID);

            JLabel FirstName = new JLabel("First Name: ", JLabel.TRAILING);
            JTextField textFieldFName = new JTextField(12);
            FirstName.setLabelFor(textFieldFName);
            textFieldFName.setSize(new Dimension(100, 100));
            p.add(FirstName);
            p.add(textFieldFName);


            JLabel LastName = new JLabel("Last Name: ", 10);
            JTextField textFieldLName = new JTextField(12);
            LastName.setLabelFor(textFieldLName);
            textFieldFName.setSize(new Dimension(100, 100));
            p.add(LastName);
            p.add(textFieldLName);

            JLabel courseLabel = new JLabel("Course: ");
            JTextField textFieldCourses = new JTextField(12);

            textFieldCourses.setSize(new Dimension(100, 100));

            courseLabel.setLabelFor(textFieldCourses);
            p.add(courseLabel);
            p.add(textFieldCourses);

            JButton addCourse = new JButton("Add Another Course");
            p.add(addCourse);
            frame.getContentPane().add(p);
            addCourse.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    courses.add(textFieldCourses.getText());
                    textFieldCourses.setText("");
                }
            });


            JButton AddNewStudent = new JButton("Add another Student");
            AddNewStudent.addActionListener((ActionEvent e2) -> {

                if (!textFieldCourses.getText().equals("")) courses.add(textFieldCourses.getText());
                if(!studentID.getText().equals("")) {


                    studentContainer.add(new Student(Long.parseLong(textFieldID.getText()), textFieldFName.getText(), textFieldLName.getText(), courses));
                }

                textFieldID.setText("");
                textFieldFName.setText("");
                textFieldLName.setText("");
                textFieldCourses.setText("");

                courses.clear();

            });
            p.add(AddNewStudent);

            JButton exit = new JButton("Exit");
            exit.addActionListener((ActionEvent e3) -> {

                if (!textFieldCourses.getText().equals("")) courses.add(textFieldCourses.getText());
                if(!textFieldID.getText().equals("")) {
                    studentContainer.add(new Student(Long.parseLong(textFieldID.getText()), textFieldFName.getText(), textFieldLName.getText(), courses));
                }
                WriteObject writeObject = new WriteObject();
                if(!studentContainer.isEmpty()) {
                    writeObject.WriteObjectTofile(studentContainer);
                }
               System.exit(0);
            });
            p.add(exit);

        });


        frame.setVisible(true);
    }

}



