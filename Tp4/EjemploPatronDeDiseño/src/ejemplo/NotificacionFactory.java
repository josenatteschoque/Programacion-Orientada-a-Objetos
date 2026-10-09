package ejemplo;

public class NotificacionFactory {
	public static Notificacion crearNotificacion(String canal) {
		if (canal == null || canal.isEmpty()) {
			throw new IllegalArgumentException("El canal no puede ser nulo o vacío");
	    }
		
		return switch (canal.toUpperCase()) {
			case "EMAIL" -> new EmailNotificacion();
			case "SMS" -> new SmsNotificacion();
			default -> throw new IllegalArgumentException("Canal desconocido: " + canal);
			};
	    }
}

