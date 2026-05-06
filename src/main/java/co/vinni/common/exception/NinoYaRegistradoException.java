package co.vinni.common.exception;

public class NinoYaRegistradoException extends RuntimeException {
    public NinoYaRegistradoException(String nombreNino) {
        super("El niño " + nombreNino + " ya está registrado con otro responsable");
    }
}