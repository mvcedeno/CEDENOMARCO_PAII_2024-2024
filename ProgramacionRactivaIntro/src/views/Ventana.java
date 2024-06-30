package views;

import controllers.Controlador;
import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana() {
        // Configuración de la ventana
        setTitle("Ejemplo de Ventana");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creación de los componentes
        JTextArea textArea = new JTextArea(10, 30);
        JTextField textField = new JTextField(20);
        JButton button1 = new JButton("Nuevo usuario");
        JButton button2 = new JButton("Comprar");
        JLabel label = new JLabel("Total Tickets");

        // Configuración del layout
        setLayout(new FlowLayout());

        // Añadir componentes a la ventana
        add(new JScrollPane(textArea));  // Añadimos el JTextArea con JScrollPane
        add(textField);
        add(button1);
        add(button2);
        add(label);

        Controlador controlador = new Controlador();

        // Añadir funcionalidad a los botones (opcional)
        button1.addActionListener( e -> {
                controlador.crearHiloUsuario();
                textArea.setText("");
                textArea.setText(controlador.listarHiloUsuario());
            });

        button2.addActionListener(e -> {
            if(!textField.getText().isEmpty()){
                int ticketsComprados = Integer.parseInt(textField.getText());
                controlador.comprarTickets(ticketsComprados);
                label.setText("Total tickets: " + controlador.getTotalTickets());

                textArea.setText("");
                textArea.setText(controlador.listarHiloUsuario());

                controlador.evaluarTickets();
                textArea.setText("");
                textArea.setText(controlador.listarHiloUsuario());
            }
        });
    }

}
