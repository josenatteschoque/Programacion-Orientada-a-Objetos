package mensajes.ui.impl.cli;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import mensajes.modelo.SeleccionMensaje;
import mensajes.ui.api.UIEngine;
import mensajes.ui.i18n.Messages;

public class Interfaz implements UIEngine {
    private final SeleccionMensaje modelo = new SeleccionMensaje();

    @Override
    public void start() {
        Scanner entrada = new Scanner(System.in, StandardCharsets.UTF_8);
        var tipos = modelo.opciones();
        System.out.println(Messages.text("app.title"));
        while (true) {
            System.out.println(Messages.text("message.choose"));
            for (int i = 0; i < tipos.size(); i++) {
                System.out.println((i + 1) + " - "
                    + Messages.text("option." + tipos.get(i).name()));
            }
            System.out.println("0 - " + Messages.text("cli.exit"));
            System.out.print(Messages.text("cli.prompt"));
            System.out.flush();
            if (!entrada.hasNextLine()) {
                return;
            }
            String opcion = entrada.nextLine().trim();
            if (opcion.equals("0")) {
                System.out.println(Messages.text("cli.bye"));
                return;
            }
            try {
                int numero = Integer.parseInt(opcion);
                if (numero < 1 || numero > tipos.size()) {
                    System.out.println(Messages.text("cli.invalid"));
                    continue;
                }
                modelo.seleccionar(tipos.get(numero - 1));
                System.out.println(Messages.text(
                    "message." + modelo.getSeleccion().name()));
            } catch (NumberFormatException e) {
                System.out.println(Messages.text("cli.invalid"));
            }
        }
    }
}
