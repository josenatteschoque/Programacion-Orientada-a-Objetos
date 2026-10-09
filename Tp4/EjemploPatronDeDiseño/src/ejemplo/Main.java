package ejemplo;

public class Main {
    public static void main(String[] args) {
        Notificacion notif = NotificacionFactory.crearNotificacion("EMAIL");
        notif.enviar("Tu código de verificación es 4821");
    }
}