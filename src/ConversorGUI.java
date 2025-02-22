import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorGUI extends JFrame {
    private JTextField cantidadField;
    private JTextArea resultadoArea;
    private JComboBox<String> tipoConversion;

    // Tasas de conversión ficticias
    private static final double DOLAR_A_PESO = 1000; // 1 peso = 1000 dólares
    private static final double EURO_A_PESO = 1200; // 1 euro = 1200 pesos
    private static final double LIBRA_A_PESO = 1400; // 1 libra = 1400 pesos
    private static final double YEN_A_PESO = 9; // 1 yen = 9 pesos
    private static final double WON_A_PESO = 0.75; // 1 won = 0.75 pesos

    public ConversorGUI() {
        setTitle("Conversor de Moneda y Temperatura");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        getContentPane().setBackground(Color.LIGHT_GRAY);

        // Elementos de la interfaz
        tipoConversion = new JComboBox<>(new String[]{
                "Convertir de Pesos a Dólares",
                "Convertir de Pesos a Euros",
                "Convertir de Pesos a Libras Esterlinas",
                "Convertir de Pesos a Yen Japonés",
                "Convertir de Pesos a Won sul-coreano",
                "Convertir de Dólares a Pesos",
                "Convertir de Euros a Pesos",
                "Convertir de Libras Esterlinas a Pesos",
                "Convertir de Yen Japonés a Pesos",
                "Convertir de Won sul-coreano a Pesos",
                "Convertir de Celsius a Fahrenheit",
                "Convertir de Celsius a Kelvin",
                "Convertir de Fahrenheit a Celsius",
                "Convertir de Fahrenheit a Kelvin",
                "Convertir de Kelvin a Celsius",
                "Convertir de Kelvin a Fahrenheit"
        });
        cantidadField = new JTextField(10);
        JButton convertirButton = new JButton("Convertir");
        resultadoArea = new JTextArea(8, 30);
        resultadoArea.setEditable(false);


        // Cambiar el color de fondo y texto de los componentes
        cantidadField.setBackground(Color.WHITE);
        cantidadField.setForeground(Color.BLACK);
        convertirButton.setBackground(Color.BLUE);
        convertirButton.setForeground(Color.WHITE);
        resultadoArea.setBackground(Color.WHITE);
        resultadoArea.setForeground(Color.BLACK);

        // Agregar elementos a la ventana
        add(new JLabel("Seleccione la conversión:"));
        add(tipoConversion);
        add(new JLabel("Ingrese la cantidad:"));
        add(cantidadField);
        add(convertirButton);
        add(new JScrollPane(resultadoArea));

        // Acción del botón
        convertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarConversion();
            }
        });
    }

    private void realizarConversion() {
        String seleccion = (String) tipoConversion.getSelectedItem();
        String cantidadTexto = cantidadField.getText();
        double cantidad;

        try {
            cantidad = Double.parseDouble(cantidadTexto);
        } catch (NumberFormatException e) {
            resultadoArea.setText("Por favor, ingrese un número válido.");
            return;
        }

        double resultado = 0;

        switch (seleccion) {
            // Conversión de monedas
            case "Convertir de Pesos a Dólares":
                resultado = cantidad / DOLAR_A_PESO;
                resultadoArea.setText(cantidad + " Pesos son " + resultado + " Dólares");
                break;
            case "Convertir de Pesos a Euros":
                resultado = cantidad / EURO_A_PESO;
                resultadoArea.setText(cantidad + " Pesos son " + resultado + " Euros");
                break;
            case "Convertir de Pesos a Libras Esterlinas":
                resultado = cantidad / LIBRA_A_PESO;
                resultadoArea.setText(cantidad + " Pesos son " + resultado + " Libras Esterlinas");
                break;
            case "Convertir de Pesos a Yen Japonés":
                resultado = cantidad / YEN_A_PESO;
                resultadoArea.setText(cantidad + " Pesos son " + resultado + " Yen Japonés");
                break;
            case "Convertir de Pesos a Won sul-coreano":
                resultado = cantidad / WON_A_PESO;
                resultadoArea.setText(cantidad + " Pesos son " + resultado + " Won sul-coreano");
                break;
            case "Convertir de Dólares a Pesos":
                resultado = cantidad * DOLAR_A_PESO;
                resultadoArea.setText(cantidad + " Dólares son " + resultado + " Pesos");
                break;
 case "Convertir de Euros a Pesos":
                resultado = cantidad * EURO_A_PESO;
                resultadoArea.setText(cantidad + " Euros son " + resultado + " Pesos");
                break;
            case "Convertir de Libras Esterlinas a Pesos":
                resultado = cantidad * LIBRA_A_PESO;
                resultadoArea.setText(cantidad + " Libras Esterlinas son " + resultado + " Pesos");
                break;
            case "Convertir de Yen Japonés a Pesos":
                resultado = cantidad * YEN_A_PESO;
                resultadoArea.setText(cantidad + " Yen Japonés son " + resultado + " Pesos");
                break;
            case "Convertir de Won sul-coreano a Pesos":
                resultado = cantidad * WON_A_PESO;
                resultadoArea.setText(cantidad + " Won sul-coreano son " + resultado + " Pesos");
                break;
            // Conversión de temperaturas
            case "Convertir de Celsius a Fahrenheit":
                resultado = (cantidad * 9/5) + 32;
                resultadoArea.setText(cantidad + " °C son " + resultado + " °F");
                break;
            case "Convertir de Celsius a Kelvin":
                resultado = cantidad + 273.15;
                resultadoArea.setText(cantidad + " °C son " + resultado + " K");
                break;
            case "Convertir de Fahrenheit a Celsius":
                resultado = (cantidad - 32) * 5/9;
                resultadoArea.setText(cantidad + " °F son " + resultado + " °C");
                break;
            case "Convertir de Fahrenheit a Kelvin":
                resultado = (cantidad - 32) * 5/9 + 273.15;
                resultadoArea.setText(cantidad + " °F son " + resultado + " K");
                break;
            case "Convertir de Kelvin a Celsius":
                resultado = cantidad - 273.15;
                resultadoArea.setText(cantidad + " K son " + resultado + " °C");
                break;
            case "Convertir de Kelvin a Fahrenheit":
                resultado = (cantidad - 273.15) * 9/5 + 32;
                resultadoArea.setText(cantidad + " K son " + resultado + " °F");
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConversorGUI conversor = new ConversorGUI();
            conversor.setVisible(true);
        });
    }
}