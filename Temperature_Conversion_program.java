import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// adding all the necessary
public class Temperature_Conversion_program  {
    private JFrame frame;
    private JLabel label;// label for the temperature
    private JLabel UnitsofTemperature;//label for units
    private JTextField InputofTemp;//textfield for entering the temperature
    private JComboBox<String> unitsinput;// to show popup menu of choices
    private JTextArea Conversion_Result ;//for the result of input conversion

    public Temperature_Conversion_program(){
        frame = new JFrame("Temperature Conversion");
        //title of the frame
        frame.setSize(400,400);//size of the frame
        frame.setLayout(new FlowLayout());//flowlayout
        // setting the title , size and layout 
        label = new JLabel("Enter the Temperature");
        frame.add(label);//adding label
        InputofTemp = new JTextField(10);
        frame.add(InputofTemp);//adding textfield to the frame

        UnitsofTemperature = new JLabel("Select unit of temperature");
        frame.add(UnitsofTemperature);

        String[] Units = {"Kelvin" , "Celsius" , "Fahrenheit"};
        unitsinput = new JComboBox<>(Units);
        frame.add(unitsinput);
        // adding combo box for the scroll down selection of the unit of temperature
        JButton Convert = new JButton("Convert Temperature");
        frame.add(Convert);

        Conversion_Result = new JTextArea(6,30);
        frame.add(Conversion_Result);
        frame.add(new JScrollPane(Conversion_Result));
        Conversion_Result.setEditable(false);
        //conversion result can't be edited
        frame.setVisible(true);

        Convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conversion();
            }
        });
        //adding the action listener to the Conversion()
    }
    private void Conversion(){
        try {
            double temperature = Double.parseDouble(InputofTemp.getText());
            String unit = (String) unitsinput.getSelectedItem();
            StringBuilder result = new StringBuilder();

            // Conversion of Unit Celsius to the Fahrenheit and Kelvin
            if (unit.equals("Celsius")) {
                double fahrenheit = (temperature * 9/5) + 32;
                double kelvin = temperature + 273.15;
                result.append(temperature).append(" °C = ").append(fahrenheit).append(" °F\n")
                        .append(temperature).append(" °C = ").append(kelvin).append(" K");
            }
            //Conversion of Fahrenheit to the Celsius and Kelvin
            else if (unit.equals("Fahrenheit")) {
                double celsius = (temperature - 32) * 5/9;
                double kelvin = celsius + 273.15;
                result.append(temperature).append(" °F = ").append(celsius).append(" °C\n")
                        .append(temperature).append(" °F = ").append(kelvin).append(" K");
            }
            //Conversion of Kelvin to the Celsius and Fahrenheit
            else if (unit.equals("Kelvin")) {
                double celsius = temperature - 273.15;
                double fahrenheit = (celsius * 9/5) + 32;
                result.append(temperature).append(" K = ").append(celsius).append(" °C\n")
                        .append(temperature).append(" K = ").append(fahrenheit).append(" °F");
            }

            Conversion_Result.setText(result.toString());
        }
        //NumberFormatException
        catch (NumberFormatException e) {
            Conversion_Result.setText("Please enter a valid number for temperature.");
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->  new Temperature_Conversion_program());
    }
}
