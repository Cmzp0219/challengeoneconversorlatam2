package conversormondas;

import java.text.DecimalFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class ConversorMondas {

    public static void main(String[] args) {
        //boolean valEntrada = true;
        double cantDinero;
        String[] paresMonedas = new String[5];

        paresMonedas[0] = "De Peso a Dolar";
        paresMonedas[1] = "De Peso a Euro";
        paresMonedas[2] = "De Peso a Libra";
        paresMonedas[3] = "De Peso a Yen";
        paresMonedas[4] = "De Dolar a Pesos";

        HashMap<String, Float> cotizacion = new HashMap<>();

        cotizacion.put("Peso", 285.30f);
        cotizacion.put("Dolar", 1f);
        cotizacion.put("Euro", 1.02f);
        cotizacion.put("Libra", 0.89f);
        cotizacion.put("Yen", 144.94f);
        
        int salida;

        do {            

        while (true) {
            try {
                cantDinero = Float.parseFloat(JOptionPane.showInputDialog("Ingresa la cantidad de dinero que deseas convertir:"));
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Valor no válido");
            }
        }

        String opcion = (String) JOptionPane.showInputDialog(null, "Elije a la moneda que deseas convertir tu dinero", "Monedas", JOptionPane.QUESTION_MESSAGE, null, paresMonedas, "De Peso a Dolar");

        float montoConvertido;
        String destino;
        switch (opcion) {
            case "De Peso a Dolar":
                montoConvertido = (float) (cantDinero * cotizacion.get("Dolar") / cotizacion.get("Peso"));
                destino = "Dolares";
                break;
            case "De Peso a Euro":
                montoConvertido = (float) (cantDinero * cotizacion.get("Euro") / cotizacion.get("Peso"));
                destino = "Euros";
                break;
            case "De Peso a Libra":
                montoConvertido = (float) (cantDinero * cotizacion.get("Libra") / cotizacion.get("Peso"));
                destino = "Libras";
                break;
            case "De Peso a Yen":
                montoConvertido = (float) (cantDinero * cotizacion.get("Yen") / cotizacion.get("Peso"));
                destino = "Yens";
                break;
           case "De Dolar a Pesos":
                montoConvertido = (float) (cantDinero * cotizacion.get("Peso") / cotizacion.get("Dolar"));
                destino = "Pesos";
                break;     
            default:
                throw new AssertionError();
        }

        DecimalFormat frmt = new DecimalFormat("#.##");
        String montoFinal = frmt.format(montoConvertido);

        JOptionPane.showMessageDialog(null, "Tienes: " + montoFinal + " " + destino, "Resutado conversion", JOptionPane.INFORMATION_MESSAGE);
        
            salida = JOptionPane.showConfirmDialog(null, "¿Desea continuar?");
        
        } while (salida == 0);

        JOptionPane.showMessageDialog(null, "Programa Terminado", "Cierre del conversor de Monedas", JOptionPane.INFORMATION_MESSAGE);
    }

}
